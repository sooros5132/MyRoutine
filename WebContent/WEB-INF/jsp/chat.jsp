<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<link rel="stylesheet" href="/css/chat.css">
		<div class="chat-container d-none">
           	<div class="chat">
            	<div class="chat-inner">
		          	<div class="friend-add-confirm confirm-container position-absolute position-center d-none">
						<div class="confirm-inner position-absolute position-center">
							<div class="confirm-text-box"></div>
							<div class="confirm-btn-box">
								<div class="confirm-no-btn confirm-btn pointer">취소</div>
								<div class="confirm-yes-btn confirm-btn pointer main-background">확인</div>
								<div class="confirm-ok-btn confirm-btn pointer main-background d-none">확인</div>
							</div>
						</div>
					</div>
                    <div class="chat-header-box chat-top-style">
                        <div class="chat-menu-button pointer chat-header-left-btn"><i class="xi-user-plus"></i></div>
                        <div class="chat-header-state"><span class="chat-header-text">친구 목록</span></div>
                        <div class="chat-menu-button pointer chat-header-right-btn"><i class="xi-close"></i></div>
                    </div>
                    <div class="chat-top-alert-box chat-top-style pointer smaller">
                    	<div class="top-alert-btn chat-input-btn pointer hide"><i class="xi-arrow-right"></i></div>
                    	<div class="top-alert-text">친구 요청이 있습니다</div>
                    	<div class="top-alert-btn chat-input-btn pointer"><i class="xi-arrow-right"></i></div>
                    </div>
                    <div class="chat-message-box d-none">
                    	<div class="chat-message-inner chat-content-box">
                        </div>
                    </div>
                    <div class="chat-send-box chat-input-box d-none">
                    	<div div class="upload-container d-none">
	                    	<div class="upload-list">
	                    		<div class="upload-btn chat-input-btn pointer"><i class="xi-arrow-up"></i></div>
	                    		<div class="file-names nowrap"></div>
	                   		</div>
                    	</div>
                    	<div class="chat-input-inner">
                        	<label class="chat-file-btn chat-input-btn pointer" for="send-file">
	                        	<i class="xi-paperclip"></i>
	                        	<input type="file" name="files" style="display:none" id="send-file" class="send-file" multiple>
                        	</label>
                        	<!-- <form enctype="multipart/form-data" method="POST" id="upload-form"><input type="file" name="files" style="display:none" id="send-file" class="send-file" multiple></form> -->
	                        <div class="chat-input"><input type="text" name="content" autocomplete="off" class="message-input" placeholder="내용"></div>
                        	<div class="chat-send-btn chat-input-btn pointer"><i class="xi-send"></i></div>
                        </div>
                    </div>
                    <div class="my-friend-box friend-box-style">
                    	<ul class="my-friend-list chat-friend-list max-width">
                    	</ul>
                    </div>
                    <div class="new-friend-box friend-box-style d-none">
                    	<ul class="new-friend-list chat-friend-list max-width">
                    	</ul>
                    </div>
                    <div class="chat-friend-search d-none">
                    	<div class="chat-friend-search-inner chat-content-box">
                    		<ul class="search-friend-list chat-friend-list max-width">
                    			<%-- <li class="friend-search-result">
                    				<div class="profile-image"><img src=""></div>
                    				<div class="friend-nickname">퉁퉁이</div>
                    				<div class="action-friend-btn"><i class="xi-plus"></i></div>
                    			</li> --%>
                    		</ul>
                    	</div>
                    </div>
                   	<div class="friend-search-input-box chat-input-box d-none">
                   		<div class="chat-input-inner">
	                        <div class="chat-input"><input class="friend-search-input" type="text" name="nickname" placeholder="닉네임"></div>
	                       	<div class="friend-search-btn chat-input-btn pointer"><i class="xi-search"></i></div>
                       	</div>
                   	</div>
            	</div>
            </div>
        </div>
        <script src="/js/chat.js"></script>