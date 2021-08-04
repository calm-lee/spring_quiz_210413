<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</head>
<body>
	<div class="container">
	<h1>즐겨찾기 추가하기</h1>
		<b>제목: </b><input type="text" name="name" id="name" class="form-control col-12" placeholder="이름을 입력하세요."><br>

		<b>주소: </b>
		<div class="form-inline">
			<input type="text" name="url" id="url" class="form-control col-11" placeholder="url을 입력하세요.">
			<button type="button" id="checkBtn" class="btn-info form-control col-1">중복확인</button>
		</div>

		<small id="isDuplicatedText" class="text-danger d-none">중복된 url입니다</small>
		<small id="isAvailableText" class="text-primary d-none">사용가능한 url입니다</small>
		
<!-- 			<div id="statusArea"></div><br> -->
		<br>
		<br>
		<p>
			<button type="button" class="btn-success btn-block form-control col-12" id="addBtn">추가</button>
		</p>
	</div>
	<script>
	$(document).ready(function(){
		
		
		$('#addBtn').on('click',function(){
			//e.preventDefault();
			
			let name = $('input[name=name]').val().trim();			
			let url = $('input[name=url]').val().trim();
			
			
			if(name == ''){
				alert("제목을 입력해주세요.");
				return;
			}
		
			if(( url.startsWith("http")  || url.startsWith("https") ) == false){
				alert("주소형식이 잘못되었습니다.");
				return;
			}
			
			
			$.ajax({
				type: 'POST' //REQUEST METHOD
				, url: '/lesson06/after_add' // Request를 보낼 주소
				, data: {'name' : name, 'url': url} //'key' : value
				, dataType: 'json' // response body  -  AJAX 통신 후 response로는 String 또는 JSON이 리턴되어야 한다.
			    , success: function(data){ // 결과가 성공했을 때의 정의
			    	alert(data.result);
			    	location.href="/lesson06/favorite_list"
			    }, complete: function(data){
			    	alert("완료");
			    }, error: function(e){ // 에러일 때 
			    	alert("error: " + e);
			    }
			    
			});
			
		});
		
		
		//중복확인 버튼
		$('#checkBtn').on('click', function(){
			
			let url = $('#url').val().trim();
			if(url == ''){
				alert("검사할 url을 입력해주세요.");
				return;
			}
			
			// AJAX로 DB에 있는지 확인
			$.ajax({
				type : 'post'
				, url: '/lesson06/is_duplication'
				, data: {'url':url}
				, success: function(data){
					if(data.isDuplication == true){
						$('#isDuplicatedText').removeClass('d-none');
						$('#isAvailableText').addClass('d-none');
						return;
					} else {
						$('#isDuplicatedText').addClass('d-none');
						$('#isAvailableText').removeClass('d-none');
						return;
					}
				}
				, error: function(e){
					alert("error: " + e);
				}
			});			
		});
		
	});
	</script>
</body>
</html>