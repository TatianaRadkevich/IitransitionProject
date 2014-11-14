package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.domain.ClientThing;

@Repository
public class ClientThingDAOImpl implements ClientThingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addClientThing(ClientThing clientThing) {
        sessionFactory.getCurrentSession().save(clientThing);
    }
    
    public ClientThing getClientThing(Integer id) {
    	return (ClientThing) sessionFactory.getCurrentSession().load(ClientThing.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ClientThing> listClientThing() {
    	return sessionFactory.getCurrentSession().createQuery("from ClientThing").list();
    }

    public void removeClientThing(Integer id) {
    	ClientThing clientThing = (ClientThing) sessionFactory.getCurrentSession().load(
    			ClientThing.class, id);
        if (null != clientThing) {
            sessionFactory.getCurrentSession().delete(clientThing);
        }

    }
}
