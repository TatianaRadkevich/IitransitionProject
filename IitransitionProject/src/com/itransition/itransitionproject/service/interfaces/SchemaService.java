package com.itransition.itransitionproject.service.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.SchemasOfUsers;

public interface SchemaService {
	
	public void addSchema(SchemasOfUsers schema);
	
	public SchemasOfUsers getSchema(Integer id);
	
	public List<SchemasOfUsers> listSchema();
	
	public void removeSchema(Integer id);

}
