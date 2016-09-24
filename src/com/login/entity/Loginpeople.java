package com.login.entity;

public class Loginpeople {
	private Integer id;
	private Long userid;
	private String password;
	
	public Loginpeople(Integer id, Long userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
