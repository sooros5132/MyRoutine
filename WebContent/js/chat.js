window.addEventListener("load", (e)=>{

	let chatToggleBtn = document.querySelector(".chat-toggle-btn");

	let chatBox = document.querySelector(".chat-container");
	let chatRightBth = chatBox.querySelector(".chat-header-right-btn > i");
	let chatLeftBtn = chatBox.querySelector(".chat-header-left-btn > i");

	// 채팅창 =================================================
	let chatMessageBox = chatBox.querySelector(".chat-message-box");
	let chatMessageBoxInner = chatMessageBox.querySelector(".chat-message-inner");

	// 헤더 ===================================================
	let chatHeaderBox = chatBox.querySelector(".chat-header-box");
	let chatHeaderText = chatHeaderBox.querySelector(".chat-header-text");

	// 친구 목록 ==============================================
	let chatFriendList = chatBox.querySelector(".chat-friend-box");
	let chatFriendListInner = chatFriendList.querySelector(".my-friend-list");

	let chatSendBox = chatBox.querySelector(".chat-send-box");
	let chatMessageInput = chatSendBox.querySelector(".message-input");
	let messageSendBtn = chatSendBox.querySelector(".chat-send-btn");

	// 회원 검색 ==============================================
	let chatFriendSearch = chatBox.querySelector(".chat-friend-search");
	let chatFriendSearchInner = chatFriendSearch.querySelector(".chat-friend-search-inner");

	let friendSearchBox = chatBox.querySelector(".friend-search-input-box");
	let friendSearchInput = friendSearchBox.querySelector(".friend-search-input");
	let friendSearchBtn = friendSearchBox.querySelector(".friend-search-btn");

	// =======================================================
	let loadingText = `<div class="chat-alert">불러오는중입니다</div>`;
	let noMoreChatText = `<div class="chat-alert">마지막입니다</div><div class="chat-alert" style="border-top: 1px dashed #ddd;border-radius:0"></div>`;
	let friendSearchText = `<div style="height: 100%;color: #ddd;text-align: center;padding-top: 40px;">닉네임으로 검색해주세요</div>`;

	// ======================================================================================
	// 테스트 나중에 로그인 배우면 값 바꾸기
	let memberId = 449;
	let otherMemberId = 0;
	// ======================================================================================
	let prevMember = 0;
	let chatPage = 1;
	let chatSize = 20;
	let searchPage = 1;
	let searchSize = 20;
	let noMoreChat = false;
	let loading = false;

	// 하단 메시지 버튼
    chatToggleBtn.addEventListener("click", ()=>{
        if(chatBox.classList.contains("d-none")){
			chatBox.classList.remove("d-none");
			getFriendList({"reqId": memberId, "state": 0});
			return;
		}
		chatBox.classList.add("d-none");
    })

	// 헤더 버튼 이벤트
	chatLeftBtn.addEventListener("click", (e)=>{
		if(e.target.classList.contains("xi-angle-left")){
			e.target.className = "xi-user-plus";
		
			chatHeaderText.textContent = "친구 목록";
			chatPage = 0;
			noMoreChat = false;
			chatMessageBoxInner.innerHTML = "";
	
			chatFriendList.classList.remove("d-none");
			chatSendBox.classList.add("d-none");
			chatMessageBox.classList.add("d-none");
			chatFriendSearch.classList.add("d-none");
			friendSearchBox.classList.add("d-none");
			return;
		}

		if(e.target.classList.contains("xi-user-plus")){
			chatHeaderText.textContent = "친구 추가(미구현)";
			chatLeftBtn.className = "xi-angle-left";
			chatFriendSearch.classList.remove("d-none");
			friendSearchBox.classList.remove("d-none");
			chatFriendList.classList.add("d-none");
			return;
		}
	});
	
	chatRightBth.addEventListener("click", (e)=>{
		chatBox.classList.add("d-none");
    });

	// 친구 리스트 클릭 이벤트
	chatFriendListInner.addEventListener("click", (e)=>{
		let target = e.target.closest('li');
		if (!target) return; 
		if (!chatFriendListInner.contains(target)) return;
		
		
		let friendNickname = target.querySelector(".friend-nickname").textContent;
		chatHeaderText.textContent = friendNickname;
		chatLeftBtn.className = "xi-angle-left";
		chatFriendList.classList.add("d-none");
		chatSendBox.classList.remove("d-none");
		chatMessageBox.classList.remove("d-none");
		
		chatMessageBoxInner.innerHTML = "";
		otherMemberId = target.dataset.friendId;
		getChatList({"memberId": memberId, "otherMemberId": otherMemberId});
	});

	// 채팅창 이벤트 =======================================================
	messageSendBtn.addEventListener("click", (e)=>{
		// if(confirm("전송하시겠습니까??"))
			sendMessage({"memberId": memberId, "otherMemberId": otherMemberId, "content": chatMessageInput.value});
	});

	chatMessageInput.addEventListener("keypress", (e)=>{
		if(!e.target.classList.contains("message-input"))
			return;
		if( e.target.value.length != 0 )
			if( e.keyCode == 13 || e.key == "Enter" )
				// if(confirm("전송하시겠습니까??"))
					sendMessage({"memberId": memberId, "otherMemberId": otherMemberId, "content": chatMessageInput.value});
	});

	chatMessageBox.addEventListener("scroll", (e)=>{
		if( chatMessageBox.scrollTop + chatMessageBox.offsetHeight == chatMessageBox.scrollHeight )
			scrollFixedUnder = true;
		if( chatMessageBox.scrollTop == 0 && !loading ){
			getChatList({"memberId": memberId, "otherMemberId": otherMemberId});
		}
	})

	// 회원 닉네임 검색 이벤트 ===============================================
	friendSearchBtn.addEventListener("click", (e)=>{
		nicknameSearch({"nickname": friendSearchInput.value});
	});

	// let friendSearchBox = chatBox.querySelector(".friend-search-input-box");
	// let friendSearchInput = friendSearchBox.querySelector(".friend-search-input");
	// let friendSearchBtn = friendSearchBox.querySelector(".friend-search-btn");


	function nicknameSearch({nickname = "", page = 1, size = searchSize}){
		getXHR({"notEncodeParams": `reqId=${reqId}&state=${state}`, "method": "POST", "url": "/api/friend/list"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let friendListData = JSON.parse(xhr.responseText);
	
				if(friendListData?.result != "sussess"){
					return;
				}
				friendListData = friendListData.datas;
	
				// console.log(friendListData);
				chatFriendListInner.innerHTML = "";
				let insertNode = "";
				friendListData.forEach(f => {
					insertNode += `<li class="friend-detail" data-friend-id="${f.id}"><div class="profile-image"><img src=""></div><div class="friend-nickname">${f.nickname}</div></li>`;
				});
				chatFriendListInner.insertAdjacentHTML("beforeend", insertNode);
			}
		})
		.catch((xhr) => console.log(xhr));
	}
	function getFriendList({reqId = 0, state = 0}){
		getXHR({"notEncodeParams": `reqId=${reqId}&state=${state}`, "method": "POST", "url": "/api/friend/list"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let friendListData = JSON.parse(xhr.responseText);
	
				if(friendListData?.result != "sussess"){
					return;
				}
				friendListData = friendListData.datas;
	
				// console.log(friendListData);
				chatFriendListInner.innerHTML = "";
				let insertNode = "";
				friendListData.forEach(f => {
					insertNode += `<li class="friend-detail" data-friend-id="${f.id}"><div class="profile-image"><img src=""></div><div class="friend-nickname">${f.nickname}</div></li>`;
				});
				chatFriendListInner.insertAdjacentHTML("beforeend", insertNode);
			}
		})
		.catch((xhr) => console.log(xhr));
	}

	function getChatList({memberId = 0, otherMemberId = 0}){
		loading = true;

		if( noMoreChat )
			return;
		if( chatMessageBoxInner.children.length == 0 )
			scrollFixedUnder = true;
		else
			scrollFixedUnder = false;
		
		chatPage++;
		if(prevMember != otherMemberId){
			chatMessageBoxInner.insertAdjacentHTML("afterbegin",loadingText);
			chatPage = 1;
		}

		prevMember = otherMemberId;

		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}&page=${chatPage}&size=${chatSize}`, "method": "POST", "url": "/api/chat/get"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				loading = false;
				let chatData = JSON.parse(xhr.responseText);
	
				if(chatData?.result == "fail"){
					chatMessageBoxInner.innerHTML = "";
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div class="chat-alert">실패하였습니다</div>`);
					return;
				}
				if(chatData.result == "empty"){
					chatMessageBoxInner.innerHTML = "";
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div class="chat-alert">메시지가 없습니다.</div>`);
					return;
				}
				if(chatData.result != "sussess"){
					chatMessageBoxInner.innerHTML = "";
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", `<div class="chat-alert">알수없는 오류입니다.</div>`);
					return;
				}
				if(chatPage == 1)
					chatMessageBoxInner.innerHTML = "";

				chatData = chatData.datas;
				let topNode = chatMessageBoxInner.children[0];
				let insertNode = "";
				if( chatData.length != chatSize ){
					noMoreChat = true;
				} else {
					noMoreChat = false;
				}
				chatData.forEach(c => {
					let whoSent = "my";
					if(c.regMemberId == otherMemberId)
						whoSent = "other";
					let regDate = new Date(c.registrantionDate);
					let regDateFmt = MMddHHmm(regDate);
					insertNode += `<div class="${whoSent}-message"><div>${c.contents}</div><div class="message-regDate">${regDateFmt}</div></div>`;
				});
				chatMessageBoxInner.insertAdjacentHTML("afterbegin", insertNode);

				if( noMoreChat )
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", noMoreChatText);
				if( chatPage > 1 && !scrollFixedUnder )
					chatMessageBox.scrollTop =  topNode.offsetTop - topNode.offsetHeight - 21;
				if( scrollFixedUnder )
					chatMessageBox.scrollTop = chatMessageBox.scrollHeight;
			}
		})
		.catch((error) => console.log(error));
	}

	function sendMessage({memberId = 0, otherMemberId = 0, content = ""}){
		chatMessageInput.value = "";
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

				chatMessageBoxInner.insertAdjacentHTML("beforeend", insertNode);

				chatMessageBox.scrollTop = chatMessageBox.scrollHeight;
			}
		})
		.catch((error) => console.log(error));
	}

	function MMddHHmm(date){
		let month = "" + (date.getMonth() + 1),
		day = "" + date.getDate(),
		hours = "" + date.getHours(),
		minutes = "" + date.getMinutes();

		if (month.length < 2)
		month = "0" + month;
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
	getChatMore = getChatList
});
let getChatMore;