package Appointment;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;


public class Appointment {
 private String appointmentID;
 private Date appointmentDate;
 private String appointmentDescription;
 private static AtomicLong IDGenerator = new AtomicLong();
 
 public Appointment(Date appointmentDate, String appointmentDescription) {
	 
	 this.appointmentID = String.valueOf(IDGenerator.getAndIncrement());
	 
	 if (appointmentDate == null) {
		 this.appointmentDate = new Date(2024, Calendar.JANUARY, 1);
	 }
	 else if (appointmentDate.before(new Date())) {
		 throw new IllegalArgumentException("Appointment must be after current date.");
	 }
	 else {
		 this.appointmentDate = appointmentDate;
	 }
	 if (appointmentDescription == null || appointmentDescription.isEmpty()) {
		 this.appointmentDescription = "NULL";
	 }
	 else if(appointmentDescription.length() > 50) {
		 this.appointmentDescription = appointmentDescription.substring(0, 50);
	 }
	 else {
		 this.appointmentDescription = appointmentDescription;
	 } 
 }
 
 //setters
 public void setAppointmentDate(Date appointmentDate) {
	 if (appointmentDate == null) {
		 this.appointmentDate = new Date(2024, Calendar.JANUARY, 1);
	 }
	 else if (appointmentDate.before(new Date())) {
		 throw new IllegalArgumentException("Appointment must be after current date.");
	 }
	 else {
		 this.appointmentDate = appointmentDate;
	 }
 }
 
 public void setAppointmentDescription(String appointmentDescription) {
	 if (appointmentDescription == null || appointmentDescription.isEmpty()) {
		 this.appointmentDescription = "NULL";
	 }
	 else if(appointmentDescription.length() > 50) {
		 this.appointmentDescription = appointmentDescription.substring(0, 50);
	 }
	 else {
		 this.appointmentDescription = appointmentDescription;
	 } 
 }
 
 //getters
 
 public String getAppointmentID() {
	 return appointmentID;
 }
 
 public Date getAppointmentDate() {
	 return appointmentDate;
 }
 
 public String getAppointmentDescription() {
	 return appointmentDescription;
 }
 
 
}

