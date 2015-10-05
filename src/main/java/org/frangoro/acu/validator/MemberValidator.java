package org.frangoro.acu.validator;

import org.frangoro.acu.model.MemberEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator {

	/**
	 * It's true whenever MemberEntity is a superclass of clazz
	 */
	public boolean supports(Class<?> clazz) {
		return MemberEntity.class.isAssignableFrom(clazz);
	}

	/**
	 * Set validation rules and validate fields against them
	 */
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"error.lastName", "Last name is required.");
	}

}
