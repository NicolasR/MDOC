package domain;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	
	private Long groupId;
	private String groupName;
	private Set<Contact> contacts;
	
	
	public ContactGroup() {
	}
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<Contact> getContacts() {
		if (contacts == null)
		{
			contacts = new HashSet<Contact>();
		}
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	

}
