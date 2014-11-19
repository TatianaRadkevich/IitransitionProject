package com.itransition.itransitionproject.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "things_of_client")
public class ThingOfClient {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_THING_OF_CLIENT")
	private Integer id;
	
	@Column(name = "LIST_VALUE")
	private String listValue;
	
	@Column(name = "ROTATION")
	private Integer rotation;
	
	@Column(name = "COORDINATES")
	private String coordinates;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_THING_OF_CLIENT", joinColumns = @JoinColumn(name = "ID_THING_OF_CLIENT"),
		inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private User user;
		
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "THING_TO_THING_OF_CLIENT", joinColumns = @JoinColumn(name = "ID_THING_OF_CLIENT"),
		inverseJoinColumns = @JoinColumn(name = "ID_THING"))
	private Thing thing;
		
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CLIENTHING_TO_SCHEMA", joinColumns = @JoinColumn(name = "ID_CLIENTTHING"),
		inverseJoinColumns = @JoinColumn(name = "ID_SCHEMA"))
	private Set<SchemasOfUsers> schemas;

	public ThingOfClient(String listValue, Integer rotation,
			String coordinates, User user) {
		super();
		this.listValue = listValue;
		this.rotation = rotation;
		this.coordinates = coordinates;
		this.user = user;
	}

	public ThingOfClient() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Thing getThing() {
		return thing;
	}

	public void setThing(Thing thing) {
		this.thing = thing;
	}

	public Set<SchemasOfUsers> getSchemas() {
		return schemas;
	}

	public void setSchemas(Set<SchemasOfUsers> schemas) {
		this.schemas = schemas;
	}

	@Override
	public String toString() {
		return "ThingOfClient [id=" + id + ", listValue=" + listValue
				+ ", rotation=" + rotation + ", coordinates=" + coordinates
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((listValue == null) ? 0 : listValue.hashCode());
		result = prime * result
				+ ((rotation == null) ? 0 : rotation.hashCode());
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
		ThingOfClient other = (ThingOfClient) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listValue == null) {
			if (other.listValue != null)
				return false;
		} else if (!listValue.equals(other.listValue))
			return false;
		if (rotation == null) {
			if (other.rotation != null)
				return false;
		} else if (!rotation.equals(other.rotation))
			return false;
		return true;
	}
	
	
}
