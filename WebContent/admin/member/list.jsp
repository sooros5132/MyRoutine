<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">

    <script src="../../js/common.js"></script>
    <script src="../../js/admin_common.js"></script>
</head>
<body>
    <div class="wrapper">
        <!-- header -->
        <header class="header">
            <h1 class="logo"><a href="/"><img src="../../image/common/logo.png" alt="마이루틴"></a></h1>
            <nav class="gnb">
                <ul>
                    <li><a href="/admin/exercise/list"><i class="xi-calendar-list"></i>운동 관리</a></li>
                    <li><a href="/admin/member/list" class="active"><i class="xi-group"></i>회원 관리</a></li>
                    <li><a href="#"><i class="xi-forum"></i>커뮤니티 관리</a></li>
                    <li><a href="/admin/notice/list"><i class="xi-comment"></i>공지사항 관리</a></li>
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
            <aside class="aside d-none">
                <nav class="snb">
                    <h2>서브메뉴</h2>
                    <ul class="dep1">
                        하위 메뉴가 있으면 li태그에 data-type:true 넣어주세요
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
                    <h1>회원관리</h1>
                    <div class="member-search-container">
                    	<div class="member-search-inner">
                            <form method="GET">
                                <table class="member-search-table">
                                    <thead>

                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>검색 옵션</td>
                                            <td>
                                                <input type="radio" name="key" id="email" value="email" <c:if test="${key == 'email'}">checked</c:if>>
                                                <label for="email">이메일</label>
                                                <input type="radio" name="key" id="nickname" value="nickname" <c:if test="${key == 'nickname'}">checked</c:if>>
                                                <label for="nickname">닉네임</label>
                                                <input type="radio" name="key" id="name" value="name" <c:if test="${key == 'name'}">checked</c:if>>
                                                <label for="name">이름</label>
                                                <input type="radio" name="key" id="phone" value="phone" <c:if test="${key == 'phone'}">checked</c:if>>
                                                <label for="phone">핸드폰번호</label>
                                                <input type="radio" name="key" id="open_info" value="open_info" <c:if test="${key == 'open_info'}">checked</c:if>>
                                                <label for="open_info">정보공개(0, 1)</label>
                                                <input type="radio" name="key" id="none" value="" <c:if test="${key != 'email' && key != 'nickname' && key != 'name' && key != 'phone' && key != 'open_info'}">checked</c:if>>
                                                <label for="none">선택안함</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>검색 내용</td>
                                            <td>
                                                <input type="radio" name="search_option" id="same" value="same" <c:if test="${search_option == 'same'}">checked</c:if>>
                                                <label for="same">일치</label>
                                                <input type="radio" name="search_option" id="contain" value="contain" <c:if test="${search_option != 'same'}">checked</c:if>>
                                                <label for="contain">일부</label>
                                                <select style="width:auto" name="rule" class="rule-value">
                                                    <option value="0" <c:if test="${rule < 1 && 9 < rule}">selected</c:if>>모든 권한</option>
                                                    <option value="1" <c:if test="${rule == 1}">selected</c:if>>회원</option>
                                                    <option value="7" <c:if test="${rule == 7}">selected</c:if>>차단</option>
                                                    <option value="8" <c:if test="${rule == 8}">selected</c:if>>탈퇴</option>
                                                    <option value="9" <c:if test="${rule == 9}">selected</c:if>>관리자</option>
                                                </select>
                                                <input type="text" name="value" value="${value}" placeholder="검색 내용">
                                                <input type="submit" value="검색">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>리스트</td>
                                            <td>
                                                <div class="member-list-setting">
                                                    <div class="member-list-size">
                                                        <select name="size" style="width: auto">
                                                            <option value="10" <c:if test="${size == 10}">selected</c:if>>10</option>
                                                            <option value="20" <c:if test="${size != 10 && size != 30 && size != 50 && size != 100}">selected</c:if>>20</option>
                                                            <option value="30" <c:if test="${size == 30}">selected</c:if>>30</option>
                                                            <option value="50" <c:if test="${size == 50}">selected</c:if>>50</option>
                                                            <option value="100" <c:if test="${size == 100}">selected</c:if>>100</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                    <div><a href="/account/signUp">가입하러 가기 -></a></div>
                    <div style="text-align:right;"><span>삭제 기능 꺼둠</span></div>
                    <table class="member-list-table">
                        <colgroup>
                            <!-- <col style="width: 3%"> -->
                            <col style="width: 5%">
                            <col style="width: auto">
                            <col style="width: 4%">
                            <col style="width: 12%">
                            <col style="width: 15%">
                            <col style="width: 14%">
                            <col style="width: 16%">
                            <col style="width: 5%">
                        </colgroup>
                        <thead>
                            <tr>
                                <!-- <th rowspan="2"><input type="checkbox" class="all-member-select"></th> -->
                                <th rowspan="2">ID</th>
                                <th>이메일</th>
                                <th>성별</th>
                                <th>이름</th>
                                <th>회원상태</th> <!-- 회원, 관리자, 정지, 탈퇴 표시-->
                                <th>권한 변경</th> <!-- 여기서 관리자 권한 부여 -->
                                <th>가입일</th>
                                <th rowspan="2">강제<br>삭제</th>
                            </tr>
                            <tr>
                                <th>닉네임</th>
                                <th colspan="2">핸드폰번호</th>
                                <th>생년월일</th>
                                <th>정보 공개</th>
                                <th>최종접속</th>
                            </tr>
                        </thead>
                        <tbody>
