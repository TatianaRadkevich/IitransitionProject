package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface BaseDAO {
	public Object getRecordById(Class classObject, Integer id);

	public void addElement(Object object);

	public List<Object> getAllRecords(String queryStr);
	
	public void updateObject(Object object);
}
