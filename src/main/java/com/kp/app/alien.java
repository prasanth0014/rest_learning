package com.kp.app;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class alien {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "alien [id=" + id + ", name=" + name + "]";
	}
	

}
