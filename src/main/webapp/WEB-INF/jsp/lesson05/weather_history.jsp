<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청</title>
	
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
		<ul class="nav align-items-center mt-5">
			<li class="nav-item align-items-center w-100 ml-2"><a href="#" class="menu-font">날씨</a></li>
			<li class="nav-item align-items-center w-100 mt-3 ml-2"><a href="/lesson05/add_weather" class="menu-font">날씨입력</a></li>
			<li class="nav-item align-items-center  w-100 mt-3 ml-2"><a href="#" class="menu-font">테마날씨</a></li>
			<li class="nav-item align-items-center  w-100 mt-3 ml-2"><a href="#" class="menu-font">관측기후</a></li>
		</ul>
		</section>
		<section id="content" class="ml-3">
			<h2 class="mt-3">과거 날씨</h2>
			<table class="table text-center mt-2">
				<thead>
					<th><b>날짜</b></th>
					<th><b>날씨</b></th>
					<th><b>기온</b></th>
					<th><b>강수량</b></th>
					<th><b>미세먼지</b></th>
					<th><b>풍속</b></th>
				</thead>
				<tbody>
					<c:forEach var="weather" items="${weather}">
						<tr>
							<td><fmt:parseDate value="${weather.date}" pattern="yyyy-MM-dd" var="date" />
								<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일" var="date2"/>
							${date2}</td>
							<td>
							<c:if test="${weather.weather eq '맑음'}">
							<img src="/images/sunny.jpg" alt="맑음">
							</c:if>
							<c:if test="${weather.weather eq '비'}">
							<img src="/images/rainy.jpg" alt="비">
							</c:if>
							<c:if test="${weather.weather eq '흐림'}">
							<img src="/images/cloudy.jpg" alt="흐림">
							</c:if>
							<c:if test="${weather.weather eq '구름조금'}">
							<img src="/images/partlyCloudy.jpg" alt="구름조금">
							</c:if>
							</td>
							<td>${weather.temperatures}℃</td>
							<td>${weather.precipitation}mm</td>
							<td>${weather.microDust}</td>
							<td>${weather.windSpeed}km/h</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</section>
	<footer>
		
	</footer>
</div>


</body>
</html>