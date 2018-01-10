package tests.EMS_tests;

import bg.softuni.core.EmergencyManagementSystemImpl;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyManagementSystem;
import org.junit.Before;
import org.mockito.Mockito;

public class EmsTests {
    private EmergencyManagementSystem emergencyManagementSystem;
    private Emergency emergency;

    @Before
    public void before(){
        this.emergencyManagementSystem = new EmergencyManagementSystemImpl();
        this.emergency = Mockito.mock(Emergency.class);
    }
}
