package org.sommer.pm.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sommer.pm.data.domain.AuctionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AuctionItem")
public class AuctionItemDao {
	
	private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;}
    public void setSessionFactory(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
    }
    
	@Autowired
	public AuctionItemDao(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	public AuctionItem viewAuctionItem(Integer AuctionItemId) {
		return (AuctionItem) sessionFactory.getCurrentSession().get(AuctionItem.class, AuctionItemId);
	}
	
	public void saveAuctionItem(AuctionItem AuctionItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(AuctionItem);
	}
	
	public List<AuctionItem> listAuctionItems() {
		List<AuctionItem> list = sessionFactory.getCurrentSession().createQuery("select * from Auction").list();
		return list;
	}
	
}