<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<td>id</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>已售百分比</td>
		</tr>
		<c:forEach items="${pageInfo.list }" var="l">
			<tr>
				<td>${l.id }</td>
				<td>${l.name }</td>
				<td>${l.price }</td>
				<td>${l.sell }%</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				
				<a href="getSellList?pageNum=1">首页</a>
				<a href="getSellList?pageNum=${pageInfo.prePage }">上一页</a>
				<a href="getSellList?pageNum=${pageInfo.nextPage }">下一页</a>
				<a href="getSellList?pageNum=${pageInfo.pages }">尾页</a>
			</td>
		</tr>
	</table>
	
</body>
</html>