<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 04/02/2018
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>



<h4>Welcome</h4>
<form:form method="post" modelAttribute="user">
    <p>Email: <form:input path="email" class="form-control input-sm chat-input" placeholder="email"/></p>
    <form:errors path="userName" style="color:red" value="${error}"/>
    <p>Password: <form:password path="password" class="form-control input-sm chat-input" placeholder="password"/></p>
    <form:errors path="password" style="color:red" value="${error}"/>
    <br/>


    <input href="#"  type="submit" name="login" value="Login" >
    <button type="registerButtom">
        <a href="register" name="register">Sign up</a>
    </button>

</form:form>


</body>
</html>
