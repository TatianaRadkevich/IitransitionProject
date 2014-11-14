package com.itransition.itransitionproject.domain;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ROLE")
	private Integer role;
	
	@OneToMany(mappedBy = "userThing", fetch = FetchType.LAZY)
	private Set<Thing> things;
	
	@OneToMany(mappedBy = "userClientthing", fetch = FetchType.LAZY)
	private Set<ClientThing> clientThings;
	
	@OneToMany(mappedBy = "userSchema", fetch = FetchType.LAZY)
	private Set<Schema> schemas;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Set<Thing> getThings() {
		return things;
	}

	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	public Set<ClientThing> getClientThings() {
		return clientThings;
	}

	public void setClientThings(Set<ClientThing> clientThings) {
		this.clientThings = clientThings;
	}

	public Set<Schema> getSchemas() {
		return schemas;
	}

	public void setSchemas(Set<Schema> schemas) {
		this.schemas = schemas;
	}	
	
}
