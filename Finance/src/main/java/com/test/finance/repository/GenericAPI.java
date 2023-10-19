package com.test.finance.repository;

import java.math.BigDecimal;
import java.util.List;

import com.test.finance.domain.Conversion;
import com.test.finance.domain.Currency;

public abstract class GenericAPI {

	public abstract List<Currency> getCurrencies();
	public abstract BigDecimal convert(Conversion conversion);
}
