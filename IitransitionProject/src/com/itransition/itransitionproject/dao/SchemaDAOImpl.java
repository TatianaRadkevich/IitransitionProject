package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.SchemaDAO;
import com.itransition.itransitionproject.entity.Schema;
import com.itransition.itransitionproject.util.HibernateUtil;

@Repository
public class SchemaDAOImpl implements SchemaDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void addSchema(Schema schema) {
        sessionFactory.getCurrentSession().save(schema);
    }
    
    public Schema getSchema(Integer id) {
    	return (Schema) sessionFactory.getCurrentSession().load(Schema.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Schema> listSchema() {
    	return sessionFactory.getCurrentSession().createQuery("from Schema").list();
    }

    public void removeSchema(Integer id) {
    	Schema schema = (Schema) sessionFactory.getCurrentSession().load(
    			Schema.class, id);
        if (null != schema) {
            sessionFactory.getCurrentSession().delete(schema);
        }

    }
}
