<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드명세서</title>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

      <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        	
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	
	<h1>2. 카드명세서</h1>
	<table class="table text-center">
		<thead>
			<th><b>사용처</b></th>
			<th><b>가격</b></th>
			<th><b>사용 날짜</b></th>
			<th><b>할부</b></th>
		</thead>
		<tbody>
			<c:forEach var="cardBill" items="${cardBill}">
				<tr>
					<td>${cardBill.store}</td>
					<td><fmt:formatNumber value="${cardBill.pay}" type="currency" /></td>
					<td>
					<fmt:parseDate value="${cardBill.date}" pattern="yyyy-MM-dd" var="pattern" />
					<fmt:formatDate value="${pattern}" pattern="yyyy년 M월 dd일" var="date" />${date}</td>
					<td>${cardBill.installment}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>