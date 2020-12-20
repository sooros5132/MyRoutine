(function(){
    const emailRegex = RegExp('^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\[.]{1}[a-zA-Z]{2,3}$');

    let signUpForm = document.querySelector(".account-container");
    let signUpFormInputs = signUpForm.querySelectorAll(".account-inner .user-info");
    let submitBtn = signUpForm.querySelector(".submit-btn");
    let emailInput = signUpForm.querySelector("#userEmail");
    let nickNameInput = document.querySelector("#userNickname");
    let pwdInput = signUpForm.querySelector("#userPwd");
    let pwdCheckInput = signUpForm.querySelector("#userPwdChk");
    
    // 중복검사 중인지 체크 변수
    let dupChecking = false;
    
    window.addEventListener("load", ()=>{
        // 파란 테두리
        signUpForm.addEventListener("focusin", (e)=>{
            if( !e.target.classList.contains("user-info") )
                return;
            e.target.parentElement.classList.add("input-active");
        });
        
         // 파란 테두리 지움
        signUpForm.addEventListener("focusout", (e)=>{
            if( !e.target.classList.contains("user-info") )
                return;
            let input = e.target;
            if( input.value.length == 0 )
                input.parentElement.classList.remove("input-active");
        });

        // 중복검사 1초 타이머 변수
        // 1초내에 다시 입력하면 초기화 되게 하려고 밖에다 둠
        let emailDupCheck;
        let nicnameDupCheck;
        signUpForm.addEventListener("input", (e) => {
            // input 아니면 리턴
            if( !e.target.classList.contains("user-info") )
                return;
            
            let input = e.target;
            
            if( input.value.length == 0 ) {
                submitBtn.classList.remove("active");
            } else {
                // 입력할 경우 에러 메시지 지우기
                let inputMsg = input.parentElement.querySelector(".input-msg");
                input.parentElement.classList.remove("input-error");
                inputMsg.textContent = "";
            }

            // 닉네임, 이메일 중복검사
            if( input.name == "email" || input.name == "nickname" ){
                let inputMsg = input.parentElement.querySelector(".input-msg");
                inputMsg.innerText = `1초동안 멈추면 중복검사가 됩니다.`;

                dupChecking = true;

                if( input.name == "email" ){
                    clearTimeout(emailDupCheck);
                    emailDupCheck = setTimeout(dupTimeout,1000);
                } else {
                    clearTimeout(nicnameDupCheck);
                    nicnameDupCheck = setTimeout(dupTimeout,1000);
                }

                function dupTimeout(){
                    let key = input.name;
                    let value = input.value;
                    // console.log(key +"  "+ value);
                    if( input.value.length == 0 )
                        return;
                    
                    if( input.type == "email" ){
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
                
            }

            if( e.target.type == "password"){
                let keyCode = 0;
                let shiftKey=false;
                keyCode=e.keyCode;
                shiftKey=e.shiftKey;
                
                // CapsLock 눌림 확인
                if (((keyCode >= 65 && keyCode <= 90)&& !shiftKey)||((keyCode >= 97 && keyCode <= 122)&& shiftKey))
                {
                    alertOpen({
                        setText: "CapsLock키가 눌려있습니다",
                        activeTime: 3,
                        alertColor: "#007a8e"
                    });
                }
                pwdSameCheck()
            }
            
            submitActiveCheck();
        });

        // label 클릭시
        signUpForm.addEventListener("click", (e)=>{
            if( e.target.tagName == "LABEL" ){
                e.target.parentElement.querySelector(".user-info").focus();
                return;
            }
            if( e.target.tagName == "INPUT" && e.target.type == "submit" ){

                //입력 안됐을 경우 빨간색 표시 + return
                let inputNullCheck = false;
                for( let i = 0; i < signUpFormInputs.length; i++){
                    if ( signUpFormInputs[i].value.length == 0 ){
                        let inputLabel = signUpFormInputs[i].parentElement.querySelector(".input-label");
                        let inputMsg = signUpFormInputs[i].parentElement.querySelector(".input-msg");
                        signUpFormInputs[i].parentElement.classList.add("input-error");
                        inputMsg.textContent = inputLabel.textContent + "을(를) 입력해주세요";
                        inputNullCheck = true;
                    }
                }

                if( inputNullCheck ){
                    alertOpen({setText: "필수 항목을 작성해 주세요",activeTime: 20,alertColor: "#ff0000"});
                    e.preventDefault();
                    return;
                }
                
                // 에러가 있을 경우
                for( let i = 0; i < signUpFormInputs.length; i++){
                    let errorClassContain = signUpFormInputs[i].parentElement.classList.contains("input-error");
                    if(errorClassContain){
                        alertOpen({setText: "다시 확인해주세요",activeTime: 20,alertColor: "#ff0000"});
                        signUpFormInputs[i].focus();
                        e.preventDefault();
                        return;
                    }
                }
                
                // 이메일 형식 맞는지 체크
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
                if( !pwdSameCheck() ){
                    alertOpen({setText: "비밀번호가 다릅니다",activeTime: 20,alertColor: "#ff0000"});
                    e.preventDefault();
                    return;
                }
                
                // 중복검사 중 체크 
                // setTimeout이 있는지 검사
                if( dupChecking ){
                    alertOpen({setText: "중복 검사 중입니다.",activeTime: 20,alertColor: "#ff0000"});
                    e.preventDefault();
                    return;
                }

                // 이상없음 가입중
                alertOpen({setText: "처리중", activeTime: 20,alertColor: ""});
                // e.preventDefault();
                // return;
            }
        });

        let pwdSameCheck = function(){
            let inputMsg = pwdCheckInput.parentElement.querySelector(".input-msg");
        
            if( pwdInput.value == pwdCheckInput.value ){
                inputMsg.parentElement.classList.remove("input-error");
                inputMsg.textContent = "";
                return true;
            }
            inputMsg.parentElement.classList.add("input-error");
            inputMsg.textContent = "비밀번호가 다릅니다.";
            return false;
        }
    
        // 자동 선택
        setTimeout(()=>{
            signUpFormInputs.forEach(input => {
                let textLen = input.value.length;
                if( textLen != 0 ){
                    input.parentElement.classList.add("input-active");
                }
            });
        }, 100);
        
    });
    
    // 중복 검사
    let dupCheck = function ({key="", value="", input=""}){
        let xhr = new XMLHttpRequest();
        let params = `key=${key}&value=${value}`;
        let formData = encodeURI(params);
        xhr.onload = function() {
            dupChecking = false;
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
                
                submitActiveCheck();
            } else {
                console.error(xhr.responseText);
            }
        };
        xhr.open('POST', '/api/account/dupCheck');
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
        xhr.send(formData); // 폼 데이터 객체 전송   
    }
    
    let submitActiveCheck = function(){
        for(let i = 0; i < signUpFormInputs.length; i++){
            if( signUpFormInputs[i].parentElement.classList.contains("input-error") || 
                signUpFormInputs[i].value.length == 0 ||
                dupChecking ){
                submitBtn.classList.remove("active");
                return;
            }
        }
        submitBtn.classList.add("active");
    }
}());


// 자동으로 아이디 포커스
// document.getElementById("userId").focus();