package com.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.base.dao.UsersDao;
import com.base.entity.Users;



public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {
	private static final Log log = LogFactory.getLog(UsersDaoImpl.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing1111
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#save(entity.Users)
	 */
	public int save(Users transientInstance) {
		log.debug("saving Users instance");
		int i=1;
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			i=0;
			throw re;
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#delete(entity.Users)
	 */
	public int delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		int i=1;
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			i=0;
			throw re;
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#findById(java.lang.Long)
	 */
	public Users findById(Integer id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get("com.base.entity.Users",
					id);
		
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#findByExample(entity.Users)
	 */
	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#findByPassword(java.lang.Object)
	 */
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#findAll()
	 */
	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#merge(entity.Users)
	 */
	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#attachDirty(entity.Users)
	 */
	public int attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		int i=1;
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			i=0;
			throw re;
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.impl.UsersDao#attachClean(entity.Users)
	 */
	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsersDao getFromApplicationContext(ApplicationContext ctx) {
		return (UsersDao) ctx.getBean("UsersDAO");
	}
}