<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="account-container">
    <form method="POST">
        <div class="account-inner">
            <h1>비밀번호 찾기</h1>
            <div>
                <input required type="email" id="userEmail" name="userEmail" class="user-info"/>
                <div class="input-label">이메일</div>
                <div class="error-msg"></div>
            </div>

            <!--
            <div>
                <input type="password" id="userPwd" class="user-info"/>
                <div class="input-label">비밀번호</div>
                <div class="error-msg"></div>
            </div>
            -->
            <input type="submit" id="forget-pwd-submit-btn" class="submit-btn" value="비밀번호 찾기">
        </div>
    </form>
</div>
<script src="/js/user/account/accountListener.js"></script>