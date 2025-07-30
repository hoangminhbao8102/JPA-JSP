<%-- 
    Document   : list
    Created on : Jul 30, 2025, 11:04:54 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Đăng ký</title>
</head>
<body>
<h2>Danh sách Đăng ký</h2>
<a href="${pageContext.request.contextPath}/enrollments?action=new">Đăng ký mới</a>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Sinh viên</th>
        <th>Khóa học</th>
        <th>Ngày đăng ký</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="e" items="${list}">
        <tr>
            <td>${e.id}</td>
            <td>${e.student.name}</td>
            <td>${e.course.title}</td>
            <td>${e.enrollmentDate}</td>
            <td>
                <form action="${pageContext.request.contextPath}/enrollments" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${e.id}"/>
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
