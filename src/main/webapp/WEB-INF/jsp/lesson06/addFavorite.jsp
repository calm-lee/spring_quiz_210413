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
		<b>이름: </b><input type="text" name="name" id="name" class="form-control col-12" placeholder="이름을 입력하세요."><br>
		<b>주소: </b><input type="text" name="url" id="url" class="form-control col-12" placeholder="url을 입력하세요."><br>
		<p>
				<input type="submit" class="btn btn-info form-control col-12" id="addBtn" value="추가">
		</p>
	</div>
	<script>
	$(document).ready(function(){
		$('#addBtn').on('click',function(e){
			//e.preventDefault();
			
			let name = $('input[name=name]').val().trim();
			if(name == ''){
				alert("제목을 입력해주세요.");
				return;
			}
			
			let url = $('input[name=url]').val().trim();
			if(url == ''){
				alert("url을 입력해주세요.");
				return;
			} else if((url.indexOf('http')) == false){
				alert("http(s)를 입력해주세요.");
				return;
			}
			
			$.ajax({
				type: 'POST'
				, url: '/lesson06/after_add'
				, data: {'name' : name, 'url': url}
			    , success: function(data){
			    	alert(data);
			    	location.href="/lesson06/after_add"
			    }, complete: function(data){
			    	alert("완료");
			    }, error: function(e){
			    	alert("error: " + e);
			    }
			    
			});
			
		});
	});
	</script>
</body>
</html>