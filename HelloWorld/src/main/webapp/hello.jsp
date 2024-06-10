<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	if (name == null) {
		name = "Anonymous";
	}
	%>
	<h1>Hello, JSP</h1>
	<p>
		Welcome
		<%=name%></p>
	<h3>POST 전송</h3>
	<p>Send POST Data to HelloServlet</p>
	<form method="POST" action="/HelloServlet/hs">
		<label for="last_name">성(Last Name)</label> <input type="text"
			id="last_name" name="last_name" placeholder="성을 입력하세요" /><br> <label
			for="firstname">이름(First Name)</label> <input type="text"
			id="first_name" name="first_name" placeholder="이름을 입력하세요" /><br>
		<input type="submit" value="전송" /><br> <input type="reset"
			value="새로 작성" /><br>

	</form>
</body>
</html>