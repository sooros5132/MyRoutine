<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" style="min-width: 300px;">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=5.0, user-scalable=no">
    <title>마이루틴</title>
    <link rel="stylesheet" href="css/user/reset.css">
    <link rel="stylesheet" href="css/user/common.css">
    
    <link rel="stylesheet" href="css/user/svg.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/user/header.jsp" />
	<!-- 바디 -->
    <div class="body">
        <h1 class="d-none">메인 바디</h1>
        <section>
            <h1 class="d-none">배경영상</h1>
            <div style="width: 100%; font-size: 0;">
                <!-- <iframe class="main-video" style="width: 1200px; height: 675px;" src="https://www.youtube.com/embed/9B1U3O8G7Bo?controls=0&autoplay=1&loop=1&disablekb=1&" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
                <!-- <iframe class="main-video" style="width:100%" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
                <iframe class="main-video" style="width:100%" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </section>
        <div style="min-height: 1000px; padding: 70px 0; background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);">
            <div style="margin: 50px 10px;">
            	<div class="border-decoration account-inner" style="min-width: 100px; max-width: 400px;background:#ffffff; margin: 0 auto;text-align:center;padding:50px 20px;">
	            	<span style="font-size: 20px; font-weight: bold;">새로운 기능</span>
	            	<br>
	            	<br>
		            <a href="/account/signUp">/account/signUp<br>에서 가입 가능</a>
		            <br>
		            <br>
		            <br>
		            <a href="/admin/member/list">회원관리 구경하러 가자~</a>
		            <br>
		            <br>
		            <br>
		            <span onclick="document.querySelector('.chat-toggle-btn').click()"><i class="xi-speech" style="color:var(--mainColor)"></i> 채팅도 가능 해볼까??</span>
	            </div>
            </div>
            <jsp:include page="/WEB-INF/jsp/user/account/login.jsp" />
        </div>        
    </div>
	<!-- // 바디 -->
	<jsp:include page="/WEB-INF/jsp/user/footer.jsp" />
    
    <jsp:include page="/WEB-INF/jsp/user/loader.jsp" />
    <jsp:include page="/WEB-INF/jsp/user/bottomMenu.jsp" />
    <!-- 이스터에그 -->
    <script src="/js/user/easterEgg.js"></script>
    <style>
        .taebo-game{
            width: 500px;
            height: 500px;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: black;
        }

        .taebo-game-img{
            width: 520px;
            height: 635px;
            background: url(/image/TB_40_2.png) no-repeat;
            transform: scale(0.7);
        }
    </style>
    <script>

        (function(){
            // 비디오 설정
            let videoSrc = [
            //     "D1PvIWdJ8xo", //[MV] IU(아이유) _ Blueming(블루밍)
            //     "CM4CkVFmTds", // TWICE(트와이스) "I CAN'T STOP ME" M/V
            //     "AAOOKbk-knM", // (MV)유아(YooA)_숲의 아이 (Bon voyage)
            //     "GywDFkY3z-c", // LEE SUHYUN - ‘ALIEN’ M/V
            //     "dyRsYk0LyA8", // BLACKPINK – ‘Lovesick Girls’ M/V
            //     "iDjQSdN_ig8", // [MV] OH MY GIRL(오마이걸) _ Nonstop(살짝 설렜어)
                "Op2wX3MVIEk", // 1조
                "ttmzTf6XhlA", // 2조
                "LJgaulCeCbI", // 3조
                "g22QkE7Mj6Q", // 4조
                "cQloq2nnEXU", // 5조
                "s7acHgkTCuU" // 6조
            ]
            let randomNum = Math.floor( Math.random() * videoSrc.length );
            let videoFrame = document.querySelector(".main-video");
            let videoMinSize = 300;
            let moblieSize = 768;
            videoFrame.style.height = `${'${window.innerWidth/100*56.25}px'}`;
            // videoFrame.setAttribute('src',`https://www.youtube-nocookie.com/embed/${'${videoSrc[randomNum]}'}/?controls=1&autoplay=0&loop=1&disablekb=1`);
            
            // https://www.youtube.com/embed/kRT174IdxuM?rel=0&loop=1&playsinline=1&playlist=kRT174IdxuM&controls=0&showinfo=0&enablejsapi=1&origin=https%3A%2F%2Fmarshall-ku.com&widgetid=1

            window.addEventListener("load",  (e)=>{
                videoFrame.setAttribute('src',`https://www.youtube-nocookie.com/embed/H-AcDBLqxi4?start=344&controls=0&autoplay=1&loop=1&mute=1&enablejsapi=1`);
                if( window.innerWidth > videoMinSize ){
                    videoFrame.style.height = `${'${window.innerWidth/100*56.25}px'}`;
                } else {
                    videoFrame.style.height = `${'${videoMinSize/100*56.25}px'}`;
                }
            })
            window.addEventListener('resize', (e)=>{
                if( window.innerWidth > videoMinSize ){
                    videoFrame.style.height = `${'${window.innerWidth/100*56.25}px'}`;
                }
            })
            
            // --// 비디오 설정 끝


        }());

        // 처음 사이즈 작게 해서 키우기
        // setTimeout(()=>{
        //     document.body.style.transform = "scale(0.9)";
        //     document.querySelector("html").style.background = "#000000";
        //     setTimeout(()=>{
        //         document.body.style.transition = "1.5s cubic-bezier(.53,1,0,1)";
        //         document.body.style.transform = "scale(1)";
        //     },100)
        // },100)

    </script>
</body>

</html>