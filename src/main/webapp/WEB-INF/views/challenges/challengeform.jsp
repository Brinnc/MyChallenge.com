<%@page import="org.sp.challenges.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	Member member=(Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

<title>Make your own challenge!</title>

<style>

body {
	padding-top: 70px;
	padding-bottom: 30px;
}

#header{
	font-family: 'Nanum Pen Script', cursive;
	font-weight: bold;
	font-size: 50px;
}

label{
	font-family: 'Nanum Pen Script', cursive;
	font-weight: bold;
	font-size: 20px;
}

input[type=text]{
	font-family: 'Nanum Pen Script', cursive;
	font-size: 15px;
}

#bt_create{
	background-color: #4A4A4A;
	color: white;
	display: block;	
	margin: auto;
	margin-top: 10px;
	width: 100%;
	border: none;
	box-shadow: 0px 0px 0px 0px #21825B;
}
#bt_create:hover {
  box-shadow: 0px 0px 0px 5px #21825B;
}

#bt_list{
	background-color: #4A4A4A;
	color: white;
	display: block;	
	margin: auto;
	margin-top: 10px;
	width: 100%;
	border: none;
	box-shadow: 0px 0px 0px 0px #21825B;
}
#bt_list:hover {
  box-shadow: 0px 0px 0px 5px #21825B;
}


#photo2{
	visibility: hidden;
}

</style>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">

	function regist() {
		//동기 방식으로의 전송
		$("form").attr({
			action: "/challenges/regist",
			method: "post",
			//enctype: "multipart/form-data"
		});
		$("form").submit();
	}

	$(document).on('click', '#bt_create', function(e){
		e.preventDefault();
		
		if(document.getElementById("photo").files.length==0){
			console.log("no files selected");
			alert("썸네일을 첨부해주세요");
		}else{
			regist();
			
		}
		
	});


	$(document).on('click', '#bt_list', function(e){

		e.preventDefault();

		location.href="/challenges/main";

	});
	
	$(function(){
		$('#content').summernote();
		
	});

</script>

</head>

<body>

	<!-- Navbar -->
		
	<!-- /.navbar -->

	<article>

		<div class="container" role="main">

			<h2 class="text-center" id="header"> Make a Challenge </h2>

			<form name="form" id="form" role="form" method="post">

				<div class="mb-3">
					<label for="title">🚩title.</label>
					<input type="text" class="form-control" name="title" id="title" placeholder="챌린지 제목">
				</div>

				<div class="mb-3">
					<label for="writer">✏️writer.</label>
					<input type="text" class="form-control" name="writer" id="writer" value="<%=member.getName()%>" readonly>
				</div>
				
				<div class="mb-3">
					<label for="writer">⏰period.</label>
					<input type="text" class="form-control" name="period" id="period" placeholder="00일">
				</div>

				<div class="mb-3">
					<label for="content">⛹️‍♀️content.</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="챌린지 내용" ></textarea>
				</div>

				<div class="mb-3">
					<label for="file">📸image.</label>
					<input type="file" class="form-control" name="filename" id="photo">
					<br>
				</div>

			</form>

			<div id=bt_wrapper>

				<button type="button" class="btn btn-sm btn-primary" id="bt_create">c r e a t e</button>

				<button type="button" class="btn btn-sm btn-primary" id="bt_list">l i s t</button>

			</div>

		</div>

	</article>

</body>

</html>