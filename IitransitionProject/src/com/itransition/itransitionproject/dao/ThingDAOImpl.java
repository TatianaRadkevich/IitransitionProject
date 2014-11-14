package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.domain.Thing;

@Repository
public class ThingDAOImpl implements ThingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addThing(Thing thing) {
        sessionFactory.getCurrentSession().save(thing);
    }
    
    public Thing getThing(Integer id) {
    	return (Thing) sessionFactory.getCurrentSession().load(Thing.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Thing> listThing() {
    	return sessionFactory.getCurrentSession().createQuery("from Thing").list();
    }

    public void removeThing(Integer id) {
    	Thing thing = (Thing) sessionFactory.getCurrentSession().load(
    			Thing.class, id);
        if (null != thing) {
            sessionFactory.getCurrentSession().delete(thing);
        }

    }
}
