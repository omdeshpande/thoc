/**
 * 
 */
package com.omdeshpande.lib.interfaces;

/**
 * @author Om Deshpande
 *
 */
public interface Dao<T, PK> {

	public PK create(T object);
	
	public void update(T object);
	
	public T read(PK id);
	
	public void delete(T object);
	
}
