package com.tcs.common.controller;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.tcs.common.model.Dependency;
import com.tcs.common.model.Status;
import com.tcs.common.service.DependencyService;
import com.tcs.common.service.ProductService;

/**
 * This class is our main controller class which handles all REST request.
 * 
 * @author shahn
 *
 */
@Controller
@RequestMapping("/statuscheck")
public class JSONController {

	@Autowired
	ProductService productService;

	@Autowired
	DependencyService dependencyService;

	/**
	 * This method will gives the status of Application1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/app1", method = RequestMethod.GET)
	public @ResponseBody Status getApp1Status() {

		Status status = new Status();
		if (isAccessable("http://localhost:8080/WebModule1")) {
			status.setStatus("Application1 (http://localhost:8080/WebModule1) is UP");
		} else {
			status.setStatus("Application1 (http://localhost:8080/WebModule1) is DOWN");
		}
		return status;
	}

	/**
	 * This method will gives the status of Application2
	 * 
	 * @return
	 */
	@RequestMapping(value = "/app2", method = RequestMethod.GET)
	public @ResponseBody Status getApp2Status() {

		Status status = new Status();
		if (isAccessable("http://localhost:8080/WebModule2")) {
			status.setStatus("Application2 (http://localhost:8080/WebModule2) is UP");
		} else {
			status.setStatus("Application2 (http://localhost:8080/WebModule2) is DOWN");
		}
		return status;
	}

	/**
	 * This method will gives the status of Main Application
	 * 
	 * @return
	 */
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public @ResponseBody Status getAppStatus() {

		Status status = new Status();
		if (isAccessable("http://localhost:8080/WebModule")) {
			status.setStatus("Application (http://localhost:8080/WebModule) is UP");
		} else {
			status.setStatus("Application (http://localhost:8080/WebModule) is DOWN");
		}
		return status;
	}

	/**
	 * This method will gives the list of dependencies.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/dependency", method = RequestMethod.GET)
	public @ResponseBody List<Dependency> getDependencies() {
		List<Dependency> dependencyList = dependencyService.listAll();
		return dependencyList;
	}

	/**
	 * This method will gives the status of Database server
	 * 
	 * @return
	 */
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public @ResponseBody Status getDBStatus()
			throws CommunicationsException, ConnectException, ClassNotFoundException, SQLException {
		Status status = new Status();
		if (productService.checkStatus()) {
			status.setStatus("Database Server is UP");
		} else {
			status.setStatus("Database Server is Down");
		}
		return status;
	}

	public static boolean isAccessable(String url) {
		url = url.replaceFirst("https", "http");

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				return false;
			}
		} catch (IOException exception) {
			return false;
		}
		return true;
	}

}