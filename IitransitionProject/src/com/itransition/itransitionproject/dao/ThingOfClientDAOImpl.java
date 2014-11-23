package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.ThingOfClientDAO;
import com.itransition.itransitionproject.entity.ThingOfClient;

@Repository
public class ThingOfClientDAOImpl implements ThingOfClientDAO{

	@Autowired
	private SessionFactory sessionFactory;
    
	@Override
	public void addThingOfClient(ThingOfClient thingOfClient) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(thingOfClient);
		session.getTransaction().commit();
	}

	@Override
	public ThingOfClient getThingOfClient(Integer id) {
		return (ThingOfClient) sessionFactory.getCurrentSession().load(ThingOfClient.class, id);
	}

	@Override
	public List<ThingOfClient> listThingOfClient() {
		return sessionFactory.getCurrentSession().createQuery("from ThingOfClient").list();
	}

	@Override
	public void removeThingOfClient(Integer id) {
		ThingOfClient clientThing = (ThingOfClient) sessionFactory.getCurrentSession().load(
    			ThingOfClient.class, id);
        if (null != clientThing) {
            sessionFactory.getCurrentSession().delete(clientThing);
        }
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
