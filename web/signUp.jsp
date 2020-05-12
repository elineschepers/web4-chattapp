<%--
  Created by IntelliJ IDEA.
  User: Eline Schepers
  Date: 12/05/2020
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<head>
    <title>sign up</title>
</head>
<body>
<c:choose>
    <c:when test="${user!=null}">
        <p>you already have an account, ${user.getFirstName()}!</p>

    </c:when>
    <c:otherwise>
        <form method="post" action="Controller?action=SignUp">
            <p>
                <label for="name">Your name </label>
                <input type="text" id="name" name="name" >
            </p>
            <p>
                <label for="surname">Your surname </label>
                <input type="text" id="surname" name="surname">
            </p>
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label>Your gender </label>
                <SELECT>
                <OPTION Value="female">female</OPTION>
                <OPTION Value="male">male</OPTION>
            </SELECT>
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" >
            </p>
            <p>
                <label for="confirmpassword">repeat password</label>
                <input type="password" id="confirmpassword" name="confirmpassword">
            </p>
            <p>
                <label for="age">your age</label>
                <input type="number" id="age" name="age" min="13" max="110">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
