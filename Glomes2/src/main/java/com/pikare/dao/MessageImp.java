package com.pikare.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.pikare.model.MessageSenders;
import com.pikare.model.Users;

public class MessageImp implements Message {
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDao userDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageSenders> getAll() {
		List<MessageSenders> users = new ArrayList<MessageSenders>();
		Session session = null;
		Transaction txn = null;
		try {  
		    session = sessionFactory.openSession();  
		    txn = session.beginTransaction();
		    Query query = session.createQuery("from MessageSenders"); //You will get Weayher object
		    users = (List<MessageSenders>)query.list();
		    txn.commit();
		    System.out.println("başarli bir şekilde eklendi");

		} catch (Exception e) { 
		    System.out.println(e.getMessage());
		} finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }

		    session.flush();  
		    session.close();   
		}
		return users;
	}

	@Override
	public MessageSenders getBySenderID(String ID , String repID) {
		List<MessageSenders> users = new ArrayList<MessageSenders>();
		Session session = null;
		Transaction txn = null;
		try {  
		    session = sessionFactory.openSession();  
		    txn = session.beginTransaction();
		    Query query = session.createQuery("from MessageSenders where senderID = '"+ID+"' and repID = '"+repID+"'"); //You will get Weayher object
		    users = (List<MessageSenders>)query.list();
		    txn.commit();
		    System.out.println("başarli bir şekilde eklendi");

		} catch (Exception e) { 
		    System.out.println(e.getMessage());
		} finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }

		    session.flush();  
		    session.close();   
		}
		if(users.size() > 0)
			return users.get(0);
		else 
			return null;
	}

	@SuppressWarnings("null")
	@Override
	public MessageSenders save(MessageSenders senders) {
		

		MessageSenders send = getBySenderID(senders.getSenderID() , senders.getRepID());
		if(send != null)
		{
			senders.setId(send.getId());
			senders.setSenderName(send.getSenderName());
			senders.setUserName(send.getUserName());
		}
		
		Session session = null;
		Transaction txn = null;
		try {  
		    session = sessionFactory.openSession();  
		    txn = session.beginTransaction();
		    session.saveOrUpdate(senders);
		    txn.commit();
		    System.out.println("başarli bir şekilde eklendi");

		} catch (Exception e) { 
		    System.out.println(e.getMessage());
		    return null;
		} finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }

		    session.flush();  
		    session.close();   
		}
		return senders;
		
	}
	@SuppressWarnings("null")
	@Override
	public boolean update(MessageSenders senders) {
		
		Session session = null;
		Transaction txn = null;
		try {  
		    session = sessionFactory.openSession();  
		    txn = session.beginTransaction();
		    session.update(senders);
		    txn.commit();
		    System.out.println("başarli bir şekilde eklendi");

		} catch (Exception e) { 
		    System.out.println(e.getMessage());
		    return false;
		} finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }

		    session.flush();  
		    session.close();   
		}
		return true;
		
	}

}
