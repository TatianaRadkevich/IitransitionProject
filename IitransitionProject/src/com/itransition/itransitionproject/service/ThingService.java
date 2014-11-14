package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.Thing;

public interface ThingService {
	
	public void addThing(Thing thing);
	
	public Thing getThing(Integer id);
	
	public List<Thing> listThing();
	
	public void removeThing(Integer id);

}
