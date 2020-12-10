<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>

    <!-- 공통CSS -->
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">

    <!-- 개별 CSS -->
    <link rel="stylesheet" href="../../css/admin/sub.css">
    <!-- 공통JS -->
    <script src="../../../js/admin_common.js"></script>
    
    <!-- 개별JS -->
 	<script src="../../js/admin.js"></script>
 
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
                            <a href="#">재활관리<i class="xi-angle-right-min"></i></a>
                            <ul class="dep2">
                                <li><a href="https:\\www.naver.com">재활 보기</a></li>
                                <li><a href="https:\\www.naver.com">재활 등록</a></li>
                            </ul>
                        </li>
                        <li><a href="https:\\www.naver.com">재활관리2</a></li>
                        <li><a href="https:\\www.naver.com">재활관리2</a></li>
                        <li><a href="https:\\www.naver.com">재활관리2</a></li>
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                 <!-- section -->
                 <section>
                     <h2 class="con-tit">운동 수정</h2>
                    <form action="edit" method="POST" class="edit-form"> 
                        <legend class="hide">운동 수정 폼</legend>
                        <div class="table-box">
                            <table class="admin-from-table">
                                <caption>1분류(일반 재활),2차 분류(신체 부위), 운동 이름, 운동설명, 운동이미지</caption>
                                <colgroup>
                                    <col style="width:150px">
                                    <col style="width:auto">
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th>운동이름</th>
                                        <td>
                                            <div>
                                                <input type="text"  name="name" value="${ex.name}">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>항목</th>
                                        <td>
                                        	
                                    
	                                            <ul class="radio-list-box">
	                                            	<c:forTokens var="div1" items="${ex.div1}" delims="," varStatus="st">
	                                                <li>
	                                                    <input id="re" class="ex-menu" type="radio" name="div1" value="re" <c:if test="${div1 == '재활'}">checked</c:if>>
	                                                    <label for="re">
	                                                        <span class="radio"></span>
	                                                        재활 운동
	                                                    </label>
	                                                </li>
	                                                <li>
	                                                    <input id="ex" class="ex-menu" type="radio"  name="div1" value="ex" <c:if test="${div1 == '일반'}">checked</c:if>>
	                                                    <label for="ex">
	                                                        <span class="radio"></span>
	                                                        일반 운동
	                                                    </label>
	                                                </li>
	                                                </c:forTokens>
	                                            </ul>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>운동 부위</th>
                                        <td>
                                        	
                                        	
                                              <!-- ex_con -->
                                              <div class="ex-con current">
                                              <ul class="check-list-box">
                                               <c:set  var="div2" value="${ex.div2}" />
                                    			<li>
                                                     <input id="re-list1" type="checkbox" name="re-list" value="목" <c:if test="${fn:contains(div2, '목')}">checked</c:if>>
                                                     <label for="re-list1">
                                                         <span class="check"></span>
                                                             목
                                                     </label>
                                                </li>
                                             	<li>
                                                      <input id="re-list2" type="checkbox" name="re-list" value="어깨" <c:if test="${fn:contains(div2, '어깨')}">checked</c:if>>
                                                      <label for="re-list2">
                                                          <span class="check"></span>
                                                              어깨
                                                      </label>
                                                  </li>
                                               <li>
                                                   <input id="re-list3" type="checkbox" name="re-list" value="팔" <c:if test="${fn:contains(div2, '팔')}">checked</c:if>>
                                                   <label for="re-list3">
                                                       <span class="check"></span>
                                                       팔(손목)
                                                   </label>
                                               </li>
                                                  <li>
                                                      <input id="re-list4" type="checkbox" name="re-list" value="허리" <c:if test="${fn:contains(div2, '허리')}">checked</c:if>>
                                                      <label for="re-list4">
                                                          <span class="check"></span>
                                                          허리
                                                      </label>
                                                  </li>
                                                  <li>
                                                      <input id="re-list5" type="checkbox" name="re-list" value="허벅지" <c:if test="${fn:contains(div2, '허벅지')}">checked</c:if>>
                                                      <label for="re-list5">
                                                          <span class="check"></span>
                                                          허벅지
                                                      </label>
                                                  </li>
                                                  <li>
                                                      <input id="re-list6" type="checkbox" name="re-list" value="무릎" <c:if test="${fn:contains(div2, '무릎')}">checked</c:if>>
                                                      <label for="re-list6">
                                                          <span class="check"></span>
                                                          무릅
                                                      </label>
                                                  </li>
                                                  <li>
                                                      <input id="re-list7" type="checkbox" name="re-list" value="발목" <c:if test="${fn:contains(div2, '발목')}">checked</c:if>>
                                                      <label for="re-list7">
                                                          <span class="check"></span>
                                                          발목
                                                      </label>
                                                  </li>
                                                  <li>
                                                      <input id="re-list8" type="checkbox" name="re-list" value="등"  <c:if test="${fn:contains(div2, '등')}">checked</c:if>>
                                                      <label for="re-list8">
                                                          <span class="check"></span>
                                                           등
                                                      </label>
                                                  </li>
                                                  <li>
                                                      <input id="re-list9" type="checkbox" name="re-list" value="엉덩이"  <c:if test="${fn:contains(div2, '엉덩이')}">checked</c:if>>
                                                      <label for="re-list9">
                                                          <span class="check"></span>
                                                          발목
                                                      </label>
                                                  </li>
                                                  <li>
                                                      <input id="re-list10" type="checkbox" name="re-list" value="뒷허벅지" <c:if test="${fn:contains(div2, '뒷허벅지')}">checked</c:if>>
                                                      <label for="re-list10">
                                                          <span class="check"></span>
                                                          뒷허벅지
                                                      </label>
                                                  </li>
                                             
                                                </ul>
                                            </div>

                                            <!-- //ex_con -->
                                           
                                            <!-- ex_con -->
                                            <div class="ex-con">
                                                <ul class="check-list-box">
                                                    <li>
                                                        <input id="ex-list1" type="checkbox" name="ex-list" value="목" checked>
                                                        <label for="ex-list1">
                                                            <span class="check"></span>
                                                            목
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="ex-list2" type="checkbox" name="ex-list" value="어꺠">
                                                        <label for="ex-list2">
                                                            <span class="check"></span>
                                                            어깨
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="ex-list3" type="checkbox" name="ex-list" value="가슴">
                                                        <label for="ex-list3">
                                                            <span class="check"></span>
                                                                가슴
                                                        </label>
                                                    </li>
                                                        <li>
                                                        <input id="ex-list4" type="checkbox" name="ex-list" value="배">
                                                        <label for="ex-list4">
                                                            <span class="check"></span>
                                                                배
                                                        </label>
                                                    </li>
                                                    
                                                        <li>
                                                        <input id="ex-list5" type="checkbox" name="ex-list" value="허리">
                                                        <label for="ex-list5">
                                                            <span class="check"></span>
                                                                허리
                                                        </label>
                                                    </li>
                                                    
                                                        <li>
                                                        <input id="ex-list6" type="checkbox" name="ex-list" value="	허벅지">
                                                        <label for="ex-list6">
                                                            <span class="check"></span>
                                                                허벅지
                                                        </label>
                                                    </li>
                                                    
                                                        <li>
                                                        <input id="ex-list7" type="checkbox" name="ex-list" value="무릅">
                                                        <label for="ex-list7">
                                                            <span class="check"></span>
                                                                무릅
                                                        </label>
                                                    </li>
                                                    
                                                        <li>
                                                        <input id="ex-list8" type="checkbox" name="ex-list" value="발목">
                                                        <label for="ex-list8">
                                                            <span class="check"></span>
                                                                발목
                                                        </label>
                                                    </li>
                                                    
                                                        <li>
                                                        <input id="ex-list9" type="checkbox" name="ex-list" value="등">
                                                        <label for="ex-list9">
                                                            <span class="check"></span>
                                                                등
                                                        </label>
                                                    </li>
                                                        <li>
                                                        <input id="ex-list10" type="checkbox" name="ex-list" value="엉덩이">
                                                        <label for="ex-list10">
                                                            <span class="check"></span>
                                                                엉덩이
                                                        </label>
                                                    </li>
                                                        <li>
                                                        <input id="ex-list11" type="checkbox" name="ex-list" value="뒷허벅지">
                                                        <label for="ex-list11">
                                                            <span class="check"></span>
                                                                뒷허벅지
                                                        </label>
                                                    </li>
                                                        <li>
                                                        <input id="ex-list12" type="checkbox" name="ex-list" value="종아리">
                                                        <label for="ex-list12">
                                                            <span class="check"></span>
                                                                종아리
                                                        </label>
                                                    </li>
                                                    
                                                </ul>
                                            </div>
                                            <!-- //ex_con -->
                                           
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>설명</th>
                                        <td>
                                            <div class="area-box">
                                                <textarea id="" cols="30" rows="10" name="des">${ex.des}</textarea>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>추천 횟수(초)</th>
                                        <td>
                                            <input type="text" name="rec" value="${ex.rec}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>첨부파일</th>
                                        <td>
                                        
                                        	<c:forTokens var="file" items="${ex.files}" delims="," varStatus="st">
                                        	${file}
	                                            <div class="attach-box-list">
	                                                <div class="attach-box">
	                                                    <input class="attach-input" type="file" name="file" capture="user" value="C:\fakepath\1${file}">
	                                                    <div class="attach-box-inner">
	                                                        <button class="attach-btn" type="button" onclick ="fileInputClick();">파일선택</button>
	                                                        <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="${file}">
	                                                        <button class="attach-cancel-btn" type="button" onclick="fileInputDel();"><i class="xi-close-min"></i></button>
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </c:forTokens>
                                            <div class="file-form-add"><i class="xi-plus-min"></i>추가</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="btn-box">
                            <button class="btn del">삭제</button>
                            <button class="btn edit">수정</button>
                            <button class="btn cancel">닫기</button>
                        </div>
                    </form>
                </section>
                <!-- section -->
            </main>
            <!-- //main(개별 컨턴츠 넣는곳) -->
        </div>

        <!-- footer -->
        <footer class="footer">
            <span>ⓒ 마이 루틴</span>
        </footer>
        <!-- //footer -->
    </div>

    <script>
        window.addEventListener('load', ()=>{
            //삭제 버튼 클릭시
            
            //수정버튼 클릭시
			let editBtn = document.querySelector('.edit');
            let editForm = document.querySelector('.edit-form');
            editBtn.addEventListener('click', (e)=>{
            	e.preventDefault();
            	editForm.method="POST";
            	editForm.submit();
            })
            
            //닫기 버튼 클릭시
        });
    </script>
</body>
</html>