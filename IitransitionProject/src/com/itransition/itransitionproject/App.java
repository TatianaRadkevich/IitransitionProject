package com.itransition.itransitionproject;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.itransition.itransitionproject.entity.SchemasOfUsers;
import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.ThingOfClient;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.util.HibernateUtil;

@Service
public class App {
	
	public static void main(String[] args) {
		System.out
				.println("Hibernate many to many - join table + extra column (Annotation)");

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		User user = new User();
		user.setNameUser("userAlexandr");
		user.setEmail("radkevich.t.s@gmail.com");
		user.setPassword("password");
		
		Thing thing = new Thing("name", "properties", "image");
		thing.setUser(user);
		
		ThingOfClient thingOfClient = new ThingOfClient();
		thingOfClient.setListValue("HELLO");
		thingOfClient.setThing(thing);
		thingOfClient.setUser(user);
		
		
		SchemasOfUsers schema = new SchemasOfUsers();
		schema.setName("aaaa");
		schema.setCountUsers(12);
		schema.setSumRaiting(100);
		schema.setParameters("HAHAH");
		schema.setUser(user);
		schema.addClientThing(thingOfClient);
		
		
		session.beginTransaction();
		session.save(user);
		session.save(thing);
		session.save(thingOfClient);
		session.save(schema);
		session.getTransaction().commit();
		
		session.close();
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		List<User> userList = (List<User>)session.createQuery("from User").list();
		session.getTransaction().commit();
		
		for (User usr : userList) {
			System.err.println(usr.getEmail());			
			System.err.println(usr.getThings());
			System.err.println(usr.getClientThings());
		}
		
		session.flush();
		session.close();
		System.out.println("Done");
	}

	
}
