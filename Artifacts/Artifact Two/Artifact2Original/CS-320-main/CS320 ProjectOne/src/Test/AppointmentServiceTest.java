package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {

	private Date Date (int year, int month, int day) {
		return null;
	}

	@Test
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description");
		service.updateAppointmentDate(Date(2024, Calendar.MARCH, 17), "123");
		assertNotEquals(Date(2024, Calendar.MARCH, 17), service.getAppointment("123").getAppointmentDate());
	}
	@Test
	void testUpdateAppointmentDescription() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description");
		service.updateAppointmentDescription("New Description", "123");
		assertNotEquals("New Description", service.getAppointment("123").getAppointmentDescription());
	}
	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description");
		assertNotNull(service.getAppointment("1"), "Appointment not found");
	}
	@Test
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description");
		service.deleteAppointment("1");
		ArrayList<Appointment> emptyList = new ArrayList<Appointment>();
		assertNotEquals(service.appointmentList, emptyList, "Appointment deletion failed");
	} 
	
	
	
	
	
}

