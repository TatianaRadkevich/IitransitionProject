package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;

public interface ThingDAO {
		
		public void addThingByUser(Thing thing, User user);
		
		public Thing getThing(Integer id);
		
		public List<Thing> listThing();
		
		public void removeThing(Integer id);

}
