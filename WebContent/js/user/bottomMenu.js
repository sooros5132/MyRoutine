// 탑 버튼 설정
(function(){
    window.addEventListener("scroll", (e)=>{
        let scrollLen = window.pageYOffset / (document.body.offsetHeight - window.innerHeight);
        let topBtnNode = document.getElementById("top-scroll").parentElement;
        
        if( scrollLen > 1 ){
            scrollLen = 1;
        }

        if ( scrollLen <= 0){
            topBtnNode.classList.remove("reveal");
            setTimeout(()=>{
                if( window.pageYOffset <= 0 )
                    topBtnNode.classList.add("d-none");
            }, 500)
        } else {
            topBtnNode.classList.remove("d-none");
            topBtnNode.classList.add("reveal");
            document.getElementById("top-scroll").setAttribute("style", `stroke-dashoffset: ${125-(125*scrollLen)};`);
        }

    });

    document.getElementById("top-scroll").addEventListener("click", ()=>{
        window.scrollTo({top: 0, behavior: 'smooth'});
    })

}());