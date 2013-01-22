package org.sommer.pm.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sommer.pm.data.domain.AuctionItem;

/**
 * 
 * source : www.javabeat.net
 */
public class JavaBeatHibernateExample {
	public static void testHibernate() {
		Configuration configuration = new Configuration();
		configuration.addClass(org.sommer.pm.data.domain.AuctionItem.class);
		configuration.setProperty("hibernate.dialect",
				"org.hibernate.dialect.DerbyDialect");
		configuration.setProperty("hibernate.connection.url",
				"jdbc:derby://localhost:1527/SampleDB");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.driver_class",
				"org.apache.derby.jdbc.ClientDriver");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.transaction.factory_class",
				"org.hibernate.transaction.JDBCTransactionFactory");
		configuration.setProperty("hibernate.current_session_context_class",
				"thread");
		configuration.setProperty("hibernate.show_sql", "true");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		AuctionItem auctionItem = new AuctionItem();
		auctionItem.setBid((long) 1);
		auctionItem.setBuyout((long) 2);
		auctionItem.setItem((long) 3);
		session.save(auctionItem);
		transaction.commit();
		session.close();
	}
}