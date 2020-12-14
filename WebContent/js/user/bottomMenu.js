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
            document.getElementById("top-scroll").setAttribute("style", `stroke-dashoffset: ${95-(95*scrollLen)};`);
        }
    });

    document.getElementById("top-scroll").addEventListener("click", ()=>{
        window.scrollTo({top: 0, behavior: 'smooth'});
    })

	window.addEventListener("load", (e)=>{
		let chatBox = document.querySelector(".chat-container");
		let chatToggle = document.querySelector(".chat-toggle");
		let chatCloseBtn = document.querySelector(".chat-close-btn");
	    chatToggle.addEventListener("click", ()=>{
	        if(chatBox.classList.contains("d-none")){
				chatBox.classList.remove("d-none");
				return;
			}
			chatBox.classList.add("d-none");
	    })
		chatCloseBtn.addEventListener("click", ()=>{
			chatBox.classList.add("d-none");
	    });
	});
}());