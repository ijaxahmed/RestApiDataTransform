/*
 * Copyright (c) 2914 sample org. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is sample program. Please contact at www.sample.com 
 * if you need any additional information or have questions.
 */
package com.org.rest.api.client.entities;

/**
 * Location Class
 * 
 * @author A.Ijaz
 * @version 1.0
 */
public class Location {

	private String _type;
	private long id;
	private String type;
	private String name;
	private Coordinates coordinates;

	public Location() {
		super();
	}

	public Location(String _type, long id, String type, String name,
			Coordinates coordinates) {
		super();
		this._type = _type;
		this.id = id;
		this.type = type;
		this.name = name;
		this.coordinates = coordinates;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toCSV() {

		StringBuilder sb = new StringBuilder();
		sb.append(this._type);
		sb.append(',');
		sb.append(this.id);
		sb.append(',');
		sb.append(this.name);
		sb.append(',');
		sb.append(this.type);
		sb.append(",");
		sb.append(this.coordinates.toString());
		// sb.append('\n');

		return sb.toString();
	}

}
