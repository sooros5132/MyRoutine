
window.addEventListener("resize",  (e)=>{
    for(let i = 0; i < 20; i++ ){
        document.querySelectorAll(".loading")[i].style.left = `${window.innerWidth/20*i}px`;
        document.querySelectorAll(".loading")[i].style.height = `${window.innerHeight}px`;
    }
})

let loader;
let loader2;
let loader3;

/* 로딩 1 ---------------------------------- */
// 로딩 스크린 색칠
(function (){
    let loadingNode = document.querySelectorAll(".loading");
    for( let i = 0; i < 20; i++){
        loadingNode[i].style.transition = "0s";
        loadingNode[i].style.transform = "";
        loadingNode[i].offsetWidth;
        loadingNode[i].style.transition = "";

        let currentNode = document.querySelectorAll(".loading")[i];
        currentNode.style.left = `${window.innerWidth/20*i}px`;
        currentNode.style.height = `${window.innerHeight}px`;

        currentNode.style.background = `hsl(${360/19*i} 100% 50% / 1)`;
    }

    // 테스트용 제거 ==================================================
    let windowLoaded = false;
    window.addEventListener("load",  (e)=>{
        windowLoaded = true;
    });
    // 테스트용 제거 ==================================================
    loader = function (){
        // 로드 리스너 등록
        window.addEventListener("load",  (e)=>{
            loaderEnd();
        });

        //== 로더 시작 준비
        let className = "loading-container-" + (new Date().getTime());
        let loadingContainer = document.querySelector(".loading-container");
        let loadingNode = document.querySelectorAll(".loading");

        loadingContainer.className = `loading-container ${className}`;
        loadingContainer.style.display = "block";
        
        // 애니메이션 초기화
        for( let i = 0; i < 20; i++){
            loadingNode[i].style.transition = "0s";
            loadingNode[i].style.transform = "";
            loadingNode[i].offsetWidth;
            loadingNode[i].style.transition = "";

            let currentNode = document.querySelectorAll(".loading")[i];
            currentNode.style.left = `${window.innerWidth/20*i}px`;
            currentNode.style.height = `${window.innerHeight}px`;

            currentNode.style.background = `hsl(${360/19*i} 100% 50% / 1)`;
        }
        let loadingScreen = document.querySelector(".loading-logo");
        loadingScreen.classList.remove("d-none","fadeout");
        loadingScreen.querySelector("svg").style.fill = "transparent";
        loadingScreen.querySelector("path").setAttribute("class", "logo-svg-draw");
        loadingScreen.querySelector("path").setAttribute("fill", "url(#logo-svg-color)");
        loadingScreen.offsetWidth;
        //==// 로더 준비 끝

        let loaderEnd = function(){
            loadingScreen.classList.add("fadeout");
            loadingScreen.querySelector("svg").style.fill = "#28B49B";
            loadingScreen.querySelector("svg").style.transition = "fill 1s";
            loadingScreen.querySelector("path").setAttribute("class", "");
            loadingScreen.querySelector("path").setAttribute("fill", "");
            setTimeout(()=>{
                let repeat = 0;
                (function recursive(){
                    setTimeout(()=>{
                        // loadingNode[19-repeat].style.transform = `translate(0, -100%)`;
                        
                        loadingNode[9-repeat].style.transform = `translate(0, -100%)`;
                        loadingNode[repeat+10].style.transform = `translate(0, -100%)`;
                        
                        // loadingNode[19-repeat].style.transform = `translate(0, -100%)`;
                        // loadingNode[repeat].style.transform = `translate(0, -100%)`;
                        repeat++;
                        // if( repeat < 20){
                        if( repeat < 10){
                            recursive();
                        } else {
                            repeat = 0;
                            setTimeout(()=>{
                                let classNameRemove = document.querySelector(`.${className}`);
                                if( classNameRemove ){
                                    classNameRemove.classList.remove(className);
                                    document.querySelector(".loading-container").style.display = "none";
                                }
                            }, 1100);
                        }
                    }, 10+repeat*2);
                }());
                setTimeout(()=>{
                    loadingScreen.classList.add("d-none");
                    // loadingScreen.remove();
                },1000)
            },1000)
        }

        // 테스트용 제거 ==================================================
        if(windowLoaded)
            loaderEnd();
        // 테스트용 제거 ==================================================
    }

    /* 로딩 2 ---------------------------------- */

    loader2 = function(){
        let className = "loading-bar-" + (new Date().getTime());
        let loadingNode = document.querySelector(".loading-container2");

        loadingNode.classList.remove("d-none");
        loadingNode.classList.remove("active");
        loadingNode.offsetWidth;

        document.querySelector(".loading-back1").offsetWidth;
        document.querySelector(".loading-back2").offsetWidth;
        document.querySelector(".loading-back3").offsetWidth;

        loadingNode.className = `loading-container2 active ${className}`;
        setTimeout(() => {
            if( document.querySelector(`.${className}`) ){
                loadingNode.classList.remove("active")
                loadingNode.classList.add("d-none");
            }
        }, 1250);
    }


    /* 로딩 3 ---------------------------------- */

    let loderInterval = setInterval(() => {
        // let loadingBar = document.querySelector(".loading-bar");
        // loadingBar.style.width = `${barWidth}%`
        // barWidth += 5;
    }, 1000);

    loader3 = function(){
        let loadingBar = document.querySelector(".loading-bar");
        let className = "loading-bar-" + (new Date().getTime());
        
        loadingBar.style.opacity = "1";
        loadingBar.className = `loading-bar ${className}`;
        loadingBar.style.transition = "0s";
        loadingBar.style.width = "";
        loadingBar.style.top = ``;
        loadingBar.offsetWidth;
        loadingBar.style.transition = "";

        clearInterval(loderInterval);
        let barWidth = 10;
        loderInterval = setInterval(() => {
            barWidth += 2;
            loadingBar.style.width = `${barWidth}%`;
            if(barWidth >= 100){
                loaderEnd();
            }
        }, 1000)

        window.addEventListener("load", (e)=>{
            loaderEnd();
        });

        function loaderEnd(){
            loadingBar.style.width = "100%";
            clearInterval(loderInterval);
            let classNameRemove = document.querySelector(`.${className}`);
            if( classNameRemove ){
                classNameRemove.classList.remove(className);
                loadingBar.style.opacity = "0";
                loadingBar.style.top = `-4px`;
            }
        }
    }

}());

window.addEventListener("load", (e)=>{
});
// 개발할땐 끄기 --------------------------------------------
loader();
loader3();
