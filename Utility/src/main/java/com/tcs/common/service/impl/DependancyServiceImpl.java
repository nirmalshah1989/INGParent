package com.tcs.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.common.dao.DependencyDao;
import com.tcs.common.model.Dependency;
import com.tcs.common.service.DependencyService;

/**
 * Implementation of @DependencyService interface
 * 
 * @author shahn
 *
 */
@Service
public class DependancyServiceImpl implements DependencyService {

	@Autowired
	private DependencyDao dependencyDao;

	@Override
	public List<Dependency> listAll() {
		return dependencyDao.findAll();
	}

}
