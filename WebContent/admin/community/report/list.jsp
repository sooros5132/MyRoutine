<%@page import="com.myroutine.web.service.ComplainService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">
    <link rel="stylesheet" href="../../css/admin/sub.css">    
    <link rel="stylesheet" href="../../../css/list-style.css">
    <script src="../../../common/js/admin_common.js"></script>
</head>
<body>
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <h1 class="logo"><a href="#"><img src="../../common/images/common/logo.png" alt="마이루틴"></a></h1>
            <nav class="gnb">
                <ul>
                    <li><a href="#"><i class="xi-calendar-list"></i>운동 관리</a></li>
                    <li><a href="#"><i class="xi-group"></i>회원 관리</a></li>
                    <li><a href="#" class="active"><i class="xi-forum"></i>건의사항 관리</a></li>
                    <li><a href="#"><i class="xi-comment"></i>공지사항 관리</a></li>
                </ul>
            </nav> 
            
            <div class="header-util">
                <span class="admin">황병준님</span>
                <a class="logout-btn" href="#">로그아웃</a>
            </div>
        </header>
        <!-- //header -->
       

        <div class="body">
            <!-- aside -->
            <aside class="aside">
                <nav class="snb">
                    <!-- <h2>서브메뉴</h2> -->
                    <ul class="dep1">
                        <!-- 하위 메뉴가 있으면 li태그에 data-type:true 넣어주세요 -->
                       <li data-type="true">
                            <a href="#">커뮤니티 관리</a>
                            <ul class="dep2">
                                <li><a href="../community/list">커뮤니티 리스트</a></li>
                                <li><a href="../community/reg">커뮤니티 등록</a></li>
                            </ul>
                        </li>
                        <li data-type="true">
                            <a href="#">건의사항 관리</a>
                            <ul class="dep2">
                                <li><a href="../complain/list">건의사항 리스트</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                <section class="title_section">
                    <div class="list_title">
                        <h1>신고사항 리스트</h1>
                    </div>
                    <table>
                        <colgroup>
                            <col style="width:100px">
                            <col style="width: auto;">
                            <col style="width: 150px">
                            <col style="width: 100px">
                        </colgroup>
                        <thead>
                            <tr>
                                <th>작성자</th>
                                <th>내용</th>
                                <th>날짜</th>
                            </tr>
                        </thead>
                        <tbody> 
                        <c:forEach items="${list}" var="n" >
                            <tr>
                                <td>${n.nickname}</td>
                                <td>${n.contents}</td>
                                <td>${n.regdate}</td>
                            </tr> 
						</c:forEach>                            
                        </tbody>
                    </table>
                </section>
<!--                 <div class="btn-box"> -->
<!--                     <div></div> -->
<!--                     <div> -->
<!--                         <button class="btn"><a href="complain-edit.html">글쓰기</a></button> -->
<!--                     </div> -->
<!--                 </div>             -->
            </main>
            <!-- //main(개별 컨턴츠 넣는곳) -->
        </div>

        <!-- footer -->
        <footer class="footer">
            <span>ⓒ 마이 루틴</span>
        </footer>
        <!-- //footer -->
    </div>
</body>
</html>