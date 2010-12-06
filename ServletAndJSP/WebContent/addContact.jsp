<%@page import="domain.ContactGroup"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un contact</title>
</head>
<body>
<form method="post" action="NewContact">
<fieldset>
First Name : <input type="text" name="firstName" size="25">
<br />
Last Name : <input type="text" name="lastName" size="25">
<br />
Email : <input type="text" name="email" size="25">
</fieldset>
<fieldset>
Street : <input type="text" name="street" size="25">
<br />
City : <input type="text" name="city" size="25">
<br />
ZIP : <input type="text" name="zip" size="25">
<br />
Country : <input type="text" name="country" size="25">
<br />
</fieldset>
<fieldset>
Phone kind : <input type="text" name="phoneKind" size="25">
<br />
Phone number : <input type="text" name="phoneNumber" size="25">
<br />
</fieldset>
<fieldset>
<p>
Choisissez les groupes :<br />
<%
SessionFactory sessionFactory =
	new Configuration().configure().buildSessionFactory();
	Session s = sessionFactory.openSession();
	
Transaction t = s.beginTransaction();
	
Query query = s.createQuery("from ContactGroup");
List<ContactGroup> list = query.list();
for(ContactGroup group : list)
{
	%>
	<input type="checkbox" name="<%=group.getGroupName()%>" id="<%=group.getGroupName()%>" /> 
	<label for="<%=group.getGroupName()%>"><%=group.getGroupName()%></label><br />
	<%
}
t.commit();
s.close();
%>
Créer un nouveau groupe : <input type="text" name="newGroup" size="25">
<br />
</p>
</fieldset>
<input type="submit" value="Submit"> <input type="reset" value="Reset">
</form>
</body>
</html>