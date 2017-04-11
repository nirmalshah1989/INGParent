package com.tcs.common.service.impl;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.tcs.common.dao.ProductDao;
import com.tcs.common.model.Product;
import com.tcs.common.service.ProductService;

/**
 * Implementation of @ProductService interface
 * 
 * @author shahn
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Value("${database.url}")
	private String URL;

	@Value("${database.username}")
	private String USERNAME;

	@Value("${database.password}")
	private String PASSWORD;

	public List<Product> listAll() {
		return productDao.findAll();
	}

	public boolean checkStatus() {
		try {
			productDao.checkDBStatus(URL, USERNAME, PASSWORD);
		} catch (CommunicationsException e) {
			return false;
		} catch (ConnectException e) {
			return false;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

}
