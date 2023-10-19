package com.test.finance.domain;

import java.math.BigDecimal;

public class Currency {

	private String identifier;
	private String location;
	private BigDecimal actualValue;
	
	public Currency(String identifier, String location) {
		this.identifier = identifier;
		this.location = location;
	}
	
	public Currency(String identifier, String location, BigDecimal actualValue) {
		this.identifier = identifier;
		this.location = location;
		this.actualValue = actualValue;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getLocation() {
		return location;
	}

	
	
	public BigDecimal getActualValue() {
		return actualValue;
	}

	@Override
	public String toString() {
		return "Currency [identifier=" + identifier + ", location=" + location + "]";
	}
	
	
}
