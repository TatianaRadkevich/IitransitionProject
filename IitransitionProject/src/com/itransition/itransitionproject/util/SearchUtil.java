package com.itransition.itransitionproject.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.jpa.Search;

public class SearchUtil {
	private static EntityManager em;
	private static FullTextEntityManager fullTextEntityManager;
	
	static {
		
		em = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
		fullTextEntityManager = Search.getFullTextEntityManager(em);
		try {
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static List search(Class clazz, String field, String match) {
		
		em.getTransaction().begin();
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(clazz).get();
		org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields(field).matching(match).createQuery();
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, clazz);
		List result = jpaQuery.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
	}

}
