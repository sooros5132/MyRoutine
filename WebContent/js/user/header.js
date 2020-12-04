(function(){
	window.addEventListener("load", ()=>{
		// 모바일 헤더 토글
		let menuOpenBtn = document.querySelector(".mobile-menu-open");
		menuOpenBtn.addEventListener("click", (e)=>{
		    let headerNode = document.querySelector(".header");
		    if( document.querySelector(".header.active") ){
		        headerNode.classList.remove("active");
		    } else {
		        headerNode.classList.add("active");
		    }
		});
		
		// 헤더 알림테스트
        let alertCnt = 0;
        let headerAlertBtn = document.querySelector(".alert-btn");
        headerAlertBtn.addEventListener("click", (e)=>{
            alertOpen({
                setText: `${++alertCnt}번 누름`,
                activeTime: 10,
                alertColor: ""
            });
        });
	});
}());