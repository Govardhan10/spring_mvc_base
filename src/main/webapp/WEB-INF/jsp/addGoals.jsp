<%--
  Created by IntelliJ IDEA.
  User: gy670554
  Date: 5/27/2020
  Time: 7:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
    <title>Goals Report</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Minutes</th>
        </tr>
        <c:forEach items="${goals} var=goal">
            <tr>
                <td>${goal.id}</td>
                <td>${goal.minutes}</td>
                <td>
                    <table>
                        <tr>
                            <th>Exercise ID</th>
                            <th>Exercise Minutes</th>
                            <th>Exercise Activity</th>
                        </tr>
                        <c:forEach items="${goal.exercises}" var="exercise">
                            <tr>
                                <td>${exercise.id}</td>
                                <td>${exercise.minutes}</td>
                                <td>${exercise.activiy}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
