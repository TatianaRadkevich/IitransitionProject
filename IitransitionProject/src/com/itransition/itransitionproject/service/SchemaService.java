package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.Schema;

public interface SchemaService {
	
	public void addSchema(Schema schema);
	
	public List<Schema> listSchema();
	
	public void removeSchema(Integer id);

}
