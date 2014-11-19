package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.ComboPropertiesDAO;
import com.itransition.itransitionproject.entity.ComboProperties;
import com.itransition.itransitionproject.util.HibernateUtil;

@Repository
public class ComboPropertiesDAOImpl implements ComboPropertiesDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void addComboProperties(ComboProperties comboProperties) {
        sessionFactory.getCurrentSession().save(comboProperties);
    }
    
    public ComboProperties getComboProperties(Integer id) {
    	return (ComboProperties) sessionFactory.getCurrentSession().load(ComboProperties.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ComboProperties> listComboProperties() {
    	return sessionFactory.getCurrentSession().createQuery("from ComboProperties").list();
    }

    public void removeComboProperties(Integer id) {
    	ComboProperties comboProperties = (ComboProperties) sessionFactory.getCurrentSession().load(
    			ComboProperties.class, id);
        if (null != comboProperties) {
            sessionFactory.getCurrentSession().delete(comboProperties);
        }

    }
}
