package tests.registration_time_tests;

import bg.softuni.interfaces.RegistrationTime;
import bg.softuni.utils.RegistrationTimeImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTimeTests {
    private final int MINUTES = 24;
    private final int HOUR = 12;
    private final int DAY = 26;
    private final int MONTH = 2;
    private final int YEAR = 2016;
    private RegistrationTime registrationTime;

    @Before
    public void before(){
        this.registrationTime = new RegistrationTimeImpl("12:24 26/02/2016");
    }

    @Test
    public void getMinutesTest(){
        int minutes = this.registrationTime.getMinutes();
        Assert.assertTrue(this.registrationTime.getMinutes() == MINUTES);
    }

    @Test
    public void getHourTest(){
        int hour = this.registrationTime.getHour();
        Assert.assertTrue(this.registrationTime.getHour() == HOUR);
    }

    @Test
    public void getDayTest(){
        int minutes = this.registrationTime.getDay();
        Assert.assertTrue(this.registrationTime.getDay() == DAY);
    }

    @Test
    public void getMonthTest(){
        int month = this.registrationTime.getMonth();
        Assert.assertTrue(this.registrationTime.getMonth() == MONTH);
    }

    @Test
    public void getYearTest(){
        int year = this.registrationTime.getYear();
        Assert.assertTrue(this.registrationTime.getYear() == YEAR);
    }
}
