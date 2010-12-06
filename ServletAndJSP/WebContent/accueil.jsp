<%@page import="org.hibernate.Transaction"%>
<%@page import="domain.Address"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
<h1>Bienvenue</h1>
<br />
<h2>Quelques liens :</h2>
<a href="addContact.jsp">Ajouter un contact</a>
<br />
<a href="deleteContact.jsp">Supprimer un contact</a>
<br />
<a href="updateContact.jsp">Modifier un contact</a>
<br />
<a href="searchContact.jsp">Chercher un contact</a>
</body>
</html>