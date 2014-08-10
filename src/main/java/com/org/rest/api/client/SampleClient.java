/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample program. Please contact at www.sample.com 
 * if you need any additional information or have questions.
 */
package com.org.rest.api.client;

import java.net.URI;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.org.rest.api.client.utilities.Constants;
import com.org.rest.api.client.utilities.Util;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * REST Web Service sample client
 * 
 * @author A.Ijaz
 * @version 1.0
 */
public class SampleClient {

	/*
	 * (non-Javadoc) Main Method program Entry point
	 */
	public static void main(String[] args) {

		try (Scanner reader = new Scanner(System.in)) {
			Util.loadProperties();
			System.out
					.println("Please enter path to save  CSV file path (e.g. D:\\temp\\abc.csv) ");
			String input = reader.next();
			Constants.CSVPATH = input;

			if (callService(args[0]))
				System.out.println("Output (CSV) file saved at "
						+ Constants.CSVPATH);
			else
				System.out.println("Program execution failed");

		} catch (Exception e) {
			System.out.println("Program execution failed");
			e.printStackTrace();

		}

	}

	/**
	 * Call Json Api with query parameter
	 * 
	 * @param queryParameter
	 *            url query parameter
	 * @return boolean true or false according to success or failure
	 * 
	 * @exception Exception
	 *                if API call fails.
	 */
	public static boolean callService(String queryParameter) throws Exception {

		String responseStr = null;
		URI uri = new URI(Constants.URl_PROTOCOL, Constants.API_URL,
				Constants.PATH_SEPARATOR + queryParameter, null);
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder
				.fromUri(uri.toString()).build());
		responseStr = service.accept(MediaType.APPLICATION_JSON).get(
				String.class);
		if ("".equalsIgnoreCase(responseStr)) {
			System.out.println("Empty response  \n");
			return false;
		}
		CSVBuilder.generateCsvFile(Constants.CSVPATH,
				JsonParser.extractLocations(responseStr));

		return true;

	}

}
