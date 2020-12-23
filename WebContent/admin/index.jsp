<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>

    <!-- 
        공통 파일입니다. (경로 다 달라서 재설정 해야합니다.)
        (로고이미지도 경로 수정해야합니다.)
    -->

    <!-- 공통CSS -->
    <link rel="stylesheet" href="../css/admin/reset.css">
    <link rel="stylesheet" href="../css/admin/common.css">
    <link rel="stylesheet" href="../css/xeicon.min.css">
    
    <!-- 공통JS -->
    <script src="../../js/admin_common.js"></script>
    
    <!-- 개별JS -->
    <script src="../../js/admin_common.js"></script>
 
</head>
<body>
    <div class="wrapper">
    	<jsp:include page="/WEB-INF/jsp/admin/header.jsp"></jsp:include>
       

        <div class="body">
            <!-- aside -->
            <!-- <aside class="aside">
                <nav class="snb"> -->
                    <!-- <h2>서브메뉴</h2> -->
                    <!-- <ul class="dep1">
                        <!-- 하위 메뉴가 있으면 li태그에 data-type:true 넣어주세요 -->
                        <!-- <li data-type="true">
                            <a href="#">재활관리<i class="xi-angle-right-min"></i></a>
                            <ul class="dep2">
                                <li><a href="https:\\www.naver.com">재활 보기</a></li>
                                <li><a href="https:\\www.naver.com">재활 등록</a></li>
                            </ul>
                        </li>
                        <li><a href="https:\\www.naver.com">재활관리2</a></li>
                        <li><a href="https:\\www.naver.com">재활관리2</a></li>
                        <li><a href="https:\\www.naver.com">재활관리2</a></li>
                    </ul>
                </nav>
            </aside> -->
         
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main main-page">
                <section class="info-box">
                    <ul>
                        <li>
                            <a href="/admin/exercise/list">
                                <span class="count">${exerciseCount}</span>
                                총 운동수
                            </a>
                        </li>
                        <li>
                            <a href="/admin/member/list">
                                <span class="count">${memberCount}</span>
                                총 회원수
                            </a>
                        </li>
                        <li>
                            <a href="/admin/community/list">
                                <span class="count">${communityCount}</span>
                                총 커뮤니티
                            </a>
                        </li>
                        <li>
                            <a href="/admin/notice/list">
                                <span class="count">${noticeCount}</span>
                                총 공지사항
                            </a>
                        </li>
                        <li>
                            <a href="/admin/complain/list">
                                <span class="count">${complainCount}</span>
                                총 건의사항
                            </a>
                        </li>
                    </ul>
                </section>
                <section class="notice-box">
                    <h2 class="main-tit">커뮤니티<a href="#" class="more">더보기<i class="xi-angle-right-min"></i></a></h2>
                    <ul>
						<c:forEach var="community" items="${communityList}">  
                        <li>
                            <a href="/admin/community/detail?id=${community.id}">
                                <span class="notice-tit">${community.title}</span>
                                <span class="notice-date">${community.regdate}</span>
                            </a>
                        </li>
						</c:forEach>
                    </ul>
                </section>
                <section class="notice-box">
                    <h2 class="main-tit">공지사항<a href="#" class="more">더보기<i class="xi-angle-right-min"></i></a></h2>
                    <ul>
						<c:forEach var="notice" items="${noticeList}">  
                        <li>
                            <a href="/admin/notice/detail?id=${notice.id}">
                                <span class="notice-tit">${notice.title}</span>
                                <span class="notice-date">${notice.regdate}</span>
                            </a>
                        </li>
						</c:forEach>
                    </ul>
                </section>
            </main>
        </div>

        <!-- footer -->
        <footer class="footer">
            <span>ⓒ 마이 루틴</span>
        </footer>
        <!-- //footer -->
    </div>
    <style>
        .main-page {display:flex; flex:1; flex-wrap: wrap; }
        .main-page section {width:100%; border-radius:10px; box-shadow: 2px 2px 7px rgba(0,0,0,0.1);}
        .main-page .info-box {}
       
        
        .main-page .main-tit {font-size:19px; margin-bottom:18px; font-weight:700; color:#30baa1;}

        .main-page section {padding:20px; margin-bottom:40px;}
        .main-page section.info-box {padding:30px; background:#D4F0EB;}
        .info-box ul {display:flex; justify-content:space-between;}
        .info-box ul li {width:150px; text-align:center;}
        .info-box ul li a {font-weight:700; color:#5d5d5d;}
        .info-box ul li a .count {display:block; width:150px; height:100px; line-height:100px; margin-bottom:10px; font-size:36px; color:#fff;  box-shadow: 1px 1px 7px rgba(0,0,0,0.1); border-radius:5px;}
        .info-box ul li:nth-of-type(1) a .count {background:#30baa1;}
        .info-box ul li:nth-of-type(2) a .count {background:#30b1ba;}
        .info-box ul li:nth-of-type(3) a .count {background:#3078ba;}
        .info-box ul li:nth-of-type(4) a .count {background:#3058ba;}
        .info-box ul li:nth-of-type(5) a .count {background:#FFA17A;}

        .main-page .notice-box {width:calc(50% - 15px); margin-right:30px; margin-bottom:20px; border:1px solid #ddd; border-top:3px solid #30baa1; font-size:16px; background:#fff;}
        .main-page .notice-box:last-child {margin-right:0px;}
        .notice-box .main-tit {position:relative; }
        .notice-box .main-tit .more {position:absolute; top:50%; transform:translateY(-50%);  right:0; font-size:13px; color:#a0a0a0;}
        .notice-box .main-tit .more > i {vertical-align:middle; margin-top:-2px;} 
        .notice-box ul li {margin-bottom:12px;}
        .notice-box ul li a {display:flex;}
        .notice-box ul li .notice-tit {display:block; width:calc(100% - 90px); margin-right:10px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;} 
        .notice-box ul li .notice-date {display:block; width:80px; font-size:15px; text-align:right;}
    </style>
</body>
</html>