package com.itransition.itransitionproject.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role", catalog = "database", uniqueConstraints = { @UniqueConstraint(columnNames = "ID_USER") })
public class RoleUser {

	private Integer id_role;
	private User user;
	private String role;

	public RoleUser() {
	}

	public RoleUser(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	/**
	 * @return the id_role
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER_ROLE", unique = true, nullable = false)
	public Integer getId_role() {
		return id_role;
	}

	/**
	 * @param id_role
	 *            the id_role to set
	 */
	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}

	/**
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	@Column(name = "ROLE", nullable = false)
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
