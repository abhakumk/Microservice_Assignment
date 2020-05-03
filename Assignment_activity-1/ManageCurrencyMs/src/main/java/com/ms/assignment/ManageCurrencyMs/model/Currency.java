package com.ms.assignment.ManageCurrencyMs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author w2cluster03
 *
 */
@Entity(name = "currency")
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4548220283637350077L;
	@Id
	private String countryCode;
	@Column(name = "converFactor", table = "currency")
	private double converFactor;
	
	/**
	 * 
	 */
	public Currency() {
		//Constructor
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
