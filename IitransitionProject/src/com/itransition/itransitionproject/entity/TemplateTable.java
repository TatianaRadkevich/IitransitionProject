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

@Entity
@Table(name = "template_table", catalog = "database")
public class TemplateTable {
	
	private Integer id_table;
	private String ref;
	private User user;
	
	public TemplateTable() {
	}

	/**
	 * @return the id_table
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_TEMPLATE", unique = true, nullable = false)
	public Integer getId_table() {
		return id_table;
	}

	/**
	 * @param id_table
	 *            the id_table to set
	 */
	public void setId_table(Integer id_table) {
		this.id_table = id_table;
	}

	/**
	 * @return the ref
	 */
	@Column(name = "TEMPLATE_CODE", nullable = false)
	public String getRef() {
		return ref;
	}

	/**
	 * @param ref
	 *            the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
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
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
