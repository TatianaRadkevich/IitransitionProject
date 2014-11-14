package com.itransition.itransitionproject.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "THINGS")
public class Thing {
	
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
	
	@Column(name = "NAME_THING")
	private String nameThing;
	
	@Column(name = "IMAGE_REF")
	private String imageReference;
	
	@Column(name = "LIST_PROPERTIES")
	private String listProperties;
	
	@OneToMany(mappedBy = "thing", fetch = FetchType.LAZY)
	private Set<ClientThing> clientThings;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_THING", joinColumns = @JoinColumn(name = "ID_THING"),
		inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private User userThing;
	
	@OneToOne
	@JoinTable(name = "PROP_TO_THING", joinColumns = @JoinColumn(name = "ID_THING_PROP"),
		inverseJoinColumns = @JoinColumn(name = "ID_PROPERTIES"))
	private ComboProperties comboProperties;
	
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

	public Set<ClientThing> getClientThings() {
		return clientThings;
	}

	public void setClientThings(Set<ClientThing> clientThings) {
		this.clientThings = clientThings;
	}

	public User getUserThing() {
		return userThing;
	}

	public void setUserThing(User userThing) {
		this.userThing = userThing;
	}

	public ComboProperties getComboProperties() {
		return comboProperties;
	}

	public void setComboProperties(ComboProperties comboProperties) {
		this.comboProperties = comboProperties;
	}
		
}
