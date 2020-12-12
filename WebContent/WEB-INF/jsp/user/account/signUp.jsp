<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="account-container">
    <form method="POST">
    <%--
    <form method="POST" action="/account/put">
    /account/signUp에서 모두 처리하게 바뀜.
    --%>
        <div class="account-inner">
            <h1>회원가입</h1>

            <div>
                <input required name="email" type="email" id="userEmail" class="user-info"/>
                <div class="input-label">이메일</div>
                <div class="input-msg error-msg"></div>
            </div>
            
            <div>
                <input required name="name" type="text" id="userName" class="user-info"/>
                <div class="input-label">이름</div>
                <div class="input-msg error-msg"></div>
            </div>

            <div>
                <input required name="nickname" type="text" id="userNickname" class="user-info"/>
                <div class="input-label">닉네임</div>
                <div class="input-msg error-msg"></div>
            </div>
            
            <div>
                <input required name="pwd" type="password" id="userPwd" class="user-info"/>
                <div class="input-label">비밀번호</div>
                <div class="input-msg error-msg"></div>
            </div>
            
            <div>
                <input required name="userPwdChk" type="password" id="userPwdChk" class="user-info"/>
                <div class="input-label">비밀번호 확인</div>
                <div class="input-msg error-msg"></div>
            </div>

            <input type="submit" id="signup-submit-btn" class="submit-btn" value="가입">
        </div>
    </form>
</div>
<script src="/js/user/account/signupListener.js"></script>