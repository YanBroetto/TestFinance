package com.test.finance;

import java.math.BigDecimal;

import com.test.finance.domain.Conversion;
import com.test.finance.repository.GenericAPI;
import com.test.finance.repository.LocalAPI;

public class FinanceAPI {

	public static void main(String[] args) {
		GenericAPI api = new LocalAPI();
		
		System.out.println(api.getCurrencies());
	
		Conversion conversion = new Conversion(new BigDecimal(10), "BRL", "USD");
		
		System.out.println(api.convert(conversion));
	}
	
}
