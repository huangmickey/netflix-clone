<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
        <input type="text" name="password">
        <input type="text" name="first-name">
        <input type="text" name="last-name">
        <input type="submit" value="submit">
    </form>

    ${userData.getEmail()}
    ${userData.getPassword()}
    ${userData.getFirstName()}
    ${userData.getLastName()}

</body>
</html>
