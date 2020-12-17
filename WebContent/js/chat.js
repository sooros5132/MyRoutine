window.addEventListener("load", (e)=>{

	let chatToggleBtn = document.querySelector(".chat-toggle-btn");

	let chatBox = document.querySelector(".chat-container");
	let chatCloseBtn = chatBox.querySelector(".chat-close-btn");

	let chatFriendList = chatBox.querySelector(".chat-friend-list");
	let chatFriendListInner = chatFriendList.querySelector(" .chat-friend-inner");
	let chatMessageBox = chatBox.querySelector(".chat-message-box");
	let chatMessageBoxInner = chatMessageBox.querySelector(".chat-message-inner");

	let chatHeaderBox = chatBox.querySelector(".chat-header-box");
	let chatHeaderText = chatHeaderBox.querySelector(".chat-header-text");

	let chatInputBox = chatBox.querySelector(".chat-input-box");
	let chatMessageInput = chatInputBox.querySelector(".send-message");
	let messageSendBtn = chatInputBox.querySelector(".chat-send");

	let loadingText = `<div style="width: 100%;text-align: center;">불러오는중입니다</div>`;

	// ======================================================================================
	// 테스트 나중에 로그인 배우면 값 바꾸기
	let memberId = 449;
	let otherMemberId = 448;
	// ======================================================================================


    chatToggleBtn.addEventListener("click", ()=>{
        if(chatBox.classList.contains("d-none")){
			chatBox.classList.remove("d-none");
			getFriendList({"reqId": memberId, "state": 0});
			return;
		}
		chatBox.classList.add("d-none");
    })

	chatCloseBtn.addEventListener("click", ()=>{
		chatBox.classList.add("d-none");
    });

	chatFriendListInner.addEventListener("click", (e)=>{
		let i;
		let nodeFound = false;
		for(i = 0; i < e.path.length; i++){
			// 자식부터 부모로 올라가면서 클래스 검사
			if( e.path[i].classList.contains("friend-detail") ){
				nodeFound = true;
				break;
			}
			// for 돌다가 리스너 달아준 애 만나면 종료 ( 그 이상엔 없으므로 )
			if( e.path[i] === e.currentTarget )
				break;
		}
		// 몾찾고 오면 이벤트 종료
		if( !nodeFound )
			return;
		
		let target = e.path[i];
		console.log()
		let friendNickname = target.querySelector(".friend-nickname").textContent;
		chatHeaderText.textContent = friendNickname;

		chatFriendList.classList.add("d-none");
		chatHeaderBox.children[0].classList.remove("hide");
		chatInputBox.classList.remove("d-none");
		chatMessageBox.classList.remove("d-none");
		
		otherMemberId = target.dataset.friendId;
		chatMessageBoxInner.innerHTML = "";
		getChatList({"memberId": memberId, "otherMemberId": otherMemberId});
	});

	chatHeaderBox.children[0].addEventListener("click", (e)=>{
		chatHeaderText.textContent = "친구 목록";
		chatMessageBoxInner.innerHTML = "";

		chatFriendList.classList.remove("d-none");
		chatHeaderBox.children[0].classList.add("hide");
		chatInputBox.classList.add("d-none");
		chatMessageBox.classList.add("d-none");
	});

	messageSendBtn.addEventListener("click", (e)=>{
		if(confirm("전송하시겠습니까??"))
			sendMessage({"memberId": memberId, "otherMemberId": otherMemberId, "content": chatMessageInput.value});
	})

	chatInputBox.addEventListener("keypress", (e)=>{
		if(!e.target.classList.contains("send-message"))
			return;
		if( e.target.value.length != 0 )
			if( e.keyCode == 13 || e.key == "Enter" )
				if(confirm("전송하시겠습니까??"))
					sendMessage({"memberId": memberId, "otherMemberId": otherMemberId, "content": chatMessageInput.value});
	});

	function getFriendList({reqId = 0, state = 0}){
		getXHR({"notEncodeParams": `reqId=${reqId}&state=${state}`, "method": "POST", "url": "/api/friend/list"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let friendListData = JSON.parse(xhr.responseText);
	
				if(friendListData?.result != "sussess"){
					return;
				}
				friendListData = friendListData.datas;
	
				console.log(friendListData);
				chatFriendListInner.innerHTML = "";

				friendListData.forEach(f => {
					let tag = `<div class="friend-detail" data-friend-id="${f.id}"><div class="profile-image"><img src=""></div><div class="friend-nickname">${f.nickname}</div></div>`;
					chatFriendListInner.insertAdjacentHTML("beforeend", tag);
				});
			}
		})
		.catch((xhr) => console.log(xhr));
	}

	function getChatList({memberId = 0, otherMemberId = 0, startIndex = 1, endIndex = 20}){

		if( chatMessageBoxInner.children.length == 0 )
			scrollFixedUnder = true;
		
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}&startIndex=${startIndex}&endIndex=${endIndex}`, "method": "POST", "url": "/api/chat/get"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let chatData = JSON.parse(xhr.responseText);
	
				if(chatData?.result == "fail"){
					chatMessageBoxInner.innerHTML = "";
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div style="width: 100%;text-align: center;">실패하였습니다</div>`);
					return;
				}
				if(chatData.result == "empty"){
					chatMessageBoxInner.innerHTML = "";
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div style="width: 100%;text-align: center;">메시지가 없습니다.</div>`);
					return;
				}
				if(chatData.result != "sussess"){
					chatMessageBoxInner.innerHTML = "";
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div style="width: 100%;text-align: center;">알수없는 오류입니다.</div>`);
					return;
				}
				chatData = chatData.datas;
				
				chatData.forEach(c => {
					let whoSend = "my";
					if(c.regMemberId == otherMemberId)
						whoSend = "other";
					let regDate = new Date(c.registrantionDate);
					let regDateFmt = MMddHHmm(regDate);
					let insertNode = `<div class="${whoSend}-message"><div>${c.contents}</div><div class="message-regDate">${regDateFmt}</div></div>`;
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", insertNode);
				});
				
				if( scrollFixedUnder )
					chatMessageBox.scrollTop = chatMessageBox.scrollHeight;
			}
		})
		.catch((error) => console.log(error));
	}

	function sendMessage({memberId = 0, otherMemberId = 0, content = ""}){
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}&content=${content}`, "method": "POST", "url": "/api/chat/send"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let sendResult = JSON.parse(xhr.responseText);
	
				if(sendResult?.result == "fail"){
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div class="my-message"><div class="send-retry">실패, 다시 보내기</div><div>${content}</div></div>`);
					return;
				}
				if(sendResult.result != "sussess"){
					return;
				}
				sendResult = sendResult.datas[0];

				let regDate = new Date(sendResult.regDate);
				
				let regDateFmt = MMddHHmm(regDate);
				let insertNode = `<div class="my-message"><div>${content}</div><div class="message-regDate">${regDateFmt}</div></div>`;

				if( chatMessageBox.scrollTop + chatMessageBox.offsetHeight == chatMessageBox.scrollHeight )
					scrollFixedUnder = true;

				chatMessageBoxInner.insertAdjacentHTML("afterbegin", insertNode);

				if( scrollFixedUnder )
					chatMessageBox.scrollTop = chatMessageBox.scrollHeight;
			}
		})
		.catch((error) => console.log(error));
	}

	function MMddHHmm(date){
		let month = '' + (date.getMonth() + 1),
		day = '' + date.getDate(),
		hours = '' + date.getHours(),
		minutes = '' + date.getMinutes();

		if (month.length < 2)
		month = '0' + month;
		if (day.length < 2)
		day = "0" + day;
		if (hours.length < 2)
		hours = "0" + hours;
		if (minutes.length < 2)
		minutes = "0" + minutes;

		return `${month}-${day} ${hours}:${minutes}`;

	}

    const getXHR = ({notEncodeParams = "", method = "GET", url = ""}) => {
        return new Promise((resolve, reject) => {
			if( url == "" )
				return;

			let xhr = new XMLHttpRequest();
			let formData = encodeURI(notEncodeParams);
			xhr.onload = function() {
				if(xhr.readyState == 4)
					return resolve(xhr);
			}
			xhr.onerror = () => reject(xhr);
			xhr.open(method, url);
			xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
			xhr.send(formData);
        });
    };
});