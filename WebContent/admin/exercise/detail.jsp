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
    <link rel="stylesheet" href="../../css/admin/exercise/detail.css">

    <script src="../../js/admin_common.js"></script>
    <script src="../../js/admin/exercise/detail.js"></script>
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
                         <li>
                            <a href="/admin/exercise/list">재활운동 관리<i class="xi-angle-right-min"></i></a>
                            
                        </li>
                        <li><a href="/admin/exercise/homelist">홈트레이닝 관리</a></li>
                   
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                <div class="main-container">
                    <div class="image-container">
                        <div class="btn-left"></div>
                        <div class="cliper">
                            <div class="show-room">
                            <c:forEach var="f" items="${fileList}">
                           		<img src="${f.route}/${f.name}" alt="${f.name}">
                            </c:forEach>
                            </div>
                        </div>
                        <div class="btn-right"></div>
                    </div>
                    <div class="detail-box">

                        <div class="container">
                            <div class="label">
                                이름 
                            </div>
                            <div class="content">
                                ${ex.name}
                            </div>
                        </div>
                        <div class="part-box-left">
                            <!--<div class="part">
                                <div class="label">종류</div>
                                <div class="content">${ex.categoryId}</div>
                            </div>-->
                            <div class="part">
                                <div class="label">부위</div>
                                <div class="content">
                                <c:forEach var="bp" items="${ebpv}">
                                	${bp.bodyPartName}
                                </c:forEach>
                                
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="part-box-left">
                        <div class="part">
                            <div class="label">등록 날짜</div>
                            <div class="content">${ex.regdate}</div>
                        </div>
                    </div>
                    

                    <div class="description-box">
                        <div class="label">운동 설명 및 방법</div>
                        <div class="text-content">
                            ${ex.contents}
                        </div>
                    </div>
                    <div class="recomand-box">
                        <div class="label">추천 회수(초)</div>
                        <div class="text-content">${ex.recommend}</div>
                    </div>
                    <div class="recomand-box">
                        <div class="label">파일목록</div>
                        <div class="text-content">
                        	<c:forEach var="f" items="${fileList}">
                        		<a download href="${f.route}/${f.name}">${f.name}</a>
                        	</c:forEach>
                        </div>
                    </div>
                    <div class="button-box">
                        <button name="kbs" value="asd">수정하기</button>
                        <button>닫기</button>
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