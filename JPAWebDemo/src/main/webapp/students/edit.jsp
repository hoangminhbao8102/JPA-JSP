<%-- 
    Document   : edit
    Created on : Jul 30, 2025, 11:00:25 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sửa Sinh viên</title>
</head>
<body>
<h2>Sửa Sinh viên</h2>
<form action="${pageContext.request.contextPath}/students" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${student.id}"/>
    Tên: <input type="text" name="name" value="${student.name}" required/><br/>
    Email: <input type="email" name="email" value="${student.email}" required/><br/>
    <button type="submit">Cập nhật</button>
    <a href="${pageContext.request.contextPath}/students">Hủy</a>
</form>
</body>
</html>
