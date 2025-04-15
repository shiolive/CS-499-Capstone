package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Contact.ContactService;
import java.util.ArrayList;

class ContactServiceTest {
	//test update first name for success
	@Test
	void testUpdateFirstName() {
		ContactService contactservice = new ContactService();
		contactservice.addContact("John", "Smith", "5556551234", "123 Main St", "1");
		contactservice.updateFirstName("Stu",  "1");
		assertEquals("Stu", contactservice.getContact("1").getFirstName(), "First Name not updated.");
	}
	
	//test update last name for failure
	@Test
	void testUpdateLastName() {
		ContactService contactservice = new ContactService();
		contactservice.addContact("John", "Smith", "5556551234", "123 Main St", "2");
		contactservice.updateLastName("Wilson",  "2");
		assertEquals("Wilson", contactservice.getContact("2").getLastName(), "Last Name not updated.");
	}
	//test update number for success
	@Test
	void testUpdatePhoneNumber() {
		ContactService contactservice = new ContactService();
		contactservice.addContact("John", "Smith", "5556551234", "123 Main St", "3");
		contactservice.updatePhoneNumber("5251119876",  "3");
		assertEquals("5251119876", contactservice.getContact("3").getPhoneNumber(), "Phone Number not updated.");
	}
	//test update address
	@Test
	void testUpdateAddress() {
		ContactService contactservice = new ContactService();
		contactservice.addContact("John", "Smith", "5556551234", "123 Main St", "4");
		contactservice.updateAddress("9 1st St",  "4");
		assertEquals("9 1st St", contactservice.getContact("4").getAddress(), "Address not updated.");
	}
	//test deleting contact by comparing new arraylist against empty arraylist
	@Test
	void testDeleteContact() {
		ContactService contactservice = new ContactService();
		contactservice.addContact("John", "Smith", "5556551234", "123 Main St", "3");
		contactservice.deleteContact("3");
		ArrayList<ContactService> emptyList = new ArrayList<ContactService>();
		assertEquals(contactservice.contactList, emptyList, "Contact not deleted");
	}
	//test adding contact by checking record not empty
	@Test
	void testAddContact() {
		ContactService contactservice = new ContactService();
		contactservice.addContact("John", "Smith", "5556551234", "123 Main St", "9");
		assertNotNull(contactservice.getContact("9"), "Contact not added");
	}


}
