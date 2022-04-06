package com.cabbookingapplication.validator;

import com.cabbookingapplication.models.Location;
import org.springframework.stereotype.Component;
import org.w3c.dom.ranges.RangeException;

@Component
public class LocationValidator implements IValidator<Location> {

    @Override
    public boolean validate(Location location) {
        if (location == null) throw new NullPointerException("Invalid location");
        if (isInRange(location.getX(), location.getY()) == false) {
            throw new IllegalArgumentException("Values must be in the range of (-2^31) to (2^31)");
        }
       return true;
    }

    private boolean isInRange(int x, int y) {
        return (x >= Integer.MIN_VALUE) && (x <= Integer.MAX_VALUE) && (y >= Integer.MIN_VALUE) && (y <= Integer.MAX_VALUE);
    }
}
