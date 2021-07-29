<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셀러 정보 추가</title>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

      <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        	
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>셀러 정보 추가</h1>
		
		<form method="post" action="/lesson06/ex01/add_new_user">
			
			<b>이름: </b>
			<input type="text" class="form-control col-3" name="name">
			<br>

			<b>생년월일: </b>
			<input type="text" class="form-control col-5" name="birth" placeholder="생년월일을 입력해주세요.">
			
			
			<b>이메일 주소: </b>
			<input type="text" class="form-control col-5" name="email" placeholder="이메일을 입력해주세요.">
			
			<b>자기소개: </b>
			<textarea class="form-control col-5" name="introduce" placeholder="이메일을 입력해주세요.">
			</textarea>
			
			<input type="submit" class="btn btn-control bg-info">			
		</form>
	</div>
	
</body>
</html>