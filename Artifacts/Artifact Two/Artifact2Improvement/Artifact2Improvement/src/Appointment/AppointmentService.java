package Appointment;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	//establish arraylist for appointments
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	//add appointment
	public void addAppointment(Date appointmentDate, String appointmentDescription, String appointmentID) {
		Appointment appointment = new Appointment(appointmentDate, appointmentDescription, appointmentID);
		appointmentList.add(appointment);
	}
	//delete appointment by id
	public void deleteAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID() == appointmentID) {
				appointmentList.remove(counter);
				break;
			}
			
		}
	}
	//update appointment date
	public void updateAppointmentDate(Date newDate, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID() == appointmentID) {
				appointmentList.get(counter).setAppointmentDate(newDate);
				break;
			}
			
		}
	}
	//update appointment description
	public void updateAppointmentDescription(String newDescription, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID() == appointmentID) {
				appointmentList.get(counter).setAppointmentDescription(newDescription);
				break;
			}
	
		}
		
	}
	//return appointment info
	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment(null, null, appointmentID);
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID() == appointmentID) {
				appointment = appointmentList.get(counter);
			}
			}
		return appointment;
	}
}

