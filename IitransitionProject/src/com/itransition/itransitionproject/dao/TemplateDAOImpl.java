package com.itransition.itransitionproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.TemplateDAO;
import com.itransition.itransitionproject.entity.TemplateTable;

public class TemplateDAOImpl extends BaseDAOImpl implements TemplateDAO {

	private static final String SELECT_REF = "from TemplateTable where ref = :ref";
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRef(TemplateTable table) {
		super.addElement(table);
	}

	@Override
	@Transactional
	public void remoteRef(TemplateTable table) {
		Session session = getSessionFactory().openSession();
		session.createQuery("delete TemplateTable where id_table = " + table.getId_table()).executeUpdate();
		session.flush();
		session.close();
	}

	@Override
	@Transactional
	public TemplateTable getTemplateTable(String ref) {
		Session session = getSessionFactory().openSession();
		TemplateTable table = (TemplateTable) session.createQuery(SELECT_REF).setParameter("ref", ref).list().get(0);
		session.flush();
		session.close();
	//	TemplateTable table = (TemplateTable) sessionFactory.getCurrentSession().createQuery(SELECT_REF).setParameter("ref", ref).list().get(0);
		return table;
	}

}
