
<%@page import="com.myroutine.web.service.CommunityService"%>
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
    <script src="../../js/admin/community/list.js"></script>        
</head>
<body>
    <div class="wrapper">
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"></jsp:include>
       

        <div class="body" style="height: 100%">
            <!-- aside -->
           	<jsp:include page="../complainAside.jsp"></jsp:include>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                <section class="title_section">
                    <div class="list_title">
                        <h1>건의사항 리스트</h1>
                        <div >
	                        <form action="list" method="get">
		                        <select name="categoryId" class="select " onchange="this.form.submit();" style="appearance:auto">
		                        	<c:forEach items="${cList}" var ="categroy">
		                        		<option <c:if test="${categoryId==categroy.id}">selected</c:if> 
		                        		value ="${categroy.id}">${categroy.type} </option>
		                        	</c:forEach>
		                        </select>
		                        <input type="text" class="search_input" name= "value">
		                        <button class="search_btn myButton" style="height:35px; text-align:center;" type="submit">검색</button>
	                        </form>
                        </div>
                    </div>
                    <div>
	                    <table class="admin-from-table">
     						<colgroup>
	                            <col style="width:100px">	
	                            <col style="width:120px">
	                            <col style="width: auto;">
	                            <col style="width: 150px">
	                            <col style="width: 100px">
                        	</colgroup>
                   	        <thead>
	                            <tr>
	                                <th>작성자</th>
	                                <th>종류</th>
	                                <th>제목</th>
	                                <th>날짜</th>
	                                <th>조회수</th>
	                            </tr>
	                        </thead>
	                        <tbody class="tbody"> 
							<c:forEach items="${list}" var="n" >               
	                            <tr>
	                                <td>${n.writerName}</td>
	                                <td>${n.categoryType}</td>
	                                <td><a href="detail?id=${n.id}">${n.title}</a></td>
	                                <td>${n.regdate}</td>
	                                <td>${n.hit}</td>
	                            </tr> 
	                         </c:forEach>
	                        </tbody>
	                    </table>
                    </div>
                </section>
                <div class="btn-box">
	                <div class="box1">
<%-- 		                	<a  class="prevPage" href="list?page=${prevPage}"> << 이전 </a> --%>
<%-- 								<c:forEach begin="1" end="${group}" var="i"> --%>
<%-- 									<span > <a class="changePage" href="list?page=${i}">${i}</a></span> --%>
<%-- 								 </c:forEach> --%>
<%-- 							<a class="nextPage" href="list?page=${nextPage}">  다음  >></a> --%>
 
		                	<div class="pager">
			                	<a  class="prev-page" href="" > << 이전 </a>
	
									<c:forEach begin="1" end="${group}" var="i">
										<span > <a class="change-page" href="">${i}</a></span>
									</c:forEach>
	
								<a class="next-page" href="">  다음  >></a>
							</div> 
								<input hidden class="group" value="${group}" />        
					</div>         
					
                    <div>
                        <button class="btn  myButton" style="width:100px; height:55px;"><a href="reg">글쓰기</a></button>
                    </div>
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