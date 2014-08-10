package com.edison.pi.calculation.test;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edison.pi.calculation.service.PiCalculationService;

public class TestPiCalculationCoverage {
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

	// @Test
	public void test_10_to_100_terms() {
		for (int i = 10; i < 100; i++) {
			calculationService.setNumberOfTerms(i);
			double result = calculationService.calculate();
			BigDecimal difference = getDifference(result);
			int accurateDecimalDigit = getAccurateDecimalDigits(difference);
			Assert.assertTrue(accurateDecimalDigit >= 1);
		}
	}

	// @Test
	public void test_100_to_1000_terms() {
		for (int i = 100; i < 1000; i++) {
			calculationService.setNumberOfTerms(i);
			double result = calculationService.calculate();
			BigDecimal difference = getDifference(result);
			int accurateDecimalDigit = getAccurateDecimalDigits(difference);
			Assert.assertTrue(accurateDecimalDigit >= 2);
		}
	}

	// @Test
	public void test_1000_to_10000_terms() {
		for (int i = 1000; i < 10000; i++) {
			calculationService.setNumberOfTerms(i);
			double result = calculationService.calculate();
			BigDecimal difference = getDifference(result);
			int accurateDecimalDigit = getAccurateDecimalDigits(difference);
			Assert.assertTrue(accurateDecimalDigit >= 3);
		}
	}

	//@Test
	public void test_10000_to_100000_terms() {
		for (int i = 10000; i < 100000; i++) {
			final int terms = i;
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					calculationService.setNumberOfTerms(terms);
					double result = calculationService.calculate();
					BigDecimal difference = getDifference(result);
					int accurateDecimalDigit = getAccurateDecimalDigits(difference);
					Assert.assertTrue(accurateDecimalDigit >= 4);
				}

			});
			thread.start();
		}
	}

	//@Test
	public void test_100000_to_1000000_terms() {
		for (int i = 100000; i < 1000000; i++) {
			final int terms = i;
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					calculationService.setNumberOfTerms(terms);
					double result = calculationService.calculate();
					BigDecimal difference = getDifference(result);
					int accurateDecimalDigit = getAccurateDecimalDigits(difference);
					Assert.assertTrue(accurateDecimalDigit >= 5);
				}

			});
			thread.start();
		}
	}

	// @Test
	public void test_1000000_to_10000000_terms() {
		for (int i = 1000000; i < 10000000; i++) {
			calculationService.setNumberOfTerms(i);
			double result = calculationService.calculate();
			BigDecimal difference = getDifference(result);
			int accurateDecimalDigit = getAccurateDecimalDigits(difference);
			Assert.assertTrue(accurateDecimalDigit >= 6);
		}
	}

	private BigDecimal getDifference(double result) {
		BigDecimal difference = BigDecimal.valueOf(result)
				.subtract(BigDecimal.valueOf(PI)).abs();
		return difference;
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
