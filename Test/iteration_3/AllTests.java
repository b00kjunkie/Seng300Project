package iteration_3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppointmentDBTest.class, PatientDBTest.class, DoctorUnavailabilityDBTest.class, CustomElementTest.class,CustomArrayTest.class,DoctorDBTest.class })
public class AllTests {

}
