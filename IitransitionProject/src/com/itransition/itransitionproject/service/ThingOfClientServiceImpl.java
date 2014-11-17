package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.ThingOfClientDAO;
import com.itransition.itransitionproject.entity.ThingOfClient;
import com.itransition.itransitionproject.service.interfaces.ThingOfClientService;

@Service
public class ThingOfClientServiceImpl implements ThingOfClientService {
 
    @Autowired
    private ThingOfClientDAO thingOfClientDAO;
 
	@Override
	@Transactional
	public void addThingOfClient(ThingOfClient thingOfClient) {
		thingOfClientDAO.addThingOfClient(thingOfClient);
	}

	@Override
	@Transactional
	public ThingOfClient getThingOfClient(Integer id) {
		return thingOfClientDAO.getThingOfClient(id);
	}

	@Override
	@Transactional
	public List<ThingOfClient> listThingOfClients() {
		return thingOfClientDAO.listThingOfClient();
	}

	@Override
	@Transactional
	public void removeThingOfClient(Integer id) {
		thingOfClientDAO.removeThingOfClient(id);
		
	}
}

