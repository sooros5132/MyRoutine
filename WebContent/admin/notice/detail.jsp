
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">
    <link rel="stylesheet" href="../../css/admin/notice/detail.css">

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
            <main id="notice" class="main">
                <h1>공지사항</h1>
                <table class="notice-list">
                    <colgroup>
                        <col style="width: 200px;">
                        <col style="width: 550px;">
                        <col style="width: 200px;">
                        <col style="width: auto;">

                    </colgroup>


                    <thead>

                    </thead>
                    <tbody>
                        <tr>
                            <td>제목</td>
                            <td colspan="3">${n.title}</td>
                        </tr>

                        <tr>
                            <td>등록일</td>
                            <td colspan="3">
                              <fmt:formatDate value="${n.regdate}" pattern="yyyy-MM-dd a hh:mm:ss"/>
                            </td>
                        </tr>
                        <tr>
                            <td>첨부파일</td>
                            
                            <td><c:forTokens var="fileName" items="${n.files}" delims=","  varStatus="st">
                                <fmt:formatDate var="year" value="${n.regdate}" pattern="yyyy" />
                                  <a download href="/static/notice/${year}/${n.id}/${fileName}"> ${fileName} </a> 
                                  <c:if test = "${st.last ==false }"> /
                                  </c:if>
                                  
                             </c:forTokens>  </td>
                            
                            <td>작성자</td>
                            <td>${n.writer_id}</td>
                        </tr>
                        <tr>
                            <td>조회수</td>
                            <td colspan="3">${n.hits}</td>
                        </tr>

                    </tbody>
                </table>

                <section class="detail_text">
                    <textarea name="" id="" cols="30" rows="10">

                    </textarea>
                </section>


                <section class="list-box">
                    <a href="list.jsp">목록</a>
                </section>


                <section class="next-list">
                    <table>
                        <colgroup>
                            <col style="width:200px">
                            <col style="width:auto">
                            <col style="width:200px">
                        </colgroup>

                        <tr>
                            <td>이전글</td>
                            <td>운영</td>
                            <td>2020-11-15</td>
                        </tr>
                        <tr>
                            <td>다음글</td>
                            <td>공지사항입니다</td>
                            <td>2020-11-16</td>
                        </tr>

                    </table>

                </section>





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