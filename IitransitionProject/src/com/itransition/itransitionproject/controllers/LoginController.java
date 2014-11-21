package com.itransition.itransitionproject.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itransition.itransitionproject.App;
import com.itransition.itransitionproject.dao.SchemaDAOImpl;
import com.itransition.itransitionproject.dao.ThingOfClientDAOImpl;
import com.itransition.itransitionproject.dao.UserDAOImpl;
import com.itransition.itransitionproject.entity.SchemasOfUsers;
import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.entity.ThingOfClient;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.SchemaServiceImpl;
import com.itransition.itransitionproject.service.ThingOfClientServiceImpl;
import com.itransition.itransitionproject.service.UserServiceImpl;
import com.itransition.itransitionproject.service.interfaces.ThingOfClientService;
import com.itransition.itransitionproject.util.HibernateUtil;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	ThingOfClientServiceImpl thingOfClientService;

	private void action() {
		ThingOfClient thingOfClient = new ThingOfClient();
		thingOfClient.setListValue("q");	
		thingOfClientService.addThingOfClient(thingOfClient);
		List<ThingOfClient> list = thingOfClientService.search("FU");
		for (ThingOfClient thing2 : list) {
			System.out.println(thing2);
		}

	}
	
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model) {
    	action();
        return "login";
    }

}
