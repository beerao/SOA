package com.login.dao.impl;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.login.entity.Loginpeople;
import com.login.service.LoginService;

public class LoginSearchDaoImpl extends HibernateDaoSupport implements LoginService{

	public int queryLoginpeople(Loginpeople lg) {
		// TODO Auto-generated method stub
		String sqlString="from Loginpeople l where l.id = 11";
		
		List list =getHibernateTemplate().find(sqlString);
		for (Iterator it = list.iterator(); it.hasNext();) {
			Loginpeople object = (Loginpeople) it.next();
			System.out.println(object.getPassword());
		}
		
		if (list!=null) {
			return 1;
		}
		else {
			
			return 0;
		}
	}

}
