package com.test.finance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.test.finance.repository.FrankFurterAPITests;
import com.test.finance.repository.LocalAPITests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	   LocalAPITests.class,
	   FrankFurterAPITests.class
	})

public class FixedSuite {

}
