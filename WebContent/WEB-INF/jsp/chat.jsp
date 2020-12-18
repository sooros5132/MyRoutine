<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<link rel="stylesheet" href="/css/chat.css">
		<div class="chat-container d-none">
            <div class="chat-inner">
            	<div class="chat">
                    <div class="chat-header-box">
                        <div class="chat-menu-button pointer chat-header-left-btn"><i class="xi-user-plus"></i></div>
                        <div class="chat-header-state"><span class="chat-header-text">친구 목록</span></div>
                        <div class="chat-menu-button pointer chat-header-right-btn"><i class="xi-close"></i></div>
                    </div>
                    <div class="chat-message-box d-none">
                    	<div class="chat-message-inner chat-content-box">
	                        <!-- <div class="other-message">상대</div>
	                        <div class="my-message">내꺼</div> -->
                        </div>
                    </div>
                    <div class="chat-send-box chat-input-box d-none">
                    	<div class="chat-input-inner">
	                        <div class="chat-input"><input type="text" name="content" class="message-input"></div>
                        	<div class="chat-send-btn chat-input-btn pointer"><i class="xi-send"></i></div>
                        </div>
                    </div>
                    <div class="chat-friend-box">
                    	<ul class="my-friend-list chat-friend-list">
                    		<div style="height: 100%;">불러오는중입니다</div>
                    	</ul>
                    </div>
                    <div class="chat-friend-search d-none">
                    	<div class="chat-friend-search-inner chat-content-box">
                    		<ul class="search-friend-list chat-friend-list">
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    			<li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="add-friend-btn"><i class="xi-plus"></i></div>
                    			</li>
                    		</ul>
                    		<div style="height: 100%;color: white;text-align: center;padding-top: 40px;">닉네임으로 검색해주세요</div>
                    	</div>
                    </div>
                   	<div class="friend-search-input-box chat-input-box d-none">
                   		<div class="chat-input-inner">
	                        <div class="chat-input"><input type="text" name="nickname" class="friend-search-input"></div>
	                       	<div class="friend-search-btn chat-input-btn pointer"><i class="xi-search"></i></div>
                       	</div>
                   	</div>
            	</div>
            </div>
        </div>
        <script src="/js/chat.js"></script>