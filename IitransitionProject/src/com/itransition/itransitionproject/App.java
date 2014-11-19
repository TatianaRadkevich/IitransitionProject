package com.itransition.itransitionproject;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.ThingService;
import com.itransition.itransitionproject.service.interfaces.UserService;
import com.itransition.itransitionproject.util.HibernateUtil;

@Service
public class App {
	private static final String SELECT_ALL_FROM_THING = "from Thing";
	@Autowired
	private static UserService userService;
	@Autowired
	private static ThingService thingService;
	
	public static void main(String[] args) {
		System.out
				.println("Hibernate many to many - join table + extra column (Annotation)");

		Session session = HibernateUtil.getSessionFactory().openSession();
		// Создаём новoго user
		User user = new User();
		user.setNameUser("userAlexandr");
		user.setEmail("radkevich.t.s@gmail.com");
		user.setPassword("password");
		Thing thing = new Thing("name", "properties", "image");
//		user.setDate("");
		// добавляем его в базу
		session.beginTransaction();
		thing.setUser(user);
		session.save(user);
		session.save(thing);
		session.getTransaction().commit();
		session.close();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> userList = (List<User>)session.createQuery("from User order by id").list();
		session.getTransaction().commit();
		for (User usr : userList) {
			System.out.println(usr.getEmail());			
			System.out.println(usr.getThings());
		}
		
		// возвращаем из базы
		/*User user1 = userService.getUserByEmailAndPass("radkevich.t.s@gmail.com", "password");
		// создаём thing
		Thing thing = new Thing("name", "properties", "image");
		// добавляем в базу thing как связку
		thingService.addThing(thing, user1);
		// создаём thing
		thing = new Thing("name1", "properties1", "image1");
		// добавляем в базу thing как связку
		thingService.addThing(thing, user1);
		// создаём thing
		thing = new Thing("name2", "properties2", "image2");
		// добавляем в базу thing как связку
		thingService.addThing(thing, user1);
		// удаляем user1 из базы
		// deleteElement(session, user1);

	/*	User user2 = userService.getUserByEmailAndPass("radkevich.t.s@gmail.com", "password");
		user2.setNameUser("Татьяна");
		userDao.updateUser(user2.getUserId(), user2, session);*/
		session.flush();
		session.close();
		System.out.println("Done");
	}

	
}
