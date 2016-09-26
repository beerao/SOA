package com.login.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.login.entity.Loginpeople;
import com.login.service.LoginService;

public class LoginSearchDaoImpl extends HibernateDaoSupport implements LoginService{

	public int queryLoginpeople(Loginpeople lg) {
		// TODO Auto-generated method stub
		getHibernateTemplate();
		return 0;
	}

}
