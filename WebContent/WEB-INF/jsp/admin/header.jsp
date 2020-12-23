<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header -->
<header class="header">
    <h1 class="logo"><a href="/admin"><img src="../../image/common/logo.png" alt="마이루틴"></a></h1>
    <nav class="gnb">
        <ul>
            <li><a href="/admin/exercise/list" class="exercise-menu"><i class="xi-calendar-list"></i>운동 관리</a></li>
            <li><a href="/admin/member/list" class="member-menu"><i class="xi-group"></i>회원 관리</a></li>
            <li><a href="/admin/community/list" class="community-menu"><i class="xi-forum"></i>커뮤니티 관리</a></li>
            <li><a href="/admin/notice/list" class="notice-menu"><i class="xi-comment"></i>공지사항 관리</a></li>
            <li><a href="/admin/complain/list" class="complain-menu"><i class="xi-presentation"></i>건의사항 관리</a></li>
        </ul>
    </nav> 
    
    <div class="header-util">
    	<c:choose>
            <c:when test="${sessionScope.memberId == null || sessionScope.memberId == ''}">
		        <a class="login-btn" href="/account/login">로그인</a>
			</c:when>
			<c:otherwise>
		        <span class="admin">${sessionScope.nickname}</span>
		        <a class="logout-btn" href="/account/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
    </div>
</header>
<!-- //header -->
<jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp"></jsp:include>