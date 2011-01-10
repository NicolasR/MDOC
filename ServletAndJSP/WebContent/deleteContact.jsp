
<%@page import="domain.ContactGroup"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="domain.Contact"%>
<%@page import="dao.DAO"%>
<%@page import="dao.AbstractDAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Supprimer un contact</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
	<form method="post" action="DeleteContact">
		<%
		//AbstractDAOFactory adf = AbstractDAOFactory
		//	.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);
		
		//DAO<Contact> daoContact = adf.getDAOContact();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
		%>
		<table>
		<thead>
		<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Email</th>
		<th>Adresse</th>
		<th>Groupes</th>
		</tr>
		</thead>
		<tbody>
		<%
		for(Contact c : daoContact.getAll())
		{
			%>
			<tr>
			<td><input type="checkbox" name="<%=c.getId()%>" id="<%=c.getId()%>" />
			<label for="<%=c.getId()%>"><%=c.getId()%></label></td>
			<td><%=c.getLastName()%></td>
			<td><%=c.getFirstName()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getAddress().getStreet()%> <%=c.getAddress().getZip()%> <%=c.getAddress().getCity()%> <%=c.getAddress().getCountry()%></td>
			<td><select><%for(ContactGroup group : c.getGroups()) { %> <option><%=group.getGroupName()%></option> <% } %></select></td>
			</tr>
			<%
		}
		%>
		</tbody>
		</table>
		<%
		%>
	<input type="submit" value="Supprimer contact">
	</form>
</body>
</html>