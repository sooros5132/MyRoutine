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
                submitBtn.classList.remove("active");
                allInputChk = false;
            }
        });
    
        // 모두 입력 됐을 시
        if ( allInputChk ){
            if( pwdSame() ){
                submitBtn.classList.add("active");
            } else {
                submitBtn.classList.remove("active");
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
    window.addEventListener("load", (e)=>{
        setTimeout(()=>{
            formInput.forEach(input => {
                let textLen = input.value.length;
                if( textLen != 0 ){
                    input.parentElement.classList.add("input-active");
                }
            });
        }, 10);
    });
    
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

        // 입력 안됐을 경우 빨간색 표시 + return
		let allInputCheck = true;
		for( let i = 0; i < formInput.length; i++){
            if ( formInput[i].value.length == 0 ){
	            let inputLabel = formInput[i].parentElement.querySelector(".input-label");
	            let errorMsg = formInput[i].parentElement.querySelector(".error-msg");
	            formInput[i].parentElement.classList.add("input-error");
	            errorMsg.textContent = inputLabel.textContent + "을(를) 입력해주세요";
				allInputCheck = false;
            }
		}
		if( !allInputCheck ){
            alertOpen({setText: "필수 항목을 작성해 주세요",activeTime: 20,alertColor: "#ff0000"});
			e.preventDefault();
        	return;
		}
		
		// 이메일 형식 맞는지 체크
		const emailRegex = RegExp('^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\[.]{1}[a-zA-Z]{2,3}$');
		let emailInput = document.querySelector("#userEmail");
		let emailCheck = emailRegex.test(emailInput.value);
		if( !emailCheck ){
            let errorMsg = emailInput.parentElement.querySelector(".error-msg");
            emailInput.parentElement.classList.add("input-error");
            errorMsg.innerText = "이메일을 형식을 확인해주세요\nex) exam123@exam.com";
			alertOpen({setText: "이메일을 형식을 확인해주세요",activeTime: 20,alertColor: "#ff0000"});
			e.preventDefault();
        	return;
		}
		
		// 비밀번호 같은지 체크
        if( !pwdSame() ){
            alertOpen({setText: "비밀번호가 다릅니다",activeTime: 20,alertColor: "#ff0000"});
			e.preventDefault();
			return;
		}
		
		// 이상없음 가입중
		alertOpen({setText: "처리중", activeTime: 20,alertColor: ""});
		
    });
}());


// 자동으로 아이디 포커스
// document.getElementById("userId").focus();