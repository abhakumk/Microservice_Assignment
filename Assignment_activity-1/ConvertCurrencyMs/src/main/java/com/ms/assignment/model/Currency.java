package com.ms.assignment.model;

import java.io.Serializable;

/**
 * @author w2cluster03
 *
 */
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4626056735670179359L;
	
	private String countryCode;
	private double converFactor;
	
	/**
	 * 
	 */
	public Currency() {
		//constructor
	};
	/**
	 * @param countryCode
	 * @param converFactor
	 */
	public Currency(String countryCode, double converFactor) {
		super();
		this.countryCode = countryCode;
		this.converFactor = converFactor;
	}
	
	/**
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return
	 */
	public double getConverFactor() {
		return converFactor;
	}
	/**
	 * @param converFactor
	 */
	public void setConverFactor(double converFactor) {
		this.converFactor = converFactor;
	}
	@Override
	public String toString() {
		return "Currency [countryCode=" + countryCode + ", converFactor=" + converFactor + "]";
	}
}
