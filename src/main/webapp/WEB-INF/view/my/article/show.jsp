<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<link href="css/css.css" rel="stylesheet">
<title>收藏列表</title>
</head>
<body>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">ID</th>
      <th scope="col">收藏夹文本</th>
      <th scope="col">收藏夹地址</th>
      <th scope="col">收藏时间</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${info.list}" var="show">
    <tr>
      <th scope="row">1</th>
      <td>${show.id}</td>
      <td>${show.text}</td>
      <td>${show.url}</td>
      <td>${show.created}</td>
      <td><a href="my/article/del?id=${show.id}"> <button class="btn-sm btn-danger">删除</button></a> 
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<jsp:include page="/WEB-INF/view/common/pages.jsp" />
</body>
<script type="text/javascript">
function goPage(page) {
	//location.href="/user/selects?page="+page
	var url = "/my/article/show?page=" + page;
	$("#center").load(url); //
}
</script>
</html>