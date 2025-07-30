<%-- 
    Document   : add
    Created on : Jul 30, 2025, 11:05:52 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Đăng ký Khóa học</title>
</head>
<body>
<h2>Đăng ký Khóa học</h2>
<form action="${pageContext.request.contextPath}/enrollments" method="post">
    <input type="hidden" name="action" value="insert"/>
    Sinh viên:
    <select name="studentId">
        <c:forEach var="s" items="${students}">
            <option value="${s.id}">${s.name}</option>
        </c:forEach>
    </select><br/>
    Khóa học:
    <select name="courseId">
        <c:forEach var="c" items="${courses}">
            <option value="${c.id}">${c.title}</option>
        </c:forEach>
    </select><br/>
    <button type="submit">Đăng ký</button>
    <a href="${pageContext.request.contextPath}/enrollments">Hủy</a>
</form>
</body>
</html>
