package com.test.finance.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.test.finance.domain.Conversion;
import com.test.finance.domain.Currency;

public class FrankFurterAPITests {

	FrankFurterAPI api;
	
	
	@Before
	public void setUp() throws Exception {
		api = new FrankFurterAPI();
	}
	

	//10 segundos de timeout
	@Test(timeout = 10000)
	public void test_getCurrencies() {
		List<Currency> currencies = api.getCurrencies();
		assertEquals(31, currencies.size());
	}

	
	@Test
	@Ignore
	public void test_Convert() {
		Conversion conversion = new Conversion(new BigDecimal(10), "USD", "BRL");
		assertEquals(50, conversion.getAmount());
	}
}
