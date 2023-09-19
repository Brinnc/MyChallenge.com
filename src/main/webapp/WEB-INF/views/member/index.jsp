<%@page import="org.sp.challenges.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Member member=(Member)session.getAttribute("Member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>
	<%=member.getName() %>님, 안녕하세요🙂
	</h3>
	
	<ul>
		<li><a href="/member/board/list">게시판 관리</a></li>
	</ul>
</body>
</html>