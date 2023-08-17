package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

import org.junit.jupiter.api.BeforeEach;

public class ContactTest {
	public String idTest, firstNameTest, lastNameTest, phoneTest, addressTest;
	public String tenId, tenFirstName, tenLastName, thirtyAddress, longId, longFirstName, longLastName, shortPhone,
				  longPhone, letterPhone, longAddress;
	
	@BeforeEach
	void testStart() {
	idTest = "123456";
	firstNameTest = "Alias";
	lastNameTest = "Mori";
	phoneTest = "1234440000";
	addressTest = "A Place Far Far Away";
	
	
	tenId = "0123456789";
	tenFirstName = "ThisisName";
	thirtyAddress = "An Address WithThiryCharacters";
	tenLastName = "ThisisName";
	longId = "12345678912";
	longFirstName = "Thisisnotarealfirstname";
	longLastName = "Thisisnotareallastname";
	shortPhone = "1";
	longPhone = "111222333344444";
	letterPhone = "1A2B3C";
	longAddress = "Man it would be quite nice to live out somewhere with this long a name";
	}
	
	//Test for default constructor
	@Test
	void defaultConstructor() {
		Contact contact = new Contact();
		assertAll("Default constructor", () -> assertNotNull(contact.getId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhone()),
				() -> assertNotNull(contact.getAddress())
				);
		
	}
	
	//Test for passing only ID to constructor
	@Test
	void constructor1() {
		Contact contact = new Contact(idTest);
		assertAll("Constructor 1", () -> assertNotNull(contact.getId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhone()),
				() -> assertNotNull(contact.getAddress())
				);
		
	}
	
	//Test for passing only ID and First Name to constructor
	@Test
	void constructor2() {
		Contact contact = new Contact(idTest, firstNameTest);
		assertAll("Constructor 2", () -> assertNotNull(contact.getId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhone()),
				() -> assertNotNull(contact.getAddress())
				);
		
	}
	
	//Test for passing only ID, First Name and Last Name to constructor
	@Test
	void constructor3() {
		Contact contact = new Contact(idTest, firstNameTest, lastNameTest);
		assertAll("Constructor 3", () -> assertNotNull(contact.getId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhone()),
				() -> assertNotNull(contact.getAddress())
				);
		
	}
	
	//Test for passing only ID First Name, Last Name and Phone Number to constructor
	@Test
	void constructor4() {
		Contact contact = new Contact(idTest, firstNameTest, lastNameTest, phoneTest);
		assertAll("Constructor 4", () -> assertNotNull(contact.getId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhone()),
				() -> assertNotNull(contact.getAddress())
				);
		
	}
	
	//Test for passing all parameters to constructor
	@Test
	//Boundary test for ID at 10 characters
	void idBoundaryTest() {
		Contact contact = new Contact();
		contact.setId(tenId);
		
		assertAll("Boundary ID tests", ()-> assertNotNull(contact.getId()),
				()-> assertEquals(tenId, contact.getId())
				);
		
		assertThrows(IllegalArgumentException.class, ()-> contact.setId(null));
		assertThrows(IllegalArgumentException.class, ()-> contact.setId(longId));
	}
	
	@Test
	void constructor5() {
		Contact contact = new Contact(idTest, firstNameTest, lastNameTest, phoneTest, addressTest);
		assertAll("Constructor 5", () -> assertNotNull(contact.getId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhone()),
				() -> assertNotNull(contact.getAddress())
				);
		
	}
	
	//Testing the First Name setting functionality
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameTest);
		assertEquals(firstNameTest, contact.getFirstName());
		assertAll("First Name Tests", ()-> assertEquals(contact.getFirstName(), firstNameTest),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setFirstName(longFirstName); }),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setFirstName(null); })
				);
		
		contact.setFirstName(tenFirstName);
		assertEquals(tenFirstName, contact.getFirstName());
	}
	
	//Testing the Last Name setting functionality
	@Test
	void setLastNameTest(){
		Contact contact = new Contact();
		contact.setLastName(lastNameTest);
		assertEquals(lastNameTest, contact.getLastName());
		assertAll("Last Name Tests", ()-> assertEquals(contact.getLastName(), lastNameTest),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setLastName(longLastName); }),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setLastName(null); })
				);
		
		contact.setLastName(tenLastName);
		assertEquals(tenLastName, contact.getLastName());
	}
	
	//Testing the Phone Number setting functionality
	@Test
	void setPhoneTest(){
		Contact contact = new Contact();
		contact.setPhone(phoneTest);
		assertEquals(phoneTest, contact.getPhone());
		assertAll("Phone Number Tests", ()-> assertEquals(contact.getPhone(), phoneTest),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setPhone(longPhone); }),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setPhone(shortPhone); }),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setPhone(null); }),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setPhone(letterPhone); })
				);
	}
	
	//Testing the Address setting functionality
	@Test
	void setAddress(){
		Contact contact = new Contact();
		contact.setAddress(addressTest);
		assertEquals(addressTest, contact.getAddress());
		assertAll("Address Tests", ()-> assertEquals(contact.getAddress(), addressTest),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setAddress(longAddress); }),
				() -> assertThrows(IllegalArgumentException.class,
						()-> {contact.setAddress(null); })
				);
		
		contact.setAddress(thirtyAddress);
		assertEquals(thirtyAddress, contact.getAddress());
	}

}
