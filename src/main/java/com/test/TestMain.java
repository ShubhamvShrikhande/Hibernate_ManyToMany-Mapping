package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user1 = new User();
		user1.setFirstName("ram");
		user1.setLastname("patil");
		user1.setEmail("ram@gmail.com");
		
		User user2 = new User();
		user2.setFirstName("shyam");
		user2.setLastname("chavan");
		user2.setEmail("shyam@gmail.com");
		
		Nominee nominee1 = new Nominee();
		nominee1.setName("ganesh");
		
		Nominee nominee2 = new Nominee();
		nominee2.setName("sachin");
		
		Nominee nominee3 = new Nominee();
		nominee3.setName("sagar");
		
		user1.getNimineeList().add(nominee1);
		user1.getNimineeList().add(nominee2);
		user1.getNimineeList().add(nominee3);
		
		nominee1.getUserList().add(user1);
		nominee2.getUserList().add(user1);
		nominee3.getUserList().add(user1);
		
		user1.getNimineeList().add(nominee2);
		user1.getNimineeList().add(nominee3);
		
		nominee2.getUserList().add(user2);
		nominee3.getUserList().add(user2);
		
		session.persist(user1);
		session.persist(user2);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

		
	}

}
