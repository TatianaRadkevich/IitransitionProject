package com.itransition.itransitionproject.service.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.Schema;

public interface SchemaService {
	
	public void addSchema(Schema schema);
	
	public Schema getSchema(Integer id);
	
	public List<Schema> listSchema();
	
	public void removeSchema(Integer id);

}
