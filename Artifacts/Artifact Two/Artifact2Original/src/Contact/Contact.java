package Contact;

public class Contact {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String contactID;
	
	
	public Contact(String firstName, String lastName, String number, String address, String contactID) {
		
		//validate first name string
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";
		}
		else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		}
		else {
			this.firstName = firstName;
		}
		//validate last name string
		if (lastName == null || lastName.isEmpty()) {
			this.firstName = "NULL";
		}
		else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		}
		else {
			this.firstName = lastName;
		}
		//validate phone number
		if (number == null || number.isEmpty() || number.length() != 10) {
			this.phoneNumber = "5555555555";
		}
		else {
			this.phoneNumber = number;
		}
		//validate address
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		}
		else if (address.length() > 30) {
			this.address = address.substring(0,30);
		}
		else {
			this.address = address;
		}
		//validate contact ID
		if (contactID == null || contactID.isEmpty()) {
			this.address = "NULL";
			}
		else if (contactID.length() > 10) {
			this.address = contactID.substring(0,10);
			}
		else {
			this.contactID = contactID;
		}
		
	}
	//getters
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	//setters
	public void setFirstName(String firstName) {
		if (firstName == null ||firstName.isEmpty()) {
			this.firstName = "NULL";
		}
		else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		}
		else {
			this.firstName = firstName;
		}
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			this.firstName = "NULL";
		}
		else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		}
		else {
			this.firstName = lastName;
		}
	}
	public void setPhoneNumber(String number) {
		if (number == null || number.isEmpty() || number.length() != 10) {
			this.phoneNumber = "5555555555";
		}
		else {
			this.phoneNumber = number;
		}
	}
	
	public void setAddress(String address) {
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		}
		else if (address.length() > 30) {
			this.address = address.substring(0,30);
		}
		else {
			this.address = address;
		}
	}
	public void setContactID(String IDNum) {
		if (IDNum == null || IDNum.length() > 10) {
			throw new IllegalArgumentException("Invalid ContactID");
		}
		contactID = IDNum;
	}
	
	
}

