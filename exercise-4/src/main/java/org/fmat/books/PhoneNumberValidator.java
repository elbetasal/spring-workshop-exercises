package org.fmat.books;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint , String> {
	@Override
	public void initialize(PhoneNumberConstraint phoneNumberConstraint) {

	}

	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext constraintValidatorContext) {
		return contactField != null && contactField.matches("[0-9]+")
				&& (contactField.length() > 8) && (contactField.length() < 14);
	}
}
