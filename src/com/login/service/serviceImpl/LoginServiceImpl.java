package com.login.service.serviceImpl;

import com.login.dao.impl.LoginSearchDaoImpl;
import com.login.entity.Loginpeople;
import com.login.service.LoginService;

public class LoginServiceImpl implements LoginService{
	LoginSearchDaoImpl loginDao;
	
	
	public LoginSearchDaoImpl getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginSearchDaoImpl loginDao) {
		this.loginDao = loginDao;
	}


	public int queryLoginpeople(Loginpeople lg) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
}
