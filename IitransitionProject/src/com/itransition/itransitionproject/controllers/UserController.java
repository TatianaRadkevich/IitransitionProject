package com.itransition.itransitionproject.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.common.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itransition.itransitionproject.entity.RoleUser;
import com.itransition.itransitionproject.entity.TemplateTable;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.RoleUserService;
import com.itransition.itransitionproject.service.interfaces.TemplateService;
import com.itransition.itransitionproject.service.interfaces.UserService;
import com.itransition.itransitionproject.util.SendMessAction;
import com.itransition.itransitionproject.util.UUIDGenerater;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleUserService roleUserService;
	@Autowired
	private TemplateService templateService;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error",
					getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/registration**", method = RequestMethod.GET)
	public ModelAndView registration() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "Это стр регистрации");
		model.setViewName("registration");
		return model;

	}

	@RequestMapping(value = "/registration**", method = RequestMethod.POST)
	public ModelAndView registration(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password) {
		templateService.addRef(save(username, email, password),
				generateLetter(email));
		ModelAndView model = getModelAndViewConfirm();
		return model;
	}

	@RequestMapping(value = "/user**")
	public ModelAndView page(@RequestParam(value = "ref", required = false) String ref) {
		ModelAndView model = new ModelAndView();
		TemplateTable table = templateService.findRef(ref);
		if(table != null){
			templateService.remoteRef(table);
			User user = table.getUser();
			RoleUser roleUser = new RoleUser(user, "ROLE_USER");
			roleUserService.addRole(roleUser);
			user.setEnabled(true);
			userService.updateUser(table.getUser());
			model.addObject("msg", "Ваша регистрация подтверждена! Авторизуйтесь");
			model.setViewName("login");
		}
		else{
			model.addObject("msg", "Вы не регистрировались. Пройдите регистрацию!");
			model.setViewName("registration");
		}
		model.addObject("title", "Spring Security + Hibernate Example");
		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession()
				.getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

	private User save(String username, String email, String password) {
		User user = new User(username, email, password, false);
		userService.addUser(user);
		return userService.getUser(email);
	}

	private ModelAndView getModelAndViewConfirm() {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> messages = new ArrayList<String>();
		keys.add("msg");
		messages.add("Вам на почту отправлено письмо! Проверьте!");
		return setModelAndView(keys, messages, "confirm");
	}

	private String generateLetter(String email) {
		String ref = UUIDGenerater.getUUID();
		SendMessAction action = new SendMessAction();
		action.setEmail(email);
		action.setMessage(UUIDGenerater.getMessage(ref));
		action.action();
		return ref;
	}

	private ModelAndView setModelAndView(ArrayList<String> key,
			ArrayList<String> messages, String page) {
		ModelAndView model = new ModelAndView();
		for (int i = 0; i < key.size(); i++)
			model.addObject(key.get(i), messages.get(i));
		model.setViewName(page);
		return model;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the templateService
	 */
	public TemplateService getTemplateService() {
		return templateService;
	}

	/**
	 * @param templateService the templateService to set
	 */
	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}

	/**
	 * @return the roleUserService
	 */
	public RoleUserService getRoleUserService() {
		return roleUserService;
	}

	/**
	 * @param roleUserService the roleUserService to set
	 */
	public void setRoleUserService(RoleUserService roleUserService) {
		this.roleUserService = roleUserService;
	}
}