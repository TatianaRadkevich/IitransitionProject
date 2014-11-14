package com.itransition.itransitionproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMBOPROPERTIES")
public class ComboProperties {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "LIST_PROPERTIES")
	private String listProperties;
	
	@OneToOne(mappedBy = "comboProperties")
	private Thing thing;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getListProperties() {
		return listProperties;
	}

	public void setListProperties(String listProperties) {
		this.listProperties = listProperties;
	}

	public Thing getThing() {
		return thing;
	}

	public void setThing(Thing thing) {
		this.thing = thing;
	}	
}
