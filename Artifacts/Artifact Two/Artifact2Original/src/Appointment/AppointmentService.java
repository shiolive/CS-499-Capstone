package Appointment;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {

	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	public void addAppointment(Date appointmentDate, String appointmentDescription) {
		Appointment appointment = new Appointment(appointmentDate, appointmentDescription);
		appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.remove(counter);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment not found");
			}
		}
	}
	
	public void updateAppointmentDate(Date newDate, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(counter).setAppointmentDate(newDate);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment not found");
			}
		}
	}
	
	public void updateAppointmentDescription(String newDescription, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(counter).setAppointmentDescription(newDescription);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment not found");
			}
		}
		
	}
	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment(null, null);
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointment = appointmentList.get(counter);
			}
			}
		return appointment;
	}
}

