package org.developer.elbetasal.spring.course.exercise2;

public class EncryptedGreetingService implements GreetingService {

	private static final String KEY = "Zx" + Math.log(2) / 3;

	private EnglishGreetingService englishGreetingService;

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
