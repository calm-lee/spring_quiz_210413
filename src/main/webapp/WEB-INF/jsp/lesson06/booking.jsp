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
			<h3 class="text-center mt-3">예약목록 보기</h3>
			<table class="table text-center mt-3">
				<thead>
					<th><b>이름</b></th>
					<th><b>예약날짜</b></th>
					<th><b>숙박일수</b></th>
					<th><b>숙박인원</b></th>
					<th><b>전화번호</b></th>
					<th><b>예약상태</b></th>
					<th><b></b></th>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${bookingList}">
						<tr>
							<td>${booking.name}</td>
							<td><fmt:formatDate value="${booking.date}"
									var="datePattern" pattern="yyyy년 M월 dd일" /> ${datePattern}</td>
							<td>${booking.day}</td>
							<td>${booking.headcount}</td>
							<td>${booking.phoneNumber}</td>
							<td>
							<c:choose>
								<c:when test="${booking.state eq '대기중'}">
									<span class=text-primary>${booking.state}</span>
								</c:when>
								<c:otherwise>
									<span class=text-success>${booking.state}</span>								
								</c:otherwise>
							</c:choose>
							</td>
							<td><button type="button" class="delete-btn btn btn-danger"
									data-delete-id="${booking.id}">삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		<footer>
			<div class="address m-3">
				제주특별자치도 제주시 애월읍<br> 사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 /
				대표:김통목<br> Copyright 2025 tongnamu. All right reserved.
			</div>
		</footer>
	</div>
</body>


<script>
	$(document).ready(function() {

		$('.delete-btn').on('click', function() {

			let deletedId = $(this).data('delete-id');

			$.ajax({
				type : 'delete',
				data : {
					'deleted_id' : deletedId
				},
				url : '/lesson06/delete_booking',
				success : function(data) {
					if(data.result == "success"){
						location.reload();
					} else{
						alert("삭제에 실패했습니다. 관리자에게 문의해주십시오.");
					}
				},
				error : function(e) {
					alert("error: " + e)
				}
			});

		});

	});
</script>
</html>