package com.capgemini.springbootbasic;

import java.util.List;

public class College {
	private String name;
	private String location;
	private List<Student> stu;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}
	public College(String name, String location, List<Student> stu) {
		super();
		this.name = name;
		this.location = location;
		this.stu = stu;
	}
	@Override
	public String toString() {
		return "College [name=" + name + ", location=" + location + ", stu=" + stu + "]";
	}
	
}
