package com.edison.pi.calculation.test;

import java.math.BigDecimal;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edison.pi.calculation.service.PiCalculationService;

/**
 * Test for PICalculationService
 * 
 * @author Edison Yang
 * @date 2014-08-10
 *
 */
public class TestPiCalculation {
	private static ApplicationContext context;
	private static PiCalculationService calculationService;
	private static final double PI = Math.PI;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext(
				"spring-pi-calculation.xml");
		calculationService = (PiCalculationService) context
				.getBean("piCalculation");
	}
	
	@Test
	public void test_0_terms(){
		calculationService.setNumberOfTerms(0);
		double result = calculationService.calculate();
		final double expectedResult = 4;
		Assert.assertEquals(expectedResult, result, 0);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_1_terms(){
		calculationService.setNumberOfTerms(1);
		double result = calculationService.calculate();
		System.out.println(1/3);
		double expectedResult = 4 * (1 - 1/3d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_2_terms(){
		calculationService.setNumberOfTerms(2);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_3_terms(){
		calculationService.setNumberOfTerms(3);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_4_terms(){
		calculationService.setNumberOfTerms(4);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_5_terms(){
		calculationService.setNumberOfTerms(5);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d - 1/11d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_6_terms(){
		calculationService.setNumberOfTerms(6);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d - 1/11d + 1/13d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_7_terms(){
		calculationService.setNumberOfTerms(7);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d - 1/11d + 1/13d - 1/15d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_8_terms(){
		calculationService.setNumberOfTerms(8);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d - 1/11d + 1/13d - 1/15d + 1/17d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_9_terms(){
		calculationService.setNumberOfTerms(9);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d - 1/11d + 1/13d - 1/15d + 1/17d - 1/19d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}
	
	@Test
	public void test_10_terms(){
		calculationService.setNumberOfTerms(10);
		double result = calculationService.calculate();
		double expectedResult = 4 * (1 - 1/3d + 1/5d - 1/7d + 1/9d - 1/11d + 1/13d - 1/15d + 1/17d - 1/19d + 1/21d);
		Assert.assertEquals(expectedResult, result, Double.NaN);
		outputResult(calculationService.getNumberOfTerms(), result);
	}

	private void outputResult(int terms, double result) {
		BigDecimal difference = BigDecimal.valueOf(result).subtract(
				BigDecimal.valueOf(PI));
		System.out.println("***************Test Result***************");
		System.out.println("Number of terms         : " + terms);
		System.out.println("Calculation result      : " + result);
		System.out.println("Pi                      : " + PI);
		System.out.println("Difference              : "
				+ difference.toPlainString());
		System.out.println();
	}
}
