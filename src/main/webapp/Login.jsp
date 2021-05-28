<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="Styles/login.css">
</head>

<body>
    <span class="logo">Netflix</span>
    <div class="sign-in-container">
        <div class="sign-in-contents">
            <p class="sign-in-text">Sign in</p>
            <form method="post" action="">
                <label>
                    <input type="text" name="username"required>
                    <span class="floating-label-email">Email Address</span>
                </label>

                <label>
                    <input type="password" name="password"required>
                    <span class="floating-label-password">Password</span>
                </label>
                <input type="submit" value="Sign in">
                <c:if test="${not empty loginError}">
                    <p style="color:#ffa00a;;">${loginError}</p>
                </c:if>
            </form>
        </div>
    </div>
</body>
</html>