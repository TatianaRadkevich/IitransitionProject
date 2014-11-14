package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.ThingDAO;
import com.itransition.itransitionproject.domain.Thing;

@Service
public class ThingServiceImpl implements ThingService {
 
    @Autowired
    private ThingDAO thingDAO;
 
    @Transactional
    public void addThing(Thing thing) {
    	thingDAO.addThing(thing);
    }
 
    @Transactional
    public List<Thing> listThing() { 
        return thingDAO.listThing();
    }
 
    @Transactional
    public void removeThing(Integer id) {
    	thingDAO.removeThing(id);
    }
}