package com.nikita.datatypes;


	import java.math.BigDecimal;

	public class ExampleofComparison {
	    public static void main(String[] args) {
	        Double a = 0.1;
	        Double b = 0.2;

	        Double sumDouble = a + b;
	        System.out.println("Double Sum: " + sumDouble);
	        BigDecimal x = BigDecimal.valueOf(0.1);
	        BigDecimal y = BigDecimal.valueOf(0.2);
	       
	        BigDecimal sumBigDecimal = x.add(y);
	        System.out.println("BigDecimal Sum: " + sumBigDecimal); 
	       
	        System.out.println("Double sum equal to BigDecimal sum? " + (sumDouble.equals(sumBigDecimal.doubleValue()))); 
	            
	        int comparisonResult = sumBigDecimal.compareTo(BigDecimal.valueOf(0.3));
	        System.out.println("Comparison Result (BigDecimal): " + comparisonResult); 
	        
	        
	        System.out.println("Difference in Double and BigDecimal sums:");
	        System.out.println("Double Difference from 0.3: " + (sumDouble - 0.3)); 
	        System.out.println("BigDecimal Difference from 0.3: " + sumBigDecimal.subtract(BigDecimal.valueOf(0.3))); 
	    }
	}


