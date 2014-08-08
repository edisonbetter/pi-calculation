package com.edison.pi.calculation.test;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edison.pi.calculation.service.PiCalculationService;

public class TestPiCalculation {
	private ApplicationContext context;
	private PiCalculationService calculationService;
	private final double PI = Math.PI;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring-pi-calculation.xml");
		calculationService = (PiCalculationService) context.getBean("piCalculation");
	}

	@Test
	public void test_1() {
		System.out.println("Available Processor:" + Runtime.getRuntime().availableProcessors());
		double result = calculationService.calculate();
		
		outputResult(result);
		long maxMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax();
		long usedMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
		//long usage = BigDecimal.valueOf(usedMemory).divide(BigDecimal.valueOf(maxMemory)).longValue();
		long usage = usedMemory / maxMemory;
		
		System.out.println("Memory Max size: " +  maxMemory);
		System.out.println("Memory Used size: " + usedMemory);
		System.out.println("Memory usage: " +  usage);
	}
	
	//@Test
	public void test_2() {
		double result = calculationService.calculate();
		outputResult(result);
	}

	private void outputResult(double result) {
		System.out.println("***************Test Result***************");
		System.out.println("calculation result: " + result);
		System.out.println("Pi                : " + PI);
		System.out.println("Difference        : "
				+ BigDecimal.valueOf(result)
						.subtract(BigDecimal.valueOf(PI)).toPlainString());
		System.out.println();
	}
}
