<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
	<table>
		<tr>
			<td><label>用户名：</label></td>
			<td><input type="text" id="accountId"></td>
		</tr>
		<tr>
		<td>
			<label>密码：</label></td>
			<td><input type="password" id="accountpassword"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<select>
					<option>总裁</option>
					<option>副总裁</option>
					<option>经理</option>
					<option>副经理</option>
					<option>职员</option>
					
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="登录"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	
	
	
</form>

</body>
</html>