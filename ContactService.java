package contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	private String uniqueId;
	private List<Contact> contactList = new ArrayList<>();
	private List<String> idList = new ArrayList<>();
	
	//creates a unique ID for each contact
	private String newId() {
		uniqueId = UUID.randomUUID().toString();
		//iterate through list of IDs, making a new ID if current
		//ID already exists
		for (int i = 0; i < idList.size(); i++) {
			if(uniqueId == idList.get(i)) {
				uniqueId = UUID.randomUUID().toString();
			}
		}
		return uniqueId.substring(0,9);
	}
	
	//additive methods for contact objects
	public void newContact() {
		Contact contact = new Contact(newId());
		contactList.add(contact);
		idList.add(contact.getId());
	}
	
	public void newContact(String firstName) {
		Contact contact = new Contact(newId(), firstName);
		contactList.add(contact);
		idList.add(contact.getId());
	}
	
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact(newId(), firstName, lastName);
		contactList.add(contact);
		idList.add(contact.getId());
	}
	
	public void newContact(String firstName, String lastName, String phone) {
		Contact contact = new Contact(newId(), firstName, lastName, phone);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(newId(), firstName, lastName, phone, address);
		contactList.add(contact);
		idList.add(contact.getId());
	}
	
	//method to search through contact list
	private Contact contactSearch(String id) throws Exception{
		for(int i=0; i < contactList.size(); i++) {
			if(id == contactList.get(i).getId()) {
				return contactList.get(i);
			}
		}
		throw new Exception ("Contact not found");
	}
	
	//subtractive methods for contact objects
	public void deleteContact(String id) throws Exception {
		contactList.remove(contactSearch(id));
	}
	
	//update features
	public void updateFirstName(String id, String firstName) throws Exception {
		contactSearch(id).setFirstName(firstName);
	}
	
	public void updateLastName(String id, String lastName) throws Exception {
		contactSearch(id).setLastName(lastName);
	}
	
	public void updatePhone(String id, String phone) throws Exception {
		contactSearch(id).setPhone(phone);
	}
	
	public void updateAddress(String id, String address) throws Exception {
		contactSearch(id).setAddress(address);
	}
	
	public List<Contact> getContactList(){
		return contactList;
	}
}
