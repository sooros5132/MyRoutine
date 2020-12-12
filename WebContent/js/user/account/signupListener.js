(function(){
    const emailRegex = RegExp('^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\[.]{1}[a-zA-Z]{2,3}$');

    function pwdSame(){
        let pwd = document.getElementById("userPwd");
        let pwdChk = document.getElementById("userPwdChk");
        let inputMsg = pwdChk.parentElement.querySelector(".input-msg");
    
        if( pwd.value == pwdChk.value ){
            inputMsg.parentElement.classList.remove("input-error");
            inputMsg.textContent = "";
            return true;
        } else {    
            let inputMsg = pwdChk.parentElement.querySelector(".input-msg");
            inputMsg.parentElement.classList.add("input-error");
            inputMsg.textContent = "비밀번호가 다릅니다.";
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
            let inputMsg = input.parentElement.querySelector(".input-msg");
            input.parentElement.classList.remove("input-error");
            inputMsg.textContent = "";
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
	            let inputMsg = formInput[i].parentElement.querySelector(".input-msg");
	            formInput[i].parentElement.classList.add("input-error");
	            inputMsg.textContent = inputLabel.textContent + "을(를) 입력해주세요";
				allInputCheck = false;
            }
		}
		if( !allInputCheck ){
            alertOpen({setText: "필수 항목을 작성해 주세요",activeTime: 20,alertColor: "#ff0000"});
			e.preventDefault();
        	return;
        }
        
        
		for( let i = 0; i < formInput.length; i++){
            let errorClassContain = formInput[i].parentElement.classList.contains("input-error");
            if(errorClassContain){
                alertOpen({setText: "다시 확인해주세요",activeTime: 20,alertColor: "#ff0000"});
                formInput[i].focus();
                e.preventDefault();
                return;
            }
        }
		
		// 이메일 형식 맞는지 체크
		
		let emailInput = document.querySelector("#userEmail");
		let emailCheck = emailRegex.test(emailInput.value);
		if( !emailCheck ){
            let inputMsg = emailInput.parentElement.querySelector(".input-msg");
            emailInput.parentElement.classList.add("input-error");
            inputMsg.innerText = "이메일을 형식을 확인해주세요\nex) exam123@exam.com";
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

		let dupCheckInput = document.querySelectorAll("#userEmail, #userNickname");

		emailInput = document.querySelector("#userEmail");
		nickNameInput = document.querySelector("#userNickname");

		dupCheckInput.forEach(input => {
			let checkInput = setTimeout(()=>{});
			input.addEventListener("input", (e)=>{
				clearTimeout(checkInput);
                let inputMsg = input.parentElement.querySelector(".input-msg");
                inputMsg.innerText = `1초동안 멈추면 중복검사가 됩니다.`;
				checkInput = setTimeout(()=>{
					let key = input.name;
					let value = input.value;
					// console.log(key +"  "+ value);
					if( input.value.length > 0){
                        if( emailInput == input ){
                            if( !emailRegex.test(emailInput.value) ){
                                alertOpen({setText: `중복 검사할 이메일 형식을 확인해주세요.`,activeTime: 20,alertColor: "#ff0000"});
                                emailInput.parentElement.classList.add("input-error");
                                inputMsg.innerText = "이메일을 형식을 확인해주세요\nex) exam123@exam.com";
                                e.preventDefault();
                                return;
                            }
                        }

						dupCheck({"key": key, "value": value, "input": input});
					}
				},1000);
			});
		});
		
		let dupCheck = function ({key="", value="", input=""}){
	        let xhr = new XMLHttpRequest();
	        let params = `key=${key}&value=${value}`;
	        let formData = encodeURI(params);
	        xhr.onload = function() {
	            if (xhr.status === 200 || xhr.status === 201) {
	                if( xhr.responseText == "" ){
	                    alertOpen({setText: `연결에 실패하였습니다.`,activeTime: 20,alertColor: "#ff0000"});
	                    return;
	                }
	                
					let inputLabel = input.parentElement.querySelector(".input-label");
					let inputMsg = input.parentElement.querySelector(".input-msg");

	                let data = JSON.parse(xhr.responseText);
	                if( data.result == 1 ){
						input.parentElement.classList.add("input-error");
						inputMsg.textContent = `이미 사용된 ${inputLabel.textContent}입니다`;
	                    alertOpen({setText: `이미 사용된 ${inputLabel.textContent}입니다`,activeTime: 20,alertColor: "#ff0000"});
	                    return;
	                }
	                
					input.parentElement.classList.remove("input-error");
                    inputMsg.innerHTML = `<span style="color:#28B49B">사용 가능한 ${inputLabel.textContent}입니다<span>`;
	                alertOpen({setText: `사용 가능한 ${inputLabel.textContent}입니다`,activeTime: 20,alertColor: ""});
	            } else {
	                console.error(xhr.responseText);
	            }
	        };
	        xhr.open('POST', '/account/check');
	        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
	        xhr.send(formData); // 폼 데이터 객체 전송
	        
	    }
    });

}());


// 자동으로 아이디 포커스
// document.getElementById("userId").focus();