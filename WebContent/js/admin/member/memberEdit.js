(function(){
    window.addEventListener("load", function(){
        let memberTable = document.querySelector(".member-list table");
        // 전체 선택 체크박스
        memberTable.querySelector(".all-member-select").addEventListener("click", (e)=>{
            let memberList = document.querySelectorAll(".member-select");
            if( memberList ){
                memberList.forEach(member => {
                    member.checked = e.target.checked;
                });
            }
        });

        // 초기 인풋들 세팅
        let inputs = memberTable.querySelectorAll("tbody .data-input, tbody .member-delete");
        inputs.forEach(input => {
            
            // 인풋들 개별값임
            let parentTrElement;
            let parentTdElement;
            let memberId;
            let dataKey = input.name;
            let dataValue;
            let confirmCheck;
            let dataUpdateBox;
            let confirmStr = "데이터를 변경 하시겠습니까??";

            if( input.classList.contains("member-delete")){
                input.addEventListener("click", (e)=>{
                    parentTrElement = input.parentElement.parentElement;
                    memberId = parentTrElement.dataset.memberId;

                    confirmCheck = confirm(confirmStr);
                    confirmCheck2 = confirm("삭제 버튼이야 진짜로??");

                    if(confirmCheck2){
                        dataValue = 1;
                        dataSend(e);
                    }
                });
            }

            switch( input.type ){
                case "checkbox":{
                    parentTdElement = input.parentElement;
                    parentTrElement = input.parentElement.parentElement;
                    memberId = parentTrElement.dataset.memberId;

                    // 서버에서 받아온게 트루였다면 체크
                    let originChecked = input.dataset.origin == "true";
                    if( originChecked ) {
                        input.checked = originChecked;
                    }
                    input.addEventListener("click", (e)=>{
                        confirmCheck = confirm(confirmStr);
                        dataValue = 0;
                        if( input.checked )
                            dataValue = 1;
                        dataSend(e);
                    });

                    break;
                }
                case "text":{
                    parentTdElement = input.parentElement.parentElement.parentElement;
                    parentTrElement = input.parentElement.parentElement.parentElement.parentElement;
                    memberId = parentTrElement.dataset.memberId;

                    dataUpdateBox = input.parentElement.parentElement;
                    let updateBtn = dataUpdateBox.querySelector(".update-btn");
                    updateBtn.addEventListener("click", (e)=>{
                        let activeCheck = !updateBtn.parentElement.classList.contains("active");
                        if( activeCheck ){
                            e.preventDefault();
                            return;
                        }
                        confirmCheck = confirm(confirmStr);
                        dataValue = input.value;
                        dataSend(e);
                    });

                    break;
                }
                case "select-one":{
                    parentTdElement = input.parentElement.parentElement.parentElement;
                    parentTrElement = input.parentElement.parentElement.parentElement.parentElement;
                    memberId = parentTrElement.dataset.memberId;
                    dataValue = input.dataset.origin;

                    // 초기 seleted 세팅 
                    input.querySelector(`option[value="${dataValue}"]`).selected = true;
                    authTostring(dataValue);
                    
                    input.addEventListener("change", (e) =>{
                        let parentDataUpdateBox = input.parentElement.parentElement;
                        if( input.value != input.dataset.origin )
                            parentDataUpdateBox.classList.add("active");
                        else 
                            parentDataUpdateBox.classList.remove("active");
                    });
                    
                    dataUpdateBox = input.parentElement.parentElement;
                    let updateBtn = dataUpdateBox.querySelector(".update-btn");
                    updateBtn.addEventListener("click", (e)=>{
                        let activeCheck = !updateBtn.parentElement.classList.contains("active");
                        if( activeCheck ){
                            e.preventDefault();
                            return;
                        }
                        confirmCheck = confirm(confirmStr);
                        dataValue = input.value;
                        dataSend(e);
                    });
                    break;
                }
            }

            // 데이터 설정하고 보냄 (중복제거) 
            // 이벤트 취소시켜야 해서 이벤트 객체 받아와야함
            let dataSend = function(e){
                if(!confirmCheck){
                    alertOpen({setText: `취소되었습니다.`,activeTime: 10,alertColor: ""});
                    e.preventDefault();
                    return;
                }
                memberUpdate({id:memberId, key:dataKey, value:dataValue});
            }

            let memberUpdate = function ({id = "", key="", value=""}){
                let xhr = new XMLHttpRequest();
                let params = `id=${id}&${key}=${value}`;
                let formData = encodeURI(params);
                xhr.onload = function() {
                    if (xhr.status === 200 || xhr.status === 201) {
                        if( xhr.responseText == "" ){
                            alertOpen({setText: `실패하였습니다.`,activeTime: 20,alertColor: "#ff0000"});
                            return;
                        }
                        
                        let data = JSON.parse(xhr.responseText);
                        if( data.result == 0 ){
                            alertOpen({setText: `실패하였습니다.`,activeTime: 20,alertColor: "#ff0000"});
                            return;
                        }
                        
                        // 변경되고 이벤트
                        alertOpen({setText: `변경되었습니다.`,activeTime: 20,alertColor: "#30baa1"});

                        switch( input.type ){
                            case "checkbox":{
                                input.dataset.origin = input.checked;
                                break;
                            }
                            case "text":{
                                input.dataset.origin = input.value;
                                dataUpdateBox.classList.remove("active");
                                break;
                            }
                            case "select-one":{
                                input.dataset.origin = input.value;
                                authTostring(input.value);
                                break;
                            }
                        }
                        if( input.classList.contains("member-delete")){
                            parentTrElement.classList.add("delete");
                            parentTrElement.nextElementSibling.classList.add("delete");

                            setTimeout(()=>{
                                parentTrElement.nextElementSibling.remove();
                                parentTrElement.remove();
                            }, 2900);
                            return;
                        }
                        highlight(parentTdElement);
                    } else {
                        console.error(xhr.responseText);
                    }
                };
                xhr.open('POST', '/admin/member/edit');
                xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
                xhr.send(formData); // 폼 데이터 객체 전송
                
            }
            
            function authTostring(num){
                let changeStr;
                let parentNextElement = parentTrElement.nextElementSibling;
                let memberStatus = parentTrElement.querySelector(".member-status")
                let block = parentNextElement.querySelector(".member-status-block input[type=checkbox]");
                let withdraw = parentNextElement.querySelector(".member-status-withdraw");
                num = parseInt(num);

                block.checked = "";
                withdraw.textContent = "NO";

                switch(num){
                    case 1:{
                        changeStr = "회원";
                        break;
                    }
                    case 7:{
                        changeStr = "차단";
                        block.checked = true;
                        highlight(block);
                        break;
                    }
                    case 8:{
                        changeStr = "탈퇴";
                        withdraw.textContent = "YES";
                        highlight(withdraw);
                        break;
                    }
                    case 9:{
                        changeStr = "관리자";
                        break;
                    }
                }
                memberStatus.textContent = changeStr;
                highlight(memberStatus);
            }
        });

        // 데이터 바뀜 체크
        let textInputs = memberTable.querySelectorAll("tbody input[type=text]");
        textInputs.forEach(input => {
            input.addEventListener("input", (e)=>{
                let parentChangeBox = input.parentElement.parentElement;
                if( input.value != input.dataset.origin )
                    parentChangeBox.classList.add("active");
                else 
                    parentChangeBox.classList.remove("active");
            });
        });
    });

    let highlight = function ( element ){
        element.classList.remove("new-update");
        element.offsetWidth;
        element.classList.add("new-update");
    }
}());
