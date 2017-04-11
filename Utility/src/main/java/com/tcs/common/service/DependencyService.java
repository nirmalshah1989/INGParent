package com.tcs.common.service;

import java.util.List;
import com.tcs.common.model.Dependency;

/**
 * This interface works as a Service layer for Dependency.
 * @author shahn
 *
 */
public interface DependencyService {
	
	public List<Dependency> listAll();

}
