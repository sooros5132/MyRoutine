<%@page import="com.myroutine.web.entity.admin.notice.Notice" %>
<%@page import="java.util.List" %>
<%@page import="com.myroutine.web.service.admin.notice.NoticeService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



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
                   <li><a href="#" class="active"><i class="xi-comment"></i>공지사항 관리</a></li>
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
                           <a href="#">공지사항<i class="xi-angle-right-min"></i></a>
                           <ul class="dep2">
                               <li><a href="list">공지 목록</a></li>
                               <li><a href="reg">공지 등록</a></li>
                           </ul>
                       </li>
                       <li><a href="#">커뮤니티<i class="xi-angle-right-min"></i></a></li>
                   </ul>
               </nav>
           </aside>
              <!-- //aside -->

          <!-- main(개별 컨턴츠 넣는곳) -->
    <main id="notice" class="main">
        <h1>공지사항 목록</h1>
        <section class="search-form">
            <h1 style="display: none;">강좌검색 폼</h1>
            <form action="">
                <fieldset>
                    <select class="option" name="f">
                        <option ${(param.f =="title")?"selected":"" } value="title">제목</option>
                        <option ${(param.f =="member_id")?"selected":"" } value="member_id">작성자</option>

                    </select>
                    <input style="text-align:left" type="text" name="q" value="${param.q}" />
                    <input type="submit" value="검색" />

      <!-- <datalist id="name">

      <option value="번호"></option>
      <option value="작성자"></option>
      <option value="제목"></option>
      
  </datalist> -->
                   </fieldset>
               </form>
           </section>

   <form action="list" method="post">
     
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
                 <c:forEach var="n" items="${list}">

                     <tr>
                         <td><input  type="checkbox" name="del-id" value="${n.id}"></td>
                         <td>${n.id}</td>
                         <td>${n.memberId}</td>
                         <td><a href="detail?id=${n.id}">${n.title}</a></td>
                         <td>${n.hit}</td>
                         <td>${n.openInfo}</td>

                         <td>${n.regdate}</td>
                         <td>

                             <input class="trigger-button" type="button" value="글수정"
                                 onClick="location.href='edit?id=${n.id}'">

                             <input type="submit" class="del-button" value="글삭제" 
                                 onClick=" confirm('삭제하시겠습니까?'), location.href='del?id=${n.id}'">
                         </td>

                     </tr>

                 </c:forEach>




                 <tr class="del-all">
                     <td colspan="8">
                         <input type="submit" class="del-button-all" value="일괄삭제"
                         onClick="confirm('삭제하시겠습니까?')" >

                     </td>

                 </tr>
             </tbody>
         </table>

      </form>

         <div class="write-box">
             <a href="../notice/reg">글쓰기</a>
         </div>



         <div class="number-list" style="text-align:center;">
             
             
             
            <c:set var="page" value="${(empty param.p)?1:param.p}" />
            <c:set var="startNum" value="${page -(page-1)%5}" />
            <c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10),'.')}" />
            
             
             <ul>
                 <li> 
                 
                 
                 <c:if test ="${startNum<=1}">
                    <span class="number prev" onclick="alert('이전페이지가 없습니다')" ><i class="xi-angle-left"></i></span>
                 </c:if>
                 
                 
                 </li>
                 <c:set var="page" value="${(empty param.p)?1:param.p }"/>
                 
                 <c:forEach var="i" begin="0" end="4" >
                 <c:if test="${(startNum+i)<=lastNum }">
                     <li style="display:inline-block;"> <a href="?p=${startNum+i}&f=${param.f}&q=${param.q}"
                             class=" ${(page==(startNum+i))?'number2':'' } number">${startNum+i}</a></li>
                 </c:if>
                 </c:forEach>
                
             
                 <li>
                  
                
                  <c:if test ="${startNum+4>= lastNum}">
                  <span  class="number next" onclick="alert('다음페이지가 없습니다')" ><i class="xi-angle-right"></i></span>
                  </c:if>
                  </li>
                   
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