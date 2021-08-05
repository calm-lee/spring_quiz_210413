<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐찾 목록</title>
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

</head>
<body>
	<div class="container">
		<h1>목록</h1>
		<table class="table">
			<thead>
				<th><b>번호</b></th>
				<th><b>이름</b></th>
				<th><b>주소</b></th>
			</thead>
			<tbody>
				<c:forEach var="favorite" items="${favoriteList}">
					<tr>
						<td>${favorite.id}</td>
						<td>${favorite.name}</td>
						<td>${favorite.url}</td>
						<!-- 				<td><button type="button" name="delBtn" class="favorite-btn btn btn-danger">삭제</button></td>
 -->
						<td><button type="button" name="delBtn"
								class="favorite-btn btn btn-danger"
								data-favorite-id="${favorite.id}">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>
		$(document).ready(function() {

			/* 		(1) name 속성과 value 속성을 이용해서 동적으로 삭제버튼 감지
			 $('td').on('click',  'button[name=delBtn]', function(){
			 // id..
			 let id = $(this).attr('value'); // 여기서 this는 여러 td 중 클릭이 된 td
			 });
			 }); */

			//(2) data를 이용해서 태그에 data를 임시저장해놓기
			$('.favorite-btn').on('click', function() {
				let favoriteId = $(this).data('favorite-id');
				alert(favoriteId);

				$.ajax({
					type : 'post',
					data : {
						'favorite_id' : favoriteId
					},
					url : '/lesson06/delete_favorite',
					success : function(data) {
						location.reload(); // 새로고침
					},
					error : function(e) {
						alert("error: " + e);
					}
				});

			});

		});
	</script>

</body>
</html>