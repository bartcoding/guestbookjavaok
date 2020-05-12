<%--
  Created by IntelliJ IDEA.
  User: Rudi
  Date: 5/12/2020
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>guestbook</title>
</head>
<body>
<h1>welcome to my guestbook!</h1>

<p>
<c:forEach items="${messages}" var="message">
    <p style="font-family: fantasy"> ${message.date}</p>
    <p style="font-family: Bahnschrift">name: ${message.name}</p>
    <p style="font-family: Consolas">message: ${message.message}</p>
</c:forEach>

</p>


<hr>
<form method='post' action=''>
    <p>please enter name:</p>
    name: <input type="text" name="name">
    message: <input type="textarea" name="message">
    <input type="submit" value="okidoki!">
</form>
</body>
</html>