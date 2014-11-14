package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.ClientThing;

public interface ClientThingService {
	
	public void addClientThing(ClientThing clientThing);
	
	public ClientThing getClientThing(Integer id);
	
	public List<ClientThing> listClientThing();
	
	public void removeClientThing(Integer id);
}
