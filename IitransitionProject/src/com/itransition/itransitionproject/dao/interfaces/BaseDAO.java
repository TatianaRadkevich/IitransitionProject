package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

public interface BaseDAO {
	
	public Object getRecordById(Class classObject, Integer id);

	public void addElement(Object object);

	public <T> List<T> getAllRecords(String queryStr);
	
	public void updateObject(Object object);
	
	public void deleteObject(Object object);
	
	public void removeObject(Class classObject, Integer id);
	
	public void executeQuery(String string, String nameParameter, String parameter);
	
	public Object getByQuery(String string, String nameParameter, String parameter);
}
