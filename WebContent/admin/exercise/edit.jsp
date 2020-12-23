<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
			<h1 class="logo">
				<a href="#"><img src="../../image/common/logo.png" alt="마이루틴"></a>
			</h1>
			<nav class="gnb">
				<ul>
					<li><a href="#" class="active"><i class="xi-calendar-list"></i>운동
							관리</a></li>
					<li><a href="#"><i class="xi-group"></i>회원 관리</a></li>
					<li><a href="#"><i class="xi-forum"></i>커뮤니티 관리</a></li>
					<li><a href="#"><i class="xi-comment"></i>공지사항 관리</a></li>
					<li><a href="#"><i class="xi-presentation"></i>건의사항 관리</a></li>
				</ul>
			</nav>

			<div class="header-util">
				<span class="admin">황병준님</span> <a class="logout-btn" href="#">로그아웃</a>
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
                        <li><a href="/admin/exercise/list">재활관리</a></li>
                        <li><a href="/admin/exercise/homelist">홈트레이닝관리</a></li>
                    </ul>
				</nav>
			</aside>
			<!-- //aside -->

			<!-- main(개별 컨턴츠 넣는곳) -->
			<main class="main">
				<!-- section -->
				<section>
					<h2 class="con-tit">운동 수정</h2>
					<form action="edit" method="POST" class="edit-form" enctype="multipart/form-data">
						<legend class="hide">운동 수정 폼</legend>
						<div class="table-box">
							<table class="admin-from-table">
								<caption>1분류(일반 재활),2차 분류(신체 부위), 운동 이름, 운동설명, 운동이미지</caption>
								<colgroup>
									<col style="width: 150px">
									<col style="width: auto">
								</colgroup>
								<tbody>
									<tr>
										<th>운동이름</th>
										<td>
											<div>
												<input type="hidden" name="id" value="${ex.id}">
												<input type="text" name="name" value="${ex.name}">
											</div>
										</td>
									</tr>
									<tr>
										<th>영문이름</th>
										<td>
											<div>
												<input type="text" name="eng-name" value="${ex.engName}">
											</div>
										</td>
									</tr>
									<tr>
										<th>항목</th>
										<td>
											<ul class="radio-list-box">

												<li>
													<input id="re" class="ex-menu" type="radio" name="category" value="1"  <c:if test ="${ex.categoryId == '1'}">checked</c:if>>
													<label for="re"> <span class="radio"></span> 재활 운동</label></li>
												<li>
													<input id="ex" class="ex-menu" type="radio" name="category" value="2" <c:if test ="${ex.categoryId == '2'}">checked</c:if>>
													<label for="ex"> <span class="radio"></span> 일반 운동</label>
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<th>운동 부위</th>
										<td>
											<!-- ex_con -->
											

											<div class="ex-con current">
										
												<ul class="check-list-box">														
												 	<li>
														<input id="re-list1" type="checkbox" name="body-part-re" value="1" <c:if test="${fn:contains(ebps, '0001')}">checked</c:if>>
														<label for="re-list1"> <span class="check"></span> 어깨</label>
													</li>
													
													<li>
														<input id="re-list2" type="checkbox" name="body-part-re" value="2" <c:if test="${fn:contains(ebps, '0004')}">checked</c:if>>
														<label for="re-list2"> <span class="check"></span> 허리</label>
													</li>
													<li>
														<input id="re-list3" type="checkbox" name="body-part-re" value="3" <c:if test="${fn:contains(ebps, '0010')}">checked</c:if>>
														<label for="re-list3"> <span class="check"></span> 목</label>
													</li>
													<li>
														<input id="re-list4" type="checkbox" name="body-part-re" value="4" <c:if test="${fn:contains(ebps, '0011')}">checked</c:if>>
														<label for="re-list4"> <span class="check"></span> 손목</label>
													</li>
													<li>
														<input id="re-list5" type="checkbox" name="body-part-re" value="5" <c:if test="${fn:contains(ebps, '0012')}">checked</c:if>>
														<label for="re-list5"> <span class="check"></span> 무릅</label>
													</li>
																						
												</ul>
											</div> 
											<!-- //ex_con -->
											<!-- ex_con -->
											<div class="ex-con">
												<ul class="check-list-box">
													<li>
														<input id="ex-list1" type="checkbox" name="body-part-ex" value="1" <c:if test="${fn:contains(ebps, '0001')}">checked</c:if>>
														<label for="ex-list1"> <span class="check"></span> 어깨</label>
													</li>
													<li>
														<input id="ex-list2" type="checkbox" name="body-part-ex" value="2" <c:if test="${fn:contains(ebps, '0002')}">checked</c:if>>
														<label for="ex-list2"> <span class="check"></span> 팔</label>
													</li>
													<li>
														<input id="ex-list3" type="checkbox" name="body-part-ex" value="3" <c:if test="${fn:contains(ebps, '003')}">checked</c:if>>
														<label for="ex-list3"> <span class="check"></span> 가슴</label>
													</li>
													<li>
														<input id="ex-list4" type="checkbox" name="body-part-ex" value="4" <c:if test="${fn:contains(ebps, '0004')}">checked</c:if>>
														<label for="ex-list4"> <span class="check"></span> 허리</label>
													</li>

													<li>
														<input id="ex-list5" type="checkbox" name="body-part-ex" value="5" <c:if test="${fn:contains(ebps, '0005')}">checked</c:if>>
														<label for="ex-list5"> <span class="check"></span> 복근</label>
													</li>

													<li>
														 <input id="ex-list6" type="checkbox" name="body-part-ex" value="6" <c:if test="${fn:contains(ebps, '0006')}">checked</c:if>>
														<label for="ex-list6"> <span class="check"></span> 등</label>
													</li>

													<li>
														<input id="ex-list7" type="checkbox" name="body-part-ex" value="7" <c:if test="${fn:contains(ebps, '0007')}">checked</c:if>>
														<label for="ex-list7"> <span class="check"></span> 허벅지</label>
													</li>

													<li>
														<input id="ex-list8" type="checkbox" name="body-part-ex" value="8" <c:if test="${fn:contains(ebps, '0008')}">checked</c:if>> 
														<label for="ex-list8"> <span class="check"></span> 엉덩이</label>
													</li>

													<li>
														<input id="ex-list9" type="checkbox" name="body-part-ex" value="9" <c:if test="${fn:contains(ebps, '0009')}">checked</c:if>>
														<label for="ex-list9"> <span class="check"></span> 전신</label>
													</li>
												</ul>
											</div> <!-- //ex_con -->

										</td>
									</tr>
									<tr>
										<th>설명</th>
										<td>
											<div class="area-box">
												 <textarea name="contents" id="" cols="30" rows="10">${ex.contents}</textarea>
											</div>
										</td>
									</tr>
									<tr>
										<th>추천 횟수(초)</th>
										<td>
											  <input type="text" name="recommend" value="${ex.recommend}">
										</td>
									</tr>
									<tr>
										<th>첨부파일</th>
										<td>
										
											<c:forEach var="file" items="${exFileList}">
		                                            <div
														class="attach-box-list">
														<div class="attach-box">
															<div class="attach-box-inner">
																<input class="attach-read only-name" type="text" title="첨부파일명 보기" name="file-name" value="${file.name}" readonly >
																<button class="attach-cancel-btn" type="button" onclick="fileInputDel();"><i class="xi-close-min"></i></button>
															</div>
														</div>
													</div>
											</c:forEach>
											
											<div class="file-form-add">
												<i class="xi-plus-min"></i>추가
											</div>
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
            let delBtn = document.querySelector('.del');
            delBtn.addEventListener('click', (e)=>{
            	e.preventDefault();
            	let delAnswer = confirm("정말로 삭제하시겠습니까?");
            	if(delAnswer == true){
            		// window.location = "./list";
                }else {
					return false;
                }
            });
            
            
            //수정버튼 클릭시
			let editBtn = document.querySelector('.edit');
            let editForm = document.querySelector('.edit-form');
            editBtn.addEventListener('click', (e)=>{
            	e.preventDefault();
            	editForm.method="POST";
            	editForm.submit();
            });
            
            
            //닫기버튼 클릭시
            let cancelBtn = document.querySelector('.cancel');
       		cancelBtn.addEventListener('click', (e)=>{
               e.preventDefault();
               let closeAnswer = confirm("정말로 닫으시겠습니까?");
               if(closeAnswer == true){
            	   window.location = "./detail?id=" + ${ex.id};
                	
               }else {
       				return false;
               } 
            });	
          
        });
      </script>
</body>
</html>