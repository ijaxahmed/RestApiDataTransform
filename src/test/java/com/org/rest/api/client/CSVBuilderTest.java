package com.org.rest.api.client;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.org.rest.api.client.entities.Coordinates;
import com.org.rest.api.client.entities.Location;

public class CSVBuilderTest extends TestCase {

	ArrayList<Location> locList = new ArrayList<Location>();
	String csvPath = null;

	protected void setUp() throws Exception {
		super.setUp();

		csvPath = "D:\\eurogo.csv";

		locList.add(new Location("Position", 37007, "location", "postdom",
				new Coordinates(52.39886, 13.06566)));
		locList.add(new Location("Position", 75238, "location", "postdom01",
				new Coordinates(71.35686, 86.89566)));

	}

	public void testGenerateCsvFile() throws Exception {

		assertEquals(true, CSVBuilder.generateCsvFile(csvPath, locList));

	}
}
