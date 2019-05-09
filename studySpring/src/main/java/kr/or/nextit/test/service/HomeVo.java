package kr.or.nextit.test.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class HomeVo {

	private String title;
	private String name;
	private String age;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
