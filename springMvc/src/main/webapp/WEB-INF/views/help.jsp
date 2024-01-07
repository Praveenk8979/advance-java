<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:directive.page isELIgnored="false" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Page</title>
</head>
<body>
	<%
	/* String name=(String)request.getAttribute("name");
	Integer id=(Integer)request.getAttribute("id");
	 LocalDateTime time=(LocalDateTime)request.getAttribute("time"); */
	%>
	<h1>
		Hello my name is
		<%-- <%=name %> --%>
		${name}
	</h1>

	<h1>
		My id is:
		<%-- <%=id %> --%>
		${id}
	</h1>
	<h1>
		Time and Date is :
		<%-- <%=time %> --%>
		${time}
	</h1>
	<hr>
	<c:forEach var="item" items="${marks}">
		<%-- <h1>${item}</h1> --%>
		<h1>
			<c:out value="${item}"></c:out>
		</h1>
	</c:forEach>
</body>
</html>