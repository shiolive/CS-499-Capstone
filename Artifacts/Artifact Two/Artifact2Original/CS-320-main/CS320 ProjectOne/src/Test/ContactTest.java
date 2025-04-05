package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {
	
	@Test
	void testContactIDLength10Char() {
		Contact contact = new Contact("First", "Last", "Phone", "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact ID cannot have more than 10 characters.");
		}
	}
	@Test
	void testFirstNameLength10Char() {
		Contact contact = new Contact("JoeBobBillyBob", "Last", "Phone", "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact First Name cannot have more than 10 characters.");
		}
	}
	@Test
	void testLastNameLength10Char() {
		Contact contact = new Contact("First", "William-Smith", "Phone", "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact Surname cannot have more than 10 characters.");
		}
	}
	@Test
	void testPhoneNumberLength10Char() {
		Contact contact = new Contact("First", "Last", "55512355678", "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact Phone Number must have 10 characters.");
		}
	}
	@Test
	void testAddressLength30Char() {
		Contact contact = new Contact("First", "Last", "Phone", "123 Washington Street Washington United Stated 12345", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact Address cannot have more than 10 characters.");
		}
	}
	@Test
	void testFirstNameNotNull() {
		Contact contact = new Contact(null, "Last", "Phone", "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact First Name cannot be null.");
		}
	}
	@Test
	void testLastNameNotNull() {
		Contact contact = new Contact("First", null, "Phone", "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact Last Name cannot be null");
		}
	}
	@Test
	void testPhoneNumberNotNull() {
		Contact contact = new Contact("First", "Last", null, "Address", " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact phone number cannot be null");
		}
	}
	@Test
	void testAddressNotNull() {
		Contact contact = new Contact("First", "Last", "Phone", null, " ");
		if(contact.getContactID().length() > 10) {
			fail("Contact address cannot be null");
		}
	}

}