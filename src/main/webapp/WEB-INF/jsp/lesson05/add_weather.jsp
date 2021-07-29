<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
	
	<link rel="stylesheet" type="text/css" href="/css/text_style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
<div class="container">
	<section class="container d-flex">
		<section id="aside">
		<div class="logo mt-3 text-center"><h3>기상청</h3></div>
		<ul class="nav flex-column mt-5">
			<li class="nav-item align-items-center w-100 ml-2"><a href="#" class="menu-font">날씨</a></li>
			<li class="nav-item align-items-center w-100 mt-3 ml-2"><a href="/lesson05/quiz04/add_weather" class="menu-font">날씨입력</a></li>
			<li class="nav-item align-items-center  w-100 mt-3 ml-2"><a href="#" class="menu-font">테마날씨</a></li>
			<li class="nav-item align-items-center  w-100 mt-3 ml-2"><a href="#" class="menu-font">관측기후</a></li>
		</ul>
		</section>
		<section id="content" class="ml-3">
			<h2 class="mt-3">날씨 입력</h2>
				<form method="post" action="/lesson05/add_weather">
					<div>
					날짜
					<input type="text" class="form-control" id="date" name="date">
					<select class="form-control" name="weather">
						<option>맑음</option>
						<option>흐림</option>
						<option>비</option>
						<option>구름 조금</option>
					</select>
					<select class="form-control" name="microDust">
						<option>좋음</option>
						<option>보통</option>
						<option>나쁨</option>
						<option>최악</option>
					</select>
					기온<input type="text" name="temperatures">℃
					강수량<input type="text" name="precipitation">mm
					풍속<input type="text" name="windSpeed">km/h
					</div>
						<input type="submit" class="btn btn-success" value="저장">
				</form>
		</section>
	</section>
	<footer>
		
	</footer>
</div>
	<script>
		
	$(document).ready(function(){
			
			$('#date').datepicker({
				changeMonth: true
				, changeYear: true
				, dateFormat: 'yy-MM-dd'
			});
		});
		
	</script>
	
</body>
</html>