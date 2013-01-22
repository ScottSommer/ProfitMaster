package org.sommer.pm.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sommer.pm.data.domain.AuctionItem;
import org.sommer.pm.data.service.specification.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import HTTPUtil.HTTPRequestPoster;

@Component
public class Controller {

	static String realm = "dreadmaul";
	static String faction = "horde";
	static String host = "us.battle.net";
	
//	URL = host + "/api/wow/item/" + ItemId
	static final String ITEM_PATH = "/api/wow/item/";

	static String filesCache = "C:\\Users\\Scott\\Desktop\\dreadmaul";
	static String getFilesUrl = "http://us.battle.net/api/wow/auction/data/" + realm;

	static String ahCache = "C:\\Users\\Scott\\Desktop\\auctions.json";

	static String silverleafCache = "C:\\Users\\Scott\\Desktop\\silverleaf.json";

	static String perditionsCache = "C:\\Users\\Scott\\Desktop\\perditionsblade.json";
	
	static int bufferSize = 8192;
	
	@Autowired AuctionItemService aiService;

	private ServiceRegistry serviceRegistry = null;

	private SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    return configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void start() {
		// TODO Auto-generated method stub
//		HTTPRequestPoster http = new HTTPRequestPoster();
		
		boolean fromWeb = false;
		
		try {

			String filesStr = null;
			
			if(fromWeb) {
				filesStr = HTTPRequestPoster.sendGetRequest(getFilesUrl, null);
				writeFile(filesCache, filesStr);
			} else {
				filesStr = readFile(filesCache);
			}
			
			JSONObject jsonFiles;
			jsonFiles = new JSONObject(filesStr);
			JSONArray innerJson = (JSONArray) jsonFiles.get("files");

//			innerJson.get(0);
			String ahUrl = (String)((JSONObject) innerJson.get(0)).get("url");
			
			System.out.println("Fetching AH data: " + ahUrl);

			String ahStr = null;
			
			if(fromWeb) {
				ahStr = HTTPRequestPoster.sendGetRequest(ahUrl, null);
				writeFile(ahCache, ahStr);
			} else {
				ahStr = readFile(ahCache);
			}
			
			JSONObject jsonAh;
			jsonAh = new JSONObject(ahStr);
			JSONArray auctions = ((JSONObject) jsonAh.get(faction)).getJSONArray("auctions");
			
			List<AuctionItem> auctionItems = new ArrayList<AuctionItem>();

			SessionFactory sessionFactory = this.configureSessionFactory();
			for(Object aucObj : auctions) {
				JSONObject auction = (JSONObject) aucObj;
				
				AuctionItem ai = new AuctionItem();

				ai.setItem(Long.valueOf(auction.get("item").toString()));
				ai.setBuyout(Long.valueOf(auction.get("buyout").toString()));
				ai.setBid(Long.valueOf(auction.get("bid").toString()));
				
				auctionItems.add(ai);
				aiService.createAuctionItem(ai);
			}
			
			System.out.println("Auctions scanned: "+auctionItems.size());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String line  = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    String ls = System.getProperty("line.separator");
	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }
	    reader.close();
	    return stringBuilder.toString();
	 }
	
	public void writeFile(String fileName, String fileContents) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		writer.write(fileContents);
		writer.flush();
		writer.close();
	}

}
