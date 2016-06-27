/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.omdeshpande.lib.interfaces.Dao;
import com.omdeshpande.lib.interfaces.HibernateDao;

/**
 * @author om
 * @param <T>
 * @param <PK>
 *
 */
public abstract class HibernateDaoAbstract<T, PK> implements Dao<T, PK>, HibernateDao {

	private SessionFactory sessionFactory;
	private Session session;
	private Class<T> type;
	
	public HibernateDaoAbstract(Class<T> type) {
		this.type = type;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public PK create(T object) {
		PK id = (PK) session.save(object);
		return id;
	}

	public void update(T object) {
		session.update(object);
	}

	public T read(PK id) {
		return session.get(type, (Serializable) id);
	}

	public void delete(T object) {
		session.delete(object);
	}
	
}
