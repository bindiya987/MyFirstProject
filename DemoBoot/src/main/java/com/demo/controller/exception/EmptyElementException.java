package com.demo.controller.exception;

public class EmptyElementException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String value;
	public EmptyElementException(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
