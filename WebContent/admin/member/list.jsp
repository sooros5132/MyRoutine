<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">

    <script src="../../js/admin_common.js"></script>
</head>
<body>
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <h1 class="logo"><a href="#"><img src="../../image/common/logo.png" alt="마이루틴"></a></h1>
            <nav class="gnb">
                <ul>
                    <li><a href="#"><i class="xi-calendar-list"></i>운동 관리</a></li>
                    <li><a href="#" class="active"><i class="xi-group"></i>회원 관리</a></li>
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
                            <a href="#">재활관리<i class="xi-angle-right-min"></i></a>
                            <ul class="dep2">
                                <li><a href="">재활 보기</a></li>
                                <li><a href="">재활 등록</a></li>
                            </ul>
                        </li>
                        <li><a href="">재활관리2</a></li>
                        <li><a href="">재활관리2</a></li>
                        <li><a href="">재활관리2</a></li>
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
            	<link rel="stylesheet" href="../../css/admin/member/list.css">
                <div class="member-list">
                    <div style="margin-bottom: 20px;padding: 10px; background: #f5f5f5;">
                        <h1 style="font-size: 20px;">아이디어 메모 저장기능 x</h1>
<textarea style="font-family: 'Courier New', Courier, monospace;" name="" id="" cols="30" rows="10">
회원 /       차단 /  탈퇴상태 / 관리자
 1  /        7  /      8   /   9

체크표시 언제 바뀔지
1. O data-origin 속성으로 기존 값 가지고 있다가 비교 후 다르면 체크아이콘 활성
2. X 바뀌면 무조건 체크아이콘 활성

가입 페이지
/account/signUp.html
</textarea>
                    </div>
                    <h1>회원관리</h1>
                    <div class="member-list-setting">
                        <div class="member-list-size">
                            <select name="" id="">
                                <option>10</option>
                                <option selected>20</option>
                                <option>50</option>
                                <option>100</option>
                            </select>
                        </div>
                    </div>
                    <table>
                        <colgroup>
                            <col style="width: 3%">
                            <col style="width: auto">
                            <col style="width: 4%">
                            <col style="width: 12%">
                            <col style="width: 8%">
                            <col style="width: 8%">
                            <col style="width: 13%">
                            <col style="width: 12%">
                            <col style="width: 5%">
                            <col style="width: 5%">
                            <col style="width: 5%">
                        </colgroup>
                        <thead>
                            <tr>
                                <th rowspan="2"><input type="checkbox" class="all-member-select"></th>
                                <th>이메일</th>
                                <th>성별</th>
                                <th>이름</th>
                                <th>메일인증</th>
                                <th>메일수신</th>
                                <th>가입일</th>
                                <th>회원상태</th> <!-- 회원, 관리자, 정지, 탈퇴 표시-->
                                <th colspan="2">권한 변경</th> <!-- 여기서 관리자 권한 부여 -->
                                <th rowspan="2">강제<br>삭제</th>
                            </tr>
                            <tr>
                                <th>닉네임</th>
                                <th colspan="2">핸드폰번호</th>
                                <th>정보 공개</th>
                                <th>SMS수신</th>
                                <th>생년월일</th>
                                <th>최종접속</th>
                                <th>탈퇴</th>
                                <th>차단</th>
                            </tr>
                        </thead>
                        <tbody>
<c:forEach var="m" items="${memberList}" varStatus="status">
<tr class="<c:choose><c:when test="${status.index % 2 == 0}">odd</c:when><c:otherwise>even</c:otherwise></c:choose>" data-member-id="${m.id}">
	<td rowspan="2"><input type="checkbox" class="member-select"></td>
	<td>
	    <div class="data-update-box">
			<div class="data-box"><input class="data-input" type="text" value="${m.email}" data-origin="${m.email}" name="email"></div>
			<div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td>${m.gender}</td>
	<td>
	    <div class="data-update-box">
	        <div class="data-box"><input class="data-input" type="text" value="${m.name}" data-origin="${m.name}" name="name"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td><c:choose><c:when test="${m.mailauth == 1}">YES</c:when><c:otherwise>NO</c:otherwise></c:choose></td>
	<td><input class="data-input" type="checkbox" data-origin="${m.receivingmail == 1}" name="receivingmail"></td>
	<td>${m.regdate}</td>
	<td class="member-status"></td>
	<td colspan="2">
	    <div class="data-update-box">
	        <div class="data-box">
	            <select class="data-input" data-origin="${m.authority}" name="authority">
	                <option value="1">회원</option>
	                <option value="7">차단</option>
	                <option value="8">탈퇴</option>
	                <option value="9">관리자</option>
	            </select>
	        </div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td rowspan="2"><input class="data-input member-delete" type="button" value="삭제" name="delete"></td>
</tr>
<tr class="<c:choose><c:when test="${status.index % 2 == 0}">odd</c:when><c:otherwise>even</c:otherwise></c:choose>" data-member-id="${m.id}">
	<td>
	    <div class="data-update-box">
	        <div class="data-box"><input class="data-input" type="text" value="${m.nickname}" data-origin="${m.nickname}" name="nickname"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td colspan="2">
	    <div class="data-update-box">
	        <div class="data-box"><input class="data-input" type="text" value="${m.phone}" data-origin="${m.phone}" name="phone"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td><input class="data-input" type="checkbox" data-origin="${m.publicinfo == 1}" name="publicinfo"></td>
	<td><input class="data-input" type="checkbox" data-origin="${m.receivingsms == 1}" name="receivingsms"></td>
	<td>
	    <div class="data-update-box">
	        <div class="data-box"><input class="data-input" type="text" value="${m.birthday}" data-origin="${m.birthday}" name="birthday"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td>${m.finalconnection}</td>
	<td class="member-status-withdraw"></td>
	<td class="member-status-block"><input class="data-input" type="checkbox" data-origin="${m.authority == 7}" name="authority"></td>
</tr>
</c:forEach>
                        </tbody>
                    </table>
				<jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp" />
                </div>
    			<script src="../../js/admin/member/memberEdit.js"></script>
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