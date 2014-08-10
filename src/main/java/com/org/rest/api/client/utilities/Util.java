/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample program. Please contact at www.sample.com 
 * if you need any additional information or have questions.
 */
package com.org.rest.api.client.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.org.rest.api.client.SampleClient;

/**
 * Utility Class
 * 
 * @author A.Ijaz
 * @version 1.0
 */
public class Util {

	/**
	 * Load Properties from Resource file
	 * 
	 * 
	 * @exception IOException
	 *                if stream to resource file does not created successfully.
	 * 
	 */
	public static void loadProperties() throws IOException {
		Properties prop = new Properties();
		String filename = "config.properties";
		try (InputStream input = SampleClient.class.getClassLoader().getResourceAsStream(filename)) {

			prop.load(input);
			Constants.CSVPATH = prop.getProperty("csvfilepath");
			Constants.API_URL = prop.getProperty("apiurl");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error Loading Properties");
			throw e;
		}
	}
}
