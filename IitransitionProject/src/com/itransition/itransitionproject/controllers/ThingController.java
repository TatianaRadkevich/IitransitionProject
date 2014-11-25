package com.itransition.itransitionproject.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itransition.itransitionproject.entity.Thing;
import com.itransition.itransitionproject.service.interfaces.ThingService;
import com.itransition.itransitionproject.service.interfaces.UserService;

@Controller
public class ThingController {
	
	private static final String FILE_STORAGE_PATH = "C:\\iTransition\\itransitionproject\\IitransitionProject\\WebContent\\WEB-INF\\pictures\\";
	private static final Character PROPERTIES_DELIMETER = '|';
	
	
	@Autowired
	private ThingService thingService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/thing**", method = RequestMethod.GET)
	public ModelAndView addThing() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Add your own thing! (only for Owners)");
		model.addObject("message", "Let's try to add something, little boy!");
		model.setViewName("thing");
		List<Thing> list = thingService.listThing();
		for (Thing thing : list)
			thingService.removeThing(thing.getThingId());
		return model;

	}

	@RequestMapping(value = "/thing**", method = RequestMethod.POST)
	public ModelAndView addThing(
			@RequestParam(value = "picture", required = false) MultipartFile picture,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "properties[]", required = false) String[] properties) {		
		ModelAndView model = new ModelAndView();
		createThing(picture, name, properties);
		model.addObject("title", "Add your own thing! (only for Owners)");
		model.addObject("message", "You've done it! Do it again!");
		model.setViewName("thing");
		return model;
	}
	
	public boolean createThing(MultipartFile file, String name, String[] properties) {
		Thing thing = new Thing();
		thing.setName_thing(name);
		thing.setProperties(getProperties(properties));
		thing.setImageRef(getFileName());
		if (!savePicture(file, thing.getImageRef()))
			return false;
		thingService.addThing(thing, null);
		return true;
	}
	
	public boolean savePicture(MultipartFile file, String fileName) {
		try {
			InputStream is = file.getInputStream();
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			FileOutputStream fos = new FileOutputStream(new File(FILE_STORAGE_PATH + fileName));
			fos.write(bytes);
			is.close();
			fos.close();
			return true;
			
		} catch (IOException e) { e.printStackTrace(); }
		
		return false;
	}

	public String getProperties(String[] properties) {
		String result = "";
		for (String prop : properties)
			result += prop + PROPERTIES_DELIMETER;
		return result;
	}
	
	public String getFileName() {
		File file = new File(FILE_STORAGE_PATH);
		return (file.listFiles().length + 1) + ".jpg";
	}
	
	public ThingService getThingService() {
		return thingService;
	}

	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}