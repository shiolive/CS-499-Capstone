package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import Appointment.Appointment;

class AppointmentTest {
private Date Date(int year, int month, int day) {
	return null;
}
	@Test
	void testAppointmentID10Chars() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description");
		if (appointment.getAppointmentID().length() > 10) {
		fail("Appointment ID must be 10 Characters or less.");
		}
	}

	@Test
	void testAppointmentDescription50Chars() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description is too long.Description is too long.Description is too long.");
		if (appointment.getAppointmentDescription().length() > 50) {
		fail("Appointment Description must be 50 Characters or less.");
		}
	}
	
	@Test
	void testAppointmentDate() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description");
		if (appointment.getAppointmentDate().before(new Date())) {
		fail("Appointment Date must be after todays date.");
		}
	}

	@Test
	void testAppointmentDateNotNull() {
		Appointment appointment = new Appointment(null, "Description");
		assertNotNull(appointment.getAppointmentDate(), "Date cannot be null.");
	}
	
	@Test
	void testAppointmentDescriptionNotNull() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), null);
		assertNotNull(appointment.getAppointmentDescription(), "Description cannot be null.");
	}
	@Test
	void testAppointmentIDNotNull() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description");
		assertNotNull(appointment.getAppointmentID(), "ID cannot be null.");
	}
}

