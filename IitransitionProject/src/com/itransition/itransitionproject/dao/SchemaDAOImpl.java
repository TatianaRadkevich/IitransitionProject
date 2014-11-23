package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.SchemaDAO;
import com.itransition.itransitionproject.entity.SchemasOfUsers;

@Repository
public class SchemaDAOImpl implements SchemaDAO {

	@Autowired
    private SessionFactory sessionFactory;

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

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
