package com.itransition.itransitionproject.dao;

import java.util.List;

import com.itransition.itransitionproject.domain.Schema;

public interface SchemaDAO {
	
	public void addSchema(Schema schema);
	
	public Schema getSchema(Integer id);
	
	public List<Schema> listSchema();
	
	public void removeSchema(Integer id);

}
