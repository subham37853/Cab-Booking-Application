package com.cabbookingapplication.validator;

import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.models.Location;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DriverValidatorTest {
    @InjectMocks
    DriverValidator driverValidator;

    @Mock
    LocationValidator locationValidator;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void testValidate_withException() {
        Driver d = new Driver(null, null, null, 1,
                null, null, 0, 0, 0);
        d.setLocation(new Location(2,2));

        when(locationValidator.validate(any(Location.class))).thenReturn(true);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Details are not correct");
        driverValidator.validate(d);
    }


    @Test
    public void testValidate() {
        Driver d = new Driver(null, null, null, 1,
                null, null, 0, 0, 0);
        d.setLocation(new Location(2,2));

        when(locationValidator.validate(any(Location.class))).thenReturn(true);

        boolean validate = driverValidator.validate(d);

        Assert.assertTrue(validate);
    }
}
