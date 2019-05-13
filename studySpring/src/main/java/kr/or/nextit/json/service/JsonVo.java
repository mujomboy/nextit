package kr.or.nextit.json.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class JsonVo {

	private String name;
	private String id;
	
	private List<Map<String, Object>> item;
	
	private boolean status;
	private String message;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Map<String, Object>> getItem() {
		return item;
	}

	public void setItem(List<Map<String, Object>> item) {
		this.item = item;
	}
	
	
}
