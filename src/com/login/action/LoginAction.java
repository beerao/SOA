package com.login.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.login.entity.Loginpeople;

import com.login.service.serviceImpl.LoginServiceImpl;

public class LoginAction {

	
	LoginServiceImpl loginService;
	Loginpeople loginpeople;
	

	public LoginServiceImpl getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}
	public Loginpeople getLoginpeople() {
		return loginpeople;
	}
	public void setLoginpeople(Loginpeople loginpeople) {
		this.loginpeople = loginpeople;
	}
	
	public void loginin() {
		int logintag = loginService.queryLoginpeople(loginpeople);
	}
	
	public void juageLogin() throws IOException{
		HttpServletResponse reponse = ServletActionContext.getResponse();
		String url="";
		url="index.jsp";
		int x;
		x=loginService.queryLoginpeople(loginpeople);
		if (x==1) {
			reponse.sendRedirect(url);
		}
	}
	
}
