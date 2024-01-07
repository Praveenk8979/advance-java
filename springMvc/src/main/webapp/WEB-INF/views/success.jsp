<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:directive.page isELIgnored="false" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${Header }</h1>
<p>${Desc }</p>

<h1 style="color: green">${msg }</h1>

<hr>
	<h1>Welcome, ${user.userName }</h1>
	<h1>Your email is : ${user.userEmail }</h1>
	<h1>Your password is : ${user.userPassword } try to the secure the password</h1>

</body>
</html>