package com.itransition.itransitionproject.entity;

import java.security.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.itransition.itransitionproject.entity.linking.UserToThing;

@Entity
@Table(name = "users", catalog = "database", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL") })
public class User implements java.io.Serializable {

	private Integer userId;
	private String nameUser;
	private String email;
	private String password;
	private int role;
//	private Date date;
	
	private Set<UserToThing> userThings = new HashSet<UserToThing>(0);

	public User() {
//		Timestamp timestamp = null;
//		date = timestamp.getTimestamp();
	}

	

	public User(String nameUser, String email, String password, int role, Set<UserToThing> userThings) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.role = role;
		this.userThings = userThings;
//		Timestamp timestamp = null;
//		date = timestamp.getTimestamp();
	}



	public User(String nameUser, String email, String password, int role) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.role = role;
//		Timestamp timestamp = null;
//		date = timestamp.getTimestamp();
	}



	/**
	 * @return the userId
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the nameUser
	 */
	@Column(name = "NAME_USER", nullable = false, length = 10)
	public String getNameUser() {
		return nameUser;
	}

	/**
	 * @param nameUser the nameUser to set
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	/**
	 * @return the email
	 */
	@Column(name = "EMAIL", unique = true, nullable = false, length = 10)
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	@Column(name = "PASSWORD", nullable = false, length = 10)
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the userThings
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	public Set<UserToThing> getUserThings() {
		return userThings;
	}

	/**
	 * @param userThings the userThings to set
	 */
	public void setUserThings(Set<UserToThing> userThings) {
		this.userThings = userThings;
	}

	/**
	 * @return the role
	 */
	@Column(name = "ROLE", nullable = false, length = 10)
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
/*
	*//**
	 * @return the date
	 *//*
	@Column(name = "DATE", nullable = false, length = 10)
	public Date getDate() {
		return date;
	}*/

}