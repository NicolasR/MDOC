
<%@page import="domain.ContactGroup"%>
<%@page import="domain.DAOContactGroup"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
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
isEntreprise: <input type="checkbox" name="isEntreprise">
</fieldset>
<fieldset>
Siret number: <input type="text" name="numSiret">
</fieldset>
<fieldset>
Choisissez les groupes :<br />
<%
DAOContactGroup daoContactGroup = new DAOContactGroup(null);
for(ContactGroup group : daoContactGroup.getAll())
{
	%>
	<input type="checkbox" name="<%=group.getGroupName()%>" id="<%=group.getGroupName()%>" /> 
	<label for="<%=group.getGroupName()%>"><%=group.getGroupName()%></label><br />
	<%
}
%>
</fieldset>
<input type="submit" value="Submit"> <input type="reset" value="Reset">
</form>
<form method="post" action="CreateGroup">
<fieldset>
Créer un nouveau groupe : <input type="text" name="newGroup" size="25"> <input type="submit" value="Submit">
</fieldset>
</form>
</body>
</html>