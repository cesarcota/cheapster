<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 04/02/2018
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>

    <title>Create a new group!</title>
</head>
<body>


</form>



<form:form method="post" modelAttribute="group">
    <p><form:input path="groupName" placeholder="Group Name"/><form:errors path="groupName" cssClass="error"/><form:errors/></p>

    <p><form:select path="type" placeHolder="Type"/></p>
    <input type="submit" value="Create"

</form:form>

<h1>${sucess}</h1>

</body>
</html>