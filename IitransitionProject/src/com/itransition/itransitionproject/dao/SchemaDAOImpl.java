package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.SchemaDAO;
import com.itransition.itransitionproject.entity.SchemasOfUsers;
import com.itransition.itransitionproject.util.HibernateUtil;

@Repository
public class SchemaDAOImpl implements SchemaDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void addSchema(SchemasOfUsers schema) {
        sessionFactory.getCurrentSession().save(schema);
    }
    
    public SchemasOfUsers getSchema(Integer id) {
    	return (SchemasOfUsers) sessionFactory.getCurrentSession().load(SchemasOfUsers.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<SchemasOfUsers> listSchema() {
    	return sessionFactory.getCurrentSession().createQuery("from Schema").list();
    }

    public void removeSchema(Integer id) {
    	SchemasOfUsers schema = (SchemasOfUsers) sessionFactory.getCurrentSession().load(
    			SchemasOfUsers.class, id);
        if (null != schema) {
            sessionFactory.getCurrentSession().delete(schema);
        }

    }
}
