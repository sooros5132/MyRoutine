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
    <script src="../../js/admin/community/edit.js"></script>
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
                                        <select name="categoryId" class ="select-box" style="appearance:auto">
				                        	<c:forEach var="categroy" items="${cList}" >
				                        		<option
				                        		 	<c:if test="${categoryId==0}">disabled</c:if>
				                        			<c:if test="${categoryId==category.Id}">selected</c:if>	 
				                        		value ="${categroy.id}">${categroy.type} </option>
				                        	</c:forEach>
                                        </select>
                                        <input name="categoryId"  type="hidden" class="category-id" value="${m.categoryId}">                                        
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
	                        <button type="submit" class="list_btn myButton">저장</button>
	                        <button class="list_btn canclebtn"><a  href="detail?id=${m.id}">취소</a></button>
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