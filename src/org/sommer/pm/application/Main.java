package org.sommer.pm.application;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.sommer.pm.data.domain.AuctionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

//	static String realm = "dreadmaul";
//	static String faction = "horde";
//	static String host = "us.battle.net";
//	
//	static final String ITEM_PATH = "/api/wow/item/";
//
//	static String filesCache = "C:\\Users\\Scott\\Desktop\\dreadmaul";
//	static String getFilesUrl = "http://us.battle.net/api/wow/auction/data/" + realm;
//
//	static String ahCache = "C:\\Users\\Scott\\Desktop\\auctions.json";
//
//	static String silverleafCache = "C:\\Users\\Scott\\Desktop\\silverleaf.json";
//
//	static String perditionsCache = "C:\\Users\\Scott\\Desktop\\perditionsblade.json";
//	
//	static int bufferSize = 8192;
//	
//	@Autowired AuctionItemService aiService;
	
	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;

	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	public SessionFactory getFactory() {
		if (sessionFactory == null) {
			synchronized (AuctionItem.class) {
				if (sessionFactory == null) {
					sessionFactory = new Configuration()
					  .configure()
					  .buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}


    public static void main(String[] args) {
    	//3
//    	SessionFactory sessionFactory = configureSessionFactory();
//
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		AuctionItem auctionItem = new AuctionItem();
//		auctionItem.setBid((long) 1);
//		auctionItem.setBuyout((long) 2);
//		auctionItem.setItem((long) 3);
//		session.save(auctionItem);
//		session.flush();
//		transaction.commit();
//		
//		
//		
//		SQLQuery query = session.createSQLQuery("select * from firstdb.Auction");
//		query.addEntity(AuctionItem.class);
//		Object result = query.uniqueResult();
//		
//		session.close();
//		
//		
//    	
//    	if(true) return;
    	
    	
        AbstractXmlApplicationContext context = 
            new ClassPathXmlApplicationContext("configuration.xml");

        Main main = context.getBean(Main.class);
        
//        Main main = new Main();
        main.start(args);
    }

    @Autowired
    private Controller controller;
    private void start(String[] args) {
//    	Controller controller = new Controller();
        controller.start();
    }
    
    
//	public static void main(String[] args) {
//		
////		Controller controller = new Controller();
//	
//		controller.start();
//		
//		
//	}
	
//	static String readFile( String file ) throws IOException {
//	    BufferedReader reader = new BufferedReader( new FileReader (file));
//	    String line  = null;
//	    StringBuilder stringBuilder = new StringBuilder();
//	    String ls = System.getProperty("line.separator");
//	    while( ( line = reader.readLine() ) != null ) {
//	        stringBuilder.append( line );
//	        stringBuilder.append( ls );
//	    }
//	    return stringBuilder.toString();
//	 }

}
