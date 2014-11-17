package com.itransition.itransitionproject;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.ThingService;
import com.itransition.itransitionproject.service.interfaces.UserService;
import com.itransition.itransitionproject.util.HibernateUtil;

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
		// ������ ���o�� user
		User user = new User();
		user.setNameUser("userAlexandr");
		user.setEmail("radkevich.t.s@gmail.com");
		user.setPassword("password");
//		user.setDate("");
		// ��������� ��� � ����
		userService.addUser(user);
		// ���������� �� ����
		User user1 = userService.getUserByEmailAndPass("radkevich.t.s@gmail.com", "password");
		// ������ thing
		Thing thing = new Thing("name", "properties", "image");
		// ��������� � ���� thing ��� ������
		thingService.addThing(thing, user1);
		// ������ thing
		thing = new Thing("name1", "properties1", "image1");
		// ��������� � ���� thing ��� ������
		thingService.addThing(thing, user1);
		// ������ thing
		thing = new Thing("name2", "properties2", "image2");
		// ��������� � ���� thing ��� ������
		thingService.addThing(thing, user1);
		// ������� user1 �� ����
		// deleteElement(session, user1);

	/*	User user2 = userService.getUserByEmailAndPass("radkevich.t.s@gmail.com", "password");
		user2.setNameUser("�������");
		userDao.updateUser(user2.getUserId(), user2, session);*/
		session.flush();
		session.close();
		System.out.println("Done");
	}

	
}
