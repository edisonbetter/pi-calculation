package com.edison.pi.calculation.service;

/**
 * This interface is for Pi calculation
 * 
 * @author Edison Yang
 *
 */
public interface PiCalculationService {
	double calculate();
	int getNumberOfTerms();
	void setNumberOfTerms(int numberOfTerms);
}
