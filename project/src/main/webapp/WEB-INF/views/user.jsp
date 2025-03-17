<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>주문내역</title>
</head>
<body>
    <h2>주문내역</h2>

    <table border="1">
        <thead>
            <tr>
                <th>주문 ID</th>
                <th>주문명</th>
                <th>주문일</th>
                <th>총 가격</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.itemName}</td>
                    <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    <td>${order.totalPrice}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
