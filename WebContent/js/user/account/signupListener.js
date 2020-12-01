(function(){
    function pwdSame(){
        let pwd = document.getElementById("userPwd");
        let pwdChk = document.getElementById("userPwdChk");
        let errorMsg = pwdChk.parentElement.querySelector(".error-msg");
    
        if( pwd.value == pwdChk.value ){
            errorMsg.parentElement.classList.remove("input-error");
            errorMsg.textContent = "";
            return true;
        } else {    
            let errorMsg = pwdChk.parentElement.querySelector(".error-msg");
            errorMsg.parentElement.classList.add("input-error");
            errorMsg.textContent = "비밀번호가 다릅니다.";
            return false;
        }
    }
    
    function pwdChk(input){
        let allInputChk = true;
        let submitBtn = document.getElementById("signup-submit-btn");
        formInput.forEach(textChk => {
            if ( textChk.value.length == 0 ){
                submitBtn.style.background = "#aeaeae";
                allInputChk = false;
            }
        });
    
        // 모두 입력 됐을 시
        if ( allInputChk ){
            if( pwdSame() ){
                submitBtn.style.background = "#1a73e8";
            } else {
                submitBtn.style.background = "#aeaeae";
            }
            
        }
    
        // 입력할 경우 에러 메시지 지우기
        if( input.value.length != 0 ){
            let errorMsg = input.parentElement.querySelector(".error-msg");
            input.parentElement.classList.remove("input-error");
            errorMsg.textContent = "";
        }
    }
    
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
    
        // 버튼 활성화, 비활성화
        input.addEventListener("input", (e) => {
            pwdChk(input);
            pwdSame();
        });
    
        // 라벨 눌러도 input으로 포커스 변경
        inputLabel.addEventListener("click", (e) => {
            input.focus();
        });
    });
    
    document.getElementById("userPwdChk").addEventListener("input", (e) => {
        pwdChk(e.target);
        pwdSame();
    });
    
    // 로그인 버튼 눌렀을 경우 Input들 체크
    document.getElementById("signup-submit-btn").addEventListener("click", (e) => {
        let inputChkAll = true;
    
        // 입력 안됐을 경우 빨간색 표시
        formInput.forEach(inputChk => {
            if ( inputChk.value.length == 0 ){
                let inputLabel = inputChk.parentElement.querySelector(".input-label");
                let errorMsg = inputChk.parentElement.querySelector(".error-msg");
                inputChk.parentElement.classList.add("input-error");
                errorMsg.textContent = inputLabel.textContent + "을(를) 입력해주세요";
                inputChkAll = false;
                alertOpen({
                    setText: "필수 항목을 작성해 주세요",
                    activeTime: 20,
                    alertColor: "#ff0000"
                });
            }
        });
        
        // 모두 입력 됐을 시
        if ( inputChkAll ){
            if( pwdSame() ){
                console.log(e)
                alertOpen({
                    setText: "회원가입 누름",
                    activeTime: 20,
                    alertColor: ""
                });
                e.preventDefault();
                return;
            } else {
                alertOpen({
                    setText: "비밀번호가 다릅니다",
                    activeTime: 20,
                    alertColor: "#ff0000"
                });
            }
        }
        console.log(1);
        e.preventDefault();
    
    });
}());


// 자동으로 아이디 포커스
// document.getElementById("userId").focus();