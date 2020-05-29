<%--
  Created by IntelliJ IDEA.
  User: gy670554
  Date: 5/29/2020
  Time: 11:48 AM
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
            <th>Minutes</th><th>Exercise Minutes</th><th>Activity</th>
        </tr>
        <c:forEach items="${goalReports}" var="goalReport">
            <tr>
                <td>${goalReport.goalMinutes}</td>
                <td>${goalReport.exerciseMinutes}</td>
                <td>${goalReport.exerciseActivity}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
