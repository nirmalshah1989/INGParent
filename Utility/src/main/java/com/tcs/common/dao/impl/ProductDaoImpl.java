package com.tcs.common.dao.impl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.tcs.common.dao.ProductDao;
import com.tcs.common.model.Product;

/**
 * Implementation of @ProudctDao interface.
 * @author shahn
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}

	public void checkDBStatus(String url, String userName, String password)
			throws ClassNotFoundException, SQLException, CommunicationsException, ConnectException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
