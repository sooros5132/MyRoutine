<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">
    <link rel="stylesheet" href="../../css/admin/exercise/list.css">

    <script src="../../js/admin_common.js"></script>
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
                        <li >
                            <a href="/admin/exercise/list">재활운동 관리</a>
                        </li>
                        <li><a href="/admin/exercise/homelist">홈트레이닝 관리<i class="xi-angle-right-min"></i></a></li>
                       
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
            
			
                <div class="content-container">
                <c:if test=""></c:if>
                
                    <div class="input-container">
                    	<form action="/admin/exercise/homelist" method="get" class="a">
                        	
                            <div class="check-label">
                                부위
                            </div>
                            <div class="check-list">
                            	<input type="checkbox" id="1" name="part" value="1">
                            	<label for="1">어깨</label>
                            	<input type="checkbox" id="2" name="part" value="2">
                            	<label for="2">팔</label>
                            	<input type="checkbox" id="3" name="part" value="3">
                            	<label for="3">가슴</label>
                            	<input type="checkbox" id="4" name="part" value="4">
                            	<label for="4">허리</label>
                            	<input type="checkbox" id="5" name="part" value="5">
                                <label for="5">복근</label>
                            	<input type="checkbox" id=6 name="part" value="6">
                            	<label for="6">등</label>
                            	<input type="checkbox" id="7" name="part" value="7">
                            	<label for="7">허벅지</label>
                            	<input type="checkbox" id="8" name="part" value="8">
                            	<label for="8">엉덩이</label>
                            	<input type="checkbox" id="9" name="part" value="9">
                                <label for="9">전신</label>
                            </div>
                            <select name="option">
                                <option value = "and">and</option>
                                <option value = "or">or</option>
                            </select>
                            <input type="submit" class="submit-input" value="검색">
                            
                            


                            <!-- <div class="search-container">
                                <select name="" id="">
                                    <option selected>제목</option>
                                    <option>내용</option>
                                </select>
                                <input type="text" class="search-input" placeholder="검색">
                                
                            </div> -->
                        </form>
                        <div class="button-box">
                        	<button >등록</button>
                        </div>
                    </div>
                    
                    <%//부위 운동 파일 %>
                    <div class="exercise-list">
                    <c:forEach var="ex" items="${list}">
                        <div class="list-box">
                            <a href="detail?id=${ex.id}" class="img-box ">
                                 <img src="${ex.efRoute}/${ex.efName}" height="134px" width="150px" alt="${ex.efName}"> 
                            </a>
                            <div class="name">
                                <a href="detail?id=${ex.id}">${ex.name}</a>
                            </div>
                        </div>
                    </c:forEach>
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