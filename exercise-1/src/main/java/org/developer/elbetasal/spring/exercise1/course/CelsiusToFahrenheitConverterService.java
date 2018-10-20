package org.developer.elbetasal.spring.exercise1.course;

public class CelsiusToFahrenheitConverterService implements TemperatureConverterService {

	@Override
	public double convertTemperature(Double temperature) {
		return (1.8 * temperature) + 32;
	}

}
