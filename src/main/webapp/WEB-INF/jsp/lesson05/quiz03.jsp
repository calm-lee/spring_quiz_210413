<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 리스트</title>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

      <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        	
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<!-- 국적의 삼국시대 를 삼국 - 형태로 변경하세요. // substring

이메일 주소의 id 부분을 굵게 표시하세요. //split @
전화번호가 010 으로 시작하지 않으면 유효하지 않은 전화번호 라고 표시하세요. //c:if & startsWith
자기소개의 내용을 15자까지 표시하세요. //substring
자기소개가 15자가 넘어 갈경우 뒤에 ... 을 표시하세요. // c:if + length
--> 


<div class="container">
<h1>회원 정보 리스트</h1>
	<table class="table text-center">
		<thead>
			<th><b>No</b></th>
			<th><b>이름</b></th>
			<th><b>전화 번호</b></th>
			<th><b>국적</b></th>
			<th><b>이메일</b></th>
			<th><b>자기소개</b></th>
		</thead>
		<tbody>
		
		<c:forEach var="member" items="${members}" varStatus="status">
		
			
			<tr>
			
				<td>${status.count}</td>
				
				<td>${member.name}</td>
				
				<td>
					<c:choose>
						<c:when test="${fn:startsWith(member.phoneNumber,'010')}">
							${member.phoneNumber}
						</c:when>
						<c:otherwise>
							유효하지 않은 전화번호
						</c:otherwise>
					</c:choose>
				</td>
				
				<td>${fn:replace(member.nationality,'시대',' - ')}</td>
				
				<td>
					<b>${fn:split(member.email,'@')[0]}</b>
						@${fn:split(member.email,'@')[1]}
				</td>
				
				<td class="text-left">
					<c:choose>
						<c:when test="${fn:length(member.introduce) > 15}">
							${fn:substring(member.introduce, 0, 16)}
							...
						</c:when>
						<c:otherwise>
							${member.introduce}
						</c:otherwise>
					</c:choose>		
				</td>
				
			</tr>
			
		</c:forEach>
		
		</tbody>
	</table>
</div>

</body>
</html>