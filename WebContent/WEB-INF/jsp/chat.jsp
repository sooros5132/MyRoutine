<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<link rel="stylesheet" href="/css/chat.css">
		<div class="chat-container d-none">
            <div class="chat-inner">
            	<div class="chat">
                    <div class="chat-header-box">
                        <div class="chat-menu-button pointer hide"><i class=" xi-angle-left left"></i></div>
                        <div class="chat-header-state"><span class="chat-header-text">친구목록</span></div>
                        <div class="chat-menu-button pointer"><i class="chat-close-btn xi-close"></i></div>
                    </div>
                    <div class="chat-message-box d-none">
                    	<div class="chat-message-inner">
	                        <!-- <div class="other-message">상대</div>
	                        <div class="my-message">내꺼</div> -->
                        </div>
                    </div>
                    <div class="chat-input-box d-none">
                    	<div class="chat-input-inner">
	                        <div class="chat-input">
	                            <input type="text" name="content" class="send-message">
	                        </div>
                        	<div class="chat-send pointer"><i class="xi-send"></i></div>
                        </div>
                    </div>
                    <div class="chat-friend-box chat-friend-list">
                    	<div class="chat-friend-inner">
                    	<div style="height: 100%;">불러오는중입니다</div>
                    	</div>
                    </div>
            	</div>
            </div>
        </div>
        <script src="/js/chat.js"></script>