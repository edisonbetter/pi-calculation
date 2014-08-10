package com.edison.pi.calculation.test;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edison.pi.calculation.service.PiCalculationService;

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
	public void test_10_terms() {
		calculationService.setCalculationTimes(10);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_100_terms() {
		calculationService.setCalculationTimes(100);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_1000_terms() {
		calculationService.setCalculationTimes(1000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_10_000_terms() {
		calculationService.setCalculationTimes(10000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_100_000_terms() {
		calculationService.setCalculationTimes(100000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_1000_000_terms() {
		calculationService.setCalculationTimes(1000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_10_000_000_terms() {
		calculationService.setCalculationTimes(10000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	@Test
	public void test_100_000_000_terms() {
		calculationService.setCalculationTimes(100000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	//@Test
	public void test_1_000_000_000_terms() {
		calculationService.setCalculationTimes(1000000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}

	//@Test
	public void test_10() {

		calculationService.setCalculationTimes(1000000000);
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
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
		System.out.println("Accurate Decimal Digits : "
				+ getAccurateDecimalDigits(difference));
		System.out.println();
	}

	private int getAccurateDecimalDigits(BigDecimal value) {
		String valueString = value.toPlainString();
		char[] valueChar = valueString.toCharArray();
		int pointIndex = 0;
		for (int i = 0; i < valueChar.length; i++) {
			if (valueChar[i] == '.') {
				pointIndex = i;
				continue;
			} else if (valueChar[i] != '0') {
				return i - pointIndex - 1;
			}
		}
		return valueChar.length;
	}
}
