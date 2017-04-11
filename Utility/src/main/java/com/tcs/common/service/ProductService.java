package com.tcs.common.service;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.tcs.common.model.Product;

/**
 * This interface works as a Service layer for Product.
 * 
 * @author shahn
 *
 */
public interface ProductService {
	/**
	 * This method will return list of products from Database.
	 * 
	 * @return
	 */
	public List<Product> listAll();

	/**
	 * This method will check Database Status.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws CommunicationsException
	 * @throws ConnectException
	 */
	public boolean checkStatus() throws ClassNotFoundException, SQLException, CommunicationsException, ConnectException;
}
