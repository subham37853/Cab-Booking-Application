package com.cabbookingapplication.validator;

public interface IValidator<T> {

    boolean validate(T t);
}
