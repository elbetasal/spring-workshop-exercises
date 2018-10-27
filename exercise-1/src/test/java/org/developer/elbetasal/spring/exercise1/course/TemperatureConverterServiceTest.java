package org.developer.elbetasal.spring.exercise1.course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TemperatureConverterServiceTest {

	@Autowired
	@Qualifier("fahrenheit")
	private TemperatureConverterService celsiusConverter;

	@Autowired
	@Qualifier("celsius")
	private TemperatureConverterService fahrenheitConverter;

	@Test
	public void convert_celsius_to_farenheit(){

		assertThat(fahrenheitConverter.convertTemperature(0D) , is(32D));
		assertThat(fahrenheitConverter.convertTemperature(30D) , is(86D));

	}

	@Test
	public void convert_fahrenheit_to_celsius(){

		assertThat(celsiusConverter.convertTemperature(15D) , is(-9.4452D));
		assertThat(celsiusConverter.convertTemperature(32D) , is(0D));

	}


}
