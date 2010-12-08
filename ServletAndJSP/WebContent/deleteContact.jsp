<%@page import="domain.Contact"%>
<%@page import="domain.DAOContact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer un contact</title>
</head>
<body>
	<form method="post" action="DeleteContact">
		<%
		DAOContact daoContact = new DAOContact(null);
		for(Contact c : daoContact.getAll())
		{
			%>
			<input type="checkbox" name="<%=c.getId()%>" id="<%=c.getId()%>" /> 
			<label for="<%=c.getId()%>"><%=c.getId()%></label><br />
			<%
		}
		%>
	<input type="submit" value="Submit"> <input type="reset" value="Reset">
	</form>
</body>
</html>