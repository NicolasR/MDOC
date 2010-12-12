<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="UpdateContact">
First Name : <input type="text" name="firstName" size="25" <%out.print("value='"+request.getParameter("firstname")+"'"); %>>
<br />
Last Name : <input type="text" name="lastName" size="25" <%out.print("value='"+request.getParameter("lastname")+"'"); %>>
<br />
Email : <input type="text" name="email" size="25" <%out.print("value='"+request.getParameter("email")+"'"); %>>
<br />
Id : <input type="text" name="id" size="25" <%out.print("value='"+request.getParameter("id")+"'"); %>>
<br />
<br />
<input type="submit" value="Submit"> <input type="reset" value="Reset">
</form>
</body>
</html>