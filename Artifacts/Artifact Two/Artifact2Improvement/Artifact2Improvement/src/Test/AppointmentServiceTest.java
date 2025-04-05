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
	//test appointment date update for failure
	@Test
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description", "123");
		service.updateAppointmentDate(Date(2024, Calendar.MARCH, 17), "123");
		assertNotEquals(Date(2024, Calendar.MARCH, 20), service.getAppointment("123").getAppointmentDate());
	}
	//test appointment description update for failure
	@Test
	void testUpdateAppointmentDescription() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description", "222");
		service.updateAppointmentDescription("New Description", "222");
		assertNotEquals("Different Description", service.getAppointment("222").getAppointmentDescription());
	}
	//test appointment description update for success
	@Test
	void testUpdateDescription() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description", "222");
		service.updateAppointmentDescription("New Description", "222");
		assertEquals("New Description", service.getAppointment("222").getAppointmentDescription());
	}
	//test add appointment by adding and then checking to make sure appointment record isnt empty	
	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description", "333");
		assertNotNull(service.getAppointment("333"), "Appointment not found");
	}
	//test delete app by adding record, deleting, and then checking against empty arraylist
	@Test
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.JANUARY, 1), "Description", "1");
		service.deleteAppointment("1");
		ArrayList<Appointment> emptyList = new ArrayList<Appointment>();
		assertEquals(service.appointmentList, emptyList, "Appointment deletion failed");
		
	} 
	
	
	
}

