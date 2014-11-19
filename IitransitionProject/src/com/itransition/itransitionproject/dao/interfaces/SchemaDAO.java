package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.SchemasOfUsers;

public interface SchemaDAO {
	
	public void addSchema(SchemasOfUsers schema);
	
	public SchemasOfUsers getSchema(Integer id);
	
	public List<SchemasOfUsers> listSchema();
	
	public void removeSchema(Integer id);

}
