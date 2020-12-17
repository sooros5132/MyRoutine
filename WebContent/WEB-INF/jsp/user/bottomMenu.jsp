<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 하단 메뉴 -->
    <link rel="stylesheet" href="/css/user/alert.css">
    <link rel="stylesheet" href="/css/user/bottomMenu.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/xeicon.min.css">
    <div class="bottom-container">
        <!-- 알림창 -->
        <!-- 
        alertOpen({
            setText: 알림 텍스트 String,
            activeTime: 지속 시간 Number,
            alertColor: 색상
        }); 
        -->
        <div class="alert-node">
            <div class="alert-node-bar"></div>
            <div class="alert-node-inner">
                <div class="alert-text">텍스트</div>
                <div class="alert-close">
                    <div class="bar1"></div>
                    <div class="bar2"></div>
                </div>
            </div>
        </div>
        <script src="/js/user/alert.js"></script>
        <!-- // 알림창 -->

   		<!-- // 하단 메뉴 버튼 -->
        <div class="bottom-menu">
            <div class="bottom-menu-inner">
                <div class="bottom-btn chat-toggle-btn circle pointer reveal">
                    <i class="xi-speech"></i>
                </div>
                <div class="bottom-btn top-scroll-btn circle pointer">
                    <div class="arrow">
                        <div></div>
                        <div></div>                    
                    </div>
                    <svg id="top-scroll" width="40" height="40" style="stroke-dashoffset: 125;">
                        <circle cx="20" cy="20" r="20"></circle>
                    </svg>
                </div>
            </div>
        </div>
        <script src="/js/user/bottomMenu.js"></script>
    	<!-- // 하단 메뉴 버튼 -->
    	
   		<!-- // 채팅 -->
		<jsp:include page="/WEB-INF/jsp/chat.jsp" />
    	<!-- // 채팅 -->
    </div>
    <!-- // 하단 메뉴 -->