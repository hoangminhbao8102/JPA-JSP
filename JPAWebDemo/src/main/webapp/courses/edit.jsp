<%-- 
    Document   : edit
    Created on : Jul 30, 2025, 11:03:47 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sửa Khóa học</title>
</head>
<body>
<h2>Sửa Khóa học</h2>
<form action="${pageContext.request.contextPath}/courses" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${course.id}"/>
    Tiêu đề: <input type="text" name="title" value="${course.title}" required/><br/>
    Tín chỉ: <input type="number" name="credits" value="${course.credits}" required/><br/>
    <button type="submit">Cập nhật</button>
    <a href="${pageContext.request.contextPath}/courses">Hủy</a>
</form>
</body>
</html>
