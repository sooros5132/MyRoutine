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
	<link rel="stylesheet" href="../../css/admin/community/edit-style.css">    

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
<!--             	<form action="post"> -->
<!-- 	                <section>         -->
<!-- 	                    <div class="title"> -->
<!-- 	                        <input type="text" name="title" placeholder="제목을 입력하세요" > -->
<!-- 	                    </div> -->
<!-- 	                    <div id="editor" > -->
<!-- 	                        <textarea class = "textarea"  name="contents" placeholder = "상품설명을 입력하세요" rows="40"> -->
	
<!-- 	                        </textarea> -->
<!-- 	                    </div> -->
<!-- 	                </section> -->
<!-- 	                <div class="btn-box"> -->
<!-- 	                    <button class="btn" type="submit">저장하기</button> -->
<!-- 	                    <button class="btn"><a href="list">취소</a></button> -->
<!-- 	                </div> -->
<!--                 </form> -->
				<section>
	                <h2 class="title">건의사항 등록</h2>
	                
<!-- 	            enctype    입력된값을 전달할때 어떠한 모양으로 전달할지 설정하는것
application/x-www-form-urlencoded
urlencoding->queryString을 인코딩 붙여서 사용
request header
 

-->
	               <form method="post" enctype="multipart/form-data">
                        <table class="admin-from-table">
                            <tbody>
                                <tr>
                                    <th>게시판 선택</th>
                                    <td  colspan="3">
                                        <select name = "categoryId" class ="select-box">
				                        	<c:forEach var="categroy" items="${cList}" >
				                        		<option 
				                        			<c:if test="${categoryId==0}">disabled</c:if>	 
				                        			<c:if test="${categoryId==1}">selected</c:if>	 
				                        			value ="${categroy.id}">${categroy.type} </option>
				                        	</c:forEach>
                                        </select>
                                   </td>
                                </tr>
                                <tr>
                                    <th>제목</th>
                                    <td  colspan="3">
                                        <input type="text" name="title" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>첨부파일</th>
                                    <td colspan="3" ><input type="file" class="attach-btn"
                                            name="file" /> </td>
                                </tr>
                                <tr>
                                    <th>추가 첨부파일</th>
                                    <td colspan="3" ><input type="file" class="attach-btn"
                                            name="file" /> </td>
                                </tr>
                                <tr class="content">
                                    <td colspan="4"><textarea class="content" name="contents" rows="20" ></textarea></td>
                                </tr>
                            </tbody>
                        </table>
	                    <div class="btn-box"> 
	                        <button type="submit" class="btn myButton" >등록</button>
	                        <a class="btn canclebtn myButton" href="list">취소</a>
		                </div>
	                </form>
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