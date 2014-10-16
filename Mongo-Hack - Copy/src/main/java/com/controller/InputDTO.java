package com.controller;

import java.io.Serializable;

public class InputDTO implements Serializable {

	private static final long serialVersionUID = -7277788175351725718L;
	private String trade;
	private Integer rating;
	private Integer zipCode;
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
}
