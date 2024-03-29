package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.ThingDAO;
import com.itransition.itransitionproject.entity.SchemasOfUsers;
import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.ThingService;
import com.itransition.itransitionproject.util.SearchUtil;

@Service
public class ThingServiceImpl implements ThingService {
 
    @Autowired
    private ThingDAO thingDAO;
 
    @Transactional
    public void addThing(Thing thing, User user) {
    	thingDAO.addThingByUser(thing, user);
    }
    
    @Transactional
    public Thing getThing(Integer id) {
    	return thingDAO.getThing(id);
    }
 
    @Transactional
    public List<Thing> listThing() { 
        return thingDAO.listThing();
    }
 
    @Transactional
    public void removeThing(Integer id) {
    	thingDAO.removeThing(id);
    }
    
    public List<Thing> search(String match) {
    	return SearchUtil.<Thing>search(Thing.class, "name_thing", match);
    }

	/**
	 * @return the thingDAO
	 */
	public ThingDAO getThingDAO() {
		return thingDAO;
	}

	/**
	 * @param thingDAO the thingDAO to set
	 */
	public void setThingDAO(ThingDAO thingDAO) {
		this.thingDAO = thingDAO;
	}
}