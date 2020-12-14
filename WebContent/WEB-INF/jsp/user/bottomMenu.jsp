<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 하단 메뉴 -->
    <link rel="stylesheet" href="/css/user/alert.css">
    <link rel="stylesheet" href="/css/user/bottomMenu.css">
    <link rel="stylesheet" href="/css/user/chat.css">
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
        <div class="chat-container d-none">
            <div class="chat-inner">
            	<div class="chat">
                    <div class="chat-header-box">
                        <div class="chat-menu-button pointer"><i class=" xi-angle-left left"></i></div>
                        <div class="chat-header-state"><span class="chat-header-text">친구목록</span></div>
                        <div class="chat-menu-button pointer"><i class="chat-close-btn xi-close"></i></div>
                    </div>
                    <div class="chat-message-box d-none">
                    	<div class="chat-message-inner">
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
                    </div>
                    <div class="chat-input-box d-none">
                    	<div class="chat-input-inner">
	                        <div class="chat-input">
	                            <input type="text">
	                        </div>
                        	<div class="chat-send pointer"><i class="xi-send"></i></div>
                        </div>
                    </div>
                    <div class="chat-friend-box chat-friend-list">
                    	<div class="chat-friend-inner">
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이1</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이2</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이3</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이4</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이5</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이6</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이7</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이8</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이9</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이10</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이11</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이12</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이13</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이14</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이15</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이16</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이17</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이18</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이19</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이20</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이21</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이22</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이23</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이24</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이25</div></div>
                    		<div><div class="profile-image"><img src=""></div><div class="friend-nickname">퉁퉁이26</div></div>
                    	</div>
                    </div>
            	</div>
            </div>
        </div>
        <script src="/js/user/chat.js"></script>
    	<!-- // 채팅 -->
    </div>
    <!-- // 하단 메뉴 -->