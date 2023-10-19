package com.test.finance;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.test.finance.repository.LocalAPITestsParametrized;

public class TestRunner {
	
   public static void main(String[] args) {
	   runFixedSuite();
	   runParametrizedSuite();
   }  		
   
   private static void runParametrizedSuite() {
	   System.out.println(" ");
	   System.out.println("Executando suite de testes parametrizados");
	   
	      Result result = JUnitCore.runClasses(LocalAPITestsParametrized.class);

	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      String sucesso = result.wasSuccessful() ? "com sucesso" : "sem sucesso";
	      System.out.println("Suite de testes parametrizados executada " + sucesso);
	      System.out.println( "");
   }
   
   private static void runFixedSuite() {
	   System.out.println(" ");
	   System.out.println("Executando suite de testes nao parametrizados");
	   
	      Result result = JUnitCore.runClasses(FixedSuite.class);

	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      String sucesso = result.wasSuccessful() ? "com sucesso" : "sem sucesso";
	      System.out.println("Suite de testes nao parametrizados executada " + sucesso);
	      System.out.println( "");
   }
}
