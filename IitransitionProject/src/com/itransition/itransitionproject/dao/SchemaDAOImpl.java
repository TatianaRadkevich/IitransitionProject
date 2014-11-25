package com.itransition.itransitionproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.SchemaDAO;
import com.itransition.itransitionproject.entity.SchemasOfUsers;

@Repository
public class SchemaDAOImpl extends BaseDAOImpl implements SchemaDAO {

    public void addSchema(SchemasOfUsers schema) {
        super.addElement(schema);
    }
    
    public SchemasOfUsers getSchema(Integer id) {
    	return (SchemasOfUsers) super.getRecordById(SchemasOfUsers.class, id);
    }

    public List<SchemasOfUsers> listSchema() {
    	return super.<SchemasOfUsers>getAllRecords("from Schema");
    }

    public void removeSchema(Integer id) {
    	super.removeObject(SchemasOfUsers.class, id);
    }
}
