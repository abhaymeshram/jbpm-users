package com.biz.model;

import java.io.Serializable;

public class UserGroups implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String groupName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "UserGroups [id=" + id + ", userName=" + userName + ", groupName=" + groupName + "]";
	}

	public UserGroups(Long id, String userName, String groupName) {
		super();
		this.id = id;
		this.userName = userName;
		this.groupName = groupName;
	}

	public UserGroups() {
	}

}
