package com.edison.pi.calculation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edison.pi.calculation.service.PiCalculationService;

public class PiCalculation {
	private static ApplicationContext context ;
	private static PiCalculationService calculationService;
	
	
	public static void main(String[] args){
		context = new ClassPathXmlApplicationContext("spring-pi-calculation.xml");
		calculationService = (PiCalculationService) context.getBean("piCalculation");
		double result = calculationService.calculate();
		outputResult(calculationService.getCalculationTimes(), result);
	}
	
	private static void outputResult(int terms, double result){
		System.out.println("The Pi calculation terms   : " + terms);
		System.out.println("The Pi calculation result : " + result);
		System.out.println();
	}
}
