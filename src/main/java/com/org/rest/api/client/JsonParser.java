/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample program. Please contact at www.sample.com 
 * if you need any additional information or have questions.
 */
package com.org.rest.api.client;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.org.rest.api.client.entities.Coordinates;
import com.org.rest.api.client.entities.Location;

/**
 * This class parse json data to required formate
 * 
 * @author A.Ijaz
 * @version 1.0
 */
public class JsonParser {

	/**
	 * Parse Json String to list of Location objects
	 * 
	 * @param responseStr
	 *            data as string
	 * @return ArrayList<Location> list of location objects
	 * 
	 * @exception ParseException
	 *                when parsing fails
	 * @exception NullPointerException
	 *                when json object Null
	 */
	public static ArrayList<Location> extractLocations(String responseStr)
			throws ParseException, NullPointerException {
		ArrayList<Location> locList = new ArrayList<Location>();

		try {
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(responseStr);
			Iterator<JSONObject> objItr = jsonArray.iterator();
			JSONObject geoPosition;
			JSONObject innerObj;
			Location loc = null;

			while (objItr.hasNext()) {

				loc = new Location();
				innerObj = (JSONObject) objItr.next();
				loc.set_type((String) innerObj.get("_type"));
				loc.setId((long) innerObj.get("_id"));
				loc.setName((String) innerObj.get("name"));
				loc.setType((String) innerObj.get("type"));
				geoPosition = (JSONObject) innerObj.get("geo_position");
				loc.setCoordinates(new Coordinates((double) geoPosition
						.get("latitude"), (double) geoPosition.get("longitude")));
				locList.add(loc);
			}

		} catch (ParseException ex) {
			System.out.println("Error parsing json response");
			ex.printStackTrace();
			throw ex;
		} catch (NullPointerException ex) {
			System.out.println("Error NULL json geo_position object");
			ex.printStackTrace();
			throw ex;
		}

		return locList;
	}
}
