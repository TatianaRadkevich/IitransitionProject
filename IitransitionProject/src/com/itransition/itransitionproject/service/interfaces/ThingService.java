package com.itransition.itransitionproject.service.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;

public interface ThingService {
	
	public void addThing(Thing thing, User user);
	
	public Thing getThing(Integer id);
	
	public List<Thing> listThing();
	
	public void removeThing(Integer id);

}
