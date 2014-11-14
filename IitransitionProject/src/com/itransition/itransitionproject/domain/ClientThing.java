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
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTTHINGS")
public class ClientThing {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "LIST_VALUE")
	private String listValue;
	
	@Column(name = "ROTATION")
	private Integer rotation;
	
	@Column(name = "COORDINATES")
	private String coordinates;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_CLIENT_THING", joinColumns = @JoinColumn(name = "ID_CLIENT"),
		inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private User userClientthing;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "THING_TO_CLIENTTHING", joinColumns = @JoinColumn(name = "ID_CLIENTTHING"),
		inverseJoinColumns = @JoinColumn(name = "ID_THING"))
	private Thing thing;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CLIENTHING_TO_SCHEMA", joinColumns = @JoinColumn(name = "ID_CLIENTTHING_TO_SCHEMA"),
		inverseJoinColumns = @JoinColumn(name = "ID_SCHEMA_TO_CLIENTTHING"))
	private Set<Schema> schemasWithClietthing;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getListValue() {
		return listValue;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

	public Integer getRotation() {
		return rotation;
	}

	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	

	public User getUserClientthing() {
		return userClientthing;
	}

	public void setUserClientthing(User userClientthing) {
		this.userClientthing = userClientthing;
	}

	public Thing getThing() {
		return thing;
	}
	

	public void setThing(Thing thing) {
		this.thing = thing;
	}

	
	public Set<Schema> getSchemasWithClietthing() {
		return schemasWithClietthing;
	}

	
	public void setSchemasWithClietthing(Set<Schema> schemasWithClietthing) {
		this.schemasWithClietthing = schemasWithClietthing;
	}
	

}
