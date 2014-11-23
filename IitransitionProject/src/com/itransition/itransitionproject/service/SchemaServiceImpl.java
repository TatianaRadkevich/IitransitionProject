package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.SchemaDAO;
import com.itransition.itransitionproject.entity.SchemasOfUsers;
import com.itransition.itransitionproject.service.interfaces.SchemaService;
import com.itransition.itransitionproject.util.SearchUtil;

@Service
public class SchemaServiceImpl implements SchemaService {
 
    @Autowired
    private SchemaDAO schemaDAO;
 
    @Transactional
    public void addSchema(SchemasOfUsers schema) {
    	schemaDAO.addSchema(schema);
    }
    
    @Transactional
    public SchemasOfUsers getSchema(Integer id) {
    	return schemaDAO.getSchema(id);
    }
 
    @Transactional
    public List<SchemasOfUsers> listSchema() { 
        return schemaDAO.listSchema();
    }
 
    @Transactional
    public void removeSchema(Integer id) {
    	schemaDAO.removeSchema(id);
    }
    
    public List<SchemasOfUsers> search(String match) {
    	return SearchUtil.<SchemasOfUsers>search(SchemasOfUsers.class, "name", match);
    }

	/**
	 * @return the schemaDAO
	 */
	public SchemaDAO getSchemaDAO() {
		return schemaDAO;
	}

	/**
	 * @param schemaDAO the schemaDAO to set
	 */
	public void setSchemaDAO(SchemaDAO schemaDAO) {
		this.schemaDAO = schemaDAO;
	}
}

