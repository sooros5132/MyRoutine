<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 하단 메뉴 -->
    <link rel="stylesheet" href="/css/user/alert.css">
    <link rel="stylesheet" href="/css/user/bottom-menu.css">
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
            <div class="bottom-btn top-scroll-btn circle">
                <div class="arrow">
                    <div></div>
                    <div></div>                    
                </div>
                <svg id="top-scroll" width="30" height="30" style="stroke-dashoffset: 95;">
                    <circle cx="15" cy="15" r="15"></circle>
                </svg>
            </div>
        </div>
        <script src="/js/user/topScroll.js"></script>
    	<!-- // 하단 메뉴 버튼 -->
    </div>
    <!-- // 하단 메뉴 -->