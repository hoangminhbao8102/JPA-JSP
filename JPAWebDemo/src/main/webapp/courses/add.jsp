<%-- 
    Document   : add
    Created on : Jul 30, 2025, 11:03:27 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thêm Khóa học</title>
</head>
<body>
<h2>Thêm Khóa học</h2>
<form action="${pageContext.request.contextPath}/courses" method="post">
    <input type="hidden" name="action" value="insert"/>
    Tiêu đề: <input type="text" name="title" required/><br/>
    Tín chỉ: <input type="number" name="credits" required/><br/>
    <button type="submit">Lưu</button>
    <a href="${pageContext.request.contextPath}/courses">Hủy</a>
</form>
</body>
</html>
