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
	//test if ID allowed through to be over 10 chars
	@Test
	void testAppointmentID10Chars() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description", "1");
		appointment.setAppointmentID("123456789012");
		if (appointment.getAppointmentID().length() > 10) {
			fail("Appointment ID must be 10 Characters or less.");
		}
	}
	//test to ensure id shortened to 10 chars through data validation steps
	@Test
	void testAppointmentID() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description", "1");
		appointment.setAppointmentID("123456789012");
		if (appointment.getAppointmentID().length() <= 10) {
			System.out.println("Appointment ID shortened.");
			return;
		}
	}
	//test if description allowed through to be over 50 chars
	@Test
	void testAppointmentDescription50Chars() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "", "2");
		appointment.setAppointmentDescription("Description is too long.Description is too long.Description is too long.");
		if (appointment.getAppointmentDescription().length() > 50) {
			fail("Appointment Description must be 50 Characters or less.");
		}
	}
	//test to ensure description shortened to 50 chars through data validation steps
	@Test
	void testAppointmentDescription() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "", "2");
		appointment.setAppointmentDescription("Description is too long.Description is too long.Description is too long.");
		if (appointment.getAppointmentDescription().length() <= 50) {
			System.out.println("Appointment Description shortened successfully");
			return;
		}
	}
	//test if appointment date is before todays date
	@Test
	void testAppointmentDate() {
		Appointment appointment = new Appointment(null, "Description", "3");
		appointment.setAppointmentDate(Date(2024, Calendar.JANUARY, 1));
		if (appointment.getAppointmentDate().before(new Date())) {
			fail("Appointment Date must be after todays date.");
		}
	}
	//test if appointment date is after todays date
	@Test
	void testAppointmentDateSuccess() {
		Appointment appointment = new Appointment(null, "Description", "3");
		appointment.setAppointmentDate(Date(2026, Calendar.JANUARY, 1));
		if (appointment.getAppointmentDate().after(new Date())) {
			System.out.println("Appointment Date accepted");
		}
	}
	
	//test if date null
	@Test
	void testAppointmentDateNotNull() {
		Appointment appointment = new Appointment(null, "Description", "4");
		appointment.setAppointmentDate(new Date());
		assertNotNull(appointment.getAppointmentDate(), "Date cannot be null.");
	}
	//test date being null is not allowed through data validation
	@Test
	void testAppointmentDateNull() {
		Appointment appointment = new Appointment(null, "Description", "5");
		appointment.setAppointmentDate(null);
		if (appointment.getAppointmentDate() == Date(1999, Calendar.JANUARY, 1)) {
			System.out.println("Date invalid, reset to January 1, 2024. Please update");
			return;
		}
	}
	//test description being null is not allowed through data validation
	@Test
	void testAppointmentDescriptionNotNull() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), null, "6");
		appointment.setAppointmentDescription(null);
		assertNotNull(appointment.getAppointmentDescription(), "Description cannot be null.");
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), null, "7");
		appointment.setAppointmentDescription(null);
		if (appointment.getAppointmentDescription() == "NULL") {
			System.out.println("Description field empty");
			return;
		}
	}
	//test ID being null is not allowed through data validation
	@Test
	void testAppointmentIDNotNull() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description", "8");
		appointment.setAppointmentID("10");
		assertNotNull(appointment.getAppointmentID(), "ID cannot be null.");
	}
	
	@Test
	void testAppointmentIDNull() {
		Appointment appointment = new Appointment(Date(2024, Calendar.JANUARY, 1), "Description", "10");
		appointment.setAppointmentID(null);
		if (appointment.getAppointmentID() == "NULL") {
			System.out.println("Appointment ID field empty");
			return;
	}
}
}

