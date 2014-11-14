package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.ClientThingDAO;
import com.itransition.itransitionproject.domain.ClientThing;

@Service
public class ClientThingServiceImpl implements ClientThingService {
 
    @Autowired
    private ClientThingDAO clientThingDAO;
 
    @Transactional
    public void addClientThing(ClientThing clientThing) {
    	clientThingDAO.addClientThing(clientThing);
    }
 
    @Transactional
    public List<ClientThing> listClientThing() { 
        return clientThingDAO.listClientThing();
    }
 
    @Transactional
    public void removeClientThing(Integer id) {
    	clientThingDAO.removeClientThing(id);
    }
}

