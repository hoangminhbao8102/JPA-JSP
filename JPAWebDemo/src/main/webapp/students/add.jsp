<%-- 
    Document   : add
    Created on : Jul 30, 2025, 11:00:12 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thêm Sinh viên</title>
</head>
<body>
<h2>Thêm Sinh viên</h2>
<form action="${pageContext.request.contextPath}/students" method="post">
    <input type="hidden" name="action" value="insert"/>
    Tên: <input type="text" name="name" required/><br/>
    Email: <input type="email" name="email" required/><br/>
    <button type="submit">Lưu</button>
    <a href="${pageContext.request.contextPath}/students">Hủy</a>
</form>
</body>
</html>
