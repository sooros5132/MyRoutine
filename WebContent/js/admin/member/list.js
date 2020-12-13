(function(){
    window.addEventListener("load", function(){
        let confirmStr = "데이터를 변경 하시겠습니까??";

        //페이징 설정
        let pagingNodes = document.querySelectorAll(".member-list .member-list-paging .paging");
        pagingNodes.forEach(pagingNode => {

            // 사용 불가인 경우 패스
            if( pagingNode.classList.contains("disable") ){
                return;
            }

            let dataPage = pagingNode.dataset.page;
            let reg = /[\\?&]page=([^&#]*)/;
            // let reg = /[\\?&]page=([^&#]*)/ 물음표 뺌
            let oldPram = location.search;
            let newPram;


            if( oldPram.match(reg) ){
                if( oldPram.match(/^\?page/) ){
                    newPram = oldPram.replace(reg, `?page=${dataPage}`)
                } else {
                    newPram = oldPram.replace(reg, `&page=${dataPage}`)
                }
            } else {
                if( oldPram == "" ){
                    newPram = `?page=${dataPage}`;
                } else {
                    newPram = oldPram + `&page=${dataPage}`;
                }
            }
            pagingNode.href = `${location.pathname}${newPram}`;
        });

        //현재 페이지숫자를 배경으로
        let currentPageNumber = document.querySelector(".page-number td");
        if( currentPageNumber ){
            let tbodyNode = currentPageNumber.parentElement.parentElement;
            // currentPageNumber.style.width = `${tbodyNode.offsetWidth}px`;
            currentPageNumber.style.lineHeight = `${tbodyNode.offsetHeight}px`;
            currentPageNumber.style.fontSize = `${tbodyNode.offsetHeight}px`;
            if( tbodyNode.offsetHeight > 1500 ){
                currentPageNumber.style.fontSize = `1500px`;
            }    
        }

        let memberTable = document.querySelector(".member-list .member-list-table");
        // 전체 선택 체크박스
        memberTable.querySelector(".all-member-select").addEventListener("click", (e)=>{
            let memberList = document.querySelectorAll(".member-select");
            if( memberList ){
                memberList.forEach(member => {
                    member.checked = e.target.checked;
                });
            }
        });

        // 초기 Input들 세팅
        let lastLoginNodes = memberTable.querySelectorAll("tbody .member-last-login");
        lastLoginNodes.forEach(lastLogin => {
            let updateBtn = lastLogin.querySelector(".update-btn");
            let parentTrElement = lastLogin.parentElement.parentElement;
            let memberId = parentTrElement.dataset.memberId;
            updateBtn.addEventListener("click", (e)=>{

                confirmCheck = confirm(confirmStr);
                if( !confirmCheck ){
                    alertOpen({setText: `취소되었습니다.`,activeTime: 10,alertColor: ""});
                    e.preventDefault();
                    return;
                }

                memberUpdatePromise({id:memberId, key:"last_login", value:"update"})
                .then((data) => {
                    if(!data)
                        return;
                    let textNode = lastLogin.querySelector(".data-box");
                    textNode.textContent = data["last_login"].substring(0,16);
                    highlight(lastLogin.parentElement);
                })
                .catch((error) => console.log(error));
            })
        });

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
                case "tel":
                case "date":
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
                    ruleToString(dataValue);
                    
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
                
                memberUpdatePromise({id:memberId, key:dataKey, value:dataValue})
                .then((data) => {
                    if(!data)
                        return;
                    // 변경되고 이벤트
                    switch( input.type ){
                        case "checkbox":{
                            input.dataset.origin = input.checked;
                            break;
                        }
                        case "tel":
                        case "date":
                        case "text":{
                            input.dataset.origin = input.value;
                            dataUpdateBox.classList.remove("active");
                            break;
                        }
                        case "select-one":{
                            input.dataset.origin = input.value;
                            ruleToString(input.value);
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
                })
                .catch((error) => console.log(error));
            }

            function ruleToString(num){
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
                        break;
                    }
                    case 8:{
                        changeStr = "탈퇴";
                        withdraw.textContent = "YES";
                        break;
                    }
                    case 9:{
                        changeStr = "관리자";
                        break;
                    }
                }
                memberStatus.textContent = changeStr;
            }
        });

        // 데이터 바뀜 체크
        let textInputs = memberTable.querySelectorAll("tbody input[type=text], tbody input[type=tel], tbody input[type=date]");
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

    const memberUpdatePromise = ({id = "", key="", value=""}) => {
        return new Promise((resolve, reject) => {
            const xhr = new XMLHttpRequest();
            let params = `id=${id}&${key}=${value}`;
            let formData = encodeURI(params);
            xhr.onload = () => {
                if (xhr.status === 200 || xhr.status === 201) {
                    //console.log(xhr);
                    if( xhr.responseText == "" ){
                        alertOpen({setText: `실패하였습니다.`,activeTime: 20,alertColor: "#ff0000"});
                        resolve(false);
                        return;
                    }
                    
                    let data = JSON.parse(xhr.responseText);
                    if( data == "" || data == null ||  data?.result == "fail" ){
                        alertOpen({setText: `실패하였습니다.`,activeTime: 20,alertColor: "#ff0000"});
                        resolve(false);
                        return;
                    }
                    if( data?.result == "sussess" ){
                        resolve(data.datas);
                        alertOpen({setText: `변경되었습니다.`,activeTime: 20,alertColor: "#30baa1"});
                    }
                } else {
                    console.error(xhr.responseText);
                }
            }
            xhr.onerror = () => reject(xhr.status);
            xhr.open('POST', '/admin/member/edit');
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
            xhr.send(formData); // 폼 데이터 객체 전송
        });
    };

    let highlight = function ( element ){
        element.classList.remove("new-update");
        element.offsetWidth;
        element.classList.add("new-update");
    }
}());
