package org.developer.elbetasal.spring.exercise1.course;

public class FahrenheitToCelsiusConverterService implements TemperatureConverterService {

	@Override
	public double convertTemperature(Double temperature) {
		return  (temperature-32)*(0.5556);
	}
}
