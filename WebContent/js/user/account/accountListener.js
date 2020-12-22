(function(){
    let formInput = document.querySelectorAll(".account-inner .user-info");

    // 자동 선택
    window.addEventListener("load", (e)=>{
        setTimeout(()=>{
            formInput.forEach(input => {
                let textLen = input.value.length;
                if( textLen != 0 ){
                    input.parentElement.classList.add("input-active");
                }
            });
        }, 100);
    });
    
    // let pwdInput = document.querySelectorAll("input[type=password]");
    // if( pwdInput ){
    //     pwdInput.forEach(input => {
    //         // keydown으로 해야 작동함
    //         input.addEventListener("keydown", (e) => {
    //             var keyCode = 0;
    //             var shiftKey=false;
    //             keyCode=e.keyCode;
    //             shiftKey=e.shiftKey;
    //             if (((keyCode >= 65 && keyCode <= 90)&& !shiftKey)||((keyCode >= 97 && keyCode <= 122)&& shiftKey))
    //             {
    //                 alertOpen({
    //                     setText: "CapsLock키가 눌려있습니다",
    //                     activeTime: 3,
    //                     alertColor: "#007a8e"
    //                 });
    //                 return;
    //             }
    //         });
    //     });
    // }
    
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
		// const emailRegex = RegExp('^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$');
		const emailRegex = RegExp('^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\[.]{1}[a-zA-Z]{2,3}$');
		let emailInput = document.querySelector("#userEmail");
		let emailCheck = emailRegex.test(emailInput.value);
		if( !emailCheck ){
            let errorMsg = emailInput.parentElement.querySelector(".error-msg");
            emailInput.parentElement.classList.add("input-error");
            errorMsg.innerText = "이메일을 형식을 확인해주세요\nex) exam123@exam.com";
			alertOpen({setText: "이메일을 확인해주세요",activeTime: 20,alertColor: "#ff0000"});
			e.preventDefault();
        	return;
		}
		
        alertOpen({
            setText: "처리중 #지금은 테스트, 동작안함",
            activeTime: 20,
            alertColor: ""
        });

        e.preventDefault();
    });
}());

// 자동으로 아이디 포커스
// document.getElementById("userId").focus();