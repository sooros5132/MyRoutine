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
    <link rel="stylesheet" href="../../css/admin/community/list-style.css">
    
    <script src="../../js/admin_common.js"></script>
    <script src="../../js/admin/community/report.js"></script>
</head>
<body>
    <div class="wrapper">
        <jsp:include page="/WEB-INF/jsp/admin/header.jsp"></jsp:include>
       

        <div class="body">
            <!-- aside -->
 			<jsp:include page="../communityAside.jsp"></jsp:include>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                <section class="title_section">
                    <div class="list_title">
                        <h1>커뮤니티 신고사항 리스트</h1>
                        <button>전체삭제</button>
                    </div>
                    <table class="admin-from-table">
                        <colgroup>
                            <col style="width:150px">
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
                                <td>${n.contents} <button type="submit" class="cmt-del-btn report-btn" style="width:20px"> X </button></td>
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