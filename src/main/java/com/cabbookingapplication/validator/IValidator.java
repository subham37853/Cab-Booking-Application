package com.cabbookingapplication.validator;

public interface IValidator<T> {

    /**
     * Validates whether an object has correct data or not.
     *
     * @param t
     * @return
     */
    boolean validate(T t);
}
