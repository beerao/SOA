package com.base.dao;

import java.util.List;

import com.base.entity.Users;


public interface UsersDao {

	public abstract int save(Users transientInstance);

	public abstract int delete(Users persistentInstance);

	public abstract Users findById(Integer id);

	public abstract List findByExample(Users instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByPassword(Object password);

	public abstract List findAll();

	public abstract Users merge(Users detachedInstance);

	public abstract int attachDirty(Users instance);

	public abstract void attachClean(Users instance);

}