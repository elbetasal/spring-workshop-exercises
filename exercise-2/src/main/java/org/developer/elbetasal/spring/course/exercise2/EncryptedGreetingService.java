package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("encryptedGreeting")
public class EncryptedGreetingService implements GreetingService {

	private static final String KEY = "Zx" + Math.log(2) / 3;

	private EnglishGreetingService englishGreetingService;

	@Autowired
	public void setEnglishGreetingService(EnglishGreetingService englishGreetingService) {
		this.englishGreetingService = englishGreetingService;
	}

	@Override
	public String greet(String name) {
		String greeting = englishGreetingService.greet(name);
		char[] result = new char[greeting.length()];
		for (int i = 0; i < greeting.length(); i++) {
			result[i] = (char) (greeting.charAt(i) + KEY.charAt(i % KEY.length()));
		}

		return new String(result);
	}



}
