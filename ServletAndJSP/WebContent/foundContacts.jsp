<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="domain.Contact"%>
<%@page import="domain.ContactGroup"%>
<%@page import="dao.DAO"%>
<%@page import="dao.AbstractDAOFactory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Résultat de la recherche</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<% 
//AbstractDAOFactory adf = AbstractDAOFactory
//.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);

//DAO<Contact> daoContact = adf.getDAOContact();
ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
List<Contact> list = new ArrayList<Contact>();
String searchType = request.getParameter("searchType");
if (searchType.equals("byfirstName")) {
	String token = request.getParameter("value").toLowerCase();
	for(Contact contact : daoContact.getAll()) {
		if (contact.getFirstName().toLowerCase().contains(token))
			list.add(contact);
	}
}
else if (searchType.equals("bylastName"))
{
	String token = request.getParameter("value").toLowerCase();
	for(Contact contact : daoContact.getAll()) {
		if (contact.getLastName().toLowerCase().contains(token))
			list.add(contact);
	}
}
else if (searchType.equals("bygroup")) {
	String token = request.getParameter("value").toLowerCase();
	for(Contact contact : daoContact.getAll()) {
		for (ContactGroup group : contact.getGroups()) {
			if (group.getGroupName().toLowerCase().contains(token))
				list.add(contact);
		}
	}
}
if (list.size() == 0)
	out.println("<h1 style='text-align: center;'>Aucun résultat!</h1>");
else
{
	%>
	<div id="found" style="text-align: center;">
	<h3><%out.print(list.size()+" résultat(s)");%></h3>
	<table style="border: solid 1px black;">
		<tr>
			<td>Nom</td>
			<td>Prénom</td>
			<td>Email</td>
			<td></td>
		</tr>
	<%
	for(Contact contact : list) {
		%>
		<tr>
			<td><%=contact.getLastName()%></td>
			<td><%=contact.getFirstName()%></td>
			<td><%=contact.getEmail()%></td>
			<td><%
				String urlargs = "updateContact.jsp?"+
				"id=" + contact.getId() + //"&firstname="+
				//contact.getFirstName() + "&lastname="+
				//contact.getLastName() + 
				"&email=" + contact.getEmail();%>
				<a href='<%=urlargs%>'>Modifier</a>
			</td>
		</tr><%
	}
	%>
	</table>
	</div>
	<%
}
%>
</body>
</html>