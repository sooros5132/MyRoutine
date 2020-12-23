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



	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>    
    <script src="../../common/js/admin_common.js"></script>
    <script src="../../js/admin/community/edit.js"></script>
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
                    <li><a href="#" class="active"><i class="xi-forum"></i>커뮤니티 관리</a></li>
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
         		<form action="edit" method="post" enctype="multipart/form-data">
	                <section>
<!--                     <div > -->
<%--                     	<h2 class="con-tit">${m.title}</h2> --%>
<!--                     </div> -->
<!--                     <textarea class="textarea" readonly> -->
<%--                        ${m.contents}   --%>
<!--                     </textarea> -->
              			<h2 class="title">건의사항 수정</h2>
	                 	   <table class="admin-from-table">
	                   	     <tbody>
	                        	<tr>
	                                <th>제목</th>
	                                <td colspan="3"><input name=title value=" ${m.title}"></td>
	                            </tr>
	                            <tr>
	                                <th>작성일</th>
	                                <td colspan="3">
	                                 	<fmt:formatDate value="${m.regdate}" pattern="yyyy-MM-dd a hh:mm:ss"/> 
	<!--                                 HH	대문자는 24시간 -->
	                                </td>
	                            </tr>
                                <tr>
                                    <th>게시판 선택</th>
                                    <td  colspan="3">
                                        <select name = "categoryId" class ="select-box">
				                        	<c:forEach var="categroy" items="${cList}" >
				                        		<option
				                        		 	<c:if test="${categoryId==0}">disabled</c:if>
				                        			<c:if test="${categoryId==category.Id}">selected</c:if>	 
				                        		value ="${categroy.id}">${categroy.type} </option>
				                        	</c:forEach>
                                        </select>
                                   </td>
                                </tr>
	                            <tr>
	                                <th>작성자</th>
	                                <td>${m.writerName}
	                                	<input type="hidden" name="writerId" value="${m.writerId}">
	                                </td>
	                                <th>조회수</th>
	                                <td><input type="hidden" name="hit" value="${m.hit}">
	                                    ${m.hit}</td>
	                            </tr>
	                            <tr>
	                                <th>첨부파일</th>
	                                <td colspan="3" class="add-file">
			
	                                	<input type="file" class="attach-btn" name="file" />		                            
	                                	<input type="file" class="attach-btn" name="file" />
	                                	
	                                	<div class="file-div">
		                                	<c:forEach items="${fList}" var="f">
			                                	<div class="file_div_del">
			                                		<a class="file_a" download="${f.name}"  href="${f.route}${f.name}">${f.name}</a> 
			                                		<a type="hidden"  name="fileId">${f.id}</a>
			                                		<a class="file_a" href="">(X)</a> 			                                		  
			                                	</div>	                                	
		                                	</c:forEach>
		                                	<input class="old_file" type="hidden" name="oldFile" value="">
										</div>
<!-- 	                                	<div class="file-div">  -->
<%-- 		                                	<c:forTokens var="fileName" items="${m.files}${m.fileId}  " delims="," varStatus="st"> --%>
<%-- 	                                			<a class="file_a" download="${fileName}"  href="${m.filePath}${fileName}"> --%>
<%-- 	                                					${fileName} </a> --%>
<!-- 	                                			<a class="file_del" href="">(X)</a> -->
<%-- 		                                		<c:if test="${st.last == false}"> --%>
<!-- 		                                			/ -->
<%-- 		                                		</c:if>                      		 --%>
<%-- 		                                	</c:forTokens> --%>
		           
<!-- 		                                </div> -->
	                                </td>
	                            </tr>
	                            <tr class="content">
	                                <td colspan="4" style="padding: 10px 0px"><textarea name="contents" rows="20"  >${m.contents}</textarea></td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </section>
	                <section class="comt-box">
	                    <div class="list_view">
		                	<input type="hidden" name="id" value="${m.id}">
	                        <button class="list_btn"><a  href="detail?id=${m.id}">취소</a></button>
	                        <button type="submit" class="list_btn">저장</button>
	                    </div>
	
	                </section>          
               	</form>
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