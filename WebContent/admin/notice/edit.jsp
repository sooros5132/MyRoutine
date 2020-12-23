
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
    	<jsp:include page="/WEB-INF/jsp/admin/header.jsp"></jsp:include>


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
                <h1>공지사항</h1>
                
                <form action="edit" method="post">
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
                            <td colspan="3">
                              <input class="title" type="text" name="title" value="${n.title}">
                            
                            </td>
                        </tr>

                        <tr>
                            <td>등록일</td>
                            <td colspan="3">
                               ${n.regdate }
                            </td>
                        </tr>
                        <tr>
                            <td>첨부파일</td>
                            
                            <td>
                            <c:forTokens var="fileName" items="${nv.fileName}" delims="," varStatus="st">
                            ${fileName}  
                            <c:if test="${!st.last}">/</c:if>
                            </c:forTokens>
                            </td>
                            
                            <td>작성자</td>
                            <td>${n.memberId}</td>
                        </tr>
                        <tr>
                            <td>조회수</td>
                            <td colspan="3">${n.hit}</td>
                        </tr>

                    </tbody>
                </table>

                <section class="detail_text">
                    <textarea name="contents" value="${n.contents}" cols="30" rows="10">${n.contents }</textarea>
                </section>


                <section class="list-box">
                    <input type="hidden" name="id" value="${n.id}">
                    <a class="btn-button" href="detail?id=${n.id}">취소</a>
                    <input class="btn-button" value="저장" type="submit">
                </section>
           </form>

                <section class="next-list">
                    <table>
                        <colgroup>
                            <col style="width:200px">
                            <col style="width:auto">
                            <col style="width:200px">
                        </colgroup>

                        <tr>
                            <td class="move-icon"><a href=""><i class="xi-angle-up-min"></i></a>다음글</td>
                            <td><a href="detail?id=${next.id}">${next.title}</a></td>
                            <td>${next.regdate}</td>
                        </tr>
                        <tr>
                            <td class="move-icon"><a href=""><i class="xi-angle-down-min"></i></a>이전글</td>
                              <td><a href="detail?id=${prev.id}">${prev.title}</a></td>
                            <td>${prev.regdate}</td>
                          
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