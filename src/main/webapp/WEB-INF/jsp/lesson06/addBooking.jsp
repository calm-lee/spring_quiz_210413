<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<link rel="stylesheet" type="text/css" href="/css/booking.css">
</head>
<body>
	<div class="container">
		<header
			class="bg-light d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 팬션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">팬션소개</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">예약안내</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section>
			<h3 class="text-center mt-3">예약하기</h3>
			<b>이름</b> <input type="text" id="name" class="form-control">
			<b>예약날짜</b> <input type="text" id="date" class="form-control">
			<b>숙박일수</b> <input type="text" id="day" class="form-control">
			<b>숙박인원</b> <input type="text" id="headCount" class="form-control">
			<b>전화번호</b> <input type="text" id="phoneNumber" class="form-control">
			<input type="submit" class="btn btn-warning form-control mt-2"
				value="예약하기" id="addBtn">
		</section>

		<script>
			$(document).ready(function() {
				
				$('#date').datepicker({
	                changeMonth: true // 월 선택
	                , changeYear: true // 년 선택
	                , dateFormat: 'yy-mm-dd' // 표시 형식
	                , showAnim: 'fadeIn' // 다른 효과 : slide, clip	           
				}); 
				

				$('#addBtn').on('click', function() {

					let name = $('#name').val().trim();
					let date = $('#date').val().trim();
					
					let day = $('#day').val().trim();
					let headCount = $('#headCount').val().trim();
					let phoneNumber = $('#phoneNumber').val().trim();

					if (name == '') {
						alert("이름을 입력해주세요.");
						return;
					}
					if (date == '') {
						alert("날짜를 입력해주세요.");
						return;
					}
					if (day == '') {
						alert("숙박일수를 입력해주세요.");
						return;
					}
					
					if (headCount == '') {
						alert("숙박인원를 입력해주세요.");
						return;
					}
					
					if (phoneNumber == '') {
						alert("전화번호를 입력해주세요.");
						return;
					}

					$.ajax({

						type : 'post',
						data : {
							'name' : name,
							'date' : date,
							'day' : day,
							'headCount' : headCount,
							'phoneNumber' : phoneNumber
						},
						url : "/lesson06/add_reservation",
						success : function(data) {
							alert(data.result);
						},
						error : function(e) {
							alert("예약에 실패했습니다.")
						}

					});

				});
			});
		</script>
</body>
</html>