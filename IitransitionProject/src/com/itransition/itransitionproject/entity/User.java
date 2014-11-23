package com.itransition.itransitionproject.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", catalog = "database", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL") })
public class User implements java.io.Serializable {

	private Integer userId;
	private String nameUser;
	private String email;
	private String password;
	private boolean enabled;
	private Set<Thing> things;
	private Set<ThingOfClient> clientThings;
	private Set<SchemasOfUsers> schemas;
	private Set<RoleUser> roleUsers;
	
	public User() {}
	
	public User(String nameUser, String email, String password,
			boolean enabled, Set<RoleUser> roleUsers) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roleUsers = roleUsers;
	}



	public User(String nameUser, String email, String password,
			boolean enabled) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "NAME_USER", nullable = false, length = 10)
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	@Column(name = "EMAIL", unique = true, nullable = false, length = 10)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", nullable = false, length = 10)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	@Column(name = "ENABLED", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the roleUsers
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public Set<RoleUser> getRoleUsers() {
		return roleUsers;
	}

	/**
	 * @param roleUsers the roleUsers to set
	 */
	public void setRoleUsers(Set<RoleUser> roleUsers) {
		this.roleUsers = roleUsers;
	}

	/**
	 * @return the things
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public Set<Thing> getThings() {
		return things;
	}

	/**
	 * @param things the things to set
	 */
	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	/**
	 * @return the clientThings
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public Set<ThingOfClient> getClientThings() {
		return clientThings;
	}

	/**
	 * @param clientThings the clientThings to set
	 */
	public void setClientThings(Set<ThingOfClient> clientThings) {
		this.clientThings = clientThings;
	}

	/**
	 * @return the schemas
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public Set<SchemasOfUsers> getSchemas() {
		return schemas;
	}

	/**
	 * @param schemas the schemas to set
	 */
	public void setSchemas(Set<SchemasOfUsers> schemas) {
		this.schemas = schemas;
	}
}