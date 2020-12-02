
// 자동 선택
// window.addEventListener("load", (e)=>{
//     setTimeout(()=>{
//         formInput.forEach(input => {
//             let textLen = input.value.length;
//             if( textLen != 0 ){
//                 input.parentElement.classList.add("input-active");
//             }
//         });
//     }, 10);
// });

(function(){
    let formInput = document.querySelectorAll(".account-inner .user-info");
    let pwdInput = document.querySelectorAll("input[type=password]");

    if( pwdInput ){
        pwdInput.forEach(input => {
            input.addEventListener("input", (e) => {
                var keyCode = 0;
                var shiftKey=false;
                keyCode=e.keyCode;
                shiftKey=e.shiftKey;
                if (((keyCode >= 65 && keyCode <= 90)&& !shiftKey)||((keyCode >= 97 && keyCode <= 122)&& shiftKey))
                {
                    alertOpen({
                        setText: "CapsLock키가 눌려있습니다",
                        activeTime: 3,
                        alertColor: "#007a8e"
                    });
                    return;
                }
            });
        });
    }
    
    formInput.forEach(input => {
        let inputLabel = input.parentElement.querySelector(".input-label");
    
        // 파란 테두리
        input.addEventListener("focus", (e) => {
            input.parentElement.classList.add("input-active");
        });
    
        // 파란 테두리 지움
        input.addEventListener("focusout", (e) => {
            let textLen = input.value.length;
            if( textLen == 0 ){
                input.parentElement.classList.remove("input-active");
            }
        });
    
        // 로그인 버튼 활성화, 비활성화
        input.addEventListener("input", (e) => {
            formInput.forEach(textChk => {
                let submitBtn = document.getElementsByClassName("submit-btn")[0];
                let headerText = document.querySelector(".account-header-text");
                if ( input.value.length == 0 ){
                    submitBtn.classList.remove("active");
                    headerText.classList.remove("active");
                } else if( textChk != input && textChk.value.length != 0 ){
                    submitBtn.classList.add("active");
                    headerText.classList.add("active");
                } else if( formInput.length == 1 && textChk.value.length != 0){
                    // 입력창이 1개일 경우
                    submitBtn.classList.add("active");
                }
            });
            
            // 입력할 경우 에러 메시지 지우기
            let errorMsg = input.parentElement.querySelector(".error-msg");
            if( input.value.length != 0 ){
                input.parentElement.classList.remove("input-error");
                errorMsg.textContent = "";
            }
        });
    
        // 라벨 눌러도 input으로 포커스 변경
        inputLabel.addEventListener("click", (e) => {
            input.focus();
        });
    });
    
    // 로그인 버튼 눌렀을 경우 Input들 체크
    document.getElementsByClassName("submit-btn")[0].addEventListener("click", (e) => {
        let allInputChk = true;
    
        // 입력 안됐을 경우 빨간색 표시
        formInput.forEach(inputChk => {
            if ( inputChk.value.length == 0 ){
                let inputLabel = inputChk.parentElement.querySelector(".input-label");
                let errorMsg = inputChk.parentElement.querySelector(".error-msg");
                inputChk.parentElement.classList.add("input-error");
                errorMsg.textContent = inputLabel.textContent + "을(를) 입력해주세요";
                allInputChk = false;
                alertOpen({
                    setText: "필수 항목을 작성해 주세요",
                    activeTime: 20,
                    alertColor: "#ff0000"
                });
            }
        });
    
        // 모두 입력 됐을 시
        if ( allInputChk ){
            console.log("sussess");
            alertOpen({
                setText: "로그인 버튼 누름",
                activeTime: 20,
                alertColor: ""
            });
            e.preventDefault();
        }
        
    });
}());

// 자동으로 아이디 포커스
// document.getElementById("userId").focus();