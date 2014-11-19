package com.itransition.itransitionproject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

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
	@Column(name = "ID", unique = true, nullable = false)
	private Integer thingId;
	
	@Column(name = "NAME_THING", nullable = false, length = 10)
	private String name_thing;
	
	@Column(name = "LIST_PROPERTIES", nullable = false)
	private String properties;
	
	@Column(name = "IMAGE_REF", nullable = false)
	private String imageRef;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.thing")
	private Set<UserToThing> userThings = new HashSet<UserToThing>(0);
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_THING", joinColumns = @JoinColumn(name = "ID_THING"),
			inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private User user;

	public Thing() {}

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

	public Integer getThingId() {
		return thingId;
	}

	public void setThingId(Integer thingId) {
		this.thingId = thingId;
	}

	public String getName_thing() {
		return name_thing;
	}

	public void setName_thing(String name_thing) {
		this.name_thing = name_thing;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	public void setUserThings(Set<UserToThing> userThings) {
		this.userThings = userThings;
	}

	public Set<UserToThing> getUserThings() {
		return userThings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}