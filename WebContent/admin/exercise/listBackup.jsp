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

    <script src="../js/admin_common.js"></script>
</head>

<body>
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <h1 class="logo"><a href="#"><img src="../../image/common/logo.png" alt="마이루틴"></a></h1>
            <nav class="gnb">
                <ul>
                    <li><a href="#" class="active"><i class="xi-calendar-list"></i>운동 관리</a></li>
                    <li><a href="#"><i class="xi-group"></i>회원 관리</a></li>
                    <li><a href="#"><i class="xi-forum"></i>커뮤니티 관리</a></li>
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
                            <a href="#">재활운동 관리<i class="xi-angle-right-min"></i></a>
                            <ul class="dep2">
                                <li><a href="https:\\www.naver.com">재활 보기</a></li>
                                <li><a href="https:\\www.naver.com">재활 등록</a></li>
                            </ul>
                        </li>
                        <li><a href="https:\\www.naver.com">홈트레이닝 관리</a></li>
                       
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">

                <div class="content-container">
                    <div class="input-container">
                        <div class="check-label">
                            부위
                        </div>
                        <div class="check-list">
                            <input type="checkbox" name="목">
                            목
                            <input type="checkbox" name="어깨">
                            어깨
                            <input type="checkbox" name="손목">
                            손목
                            <input type="checkbox" name="허리">
                            허리
                            <input type="checkbox" name="다리">
                            다리
      
                            <!-- and 검색 or 검색 / 라디오 or 셀렉트
                            데이터베이스에서 한다. -->
                        </div>

                        <div class="search-container">
                            <select name="" id="">
                                <option selected>제목</option>
                                <option>내용</option>
                            </select>
                            <input type="text" class="search-input" placeholder="검색">
                            <input type="submit" class = "submit-input" name="" id="" value="검색">
                        </div>
                    </div>
                    <div class="exercise-list">
                    <c:forEach var="ex" items="${list}">
                        <div class="list-box">
                            <a href="detailBackup?name=${ex.name}" class="img-box ">
                                <img src="../../image/exercise/${ex.engName}1.jpg" height="134px" width="150px" alt="">
                            </a>
                            <div class="name">
                                <a href="detailBackup?name=${ex.name}">${ex.name}</a>
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