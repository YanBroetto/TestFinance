package com.test.finance.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import com.test.finance.domain.Conversion;
import com.test.finance.domain.Currency;

public class LocalAPI extends GenericAPI {

	@Override
	public List<Currency> getCurrencies() {
		return Arrays.asList(
				new Currency("BRL", "Brasil", new BigDecimal(1)),
				new Currency("EUR", "Europa", new BigDecimal(0.10)),
				new Currency("USD", "United States", new BigDecimal(0.20)));
	}

	@Override
	public BigDecimal convert(Conversion conversion) {
	    Currency from = getCurrency(conversion.getFrom());
	    Currency to = getCurrency(conversion.getTo());

	    BigDecimal exchangeRate = to.getActualValue().divide(from.getActualValue(), 2, RoundingMode.HALF_UP);

	    return conversion.getAmount().multiply(exchangeRate);
	}
	
	public Currency getCurrency(String symbol) {
		return getCurrencies().stream().filter((e) -> e.getIdentifier().equals(symbol)).findFirst().get();
	}

}
