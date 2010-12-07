package domain;


public class PhoneNumber {
	
	private Integer id;
	private String phoneKind;
	private String phoneNumber;
	private Contact contact;
	
	public PhoneNumber(Integer id, String phoneKind, String phoneNumber) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	

}
