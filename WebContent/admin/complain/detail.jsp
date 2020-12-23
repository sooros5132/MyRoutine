<%@page import="com.myroutine.web.service.CommunityService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <link rel="stylesheet" href="../../css/admin/community/edit-style.css">

    <script src="../../js/admin_common.js"></script>
    <script src="../../js/admin/complain/detail.js"></script>    
</head>
<body>
    <div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/admin/header.jsp"></jsp:include>
        <div class="body">
            <!-- aside -->
			<jsp:include page="../complainAside.jsp"></jsp:include>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                <section>
<!--                     <div > -->
<%--                     	<h2 class="con-tit">${m.title}</h2> --%>
<!--                     </div> -->
<!--                     <textarea class="textarea" readonly> -->
<%--                        ${m.contents}   --%>
<!--                     </textarea> -->
					<div class="title-div">
	              		<h2 class="title">건의사항 상세</h2>
	              		<input class="report report-btn" type="button" value="신고">
	              		 <input type="hidden" class="member_id" name="memberId" value="22">
              		</div> 
                    <table class="admin-from-table">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td >${m.title}</td>
                                <th>작성일</th>
                                <td >
                                 	<fmt:formatDate value="${m.regdate}" pattern="yyyy-MM-dd a hh:mm:ss"/> 
<!--                                 HH	대문자는 24시간 -->
                                </td>
                            </tr>
                            <tr>
                            </tr>
                            <tr>
                                <th>게시판 종류</th>
                                <td  >${m.categoryType} </td>
                                <th>작성자</th>
                                 	<td>${m.writerName}
                                 	<input type="hidden" value="${m.writerId}">
                                 	</td> 
<!--                                 <th>조회수</th> -->
<%--                                 <td>${m.hit}</td> --%>
                           </tr> 
                            <tr>
                            </tr>
                            <tr>
                                <th>첨부파일</th>
                                <td colspan="3" >
                                	<c:forTokens var="fileName" items="${m.files}" delims="," varStatus="st">
                            			<fmt:formatDate var="year" value="${m.regdate}" pattern="yyyy" />
                                		<a download="${fileName}" href="${m.filePath}${fileName}">${fileName}</a>
<%--                                 		<a download href="/static/community/${year}/${m.id}/${fileName}"> ${fileName} </a> --%>
                                		<c:if test="${st.last != true}">
                                			/
                                		</c:if>                      		
                                	</c:forTokens>
                                	
                                </td>
                            </tr>
                            <tr class="content" height="300">
                                <td colspan="4">${m.contents}</td>
                            </tr>
                        </tbody>
                    </table>
                </section>
<!--       
<!--                     	<input  type="button" value="댓글추가테스트" class="test-btn"> -->
                    <div class="list_view">
                        <button class="list_btn myButton"><a  href="list">목록</a></button>
                    	<button class="list_btn myButton"><a  href="edit?id=${m.id}">수정</a></button>
                    </div>
                </section>          
            </main>
            
<!--     =============== =============== =============== =============== =============== =============== ================= -->
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