<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增理财信息</title>
</head>
<body>
	<h1>新增理财信息</h1>
	<form action="add.do" method="post">
		<table>
			<tr>
				<td>产品代码</td>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<td>风险评级</td>
				<td><select name="risk">
						<option value="0">请选择</option>
						<option value="1">R1</option>
						<option value="2">R2</option>
						<option value="3">R3</option>
				</select></td>
			</tr>
			<tr>
				<td>预期收益</td>
				<td><input name="income" /></td>
			</tr>
			<tr>
				<td>发售起始日</td>
				<td><input name="saleStarting" type="date" /></td>
			</tr>
			<tr>
				<td>发售截止日</td>
				<td><input name="saleEnd" type="date"/></td>
			</tr>
			<tr>
				<td>产品到期日</td>
				<td><input name="end" type="date"/></td>
			</tr>
		</table>
		<input type="submit" value="保存"/><input type="reset" value="重置"/><input type="button" value="返回" onclick=""/>
	</form>
</body>
</html>