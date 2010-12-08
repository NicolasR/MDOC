package domain;

import java.util.Set;

public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private Long id;
	private Address address;
	private Set<PhoneNumber> phones;
	private Set<ContactGroup> groups;
	
	
	
	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	public Set<ContactGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact() {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
