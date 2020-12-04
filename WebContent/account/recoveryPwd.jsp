<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>
    
    <link rel="stylesheet" href="/css/user/reset.css">
    <link rel="stylesheet" href="/css/user/common.css">
    <link rel="stylesheet" href="/css/user/account/accounts.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/user/header.jsp" />
	<div style="min-height: 1000px; padding: 150px 0; background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);">
		<jsp:include page="/WEB-INF/jsp/user/account/recoveryPwd.jsp" />
	</div>
	<jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp" />
	<jsp:include page="/WEB-INF/jsp/user/footer.jsp" />
</body>
</html>