package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.ContactService;

import org.junit.jupiter.api.BeforeEach;

public class ContactServiceTest {
	public String idTest, firstNameTest, lastNameTest, phoneTest, addressTest;
	public String longId, longFirstName, longLastName, shortPhone, longPhone, longAddress;
	
	@BeforeEach
	void testStart() {
	idTest = "123456";
	firstNameTest = "Alias";
	lastNameTest = "Mori";
	phoneTest = "1234440000";
	addressTest = "A Place Far Far Away";
	
	longId = "1234567891";
	longFirstName = "Thisisnotarealfirstname";
	longLastName = "Thisisnotareallastname";
	shortPhone = "1";
	longPhone = "111222333344444";
	longAddress = "Man it would be quite nice to live out somewhere with this long a name";
	}
	
	@Test
	void newContactTest() {
		ContactService contact = new ContactService();
		contact.newContact();
		
		assertAll("Default constructor",() -> assertNotNull(contact.getContactList().get(0).getId()),
				() -> assertEquals("Jone", contact.getContactList().get(0).getFirstName()),
				() -> assertEquals("Doe", contact.getContactList().get(0).getLastName()),
				() -> assertEquals("1234445555", contact.getContactList().get(0).getPhone()),
				() -> assertEquals("That Place", contact.getContactList().get(0).getAddress())
				);
	}
		
	@Test
	void newContactTest2() {
		ContactService contact = new ContactService();
		contact.newContact(firstNameTest);
		
		assertAll("Default constructor",() -> assertNotNull(contact.getContactList().get(0).getId()),
				() -> assertEquals(firstNameTest, contact.getContactList().get(0).getFirstName()),
				() -> assertEquals("Doe", contact.getContactList().get(0).getLastName()),
				() -> assertEquals("1234445555", contact.getContactList().get(0).getPhone()),
				() -> assertEquals("That Place", contact.getContactList().get(0).getAddress())
				);
	}
	
	@Test
	void newContactTest3() {
		ContactService contact = new ContactService();
		contact.newContact(firstNameTest, lastNameTest);
		
		assertAll("Default constructor",() -> assertNotNull(contact.getContactList().get(0).getId()),
				() -> assertEquals(firstNameTest, contact.getContactList().get(0).getFirstName()),
				() -> assertEquals(lastNameTest, contact.getContactList().get(0).getLastName()),
				() -> assertEquals("1234445555", contact.getContactList().get(0).getPhone()),
				() -> assertEquals("That Place", contact.getContactList().get(0).getAddress())
				);
}
	
	@Test
	void newContactTest4() {
		ContactService contact = new ContactService();
		contact.newContact(firstNameTest, lastNameTest, phoneTest);
		
		assertAll("Default constructor",() -> assertNotNull(contact.getContactList().get(0).getId()),
				() -> assertEquals(firstNameTest, contact.getContactList().get(0).getFirstName()),
				() -> assertEquals(lastNameTest, contact.getContactList().get(0).getLastName()),
				() -> assertEquals(phoneTest, contact.getContactList().get(0).getPhone()),
				() -> assertEquals("That Place", contact.getContactList().get(0).getAddress())
				);
		
}
	
	@Test
	void newContactTest5() {
		ContactService contact = new ContactService();
		contact.newContact(firstNameTest, lastNameTest, phoneTest, addressTest);
		
		assertAll("Default constructor",() -> assertNotNull(contact.getContactList().get(0).getId()),
				() -> assertEquals(firstNameTest, contact.getContactList().get(0).getFirstName()),
				() -> assertEquals(lastNameTest, contact.getContactList().get(0).getLastName()),
				() -> assertEquals(phoneTest, contact.getContactList().get(0).getPhone()),
				() -> assertEquals(addressTest, contact.getContactList().get(0).getAddress())
				);
		
		
	}

	  @Test
	  void deleteContactTest() {
	    ContactService contact = new ContactService();
	    contact.newContact();
	    assertThrows(Exception.class, () -> contact.deleteContact(idTest));
	    assertAll(() -> contact.deleteContact(contact.getContactList().get(0).getId()));
	  }

	  @Test
	  void updateFirstName() throws Exception {
	    ContactService contact = new ContactService();
	    contact.newContact();
	    contact.updateFirstName(contact.getContactList().get(0).getId(),firstNameTest);
	    assertEquals(firstNameTest, contact.getContactList().get(0).getFirstName());
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updateFirstName(contact.getContactList().get(0).getId(),longFirstName));
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updateFirstName(contact.getContactList().get(0).getId(), null));
	    assertThrows(Exception.class, () -> contact.updateFirstName(idTest, firstNameTest));
	  }
	  
	  @Test
	  void updateLastNameTest() throws Exception {
	    ContactService contact = new ContactService();
	    contact.newContact();
	    contact.updateLastName(contact.getContactList().get(0).getId(),lastNameTest);
	    assertEquals(lastNameTest, contact.getContactList().get(0).getLastName());
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updateLastName(contact.getContactList().get(0).getId(),longLastName));
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updateLastName(contact.getContactList().get(0).getId(), null));
	    assertThrows(Exception.class, () -> contact.updateLastName(idTest, lastNameTest));
	  }
	  
	  @Test
	  void updatePhoneTest() throws Exception {
	    ContactService contact = new ContactService();
	    contact.newContact();
	    contact.updatePhone(contact.getContactList().get(0).getId(),phoneTest);
	    assertEquals(phoneTest, contact.getContactList().get(0).getPhone());
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updatePhone(contact.getContactList().get(0).getId(),longPhone));
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updatePhone(contact.getContactList().get(0).getId(),shortPhone));
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updatePhone(contact.getContactList().get(0).getId(), null));
	    assertThrows(Exception.class, () -> contact.updatePhone(idTest, phoneTest));
	  }
	  
	  @Test
	  void updateAddress() throws Exception {
	    ContactService contact = new ContactService();
	    contact.newContact();
	    contact.updateAddress(contact.getContactList().get(0).getId(),addressTest);
	    assertEquals(addressTest, contact.getContactList().get(0).getAddress());
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updateAddress(contact.getContactList().get(0).getId(),longAddress));
	    assertThrows(IllegalArgumentException.class,
	    		() -> contact.updateAddress(contact.getContactList().get(0).getId(), null));
	    assertThrows(Exception.class, () -> contact.updateAddress(idTest, addressTest));
	  }
	  
}
