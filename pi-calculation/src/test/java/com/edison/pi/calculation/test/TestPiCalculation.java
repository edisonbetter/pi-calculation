package com.edison.pi.calculation.test;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edison.pi.calculation.service.PiCalculationService;

public class TestPiCalculation {
	private static ApplicationContext context ;
	private static PiCalculationService calculationService;
	private static final double PI = Math.PI;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext("spring-pi-calculation.xml");
		calculationService = (PiCalculationService) context.getBean("piCalculation");
	}

	@Test
	public void test_1() {
		calculationService.setCalculationTimes(10);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	@Test
	public void test_2() {
		calculationService.setCalculationTimes(100);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	@Test
	public void test_3() {
		calculationService.setCalculationTimes(1000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	@Test
	public void test_4() {
		calculationService.setCalculationTimes(10000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	@Test
	public void test_5() {
		calculationService.setCalculationTimes(100000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	@Test
	public void test_6() {
		calculationService.setCalculationTimes(1000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	@Test
	public void test_7() {
		calculationService.setCalculationTimes(10000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	private void outputResult(int calculationTimes, double result) {
		System.out.println("***************Test Result***************");
		System.out.println("Calculation times : " + calculationTimes);
		System.out.println("Calculation result: " + result);
		System.out.println("Pi                : " + PI);
		System.out.println("Difference        : "
				+ BigDecimal.valueOf(result)
						.subtract(BigDecimal.valueOf(PI)).toPlainString());
		System.out.println();
	}
}
