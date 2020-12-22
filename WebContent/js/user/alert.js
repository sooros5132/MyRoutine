let alertOpen;

(function(){
    let alertNode = document.querySelector(".alert-node");
    let alertText = document.querySelector(".alert-text");
    let alertClose = document.querySelector(".alert-close");
    let bottomMenu = document.querySelector(".bottom-container");
    let barNode = document.querySelector(".alert-node-bar");
    
    alertOpen = function({ setText = "", activeTime = 10, alertColor = "" }){
        if( alertNode ){
            let className = "alert-node-" + (new Date().getTime());
        
            // 초기화
            barNode.style.transition = `0s`;
            barNode.style.width = "100%";
            barNode.offsetWidth;
            
            // 스타일 주기
            bottomMenu.className = `bottom-container alert-active ${className}`;
            barNode.style.transition = `linear width ${activeTime}s`;
            barNode.style.width = "0%";
            
            // 백그라운드 컬러 설정
            alertNode.style.background = alertColor;
            //barNode.style.background = alertColor;
    
            alertText.textContent = setText;
            setTimeout(()=>{
                let closeNode = document.getElementsByClassName(className)[0];
                if( closeNode ){
                    closeNode.classList.remove(className);
                    bottomMenu.classList.remove("alert-active");
                    barNode.classList.value = "alert-node-bar";
                }
            }, activeTime*1000);
        }
    }
    window.addEventListener("load",  (e)=>{
        alertClose.addEventListener("click", (e)=>{
            bottomMenu.classList.remove("alert-active");
            barNode.classList.value = "alert-node-bar";
        });
    });
}());