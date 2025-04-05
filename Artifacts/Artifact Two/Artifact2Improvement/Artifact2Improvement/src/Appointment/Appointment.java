package Appointment;

import java.util.Calendar;
import java.util.Date;


public class Appointment {
 private String appointmentID;
 private Date appointmentDate;
 private String appointmentDescription;
  
 public Appointment(Date appointmentDate, String appointmentDescription, String appointmentID) {
	 
	 //data validation
	 if (appointmentDate == null) {
		 this.appointmentDate = new Date(2024, Calendar.JANUARY, 1);
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
	 if (appointmentID.length() > 10) {
		 this.appointmentID = appointmentID.substring(0, 10);
	 }
	 else {
		 this.appointmentID = appointmentID;
	 }
 }
 
 //setters
 public void setAppointmentDate(Date appointmentDate) {
	 if (appointmentDate == null) {
		 this.appointmentDate = new Date(1999, Calendar.JANUARY, 1);
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
 
 public void setAppointmentID(String appointmentID) {
	 if (appointmentID == null || appointmentID.isEmpty()) {
		 this.appointmentID = "NULL";
	 }
	 else if (appointmentID.length() > 10) {
		 this.appointmentID = appointmentID.substring(0, 10);
	 }
	 else {
		 this.appointmentID = appointmentID;
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
