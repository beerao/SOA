package com.login.model;

public class Login {
//存放登陆账户与密码
	//账户
	private Long userid;
	//密码
	private String password;
	
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
