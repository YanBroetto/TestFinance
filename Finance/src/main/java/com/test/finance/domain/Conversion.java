package com.test.finance.domain;

import java.math.BigDecimal;

public class Conversion {

	private BigDecimal amount;
	private String from;
	private String to;
	
	public Conversion(BigDecimal amount, String from, String to) {
		this.amount = amount;
		this.from = from;
		this.to = to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}
}
