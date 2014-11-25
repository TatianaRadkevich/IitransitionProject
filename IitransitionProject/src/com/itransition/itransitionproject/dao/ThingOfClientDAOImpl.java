package com.itransition.itransitionproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.ThingOfClientDAO;
import com.itransition.itransitionproject.entity.ThingOfClient;

@Repository
public class ThingOfClientDAOImpl extends BaseDAOImpl implements ThingOfClientDAO{
    
	@Override
	public void addThingOfClient(ThingOfClient thingOfClient) {
		super.addElement(thingOfClient);
	}

	@Override
	public ThingOfClient getThingOfClient(Integer id) {
		return (ThingOfClient) super.getRecordById(ThingOfClient.class, id);
	}

	@Override
	public List<ThingOfClient> listThingOfClient() {
		return super.<ThingOfClient>getAllRecords("from ThingOfClient");
	}

	@Override
	public void removeThingOfClient(Integer id) {
		super.removeObject(ThingOfClient.class, id);
	}
}
