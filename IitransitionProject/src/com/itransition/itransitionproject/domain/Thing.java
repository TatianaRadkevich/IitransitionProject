package com.itransition.itransitionproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "THING")
public class Thing {
	
	@Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
	
	@Column(name = "NAME_THING")
	private String nameThing;
	
	@Column(name = "IMAGE-REF")
	private String imageReference;
	
	@Column(name = "LIST_PROPERTIES")
	private String listProperties;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameThing() {
		return nameThing;
	}

	public void setNameThing(String nameThing) {
		this.nameThing = nameThing;
	}

	public String getImageReference() {
		return imageReference;
	}

	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}

	public String getListProperties() {
		return listProperties;
	}

	public void setListProperties(String listProperties) {
		this.listProperties = listProperties;
	}
	
	

}
