package com.buddyevents.node.entity;

import java.io.Serializable;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Person implements Serializable {
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = -2441611238613495749L;
	@GraphId
	   private Long id;
		private String name;
	private String phone;
	private String email;
	private String socialProfile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSocialProfile() {
		return socialProfile;
	}
	public void setSocialProfile(String socialProfile) {
		this.socialProfile = socialProfile;
	}
	 
}



