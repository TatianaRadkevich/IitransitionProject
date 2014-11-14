package com.itransition.itransitionproject.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToMany(mappedBy = "schemasWithClietthing", fetch = FetchType.LAZY)
	private Set<ClientThing> clentThings;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_SCHEMA", joinColumns = @JoinColumn(name = "ID_SCHEMA"),
		inverseJoinColumns = @JoinColumn(name = "ID_USERS"))
	private User userSchema;

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

	public Set<ClientThing> getClentThings() {
		return clentThings;
	}

	public void setClentThings(Set<ClientThing> clentThings) {
		this.clentThings = clentThings;
	}

	public User getUserSchema() {
		return userSchema;
	}

	public void setUserSchema(User userSchema) {
		this.userSchema = userSchema;
	}	
}
