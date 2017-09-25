<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div id="main">
	<form action="show.do" method="post">
		产品代码<input name="id" />
		风险评级
		<select name="risk">
			<option value="0">请选择</option>
			<option value="1">R1</option>
			<option value="2">R2</option>
			<option value="3">R3</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="查询"/>
	</form>
	<a href="add.jsp">新增理财信息</a>
	<table border="1">
		<tr>
			<td>产品代码</td>
			<td>风险评级</td>
			<td>预期收益</td>
			<td>发售起始日</td>
			<td>发售截止日</td>
			<td>产品到期日</td>
			<td>删除</td>
			<td>更新</td>
		</tr>
		<c:forEach var="financingProduct" items="${financingProducts }">
			<tr>
				<td>${financingProduct.id }</td>
				<td>${financingProduct.risk }</td>
				<td>${financingProduct.income }</td>
				<td>${financingProduct.saleStarting }</td>
				<td>${financingProduct.saleEnd }</td>
				<td>${financingProduct.end }</td>
				<td><a href="delete.do?id=${financingProduct.id }">删除</a></td>
				<td><a href="toUpdate.do?id=${financingProduct.id }">更新</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>