package com.example.szs.common.model;

import javax.validation.*;
import java.util.Set;

public abstract class SelfValidating<T> {

    private final Validator validator;
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    protected SelfValidating() {
        validator = factory.getValidator();
    }

    protected void validate() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
