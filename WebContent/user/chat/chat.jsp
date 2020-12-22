<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이루틴 채팅</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=5.0, user-scalable=no">
<link rel="stylesheet" href="css/user/reset.css">
<link rel="stylesheet" href="css/user/common.css">
</head>
<body>
	<!-- 채팅 -->
	<jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp" />
   	<!-- // 채팅 -->
   	<style>
   		html, body{
   			background: rgb(36, 37, 38);
   		}
	    .chat-container .chat .chat-inner{
	        position: fixed;
	        top: 0;
	        right: 0;
	        width: 100%;
	        min-width: 300px;
	        padding-top: 0;
	        --height: calc(100% - 40px);
	        height: 100%;
	        background-color:rgb(36, 37, 38);
	        border-radius: 0;
	        box-shadow: none;
	        --z-index: 1;
	    }
   	</style>
   	<script>

	// 하단 메뉴 메시지 버튼 ==================================================
		let chatToggleBtn = document.querySelector(".chat-toggle-btn");
		
		window.addEventListener("load", (e)=>{
			chatToggleBtn.click();
		})
   	</script>
</body>
</html>