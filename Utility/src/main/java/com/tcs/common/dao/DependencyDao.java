package com.tcs.common.dao;

import java.util.List;

import com.tcs.common.model.Dependency;

/**
 * This interface works as a Dao layer for Dependancy.
 * 
 * @author shahn
 *
 */
public interface DependencyDao {

	/**
	 * This method will return list of dependencies from Database.
	 * 
	 * @return
	 */
	public List<Dependency> findAll();

}
