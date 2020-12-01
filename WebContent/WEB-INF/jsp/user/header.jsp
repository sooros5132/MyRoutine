<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 헤더 -->
    <header class="header">
        <div class="container header-container">
            <h1 class="d-none">헤더메뉴</h1>
            <section class="logo">
                <h1 class="d-none">로고</h1>
                <a href="/">
                    <svg style="fill:#28B49B; overflow: unset;filter: drop-shadow( 1px 1px 2px #333);" viewBox="0 0 44 40">
                        <path d="M37.28,15.99C26.85,11.19,16.36,6.53,5.93,1.72C1.5-0.34,0.46,2.43,0.44,4.92c-0.04,4.8-0.06,3-0.06,7.15
                      c0,2.5,0.58,3.71,2.9,4.7c6.16,2.64,12.18,5.6,18.75,8.66c-5.8,2.72-11.07,5.19-16.83,7.9c0-3.28,0.05-6.09,0.05-8.89
                      c0-2.95-2.69-4.49-3.83-3.68C0.38,21.5,0.5,23,0.5,24.21c0,6.81-0.07,7.94-0.06,11.91c0.01,2.91,0.68,4.48,4.14,2.87
                      c10.95-5.09,21.99-9.97,32.99-14.94c1.86-0.84,4.49-2.11,4.49-3.65C42.07,18.15,39.34,16.94,37.28,15.99z M24.48,21.14
                      c-5.33-2.52-10.66-5.04-16.07-7.37c-3.2-1.38-3.94-3.44-2.85-6.59c9.23,4.32,18.3,8.57,27.41,12.84
                      C30.19,22.17,27.44,22.54,24.48,21.14z" />
                    </svg>
                </a>
            </section>
            <nav class="main-menu-container">
                <h1 class="d-none">메인메뉴</h1>
                <ul>
                    <li><div onclick="loader()"><a>로딩1</a></div></li>
                    <li><div onclick="loader2()"><a>로딩2</a></div></li>
                    <li><div onclick="loader3()"><a>로딩바</a></div></li>
                    <li><div class="alert-btn"><a>알림창</a></div></li>
                    <li><div onclick="document.querySelector('.alert-close').click()"><a>알림 닫기</a></div></li>
                </ul>
            </nav>
            <section class="member-container">
                <h1 class="d-none">회원 메뉴</h1>
                <ul>
                    <li><div><a class="login-btn"href="/account/signUp.html">회원가입</a></div></li>
                    <!-- <li><div><a>로그아웃</a></div></li> -->
                </ul>
            </section>
            <section class="mobile-menu-open">
                <h1 class="d-none">메뉴 열기 버튼</h1>
                <div>
                    <ul class="menu-open-btn">
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
            </section>
        </div>
    </header>
    <link rel="stylesheet" href="/css/user/header.css">
    <!-- // 헤더 -->