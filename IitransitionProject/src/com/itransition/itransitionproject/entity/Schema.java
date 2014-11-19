package com.itransition.itransitionproject.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "SCHEMAS")
public class Schema implements Serializable {
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PARAM")
	private String parameters;
	
	@Column(name = "SUM_RAITING")
	private Integer sumRaiting;
	
	@Column(name = "COUNT_USERS")
	private Integer countUsers;
	
	@ManyToMany(mappedBy = "schemas", fetch = FetchType.LAZY)
	private Set<ThingOfClient> clentThings;
		
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinTable(name = "USER_TO_SCHEMA", joinColumns = @JoinColumn(name = "ID_SCHEMA"),
		inverseJoinColumns = @JoinColumn(name = "ID_USER"))
	private User user;

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

	public Set<ThingOfClient> getClentThings() {
		return clentThings;
	}

	public void setClentThings(Set<ThingOfClient> clentThings) {
		this.clentThings = clentThings;
	}

	public void addClientThing(ThingOfClient thingOfClient) {
		if (this.getClentThings() == null)
			this.setClentThings(new HashSet<ThingOfClient>());
		this.getClentThings().add(thingOfClient);
			
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Schema [id=" + id + ", name=" + name + ", parameters="
				+ parameters + ", sumRaiting=" + sumRaiting + ", countUsers="
				+ countUsers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countUsers == null) ? 0 : countUsers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result
				+ ((sumRaiting == null) ? 0 : sumRaiting.hashCode());
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
		Schema other = (Schema) obj;
		if (countUsers == null) {
			if (other.countUsers != null)
				return false;
		} else if (!countUsers.equals(other.countUsers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (sumRaiting == null) {
			if (other.sumRaiting != null)
				return false;
		} else if (!sumRaiting.equals(other.sumRaiting))
			return false;
		return true;
	}
		
}
