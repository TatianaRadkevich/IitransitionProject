package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.ThingOfClient;

public interface ThingOfClientDAO {
	
	public void addThingOfClient(ThingOfClient thingOfClient);
	
	public ThingOfClient getThingOfClient(Integer id);
	
	public List<ThingOfClient> listThingOfClient();
	
	public void removeThingOfClient(Integer id);

}
