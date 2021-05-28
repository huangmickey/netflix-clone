<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<head>
    <link rel="stylesheet" href="Styles/register.css">
    <title>Register</title>
</head>

<body>
    <div class="sign-up-container">
        <div class="sign-up-contents">
            <form id="register-form" action="" method="post">
                <p>Sign Up</p>
                <label>E-mail Address<br>
                    <input id="set-email" type="text" readonly="readonly" name="username"> <br>
                </label>
                <br>
                <label>First Name<br>
                    <input type="text" name="first-name" required> <br>
                </label>
                <br>
                <label>Last Name<br>
                    <input type="text" name="last-name" required> <br>
                </label>
                <br>
                <label>Password<br>
                    <input id="password" type="password" name="password" required> <br>
                </label>
                <br>
                <label>Confirm Password<br>
                    <input id="confirm-password" type="password" name="confirm-password" required oninput="checkPassword(this)"> <br>
                </label>
                <br>
                <br><br>
                <input type="submit" name="Register">
                <c:if test="${not empty registerError}">
                </c:if>

            </form>
        </div>

        <div class="break"></div>

        <div class="test">
            <p>hello</p>
        </div>

    </div>
<script>
    const email = localStorage.getItem("email");
    document.getElementById("set-email").value = email;

    function checkPassword(password) {
        if(password.value !== document.getElementById("password").value) {
            password.setCustomValidity("Passwords must be matching.");
        } else {
            password.setCustomValidity("");
        }
    }
</script>
</body>
</html>
