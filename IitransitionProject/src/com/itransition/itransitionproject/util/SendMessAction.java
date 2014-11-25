package com.itransition.itransitionproject.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itransition.itransitionproject.mail.Sender;

public class SendMessAction {

	private static Sender tlsSender = new Sender("web.programming.kursach@gmail.com", "kursachFORItransition");
	private String email;
	private String message;

	public void action() {
		String subject = "Итра проект приветствует Вас!!!)))";
		// subject - заголовок, message = тело письма, далее от кого и куда
		tlsSender.send(subject, message, "web.programming.kursach@gmail.com", email);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
