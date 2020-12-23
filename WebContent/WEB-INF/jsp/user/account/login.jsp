<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 로그인 -->
	<link rel="stylesheet" href="/css/user/account/accounts.css">
    <section class="account-container">
	    <form method="POST">
	        <div class="account-inner">
	            <div class="account-logo">
	                <div>
	                    <svg style="fill: transparent; overflow: unset;filter: drop-shadow( 1px 1px 2px #000000aa );" viewBox="0 0 44 40">
	                        
	                        <path fill="url(#logo-svg-color)" class="logo-svg-draw"  d="M37.28,15.99C26.85,11.19,16.36,6.53,5.93,1.72C1.5-0.34,0.46,2.43,0.44,4.92c-0.04,4.8-0.06,3-0.06,7.15
	                      c0,2.5,0.58,3.71,2.9,4.7c6.16,2.64,12.18,5.6,18.75,8.66c-5.8,2.72-11.07,5.19-16.83,7.9c0-3.28,0.05-6.09,0.05-8.89
	                      c0-2.95-2.69-4.49-3.83-3.68C0.38,21.5,0.5,23,0.5,24.21c0,6.81-0.07,7.94-0.06,11.91c0.01,2.91,0.68,4.48,4.14,2.87
	                      c10.95-5.09,21.99-9.97,32.99-14.94c1.86-0.84,4.49-2.11,4.49-3.65C42.07,18.15,39.34,16.94,37.28,15.99z M24.48,21.14
	                      c-5.33-2.52-10.66-5.04-16.07-7.37c-3.2-1.38-3.94-3.44-2.85-6.59c9.23,4.32,18.3,8.57,27.41,12.84
	                      C30.19,22.17,27.44,22.54,24.48,21.14z" />
	                    </svg>
	                </div>
	            </div>
	            <h1 class="d-none">로그인</h1>
	            <div class="account-header-text">
	                <svg viewBox="0 0 79.37 19.84" enable-background="new 0 0 79.37 19.84">
	                <defs>
	                    <linearGradient id="login-svg-color" x1="0%" y1="0%" x2="100%" y2="100%">
	                        <stop offset="0%" style="stop-color:#ff5fa2;stop-opacity:1"></stop>
	                        <stop offset="100%" style="stop-color:#fcc89b;stop-opacity:1"></stop>
	                    </linearGradient>
	                </defs> 
	                <g>
	                    <path fill="url(#login-svg-color)" class="login-svg-draw" d="M14.661,18.566H4.793V1.317h3.34v14.484h6.527V18.566z"/>
	                    <path fill="url(#login-svg-color)" class="login-svg-draw" d="M15.329,10.165c0-2.711,0.779-4.91,2.338-6.598s3.631-2.531,6.217-2.531c2.453,0,4.428,0.818,5.924,2.455
	                        s2.244,3.736,2.244,6.299c0,2.703-0.771,4.892-2.314,6.568s-3.584,2.514-6.123,2.514c-2.469,0-4.467-0.816-5.994-2.449
	                        S15.329,12.703,15.329,10.165z M18.844,9.977c0,1.75,0.432,3.185,1.295,4.306s2.037,1.682,3.521,1.682
	                        c1.539,0,2.736-0.533,3.592-1.6s1.283-2.514,1.283-4.341c0-1.883-0.414-3.367-1.242-4.453s-2-1.629-3.516-1.629
	                        c-1.531,0-2.736,0.568-3.615,1.705S18.844,8.227,18.844,9.977z"/>
	                    <path fill="url(#login-svg-color)" class="login-svg-draw" d="M48.844,17.395c-1.695,0.984-3.742,1.477-6.141,1.477c-2.671,0-4.796-0.775-6.375-2.326s-2.367-3.662-2.367-6.333
	                        c0-2.688,0.859-4.889,2.578-6.604s3.992-2.572,6.82-2.572c1.844,0,3.445,0.266,4.805,0.797v3.246
	                        c-1.328-0.805-2.961-1.207-4.898-1.207c-1.711,0-3.103,0.564-4.177,1.693s-1.611,2.619-1.611,4.471c0,1.89,0.484,3.361,1.453,4.412
	                        s2.296,1.576,3.984,1.576c1.031,0,1.891-0.168,2.578-0.504v-3.809h-3.539V8.993h6.891V17.395z"/>
	                    <path fill="url(#login-svg-color)" class="login-svg-draw" d="M55.711,1.317v17.25h-3.34V1.317H55.711z"/>
	                    <path fill="url(#login-svg-color)" class="login-svg-draw" d="M74.859,18.566h-3.492L63.738,6.883c-0.313-0.477-0.57-0.922-0.773-1.336h-0.047c0.063,0.547,0.094,1.438,0.094,2.672
	                        v10.347h-3.188V1.317h3.727l7.359,11.378c0.375,0.578,0.648,1.023,0.82,1.336h0.047c-0.063-0.305-0.094-1.109-0.094-2.414v-10.3
	                        h3.176V18.566z"/>
	                </g>
	                </svg>
	            </div>
	            <div>
	                <input required type="email" id="userEmail" name="userEmail" class="user-info"/>
	                <label for="userId" class="input-label">이메일</label>
	                <div class="input-msg error-msg"></div>
	            </div>

	            <div>
	                <input required type="password" id="userPwd" name="pwd" class="user-info"/>
	                <label for="userPwd" class="input-label">비밀번호</label>
	                <div class="input-msg error-msg"></div>
	            </div>
                <input required type="hidden" name="return-url" value="${returnUrl}"/>
	            
	            <input type="submit" id="login-submit-btn" class="submit-btn" value="로그인">
	            <div class="recovery"><span><a href="/account/recoveryEmail.html">이메일</a></span> / <span><a href="/account/recoveryPwd.html">비밀번호</a> 찾기</span></div>
	
	            <div id="signup-btn" class="account-btn"><a href="/account/signUp.html">회원가입</a></div>
	        </div>
	    </form>
	</section>
	<script src="/js/user/account/loginListener.js"></script>
    <!-- // 로그인 -->