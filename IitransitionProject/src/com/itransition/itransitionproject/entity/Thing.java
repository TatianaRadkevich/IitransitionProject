package com.itransition.itransitionproject.entity;

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

import com.itransition.itransitionproject.entity.linking.UserToThing;

@Entity
@Table(name = "things", catalog = "database")
public class Thing implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_THING", unique = true, nullable = false)
	private Integer thingId;
	
	@Column(name = "NAME_THING", nullable = false, length = 10)
	private String name_thing;
	
	@Column(name = "LIST_PROPERTIES", nullable = false)
	private String properties;
	
	@Column(name = "IMAGE_REF", nullable = false)
	private String imageRef;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.thing")
	private Set<UserToThing> userThings = new HashSet<UserToThing>(0);

	public Thing() {
	}

	

	public Thing(String name_thing, String properties, String imageRef,
			Set<UserToThing> userThings) {
		super();
		this.name_thing = name_thing;
		this.properties = properties;
		this.imageRef = imageRef;
		this.userThings = userThings;
	}



	public Thing(String name_thing, String properties, String imageRef) {
		super();
		this.name_thing = name_thing;
		this.properties = properties;
		this.imageRef = imageRef;
	}



	/**
	 * @return the thingId
	 */
	public Integer getThingId() {
		return thingId;
	}

	/**
	 * @param thingId the thingId to set
	 */
	public void setThingId(Integer thingId) {
		this.thingId = thingId;
	}

	/**
	 * @return the name_thing
	 */
	public String getName_thing() {
		return name_thing;
	}

	/**
	 * @param name_thing the name_thing to set
	 */
	public void setName_thing(String name_thing) {
		this.name_thing = name_thing;
	}

	/**
	 * @return the properties
	 */
	public String getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(String properties) {
		this.properties = properties;
	}

	
	/**
	 * @return the imageRef
	 */
	public String getImageRef() {
		return imageRef;
	}



	/**
	 * @param imageRef the imageRef to set
	 */
	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}



	/**
	 * @param userThings the userThings to set
	 */
	public void setUserThings(Set<UserToThing> userThings) {
		this.userThings = userThings;
	}



	/**
	 * @return the userThings
	 */
	public Set<UserToThing> getUserThings() {
		return userThings;
	}

}