package kr.or.nextit.session.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author 한무
 * 로그인 정보 저장 클래스
 */
public class LoginVo {

	private String id;
	private String password;
	private String name;
	private Integer age;
	private String phone;
	private String email;
	private String ip;
	private String regDate;
	
	

//	public LoginVo(String id, String password, String name, int age, String phone, String email, String ip, String regDate) {
//		this.id = id;
//		this.password = password;
//		this.name = name;
//		this.age = age;
//		this.phone = phone;
//		this.email = email;
//		this.ip = ip;
//		this.regDate = regDate;
//	}
	
	public String toString(){ return ToStringBuilder.reflectionToString(this);}

	public void setId(String id) {this.id = id;}
	
	public void setPassword(String password) {this.password = password;}
	
	public void setName(String name) {this.name = name;}
	
	public void setAge(Integer age) {this.age = age;}
	
	public void setPhone(String phone) {this.phone = phone;}
	
	public void setEmail(String email) {this.email = email;}
	
	public void setIp(String ip) {this.ip = ip;}
	
	public void setRegDate(String regDate) {this.regDate = regDate;}

	public String getId() {return id;}

	public String getPassword() {return password;}

	public String getName() {return name;}

	public Integer getAge() {return age;}

	public String getPhone() {return phone;}

	public String getEmail() {return email;}
	
	public String getIp() {return ip;}

	public String getRegDate() {return regDate;}

}
