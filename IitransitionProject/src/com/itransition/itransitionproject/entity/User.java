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

@Entity
@Table(name = "users", catalog = "database", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL") })
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name = "NAME_USER", nullable = false, length = 10)
	private String nameUser;
	
	@Column(name = "EMAIL", unique = true, nullable = false, length = 10)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false, length = 10)
	private String password;
	
	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Thing> things;
		
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<ThingOfClient> clientThings;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<SchemasOfUsers> schemas;
	
	/*@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<RoleUser> roleUsers;*/

	public User() {}
	
	public User(String nameUser, String email, String password,
			boolean enabled, Set<Thing> things, Set<RoleUser> roleUsers) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.things = things;
//		this.roleUsers = roleUsers;
	}



	public User(String nameUser, String email, String password,
			boolean enabled, Set<Thing> things) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.things = things;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Thing> getThings() {
		return things;
	}

	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	public Set<ThingOfClient> getClientThings() {
		return clientThings;
	}

	public void setClientThings(Set<ThingOfClient> clientThings) {
		this.clientThings = clientThings;
	}

	public Set<SchemasOfUsers> getSchemas() {
		return schemas;
	}

	public void setSchemas(Set<SchemasOfUsers> schemas) {
		this.schemas = schemas;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

/*	*//**
	 * @return the roleUsers
	 *//*
	public Set<RoleUser> getRoleUsers() {
		return roleUsers;
	}

	*//**
	 * @param roleUsers the roleUsers to set
	 *//*
	public void setRoleUsers(Set<RoleUser> roleUsers) {
		this.roleUsers = roleUsers;
	}*/

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nameUser=" + nameUser + ", email="
				+ email + ", password=" + password
				+ ", things=" + things + ", clientThings=" + clientThings
				+ ", schemas=" + schemas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((nameUser == null) ? 0 : nameUser.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nameUser == null) {
			if (other.nameUser != null)
				return false;
		} else if (!nameUser.equals(other.nameUser))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	

}