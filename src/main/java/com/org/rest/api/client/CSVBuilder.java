/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample program. Please contact at www.sample.com 
 * if you need any additional information or have questions.
 */

package com.org.rest.api.client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.org.rest.api.client.entities.Location;

/**
 * This class create CSV file from Data
 * 
 * @author A.Ijaz
 * @version 1.0
 */
public class CSVBuilder {

	/**
	 * Create CSV file from data
	 * 
	 * @param sFileName
	 *            CSV file path
	 * @param locList
	 *            data convert to CSV
	 * 
	 * @return boolean true or false according to success or failure
	 * 
	 * @exception IOException
	 *                if stream to sFileName cannot be written to or closed.
	 * 
	 */
	public static boolean generateCsvFile(String sFileName,
			ArrayList<Location> locList) throws IOException {

		try (FileWriter fw = new FileWriter(sFileName)) {

			fw.append("_type");
			fw.append(',');
			fw.append("_id");
			fw.append(',');
			fw.append("name");
			fw.append(',');
			fw.append("type");
			fw.append(',');
			fw.append("latitude");
			fw.append(',');
			fw.append("longitude");
			fw.append('\n');

			for (Location loc : locList) {
				fw.append(loc.toCSV() + '\n');
			}
			return true;
		} catch (IOException e) {
			System.out.println("Error Writing CSV File");
			e.printStackTrace();
			throw e;
		}
	}
}
