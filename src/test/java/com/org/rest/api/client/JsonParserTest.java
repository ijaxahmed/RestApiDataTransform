package com.org.rest.api.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

public class JsonParserTest extends TestCase {

	String jsonAsString = null;

	protected void setUp() throws Exception {
		super.setUp();
		String path = getClass().getResource("/test.csv").getPath();
		File file = new File(path);
		System.out.println(file.getAbsolutePath());

		try (FileInputStream fisTargetFile = new FileInputStream(new File(
				file.getAbsolutePath()))) {
			jsonAsString = IOUtils.toString(fisTargetFile, "UTF-8");
		} catch (IOException e) {
			System.out.println("Test Failed: File not Found");
			e.printStackTrace();
		}

	}

	public void testExtractLocations() throws Exception {

		assertEquals(8, (JsonParser.extractLocations(jsonAsString)).size());

	}

}