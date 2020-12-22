<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script src="../../js/admin_common.js"></script>
    
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
                    <li><a href="#"><i class="xi-presentation"></i>건의사항 관리</a></li>
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
                        <li><a href="https:\\www.naver.com">재활관리</li>
                        <li><a href="https:\\www.naver.com">홈트레이닝관리</a></li>
                    </ul>
                </nav>
            </aside>
            <!-- //aside -->

            <!-- main(개별 컨턴츠 넣는곳) -->
            <main class="main">
                 <!-- section -->
                 <section>
                     <h2 class="con-tit">운동 등록</h2>
                    <form class="add-form" action="add" method="POST" enctype="multipart/form-data">
                        <legend class="hide">운동 등록 폼</legend>
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
                                                <input type="text" name="name">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>영문이름</th>
                                        <td>
                                            <div>
                                                <input type="text" name="eng-name">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>항목</th>
                                        <td>
                                            <ul class="radio-list-box">
                                               	<li>
                                               	<input id="re" class="ex-menu" type="radio" name="category" value="1" checked>
                                                    <label for="re">
                                                        <span class="radio"></span>
                                                        재활 운동
                                                    </label>
                                                </li>
                                                <li>
                                                    <input id="ex" class="ex-menu" type="radio"  name="category" value="2">
                                                    <label for="ex">
                                                        <span class="radio"></span>
                                                        일반 운동
                                                    </label>
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
                                                        <input id="re-list1" type="checkbox" name="body-part-re" value="1" checked>
                                                        <label for="re-list1">
                                                            <span class="check"></span>
                                                           	목
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list2" type="checkbox" name="body-part-re" value="2">
                                                        <label for="re-list2">
                                                            <span class="check"></span>
                                                           	어깨
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list3" type="checkbox" name="body-part-re" value="3">
                                                        <label for="re-list3">
                                                            <span class="check"></span>
                                                            팔
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list4" type="checkbox" name="body-part-re" value="4">
                                                        <label for="re-list4">
                                                            <span class="check"></span>
                                                            허리
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list5" type="checkbox" name="body-part-re" value="5">
                                                        <label for="re-list5">
                                                            <span class="check"></span>
                                                            허벅지
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list6" type="checkbox" name="body-part-re" value="6">
                                                        <label for="re-list6">
                                                            <span class="check"></span>
                                                            무릅
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list7" type="checkbox" name="body-part-re" value="7">
                                                        <label for="re-list7">
                                                            <span class="check"></span>
                                                            발목
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list8" type="checkbox" name="body-part-re" value="8">
                                                        <label for="re-list8">
                                                            <span class="check"></span>
                                                           	등
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list9" type="checkbox" name="body-part-re" value="9">
                                                        <label for="re-list9">
                                                            <span class="check"></span>
                                                           	엉덩이
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="re-list10" type="checkbox" name="body-part-re" value="10">
                                                        <label for="re-list10">
                                                            <span class="check"></span>
                                                            뒷허벅지
                                                        </label>
                                                    </li>
                                                    <li>
                                                       <input id="re-list11" type="checkbox" name="body-part-re" value="15">
                                                       <label for="re-list11">
                                                           <span class="check"></span>
                                                           손목
                                                       </label>
                                                   </li>
                                                </ul>
                                            </div>
                                            <!-- //ex_con -->
                                            <!-- ex_con -->
                                            <div class="ex-con">
                                                <ul class="check-list-box">
                                                    <li>
                                                        <input id="ex-list1" type="checkbox" name="body-part-ex" value="1" checked>
                                                        <label for="ex-list1">
                                                            <span class="check"></span>
                                                            목
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="ex-list2" type="checkbox" name="body-part-ex" value="2">
                                                        <label for="ex-list2">
                                                            <span class="check"></span>
                                                            어깨
                                                        </label>
                                                    </li>
                                                    <li>
                                                        <input id="ex-list3" type="checkbox" name="body-part-ex" value="11">
                                                        <label for="ex-list3">
                                                            <span class="check"></span>
                                                           	가슴
                                                        </label>
                                                    </li>
													  <li>
                                                        <input id="ex-list4" type="checkbox" name="body-part-ex" value="12">
                                                        <label for="ex-list4">
                                                            <span class="check"></span>
                                                           	배
                                                        </label>
                                                    </li>
													
													  <li>
                                                        <input id="ex-list5" type="checkbox" name="body-part-ex" value="4">
                                                        <label for="ex-list5">
                                                            <span class="check"></span>
                                                           	허리
                                                        </label>
                                                    </li>
													
													  <li>
                                                        <input id="ex-list6" type="checkbox" name="body-part-ex" value="5">
                                                        <label for="ex-list6">
                                                            <span class="check"></span>
                                                           	허벅지
                                                        </label>
                                                    </li>
													
													  <li>
                                                        <input id="ex-list7" type="checkbox" name="body-part-ex" value="6">
                                                        <label for="ex-list7">
                                                            <span class="check"></span>
                                                           	무릅
                                                        </label>
                                                    </li>
													
													  <li>
                                                        <input id="ex-list8" type="checkbox" name="body-part-ex" value="7">
                                                        <label for="ex-list8">
                                                            <span class="check"></span>
                                                           	발목
                                                        </label>
                                                    </li>
													
													  <li>
                                                        <input id="ex-list9" type="checkbox" name="body-part-ex" value="8">
                                                        <label for="ex-list9">
                                                            <span class="check"></span>
                                                           	등
                                                        </label>
                                                    </li>
                                                     <li>
                                                        <input id="ex-list10" type="checkbox" name="body-part-ex" value="9">
                                                        <label for="ex-list10">
                                                            <span class="check"></span>
                                                           	엉덩이
                                                        </label>
                                                    </li>
                                                     <li>
                                                        <input id="ex-list11" type="checkbox" name="body-part-ex" value="10">
                                                        <label for="ex-list11">
                                                            <span class="check"></span>
                                                           	뒷허벅지
                                                        </label>
                                                    </li>
                                                    <li>
                                                       <input id="ex-list12" type="checkbox" name="body-part-ex" value="13">
                                                       <label for="ex-list12">
                                                           <span class="check"></span>
                                                          	종아리
                                                       </label>
                                                   </li>
                                                   <li>
                                                       <input id="ex-list13" type="checkbox" name="body-part-ex" value="14">
                                                       <label for="ex-list13">
                                                           <span class="check"></span>
                                                          	전신
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
                                                <textarea name="contents" id="" cols="30" rows="10"></textarea>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>추천 횟수(초)</th>
                                        <td>
                                            <input type="text" name="recommend">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>첨부파일</th>
                                        <td>
                                            <div class="attach-box-list">
                                                <div class="attach-box">
                                                    <input class="attach-input" type="file" name="file" accept="image/*">
                                                    <div class="attach-box-inner">
                                                        <button class="attach-btn" type="button" onclick ="fileInputClick();">파일선택</button>
                                                        <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="">
                                                        <button class="attach-cancel-btn" type="button" onclick="fileInputDel();"><i class="xi-close-min"></i></button>
                                                    </div>
                                                </div>
                                                <!-- <div class="attach-box">
                                                    <input class="attach-input" type="file">
                                                    <div class="attach-box-inner">
                                                        <button class="attach-btn" type="button" >파일선택</button>
                                                        <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="aaaaaaaaaa.jpg">
                                                        <button class="attach-cancel-btn" type="button"><i class="xi-close-min"></i></button>
                                                    </div>
                                                </div> -->
                                            </div>
                                            <div class="file-form-add"><i class="xi-plus-min"></i>추가</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="btn-box">
                            <button class="btn add">등록</button>
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
            //등록버튼 클릭시
            let btn = document.querySelector(".btn.add");
            let addForm = document.querySelector(".add-form");
            let isChecked = false;
           
            btn.addEventListener('click', (e)=>{
                e.preventDefault();
                console.log("aaaa");
                isChecked = formCheck();
                console.log(isChecked +"isChecked" )
                if(isChecked == true){
                	console.log("gogo`")
                    addForm.method="POST";
                    addForm.submit();
                }
            })
            
            //(첨부파일 제외하고) 폼 비었는지 확인 
            function formCheck(){
                let exName = document.querySelector('input[name=name]');
                
                let exEngName = document.querySelector('input[name=eng-name]');
                
                let category = document.querySelector('input[name=category]:checked');

     
                
                let contents = document.querySelector('textarea[name=contents]');
                let recommend = document.querySelector('input[name=recommend]');

                if(exName.value.trim()==''){
                    alert('운동이름이 비어있습니다.\n운동이름을 입력해 주세요');
                    exName.focus();
                    return false;
                }
                if(category.getAttribute('value') == '1'){
                    let reList = document.querySelectorAll('input[name=body-part-re]:checked');
                    if(reList.length <= 0){
                        console.log(reList.length);
                        alert('재활 운동 부위를 1개 이상 선택해 주세요.');
                        return false;
                    } 
                }else if(category.getAttribute('value') == '2'){
                    let exList = document.querySelectorAll('input[name=body-part-ex]:checked');
                    if(exList.length <= 0){
                        console.log(exList.length);
                        alert('일반 운동 부위를 1개 이상 선택해 주세요.');
                        return false;
                    } 
                }

                if(contents.value.trim()==''){
                    alert('설명이 비어있습니다,\n운동 설명을 입력해 주세요.');
                    contents.focus();
                    return false;
                }
                if(recommend.value.trim()==''){
                    alert('추천횟수가 비어있습니다.\n추천횟수를 입력해 주세요.');
                    recommend.focus();
                    return false;
                }
                
                return true;
            }
        });
    </script>
<!-- 	<script>
        window.addEventListener('load', ()=>{
            //등록버튼 클릭시
            let btn = document.querySelector(".btn");
            let addForm = document.querySelector(".add-form");
            btn.addEventListener('click', (e)=>{
                e.preventDefault();
                addForm.method="POST";
                addForm.submit();
            })
        });
    </script> -->
</body>
</html>