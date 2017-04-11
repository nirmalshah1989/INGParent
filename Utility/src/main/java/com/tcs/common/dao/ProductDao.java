package com.tcs.common.dao;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.tcs.common.model.Product;

/**
 * This interface works as a Dao layer for Product.
 * 
 * @author shahn
 *
 */
public interface ProductDao {

	/**
	 * This method will return list of products from Database.
	 * 
	 * @return
	 */
	public List<Product> findAll();

	/**
	 * This method will check Database Status.
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws CommunicationsException
	 * @throws ConnectException
	 */
	public void checkDBStatus(String url, String userName, String password)
			throws ClassNotFoundException, SQLException, CommunicationsException, ConnectException;
}
