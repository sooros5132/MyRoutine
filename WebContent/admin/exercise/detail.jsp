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
                <div class="main-container">
                    <div class="image-container">
                        <div class="btn-left"></div>
                        <div class="cliper">
                            <div class="show-room">
                           		<img src="../../image/exercise/${ex.engName}1.jpg" alt="${ex.engName}1" class="current">
                                <img src="../../image/exercise/${ex.engName}2.jpg" alt="${ex.engName}2">
                                <img src="../../image/exercise/${ex.engName}3.jpg" alt="${ex.engName}3">
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
                            <div class="part">
                                <div class="label">종류</div>
                                <div class="content">${ex.div1}</div>
                            </div>
                            <div class="part">
                                <div class="label">부위</div>
                                <div class="content">${ex.div2}</div>
                            </div>
                        </div>
                    </div>
                    <div class="part-box-left">
                        <div class="part">
                            <div class="label">등록 날짜</div>
                            <div class="content">${ex.regDate}</div>
                        </div>
                    </div>
                    

                    <div class="description-box">
                        <div class="label">운동 설명 및 방법</div>
                        <div class="text-content">
                            ${ex.des}
                        </div>
                    </div>
                    <div class="recomand-box">
                        <div class="label">추천 회수(초)</div>
                        <div class="text-content">${ex.rec}</div>
                    </div>
                    <div class="recomand-box">
                        <div class="label">파일목록</div>
                        <div class="text-content">${ex.files}</div>
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