package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.ThingDAO;
import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;

@Repository
public class ThingDAOImpl extends BaseDAOImpl implements ThingDAO{

	@Autowired
	SessionFactory session;
	
    public void addThingByUser(Thing thing, User user) {
    	super.addElement(thing);
    }
    
    public Thing getThing(Integer id) {
    	return (Thing) super.getRecordById(Thing.class, id);
    }

    public List<Thing> listThing() {
    	return session.openSession().createQuery("from Thing").list();
    }

    public void removeThing(Integer id) {
    	Thing thing = (Thing) session.openSession().get(Thing.class, id);
        if (null != thing) {
            session.openSession().delete(thing);
        }

    }
}