<c:if test="${memberList eq '[]'}"><tr style="line-height: 300px;font-size: 70px;color: #ddd;"><td colspan="11">검색 결과가 없습니다</td></tr></c:if>
<c:forEach var="m" items="${memberList}" varStatus="status">
<tr class="<c:choose><c:when test="${status.index % 2 == 0}">odd</c:when><c:otherwise>even</c:otherwise></c:choose>" data-member-id="${m.id}">
	<!-- <td rowspan="2"><input type="checkbox" class="member-select"></td> -->
    <td class="member-detail" rowspan="2"><div>${m.id}</div></th>
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
	<td class="member-status"></td>
	<td>
	    <div class="data-update-box">
	        <div class="data-box">
	            <select class="data-input" data-origin="${m.rule}" name="rule">
	                <option value="1">회원</option>
	                <option value="7">차단</option>
	                <option value="8">탈퇴</option>
	                <option value="9">관리자</option>
	            </select>
	        </div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td><fmt:formatDate value="${m.regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
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
	        <div class="data-box"><input class="data-input" type="tel" value="${m.phone}" data-origin="${m.phone}" name="phone"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td>
	    <div class="data-update-box">
	        <div class="data-box"><input class="data-input" type="date" value="${m.birthday}" data-origin="${m.birthday}" name="birthday"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
	</td>
	<td>
		<div class="data-update-box">
	        <div class="data-box"><input class="data-input" type="checkbox" data-origin="${m.openInfo}" name="open_info"></div>
	        <div class="change-icon update-btn"><i class="xi-check"></i></div>
	    </div>
    </td>
	<td>
	    <div class="data-update-box active member-last-login">
	        <div class="data-box"><fmt:formatDate value="${m.lastLogin}" pattern="yyyy-MM-dd HH:mm"/></div>
	        <div class="change-icon update-btn changed"><i class="xi-renew"></i></div>
	    </div>
	</td>
</tr>
</c:forEach>

<c:if test="${memberList != '[]'}">
	<tr class="page-number" style="height:0">
		<!--<td colspan="11">검색된 멤버: ${totalCount} 총 페이지: ${totalPage}</td>-->
		<td colspan="11">${page}</td>
	</tr>
