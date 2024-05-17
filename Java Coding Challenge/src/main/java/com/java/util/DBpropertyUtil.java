package com.java.AssetManagement.util;

import java.util.ResourceBundle;

public class DBpropertyUtil {

	public static String getConnectionString(String propertyFile) {
		ResourceBundle rb = ResourceBundle.getBundle(propertyFile);
		String connStr = rb.getString("url");
		return connStr;
	}
}
