package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.SchemaDAO;
import com.itransition.itransitionproject.domain.Schema;

@Service
public class SchemaServiceImpl implements SchemaService {
 
    @Autowired
    private SchemaDAO schemaDAO;
 
    @Transactional
    public void addSchema(Schema schema) {
    	schemaDAO.addSchema(schema);
    }
    
    @Transactional
    public Schema getSchema(Integer id) {
    	return schemaDAO.getSchema(id);
    }
 
    @Transactional
    public List<Schema> listSchema() { 
        return schemaDAO.listSchema();
    }
 
    @Transactional
    public void removeSchema(Integer id) {
    	schemaDAO.removeSchema(id);
    }
}

