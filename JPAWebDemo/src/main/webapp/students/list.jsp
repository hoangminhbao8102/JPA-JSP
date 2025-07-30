<%-- 
    Document   : list
    Created on : Jul 30, 2025, 10:58:34 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Sinh viên</title>
</head>
<body>
<h2>Danh sách Sinh viên</h2>
<a href="${pageContext.request.contextPath}/students?action=new">Thêm mới</a>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Tên</th><th>Email</th><th>Hành động</th>
    </tr>
    <c:forEach var="s" items="${list}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/students?action=edit&id=${s.id}">Sửa</a> |
                <form action="${pageContext.request.contextPath}/students" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${s.id}"/>
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
