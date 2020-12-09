<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이루틴</title>
    <link rel="stylesheet" href="../../css/admin/reset.css">
    <link rel="stylesheet" href="../../css/admin/common.css">
    <link rel="stylesheet" href="../../css/xeicon.min.css">
    <link rel="stylesheet" href="../../css/admin/notice/reg.css">

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
                    <li><a href="#"><i class="xi-group"></i>회원 관리</a></li>
                    <li><a href="#"><i class="xi-forum"></i>커뮤니티 관리</a></li>
                    <li><a href="#" class="active"><i class="xi-comment"></i>공지사항 관리</a></li>
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
                <h1>글 쓰기</h1>

                <section>

                    <form method="post">
                        <fieldset>
                            <table>
                                <colgroup>
                                    <col style="width: 150px;">
                                    <col style="width:auto">
                                </colgroup>

                                <tr>
                                    <th>제목</th>
                                    <td>
                                        <input type="text" name="title" autofocus placeholder="20자 이내로 작성하시오" list="name" required>
                                    </td>

                                    <datalist id="name">

                                        <option value="공지사항"></option>
                                        <option value="이벤트"></option>
                                        <option value="갤러리 자료실"></option>
                                        <option value="공지사항2"></option>
                                    </datalist>


                                </tr>

                                <tr>
                                    <th>공개여부</th>
                                    <td class="radio-list-box">


                                        <input id="re" class="ex-menu" type="radio" name="ex-menu" value="re" checked>
                                        <label for="re">
                                            <span class="radio"></span>
                                            공개</label>



                                        <input id="ex" class="ex-menu" type="radio" name="ex-menu" value="ex">
                                        <label for="ex">
                                            <span class="radio"></span>
                                            비공개</label>



                                    </td>
                                </tr>
                                <tr class="write">
                                    <th class="list">내용</th>
                                    <td>
                                        <textarea class="content-text" name="content" id="" cols="30" rows="10"> </textarea>

                                    </td>


                                </tr>


                                <tr>
                                    <th>파일첨부</th>
                                    <td>
                                        <div class="attach-box-list">
                                            <div class="attach-box">
                                                <input class="attach-input" type="file">
                                                <div class="attach-box-inner">
                                                    <button class="attach-btn" type="button"
                                                        onclick="fileInputClick();">파일선택</button>
                                                    <input class="attach-read" type="text" title="첨부파일명 보기" readonly
                                                        value="">
                                                    <button class="attach-cancel-btn" type="button"
                                                        onclick="fileInputDel();"><i class="xi-close-min"></i></button>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="file-form-add"><i class="xi-plus-min"></i>추가</div>
                                    </td>

                                    <!-- <td> <input class="subtext" type="text">
                                        <input class="subtext2" type="file" value="찾아보기"> </td> -->
                                </tr>


                            </table>
                        </fieldset>

                        <div class="btn-box">
                         <input class="btn" type="submit" value="등록"  style="height:46px;">
                           
                            <button class="btn cancel">닫기</button>
                        </div>

                    </form>
                </section>

                <template class='attach-template'>
                    <div class="attach-box">
                        <input class="attach-input" type="file">
                        <div class="attach-box-inner">
                            <button class="attach-btn" type="button" onclick="fileInputClick();">파일선택</button>
                            <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="">
                            <button class="attach-cancel-btn" type="button" onclick="fileInputDel();"><i
                                    class="xi-close-min"></i></button>
                        </div>
                    </div>
                </template>



            </main>
            <!-- //main(개별 컨턴츠 넣는곳) -->
        </div>

        <!-- footer -->
        <footer class="footer">
            <span>ⓒ 마이 루틴</span>
        </footer>
        <!-- //footer -->
        <script src="../../js/admin.js"></script>
    </div>
</body>

</html>