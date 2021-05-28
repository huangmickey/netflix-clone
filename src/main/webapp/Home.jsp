<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>Welcome ${Character.toUpperCase(userName.charAt(0)).toString().concat(userName.substring(1))}</h1> <!--Character.toUpperCase(userName.charAt(0)).toString().concat(userName.substring(1))-->
<button onclick="window.location.href='/details'">Details</button>
<button onclick="window.location.href='/logout'">Log out</button>
</body>
</html>