package com.itransition.itransitionproject.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(mappedBy = "thing", fetch = FetchType.LAZY)
	private Set<ThingOfClient> clientThings;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_THING", joinColumns = @JoinColumn(name = "ID_THING"),
			inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private User user;
	
	@OneToOne
	@JoinTable(name = "COMBO_PROPERTIES_TO_THING", joinColumns = @JoinColumn(name = "ID_THING"),
		inverseJoinColumns = @JoinColumn(name = "ID_COMBO_PROPERTIES"))
	private ComboProperties comboProperties;

	public Thing() {}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<ThingOfClient> getClientThings() {
		return clientThings;
	}

	public void setClientThings(Set<ThingOfClient> clientThings) {
		this.clientThings = clientThings;
	}

	public ComboProperties getComboProperties() {
		return comboProperties;
	}

	public void setComboProperties(ComboProperties comboProperties) {
		this.comboProperties = comboProperties;
	}
	

	@Override
	public String toString() {
		return "Thing [thingId=" + thingId + ", name_thing=" + name_thing
				+ ", properties=" + properties + ", imageRef=" + imageRef
				+ "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((imageRef == null) ? 0 : imageRef.hashCode());
		result = prime * result
				+ ((name_thing == null) ? 0 : name_thing.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((thingId == null) ? 0 : thingId.hashCode());
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
		Thing other = (Thing) obj;
		if (imageRef == null) {
			if (other.imageRef != null)
				return false;
		} else if (!imageRef.equals(other.imageRef))
			return false;
		if (name_thing == null) {
			if (other.name_thing != null)
				return false;
		} else if (!name_thing.equals(other.name_thing))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (thingId == null) {
			if (other.thingId != null)
				return false;
		} else if (!thingId.equals(other.thingId))
			return false;
		return true;
	}
	
	

}