package domain;

import java.util.ArrayList;

public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private long id;
	private Address address;
	private ArrayList<PhoneNumber> phones;
	private ArrayList<ContactGroup> books;
	
	
	
	public ArrayList<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<PhoneNumber> phones) {
		this.phones = phones;
	}

	public ArrayList<ContactGroup> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<ContactGroup> books) {
		this.books = books;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact() {
	}
	
	public Contact(String firstName, String lastName, String email/*, long id*/) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
