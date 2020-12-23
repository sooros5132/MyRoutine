<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

            <aside class="aside">
                <nav class="snb">
                    <!-- <h2>서브메뉴</h2> -->
                    <ul class="dep1">
                        <!-- 하위 메뉴가 있으면 li태그에 data-type:true 넣어주세요 -->
                       <li data-type="true">
                            <a href="#">커뮤니티 관리</a>
                            <ul class="dep2">
                                <li><a href="../community/list">커뮤니티 리스트</a></li>
                                <li><a href="../community/report/list">커뮤니티신고 리스트</a></li>
                                <li><a href="../community/report/comment/list">커뮤니티댓글신고 리스트</a></li>                                
                            </ul>
                        </li>
<!--                         <li data-type="true"> -->
<!--                             <a href="#">건의사항 관리</a> -->
<!--                             <ul class="dep2"> -->
<!--                                 <li><a href="../complain/list">건의사항 리스트</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->

                    </ul>
                </nav>
       </aside>

</body>
</html>