package com.test.finance.repository;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.test.finance.util.SpreadsheetData;

@RunWith(Parameterized.class)
public class LocalAPITestsParametrized {

	private String from;
	private String to;
	private double amount;
	private double result;
	
	
	@Parameters
    public static Collection spreadsheetData() throws IOException {
        InputStream spreadsheet = new FileInputStream("src/test/resources/conversions.xls");
        return new SpreadsheetData(spreadsheet).getData();
    }
	
	public LocalAPITestsParametrized(String from, String to, double amount, double result) {
        super();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.result = result;
    }
}
