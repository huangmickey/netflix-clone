<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<head>
    <link rel="stylesheet" href="Styles/landing.css">
    <title>Landing</title>
</head>

<body>
    <div class="top-container">

        <div class="top-bar">
            <text id="logo">Netflix</text>
            <button id="top-button" type="button" onclick="toLogin()">Sign in</button>

        </div>

        <div class="register-container">

            <form name="email-form" action="${pageContext.request.contextPath}/register" onsubmit="submitEmail()">


                    <input id="email-address" type="email" name="email-address" placeholder="Email Address" required>
                    <input id="submit" type="submit" value="Get Started >" onclick="validateEmail()">

                    <p id="error-message" class="error-message"></p>
            </form>
        </div>
    </div>

    <div class="card-one">
        <p>Card One</p>
    </div>

    <div class="card-two">
        <p>Card Two</p>
    </div>

    <div class="card-three">
        <p>Card Three</p>
    </div>

    <div class="footer">
        <p>Footer</p>
    </div>

</body>


<script>

    function toLogin() {
        document.location='/login';
    }
    function validateEmail() {
        const email = document.getElementById("email-address").value;
        if(email === "") {
            document.getElementById("error-message").innerHTML = "Email can not be blank!";
        } else {
            document.getElementById("error-message").innerHTML = "Please enter a valid email.";
        }
    }

    function submitEmail() {
        const sendEmail = document.getElementById("email-address");
        localStorage.setItem("email", sendEmail.value);
        sendEmail.value="";
    }


</script>

</html>
