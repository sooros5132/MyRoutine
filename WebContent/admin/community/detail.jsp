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
	<link rel="stylesheet" href="../../css/admin/community/detail-style.css">    

    <script src="../../common/js/admin_common.js"></script>
    <script src="../../js/admin/community/detail.js"></script>
    
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
                <section>
<!--                     <div > -->
<%--                     	<h2 class="con-tit">${m.title}</h2> --%>
<!--                     </div> -->
<!--                     <textarea class="textarea" readonly> -->
<%--                        ${m.contents}   --%>
<!--                     </textarea> -->
					<div class="title-div">
	              		<h2 class="title">커뮤니티 상세</h2>
	              		<input class="report" type="button" value="신고">
              		</div> 
                    <table class="admin-from-table">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td colspan="3">${m.title}</td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td colspan="3">
                                 	<fmt:formatDate value="${m.regdate}" pattern="yyyy-MM-dd a hh:mm:ss"/> 
<!--                                 HH	대문자는 24시간 -->
                                </td>
                            </tr>
                            <tr>
                                <th>게시판 종류</th>
                                <td  colspan="3">${m.categoryType} </td>
                           </tr> 
                            <tr>
                                <th>작성자</th>
                                 	<td>${m.writerName}
                                 	<input type="hidden" value="${m.writerId}">
                                 	</td> 
                                <th>조회수</th>
                                <td>${m.hit}</td>
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
                                <td  colspan="4" class="content_td">                       
                                ${m.contents}</td>
                            </tr>
                        </tbody>
                    </table>
                </section>
                <section class="comt-box">
					<form method="post" >
	                    <div class="div-ap"> 
<%--  	                    	<input type="hidden" name="memberId" value="${m.memberId}">  --%>
 	                    	<input type="hidden" class="member_id" name="memberId" value="22"> 
 	                    	<input type="hidden" class="community_id" name="communityId" value="${m.id}">
	                        <input type="text" name="contents" class="ap-text" placeholder="  댓글 입력하세요">
	                        <button class="ap-btn">댓글</button>
<!-- 	                        <button type="submit" class="ap-btn">댓글</button> -->	                    </div>
					</form>
	                    <table class="comt">
	                        <tbody class="tbody">
	                            <colgroup>
	                                <col style="width:auto">
	                                <col style="width:150px">
	                                <col style="width:100px">
	                                <col style="width:100px">
	                            </colgroup>
	                            <c:forEach var="n" items="${list}" >
									<form action="commentDel" method="post">
			                            <tr class="cmd-tr">
			                                <td class="comt-list">${n.contents}<button type="submit" class="cmt-del-btn" > X </button></td>
			                                <td class="comt-writer">${n.regdate}</td>
			                                <td class="comt-writer">${n.writerName}</td>
			                                <td class="comt-writer">
			                                	<input class="comn-report" type="button" value="신고">
			                                	<input type="hidden" name="id" value="${n.id}" class="cmt-id">
			                                	<input type="hidden" name="detailId" value="${m.id}">
			                                </td> 
			                            </tr>
				                    </form>
	                       		</c:forEach>
	                        </tbody>
	                    </table>
                    <div class="list_view">
<!--                     	<input  type="button" value="댓글추가테스트" class="test-btn"> -->
                        <button class="list_btn"><a  href="list">목록</a></button>
                    	<button class="list_btn"><a  href="edit?id=${m.id}">수정</a></button>
                    </div>
                </section>          
            </main>
            
<!--     =============== =============== =============== =============== =============== =============== ================= -->
            <!-- //main(개별 컨턴츠 넣는곳) -->
        </div>
    	<script src="comment.js"></script>
        <!-- footer -->
        <footer class="footer">
            <span>ⓒ 마이 루틴</span>
        </footer>
        <!-- //footer -->
    </div>
</body>
</html>