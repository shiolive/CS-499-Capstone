package Contact;
import java.util.ArrayList;


public class ContactService {
	private int contactNum = 0;
	//create array list to hold contacts
	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	//create new contact
	public void addContact(String firstName, String lastName, String phoneNumber, String address, String contactID) {
		Contact contact = new Contact(firstName, lastName, phoneNumber, address, contactID);
		contactList.add(contact);
		contactNum++;
	}
	
	//contact getter by ID for ease of use
	public Contact getContact(String contactID) {
		Contact contact = new Contact(null, null, null, null, null);
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contact = contactList.get(counter);
			}
		}
		return contact;
	}
	//delete contact by ID
	public void deleteContact(String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contactList.remove(counter);
				break;
			}
			
	}	
}
	//update first name string of contact
	public void updateFirstName(String updatedName, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contactList.get(counter).setFirstName(updatedName);
				break;
			}
			
	}
	}
	//update last name string of contact
	public void updateLastName(String updatedName, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contactList.get(counter).setLastName(updatedName);
				break;
			}
			
	}
	}
	//update phone number of contact
	public void updatePhoneNumber(String updatedNumber, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contactList.get(counter).setPhoneNumber(updatedNumber);
				break;
			}
			
	}
	}
	//update address of contact
	public void updateAddress(String updatedAddress, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contactList.get(counter).setAddress(updatedAddress);
				break;
			}
			
	}
	}
}


