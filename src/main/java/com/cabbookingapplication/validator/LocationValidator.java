package com.cabbookingapplication.validator;

import com.cabbookingapplication.models.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationValidator implements IValidator<Location> {

    @Override
    public boolean validate(Location location) {
       return true;
    }
}
