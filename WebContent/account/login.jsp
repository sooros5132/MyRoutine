<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    
    <link rel="stylesheet" href="/css/user/reset.css">
    <link rel="stylesheet" href="/css/user/common.css">
    <link rel="stylesheet" href="/css/user/account/accounts.css">
    <link rel="stylesheet" href="/css/user/svg.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/user/header.jsp" />
	<div style="min-height: 1000px; padding: 150px 0; background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);">
		<c:choose>
            <c:when test="${sessionScope.memberId == null || sessionScope.memberId == ''}">
				<jsp:include page="/WEB-INF/jsp/user/account/login.jsp" />
			</c:when>
			<c:otherwise>
		<div class="">
			<div class="account-inner">
				<svg class="svg-check-container active" width="30" height="15" xmlns="http://w3.org/2000/svg" version="1.1" viewBox="0 0 16 16">
					<!-- <path fill="rgb(214,24,24)"xmlns="http://www.w3.org/2000/svg" d="M 15.99 14.54C 15.99 14.54 14.54 15.99 14.54 15.99 14.54 15.99 8 9.45 8 9.45 8 9.45 1.46 15.99 1.46 15.99 1.46 15.99 0.01 14.54 0.01 14.54 0.01 14.54 6.55 8 6.55 8 6.55 8 0.01 1.46 0.01 1.46 0.01 1.46 1.46 0.01 1.46 0.01 1.46 0.01 8 6.55 8 6.55 8 6.55 14.54 0.01 14.54 0.01 14.54 0.01 15.99 1.46 15.99 1.46 15.99 1.46 9.45 8 9.45 8 9.45 8 15.99 14.54 15.99 14.54Z" /> -->
					<path fill="rgb(214,24,24)" xmlns="http://www.w3.org/2000/svg" d="M15.988,14.543l-1.445,1.445L0.012,1.457,1.457,0.012ZM14.543,0.012l1.445,1.445L1.457,15.988,0.012,14.543Z"/>
				</svg>
				<div>이미 로그인이 되어있습니다.</div>
			</div>
		</div>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp" />
	<jsp:include page="/WEB-INF/jsp/user/footer.jsp" />
</body>
</html>