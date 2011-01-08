package util;

import org.aspectj.lang.ProceedingJoinPoint;

import domain.Contact;
import domain.ContactGroup;

public class AOPclass {
	public void contactCreated(Contact contact) {
		System.out.println("Contact created:");
		System.out.println("firstName: "+contact.getFirstName());
		System.out.println("lastName: "+contact.getLastName());
		for (ContactGroup group : contact.getGroups()) {
			System.out.println(group.getGroupName());
		}
		System.out.println("END");
	}
	
	public void contactDeleted(ProceedingJoinPoint pjp, long id) throws Throwable
	{
		if (id == 1)
		{
			System.out.println("Impossible de supprimer ce contact !");
		}
		else
		{
			pjp.proceed();
		}
	}
}
