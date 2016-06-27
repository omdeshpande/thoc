/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Om Deshpande
 *
 */
public interface HibernateDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	
	public SessionFactory getSessionFactory();
	
	public Session getSession();
	
}
