package com.org.rest.api.client;

import com.org.rest.api.client.utilities.Constants;
import com.org.rest.api.client.utilities.Util;

import junit.framework.TestCase;

public class UtilTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();

	}

	public void testLoadProperties() throws Exception {
		Util.loadProperties();
		assertEquals("./goero.csv", Constants.CSVPATH);

	}

}
