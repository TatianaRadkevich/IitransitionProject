package com.itransition.itransitionproject.service.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.ThingOfClient;

public interface ThingOfClientService {
	
	public void addThingOfClient(ThingOfClient thingOfClient);
	
	public ThingOfClient getThingOfClient(Integer id);
	
	public List<ThingOfClient> listThingOfClients();
	
	public void removeThingOfClient(Integer id);
}
