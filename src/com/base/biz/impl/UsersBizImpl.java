package com.base.biz.impl;

import java.util.List;

import com.base.biz.UsersBiz;
import com.base.dao.UsersDao;
import com.base.entity.Users;





public class UsersBizImpl implements UsersBiz {

	UsersDao userDao=null;
	Users user=new Users();


	

	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}


	public void attachClean(Users instance) {
		// TODO Auto-generated method stub

	}

	public int attachDirty(Users instance) {
		
		return userDao.attachDirty(instance);
	}

	public int delete(Users persistentInstance) {	
		
		
		return userDao.delete(persistentInstance);
	}

	public List findAll() {
		return userDao.findAll();
	}
	public static void main(String[] args) {
		UsersBizImpl sBizImpl = new UsersBizImpl();
		List list = sBizImpl.findAll();
		System.out.println(list.toString());
	}
	public List findByExample(Users instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public List findByName(Object name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByPassword(Object password) {
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users merge(Users detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public int save(Users transientInstance) {
		// TODO Auto-generated method stub
		return userDao.save(transientInstance);
	}

	
}
