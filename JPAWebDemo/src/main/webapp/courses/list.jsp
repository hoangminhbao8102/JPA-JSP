<%-- 
    Document   : list
    Created on : Jul 30, 2025, 11:02:19 AM
    Author     : 20113
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Khóa học</title>
</head>
<body>
<h2>Danh sách Khóa học</h2>
<a href="${pageContext.request.contextPath}/courses?action=new">Thêm mới</a>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Tiêu đề</th><th>Số tín chỉ</th><th>Hành động</th>
    </tr>
    <c:forEach var="c" items="${list}">
        <tr>
            <td>${c.id}</td>
            <td>${c.title}</td>
            <td>${c.credits}</td>
            <td>
                <a href="${pageContext.request.contextPath}/courses?action=edit&id=${c.id}">Sửa</a> |
                <form action="${pageContext.request.contextPath}/courses" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${c.id}"/>
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
