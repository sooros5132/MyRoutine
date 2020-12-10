<%@page import="com.myroutine.web.entity.admin.notice.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.myroutine.web.service.admin.notice.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">
    <link rel="stylesheet" href="../../css/admin/notice/list.css">

    <script src="../../js/admin_common.js"></script>
    <script src="../../js/admin/notice/notice.js"></script>
</head>
<body>
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <h1 class="logo"><a href="#"><img src="../../image/common/logo.png" alt="마이루틴"></a></h1>
            <nav class="gnb">
                <ul>
                    <li><a href="#"><i class="xi-calendar-list"></i>운동 관리</a></li>
                    <li><a href="#"><i class="xi-group"></i>회원 관리</a></li>
                    <li><a href="#"><i class="xi-forum"></i>커뮤니티 관리</a></li>
                    <li><a href="#"class="active"><i class="xi-comment"></i>공지사항 관리</a></li>
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
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main id="notice"class="main">
                <h1>공지사항 목록</h1>
                <table class="notice-list">
                    <colgroup>
                      <col style="width: 50px;">
                      <col style="width: 100px;">
                      <col style="width: 100px;">
                      <col style="width: auto;">
                      <col style="width: 100px;">
                      <col style="width: 100px;">
                      <col style="width: 100px;">
                      <col style="width: 120px;">
                    </colgroup>

                  
                   <thead>
                    <tr>
                       <th><input class="overall-checkbox" type="checkbox"></th>
                        <th>번호</th>
                        <th>작성자</th>
                        <th>글 제목</th>
                        <th>조회수</th>
                        <th>공개여부</th>
                        <th>등록일</th>
                        <th>게시물관리</th>
                        
                    </tr>
                </thead>
                <tbody>
                  <c:forEach var="n" items="${list}" >
                    <tr>
                       <td><input type="checkbox"></td>
                        <td>${n.id}</td>
                        <td>${n.writer_id}</td>
                        <td><a href="detail?id=${n.id}"> ${n.title} </a></td>
                        <td>${n.hits}</td>
                        <td>${n.open}</td>
                        
                        <td>${n.regdate }</td>
                        <td>
                            <input  type="button" value="글수정">
                            <input type="button" class="del-button"
                            value="글삭제">
                        </td>
                          
                    </tr>
                    </c:forEach>
                 
                    
                   
                    
                     <tr class="del-all">
                       <td colspan="8">
                            <input type="button" class="del-button-all" value="일괄삭제">
    
                       </td>
                       
                   </tr>
                </tbody>
                </table>

                     <div class="write-box">
                         <a href="../notice/reg.jsp">글쓰기</a>
                     </div>

                     <div class="number-list" style="text-align:center;">
                         <ul>
                             <c:forEach begin="0" end="4" varStatus="st">
                             <li style="display:inline-block;"> <a href ="" class="number">${st.count}</a></li>
                             </c:forEach>
                             
                         </ul>
                       
                    </div>


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