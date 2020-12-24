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
        // memberTable.querySelector(".all-member-select").addEventListener("click", (e)=>{
        //     let memberList = document.querySelectorAll(".member-select");
        //     if( memberList ){
        //         memberList.forEach(member => {
        //             member.checked = e.target.checked;
        //         });
        //     }
        // });

        // 제일 왼쪽 선택 도우미
        // let memberSelects = document.querySelectorAll(".member-list .member-select");
        // memberSelects.forEach(input => {
        //     input.parentElement.addEventListener("click", (e)=>{
        //         if(input.checked)
        //             input.checked = false;
        //         else
        //             input.checked = true;
        //     })
        // });

        // 초기 Input들 세팅
        let lastLoginNodes = memberTable.querySelectorAll("tbody .member-last-login");
        lastLoginNodes.forEach(lastLogin => {
            let updateBtn = lastLogin.querySelector(".update-btn i");
            let parentTrElement = lastLogin.parentElement.parentElement;
            let memberId = parentTrElement.dataset.memberId;
            updateBtn.addEventListener("click", (e)=>{

                confirmCheck = confirm(confirmStr);
                if( !confirmCheck ){
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
            let parentTrElement = input.parentElement.parentElement.parentElement.parentElement;
            let parentTdElement = input.parentElement.parentElement.parentElement;
            let memberId = parentTrElement.dataset.memberId;
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
                    // 서버에서 받아온게 트루였다면 체크
                    let originChecked = input.dataset.origin == "1";
                    if( originChecked ) {
                        input.checked = originChecked;
                    }
                    
                    dataUpdateBox = input.parentElement.parentElement;
                    let updateBtn = dataUpdateBox.querySelector(".update-btn i");
                    updateBtn.addEventListener("click", (e)=>{
                        let changeCheck = parentTdElement.classList.contains("changed");
                        if( !changeCheck ){
                            e.preventDefault();
                            return;
                        }
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
                    dataUpdateBox = input.parentElement.parentElement;
                    let updateBtn = dataUpdateBox.querySelector(".update-btn i");
                    updateBtn.addEventListener("click", (e)=>{
                        let changeCheck = parentTdElement.classList.contains("changed");
                        if( !changeCheck ){
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
                    dataValue = input.dataset.origin;

                    // 초기 seleted 세팅 
                    input.querySelector(`option[value="${dataValue}"]`).selected = true;
                    let memberStatus = parentTrElement.querySelector(".member-status");
                    memberStatus.textContent = ruleToString(dataValue);
                    
                    dataUpdateBox = input.parentElement.parentElement;
                    let updateBtn = dataUpdateBox.querySelector(".update-btn i");
                    updateBtn.addEventListener("click", (e)=>{
                        let changeCheck = parentTdElement.classList.contains("changed");
                        if( !changeCheck ){
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
                    e.preventDefault();
                    return;
                }
                
                memberUpdatePromise({id:memberId, key:dataKey, value:dataValue})
                .then((data) => {
                    if( input.classList.contains("member-delete")){
                        parentTrElement.classList.add("delete");
                        parentTrElement.nextElementSibling.classList.add("delete");

                        setTimeout(()=>{
                            parentTrElement.nextElementSibling.remove();
                            parentTrElement.remove();
                        }, 1400);
                        return;
                    }
                    if(!data)
                        return;
                    // 변경되고 이벤트
                    switch( input.type ){
                        case "checkbox":{
                            let newData = 0;
                            if( input.checked )
                                newData = 1;
                            input.dataset.origin = newData;
                            break;
                        }
                        case "tel":
                        case "date":
                        case "text":{
                            input.dataset.origin = input.value;
                            break;
                        }
                        case "select-one":{
                            input.dataset.origin = input.value;
                            let memberStatus = parentTrElement.querySelector(".member-status");
                            memberStatus.textContent = ruleToString(input.value);
                            break;
                        }
                    }
                    parentTdElement.classList.remove("fail");
                    parentTdElement.classList.remove("changed");
                    highlight(parentTdElement);
                })
                .catch((error) => {
                    parentTdElement.classList.add("fail");
                });
            }

        });

        // 데이터 바뀜 체크
        let textInputs = memberTable.querySelectorAll("tbody input[type=text], tbody input[type=tel], tbody input[type=date], tbody input[type=checkbox], tbody select");
        textInputs.forEach(input => {
            input.addEventListener("input", (e)=>{
                let parentTdElement = input.parentElement.parentElement.parentElement;
                let originData = input.dataset.origin;
                
                parentTdElement.classList.remove("fail");

                if(input.type == "checkbox"){
                    originData = input.dataset.origin == "1";

                    if( input.checked != originData )
                        parentTdElement.classList.add("changed");
                    else 
                        parentTdElement.classList.remove("changed");

                    return;
                }
                if( input.value != originData )
                    parentTdElement.classList.add("changed");
                else 
                    parentTdElement.classList.remove("changed");
            });
        });

        // 일괄 변경 버튼 이벤트
        let updateAllBtn = document.querySelector(".update-all-btn");
        updateAllBtn.addEventListener("click", ()=>{
            let updateBtns = memberTable.querySelectorAll("tbody td.changed .update-btn");
            if(updateBtns.length == 0)
                return;
            
            let confirmCheck = confirm("변경된 데이터들을 일괄 변경 하시겠습니까??");
            if( confirmCheck ){
                let resultCount = 0;
                updateBtns.forEach(updateBtn => {
                    let parentTrElement = updateBtn.parentElement.parentElement.parentElement;
                    let parentTdElement = updateBtn.parentElement.parentElement;
                    let input = parentTdElement.querySelector(`input[type="text"], input[type="tel"], input[type="checkbox"], input[type="date"], select`);
                    let memberId = parentTrElement.dataset.memberId;
                    let dataKey = input.name;
                    let dataValue;
                    switch( input.type ){
                        case "checkbox":{
                            dataValue = 0;
                            if( input.checked )
                                dataValue = 1;
                            break;
                        }
                        case "tel":
                        case "date":
                        case "text":
                        case "select-one":{
                            dataValue = input.value;
                            break;
                        }
                    }
                    console.log(input);
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
                                break;
                            }
                            case "select-one":{
                                console.log(data);
                                input.dataset.origin = input.value;
                                let memberStatus = parentTrElement.querySelector(".member-status");
                                memberStatus.textContent = ruleToString(input.value);
                                break;
                            }
                        }
                        parentTdElement.classList.remove("changed");
                        highlight(parentTdElement);
                        alertOpen({setText: `${++resultCount}개가 변경되었습니다.`,activeTime: 20,alertColor: "#30baa1"});
                    })
                    .catch((error) => {
                        parentTdElement.classList.add("fail");
                    });
                });
            }
        })
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
                        reject(xhr.status);
                        return;
                    }
                    
                    let data = JSON.parse(xhr.responseText);
                    if( data == "" || data == null ||  data.result == "fail" ){
                        alertOpen({setText: `실패하였습니다.`,activeTime: 20,alertColor: "#ff0000"});
                        reject(xhr.status);
                        return;
                    }
                    if( data.result == "sussess" ){
                        alertOpen({setText: `변경되었습니다.`,activeTime: 20,alertColor: "#30baa1"});
                    }
                    resolve(data.datas);
                } else {
                    console.error(xhr.responseText);
                }
            }
            xhr.onerror = () => reject(xhr.status);
            xhr.open('POST', '/api/member/edit');
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
            xhr.send(formData); // 폼 데이터 객체 전송
        });
    };

    let highlight = function ( element ){
        element.classList.remove("new-update");
        element.offsetWidth;
        element.classList.add("new-update");
    }
    
    let ruleToString = function(num){
        let changeStr = "";

        num = parseInt(num);
        switch(num){
            case 1:{
                changeStr = "회원";
                break;
            }
            case 7:{
                changeStr = "차단";
                break;
            }
            case 8:{
                changeStr = "탈퇴";
                break;
            }
            case 9:{
                changeStr = "관리자";
                break;
            }
        }
        return changeStr;
    }

}());
