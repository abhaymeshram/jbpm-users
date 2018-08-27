package com.biz.model;

import java.io.Serializable;

public class Sample implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String lastName;
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Sample(String name, String email, String lastName) {
		super();
		this.name = name;
		this.email = email;
		this.lastName = lastName;
	}
	public Sample() {
	}
	@Override
	public String toString() {
		return "Sample [name=" + name + ", email=" + email + ", lastName=" + lastName + "]";
	}
	
	
	

}
