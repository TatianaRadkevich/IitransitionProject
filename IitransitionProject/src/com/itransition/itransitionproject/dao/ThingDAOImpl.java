package com.itransition.itransitionproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.ThingDAO;
import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;

@Repository
public class ThingDAOImpl extends BaseDAOImpl implements ThingDAO{
	
    public void addThingByUser(Thing thing, User user) {
    	super.addElement(thing);
    }
    
    public Thing getThing(Integer id) {
    	return (Thing) super.getRecordById(Thing.class, id);
    }

    public List<Thing> listThing() {
    	return super.<Thing> getAllRecords("from Thing");
    }

    public void removeThing(Integer id) {
    	super.removeObject(Thing.class, id);
    }
}
