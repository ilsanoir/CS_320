package contact;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public void setId(String id) {
		if(id == null || id.length() > 10 || id.length() < 0) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
		
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
		
	}
	
	public void setPhone(String phone) {
		if(phone == null || phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phone = phone;
		
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
		
	}
	
	public Contact(){
		this.id = "12345";
		this.firstName = "Jone";
		this.lastName = "Doe";
		this.phone = "1234445555";
		this.address = "That Place";
		
	}
	
	public Contact(String id){
	
		setId(id);
		this.firstName = "Jone";
		this.lastName = "Doe";
		this.phone = "1234445555";
		this.address = "That Place";
	}
	
	public Contact(String id, String firstName){		
		setId(id);
		setFirstName(firstName);
		this.lastName = "Doe";
		this.phone = "1234445555";
		this.address = "That Place";
		
	}
	
	public Contact(String id, String firstName, String lastName){	
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		this.phone = "1234445555";
		this.address = "That Place";
		
	}
	
	public Contact(String id, String firstName, String lastName, String phone){
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		this.address = "That Place";
	}
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	

	
	public String getId(){
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
}
