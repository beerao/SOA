package com.login.dao;

import com.login.entity.Loginpeople;

public interface LoginSearchDao {
	
	public abstract int queryPeople(Loginpeople lg);
}
