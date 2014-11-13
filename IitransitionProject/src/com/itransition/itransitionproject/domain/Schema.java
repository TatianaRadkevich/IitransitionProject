package com.itransition.itransitionproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEMAS")
public class Schema {
	
	@Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PARAM")
	private String parameters;
	
	@Column(name = "SUM_RAITING")
	private Integer sumRaiting;
	
	@Column(name = "COUNT_USERS")
	private Integer countUsers;

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

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Integer getSumRaiting() {
		return sumRaiting;
	}

	public void setSumRaiting(Integer sumRaiting) {
		this.sumRaiting = sumRaiting;
	}

	public Integer getCountUsers() {
		return countUsers;
	}

	public void setCountUsers(Integer countUsers) {
		this.countUsers = countUsers;
	}
}
