package com.tcs.common.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tcs.common.dao.DependencyDao;
import com.tcs.common.model.Dependency;

/**
 * Implementation of @DependencyDao interface.
 * @author shahn
 *
 */
@Repository
public class DependencyDaoImpl implements DependencyDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Dependency> findAll() {
		return em.createQuery("SELECT d FROM Dependency d").getResultList();
	}

}
