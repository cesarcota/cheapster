<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 04/02/2018
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>



<h1 class = "listof">"List of Groups" </h1>

<a class="newGroupButton" role="button" href="newgroup" name="newgroup">New Group</a>

<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Group name</th>
        <th scope="col">Group picture</th>

    </tr>
    </thead>

    <tbody>
    <ul>
        <c:forEach var="group" items="${groupList}">
        <tr>
            <td>
                <a href="group/${group.id}"> ${group.groupName}</a>
            </td>

        </tr>
        </c:forEach>
    </ul>
    </tbody>


</table>
    </body>
</html>
