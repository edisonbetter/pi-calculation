package com.edison.pi.calculation.service;

/**
 * This interface is for Pi calculation
 * 
 * @author Edison Yang
 * @date 2014-08-10 
 */
public interface PiCalculationService {
	double calculate();
	int getNumberOfTerms();
	void setNumberOfTerms(int numberOfTerms);
}
