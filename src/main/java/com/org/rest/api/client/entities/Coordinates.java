/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample program. Please contact at www.sample.com 
 * if you need any additional information or have questions.
 */
package com.org.rest.api.client.entities;

/**
 * Geolocation Coordinate
 * 
 * @author A.Ijaz
 * @version 1.0
 */
public class Coordinates {

	private double latitude;
	private double longitude;

	public Coordinates(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String toString() {
		return String.valueOf(this.latitude) + ","
				+ String.valueOf(this.longitude);
	}

}
