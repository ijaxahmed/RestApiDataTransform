package com.org.rest.api.client;

import com.org.rest.api.client.utilities.Constants;
import com.org.rest.api.client.utilities.Util;

import junit.framework.TestCase;

public class SampleClientTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		Util.loadProperties();
		Constants.CSVPATH = "D:\\eurogo.csv";

	}

	public void testCallService() throws Exception {

		assertEquals(true, SampleClient.callService("Dusseldorf"));

	}

}
