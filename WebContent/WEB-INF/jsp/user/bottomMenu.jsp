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
                <div class="bottom-btn chat-toggle circle pointer reveal">
                    <i class="xi-speech"></i>
                </div>
                <div class="bottom-btn top-scroll-btn circle pointer">
                    <div class="arrow">
                        <div></div>
                        <div></div>                    
                    </div>
                    <svg id="top-scroll" width="30" height="30" style="stroke-dashoffset: 95;">
                        <circle cx="15" cy="15" r="15"></circle>
                    </svg>
                </div>
            </div>
        </div>
        <script src="/js/user/bottomMenu.js"></script>
    	<!-- // 하단 메뉴 버튼 -->
    	
   		<!-- // 채팅 -->
        <div class="chat-container d-none">
            <div class="chat-inner">
            	<div class="chat">
                    <div class="chat-header-box">
                        <div class="chat-menu-button pointer"><i class=" xi-angle-left left"></i></div>
                        <div class="chat-other"><span class="other-name">테스트</span></div>
                        <div class="chat-menu-button pointer"><i class="chat-close-btn xi-close"></i></div>
                    </div>
                    <div class="chat-message-box">
                        <div class="other-message">상대</div>
                        <div class="my-message">내꺼</div>
                        <div class="my-message">내꺼</div>
                        <div class="my-message">내꺼</div>
                        <div class="other-message">상대</div>
                        <div class="other-message">상대</div>
                        <div class="other-message">상대</div>
                        <div class="my-message">내꺼</div>
                        <div class="other-message">상대</div>
                        <div class="other-message">상대</div>
                        <div class="my-message">내꺼</div>
                        <div class="my-message">내꺼</div>
                    </div>
                    <div class="chat-input-box">
                        <div class="chat-input">
                            <input type="text">
                        </div>
                        <div class="chat-send pointer"><i class="xi-send"></i></div>
                    </div>
            	</div>
            </div>
        </div>
        <script src="/js/chat.js"></script>
    	<!-- // 채팅 -->
    </div>
    <!-- // 하단 메뉴 -->