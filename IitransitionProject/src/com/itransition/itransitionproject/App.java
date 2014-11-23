package com.itransition.itransitionproject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itransition.itransitionproject.entity.SchemasOfUsers;
import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.ThingOfClient;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.ThingOfClientServiceImpl;

@Service
public class App {
	// @Autowired поскольку при запуске приложения оно первым делом ижет в точку
	// входа, а не читает конфигурационные файлы, то здесь inject не работает =>
	// не работает и танзакция
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		System.out
				.println("Hibernate many to many - join table + extra column (Annotation)");
		Configuration configuration = new Configuration();
		configuration.configure("resources/hibernate.cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
		//		configuration.getProperties()).build();
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		System.err.println("сессия не пуста!!! = " + session);

		User user = new User();
		user.setNameUser("userAlexandr");
		user.setEmail("radkevich.t.s@gmail.com");
		user.setPassword("password");

		Thing thing = new Thing("name", "properties", "image");
		thing.setUser(user);

		ThingOfClient thingOfClient = new ThingOfClient();
		thingOfClient.setListValue("привет");
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
		session = sessionFactory.openSession();

		session.beginTransaction();
		List<User> userList = (List<User>) session.createQuery("from User")
				.list();
		session.getTransaction().commit();

		List<ThingOfClient> list = new ThingOfClientServiceImpl()
				.search("hello");

		for (ThingOfClient thing2 : list) {
			System.err
					.println("--------------------------------------------------------------------"
							+ thing2);
		}

		for (User usr : userList) {
			System.err.println(user.getEmail());
			System.err.println(user.getThings());
			System.err.println(user.getClientThings());
		}
		session.close();
		System.out.println("Done");
	}

}