</c:if>
                        </tbody>
                    </table>
                    <div><span>변경한 값들 <input type="button" class="update-all-btn" value="일괄 변경"></span></div>
                    <div class="member-list-paging">
                    	<div>
						    <!-- 보여질 페이지 번호들 최대 수 -->
						    <c:set var="pagings" value="9"/>
						    <!-- 페이지 절반 -->
						    <fmt:parseNumber var="pagingHalf" integerOnly="true" value="${(pagings / 2) / 1 }" />
						    <!-- 전체페이지 수 -->
						    <fmt:parseNumber var="totalPage" integerOnly="true" value="${totalCount / size + (1 - ((totalCount / size) % 1)) % 1}" />
						    <!-- 페이지 생성 시작값 -->
						    <c:set var="startPage" value="1"/>
						    <!-- 페이지 생성 종료값 -->
						    <c:set var="endPage" value="${totalPage}"/>
						    
						    <c:if test="${ page > pagingHalf && page + (pagingHalf - 1) < totalPage}">
						    	<c:set var="startPage" value="${page - (pagingHalf)}"/>
						    </c:if>
						    <!-- 마지막 페이지 근접일 경우 -->
						    <c:if test="${ page >= 4 && page >= totalPage - (pagingHalf-1)}">
							    <c:set var="startPage" value="${page - (pagings - 1 - (totalPage - page))}"/>
						    </c:if>
						    
						    <c:if test="${ startPage < 1 }">
							    <c:set var="startPage" value="1"/>
						    </c:if>
						    
						    <!-- 페이지 전체가 페이지 절반보다 클 때 -->
						    <c:if test="${totalPage > pagingHalf}">
						    	<c:set var="endPage" value="${page + pagingHalf}"/>
						    </c:if>
						    
						    <!-- 현재 페이지가 페이지 절반 이하일때 -->
						    <c:if test="${page <= pagingHalf}">
						    	<c:set var="endPage" value="${page + (pagings - page)}"/>
						    </c:if>
						    
						    <!-- 넘어가면 다시 초기화 -->
						    <c:if test="${totalPage <= endPage}">
						    	<c:set var="endPage" value="${totalPage}"/>
						    </c:if>
						    
   						 	<a class="p-prev-next p-first-end paging <c:if test="${page <= 1}">disable</c:if>" data-page="1"><i class="xi-angle-left-min"></i><i class="xi-angle-left-min"></i></a>
						    <a class="p-prev-next paging <c:if test="${page <= 1}">disable</c:if>" data-page="${page-1}"><i class="xi-angle-left-min"></i></a>
    						
						    <c:forEach begin="${startPage}" end="${endPage}" var="nowPage">
						        <c:choose>
						            <c:when test="${nowPage eq page}">
						                <a class="now-page disable"style="font-weight: bold">${nowPage}</a>
						            </c:when>
						            <c:otherwise>
						                <a class="paging" data-page="${nowPage}">${nowPage}</a>
						            </c:otherwise>
						        </c:choose>
						    </c:forEach>
						    
						    <a class="p-prev-next paging <c:if test="${page >= totalPage}">disable</c:if>" data-page="${page+1}"><i class="xi-angle-right-min"></i></a>
						    <a class="p-prev-next p-first-end paging <c:if test="${page >= totalPage}">disable</c:if>" <c:if test="${page <= 1}">disable</c:if> data-page="<fmt:parseNumber integerOnly="true" value="${totalPage}" />"><i class="xi-angle-right-min"></i><i class="xi-angle-right-min"></i></a>
                    	</div>
                    </div>
                    
					<div style="line-height: 30px;font-size: 20px;font-weight: bold;text-align:center;color: #d2d2d2;">
						<div>검색된 회원: ${totalCount}, 총 페이지: ${totalPage}</div>
					</div>
				<jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp" />
                </div>
                <div></div>
    			<script src="../../js/admin/member/list.js"></script>
    			
                    <div style="margin-top: 20px;margin-bottom: 20px;padding: 10px; background: #f5f5f5;">
                        <h1 style="font-size: 20px;">아이디어 메모장 저장기능 x</h1>
                        <a href="/account/signUp" style="display: inline-block; margin: 10px 0;">가입하러 가기 -></a>
<textarea style="font-family: 'Courier New', Courier, monospace;" name="" id="" cols="30" rows="20">
회원 삭제하면 가입도 부탁드립니다
/account/signUp

페이징 추가 계획중
size: 리스트 개수
page: 페이지
key: 검색 키
value: 검색 값
rule: 회원 권한
search_option: 검색 내용의 일치, 일부

회원 /       차단 /  탈퇴상태 / 관리자
 1  /        7  /      8   /   9
</textarea>
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