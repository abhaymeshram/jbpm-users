package com.biz.model;

import java.io.Serializable;
import java.util.Date;

public class Groups implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private Date createdDate;
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Groups [id=" + id + ", name=" + name + ", description=" + description + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

	public Groups(Long id, String name, String description, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Groups() {
	}

}
