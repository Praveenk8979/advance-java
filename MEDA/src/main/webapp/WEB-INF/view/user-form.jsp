<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h1>User Form</h1>
    <form action="/saveUser" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        Username: <input type="text" name="username" value="${user.username}"/><br/>
        Password: <input type="text" name="password" value="${user.password}"/><br/>
        <input type="submit" value="Save"/>
    </form>
    <br/>
    <a href="/user-list">Back to List</a>
</body>
</html>
