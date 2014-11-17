package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.Schema;

public interface SchemaDAO {
	
	public void addSchema(Schema schema);
	
	public Schema getSchema(Integer id);
	
	public List<Schema> listSchema();
	
	public void removeSchema(Integer id);

}
