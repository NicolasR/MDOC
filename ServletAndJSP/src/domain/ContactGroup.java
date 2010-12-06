package domain;

import java.util.ArrayList;

public class ContactGroup {
	
	private Integer groupId;
	private String groupName;
	private ArrayList<Contact> contacts;
	
	
	public ContactGroup() {
	}
	
	public ContactGroup(Integer groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
	

}
