package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {
	//test if ID allowed through to be over 10 chars
	@Test
	void testContactIDLength10Char() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", "");
		contact.setContactID("123456789012");
		if(contact.getContactID().length() > 10) {
			fail("Contact ID cannot have more than 10 characters.");
		}
	}
	//test to ensure id shortened to 10 chars through data validation steps
	@Test
	void testContactID() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", "");
		contact.setContactID("123456789012");
		if(contact.getContactID().length() <= 10) {
			System.out.println("Contact ID shortened successfully");
			return;
		}
	}
	//test if first name allowed through to be over 10 chars
	@Test
	void testFirstNameLength10Char() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setFirstName("JoeBobBillyBob");
		if(contact.getFirstName().length() > 10) {
			fail("Contact First Name cannot have more than 10 characters.");
		}
	}
	//test to ensure name shortened to 10 chars through data validation steps
	@Test
	void testFirstName() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", "");
		contact.setFirstName("JoeBobBillyBob");
		if(contact.getFirstName().length() <= 10) {
			System.out.println("First Name shortened successfully");
			return;
		}
	}
	//test if last name allowed through to be over 10 chars
	@Test
	void testLastNameLength10Char() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setLastName("William-Smith-Johnson");
		if(contact.getLastName().length() > 10) {
			fail("Contact Surname cannot have more than 10 characters.");
		}
	}
	//test to ensure name shortened to 10 chars through data validation steps
	@Test
	void testLastName() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setLastName("William-Smith-Johnson");
		if(contact.getLastName().length() <= 10) {
			System.out.println("Last Name shortened successfully");
			return;
		}
	}
	//test if phone number allowed through to be over 10 chars
	@Test
	void testPhoneNumberLength10Char() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setPhoneNumber("55512355678");
		if(contact.getPhoneNumber().length() > 10) {
			fail("Contact Phone Number must have 10 characters.");
		}
	}
	//test to ensure number shortened to 10 chars through data validation steps
	@Test
	void testPhoneNumber() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setPhoneNumber("55512355678");
		if(contact.getPhoneNumber().length() <= 10) {
			System.out.println("Phone Number shortened successfully");
			return;
		}
	}
	//test if address allowed through to be over 30 chars
	@Test
	void testAddressLength30Char() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setAddress("123 Washington Street Washington United Stated 12345");
		if(contact.getAddress().length() > 10) {
			fail("Contact Address cannot have more than 10 characters.");
		}
	}
	//test to ensure address shortened to 30 chars through data validation steps
	@Test
	void testAddress() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		contact.setAddress("123 Washington Street Washington United Stated 12345");
		if(contact.getAddress().length() <= 30) {
			System.out.println("Address shortened successfully");
			return;
		}
	}
	
	
	//test if name null
	@Test
	void testFirstNameNotNull() {
		Contact contact = new Contact("", "Last", "Phone", "Address", " ");
		contact.setFirstName(null);
		if(contact.getFirstName() == null) {
			fail("Contact First Name cannot be null.");
		}
	}
	//test name being null is not allowed through data validation
	@Test
	void testFirstNameNull() {
		Contact contact = new Contact("", "Last", "Phone", "Address", " ");
		contact.setFirstName(null);
		if(contact.getFirstName() == "NULL") {
			return;
		}
	}
	
	//test if name null
	@Test
	void testLastNameNotNull() {
		Contact contact = new Contact("First", "", "Phone", "Address", " ");
		contact.setLastName(null);
		if(contact.getLastName() == null) {
			fail("Contact Last Name cannot be null");
		}
	}
	//test name being null is not allowed through data validation
	@Test
	void testLastNameNull() {
		Contact contact = new Contact("First", "", "Phone", "Address", " ");
		contact.setLastName(null);
		if(contact.getLastName() == "NULL") {
			return;
		}
	}
	//test if number null
	@Test
	void testPhoneNumberNotNull() {
		Contact contact = new Contact("First", "Last", "", "Address", " ");
		contact.setPhoneNumber(null);
		if(contact.getPhoneNumber() == null) {
			fail("Contact phone number cannot be null");
		}
	}
	//test number being null is not allowed through data validation
	@Test
	void testPhoneNumberNull() {
		Contact contact = new Contact("First", "Last", "", "Address", " ");
		contact.setPhoneNumber(null);
		if(contact.getPhoneNumber() == "5555555555") {
			return;
		}
	}
	//test if address null
	@Test
	void testAddressNotNull() {
		Contact contact = new Contact("First", "Last", "Phone", "", " ");
		contact.setAddress(null);
		if(contact.getAddress() == null) {
			fail("Contact address cannot be null");
		}
	}
	//test address being null is not allowed through data validation
	@Test
	void testAddressNull() {
		Contact contact = new Contact("First", "Last", "Phone", "", " ");
		contact.setAddress(null);
		if(contact.getAddress() == "NULL") {
			return;
		}
	}
	

}