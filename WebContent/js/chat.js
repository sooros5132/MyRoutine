window.addEventListener("load", (e)=>{

	let chatToggleBtn = document.querySelector(".chat-toggle-btn");

	let chatBox = document.querySelector(".chat-container");
	let chatRightBth = chatBox.querySelector(".chat-header-right-btn > i");
	let chatLeftBtn = chatBox.querySelector(".chat-header-left-btn > i");

	// 채팅창 ========================================================================
	let chatMessageBox = chatBox.querySelector(".chat-message-box");
	let chatMessageBoxInner = chatMessageBox.querySelector(".chat-message-inner");

	// 헤더 ==========================================================================
	let chatHeaderBox = chatBox.querySelector(".chat-header-box");
	let chatHeaderText = chatHeaderBox.querySelector(".chat-header-text");

	// 친구 목록 =====================================================================
	let chatFriendList = chatBox.querySelector(".my-friend-box");
	let chatFriendListInner = chatFriendList.querySelector(".my-friend-list");
	
	let chatSendBox = chatBox.querySelector(".chat-send-box");
	let chatMessageInput = chatSendBox.querySelector(".message-input");
	let messageSendBtn = chatSendBox.querySelector(".chat-send-btn");
	
	let newFriendList = chatBox.querySelector(".new-friend-box");
	let newFriendListInner = newFriendList.querySelector(".new-friend-list");

	// 상단 알림 박스 ================================================================
	let topAlertBox = chatBox.querySelector(".chat-top-alert-box");
	let topAlertText = topAlertBox.querySelector(".top-alert-text");
	let topAlertBtn = topAlertBox.querySelector(".top-alert-btn");

	// 회원 검색 =====================================================================
	let chatFriendSearch = chatBox.querySelector(".chat-friend-search");
	let searchFriendList = chatFriendSearch.querySelector(".search-friend-list");

	let friendSearchBox = chatBox.querySelector(".friend-search-input-box");
	let friendSearchInput = friendSearchBox.querySelector(".friend-search-input");
	let friendSearchBtn = friendSearchBox.querySelector(".friend-search-btn");

	let friendAddBtn = friendSearchBox.querySelector("action-friend-btn");

	// 사용자 입력 박스 ==============================================================
	let confirmBox = chatBox.querySelector(".friend-add-confirm");
	let confirmTextBox = confirmBox.querySelector(".confirm-text-box");
	let confirmBtnBox = confirmBox.querySelector(".confirm-btn-box");
	let confirmYesBtn = confirmBtnBox.querySelector(".confirm-yes-btn");
	let confirmNoBtn = confirmBtnBox.querySelector(".confirm-no-btn");
	let confirmOkBtn = confirmBtnBox.querySelector(".confirm-ok-btn");


	// 텍스트 =======================================================================
	let loadingText = `<div class="chat-alert" style="padding-top: 30px;">불러오는 중입니다</div>`;
	let noMoreText = `<li class="chat-alert">마지막 입니다</li>`;
	let dashedNode = `<div class="chat-alert" style="border-top: 1px dashed #ddd;border-radius:0"></div>`;
	let friendSearchText = `<li class="friend-search-text chat-alert">닉네임으로 검색해주세요</li>`;
	let noMoreChatText = `<li class="chat-alert">메시지가 없습니다.</li>`;
	let friendSearching = `<li class="friend-search-text chat-alert">검색중입니다.</li>`;
	let friendDeleteText = `<div class="chat-alert friend-delete" data-action="delete"><span class="pointer reject">친구 삭제</span></div>`;
	let failText = `<div class="chat-alert">실패하였습니다</div>`;
	let notKnowErrorText = `<div class="chat-alert">알 수 없는 오류입니다</div>`;
	
	// ======================================================================================
	// ======================================================================================
	// ======================================================================================
	// ======================================================================================
	// 테스트 나중에 로그인 배우면 값 바꾸기
	let memberId = 449;
	let otherMemberId = 0;
	// ======================================================================================
	// ======================================================================================
	// ======================================================================================
	// ======================================================================================

	// 채팅에 필요한 변수들
	let chatPage = 1;
	let chatSize = 20;
	let prevMember = 0;
	let noMoreChat = false;
	let chatLoading = false;
	
	// 검색에 필요한 변수들
	let searchPage = 1;
	let searchSize = 20;
	let prevSearchNickname = "";
	let noMoreSearchingResult = false;
	let searchLoading = false;

	let friendActionId = 0;
	let friendElement = null;

	// 상단 알림 버튼 ===========================================================
	topAlertBox.addEventListener("click", (e)=>{
		topAlertBox.classList.add("smaller");

		chatLeftBtn.className = "xi-angle-left";
		chatHeaderText.textContent = "친구 요청 목록";
		newFriendList.classList.remove("d-none");
		chatFriendList.classList.add("d-none");
	});
	
	chatBox.addEventListener("click", (e)=>{
		if(chatHeaderText.textContent != "친구 목록"){
			topAlertBox.classList.add("smaller");
		}
		// console.log(e.target);
		if(e.target.tagName == "SPAN" && e.target.parentElement.classList.contains("friend-delete")){
			let target = e.target.parentElement;
			let friendList = chatFriendListInner.querySelectorAll(".action-friend-btn");
			if(target.classList.contains("active")){
				friendList.forEach(f => {
					f.classList.add("d-none");
					f.parentElement.classList.remove("shake");
				});
				target.classList.remove("active");
			} else {
				friendList.forEach(f => {
					f.classList.remove("d-none");
					let p = f.parentElement;
					p.style.animationDelay = `-${(Math.random() * 5).toFixed(2)}s`;
					f.parentElement.classList.add("shake");
				});
				target.classList.add("active");
			}
			
		}
	})
	// let topAlertBox = chatBox.querySelector(".chat-top-alert-box");
	// let topAlertText = topAlertBox.querySelector(".top-alert-text");
	// let topAlertBtn = topAlertBox.querySelector(".top-alert-btn");

	// 하단 메뉴 메시지 버튼 ==================================================
    chatToggleBtn.addEventListener("click", ()=>{
        if(chatBox.classList.contains("d-none")){
			chatBox.classList.remove("d-none");
			getFriendList({"reqId": memberId, "state": 0});
			return;
		}
		chatBox.classList.add("d-none");
    })

	// 헤더 버튼 이벤트 =======================================================
	chatLeftBtn.addEventListener("click", (e)=>{
		if(e.target.classList.contains("xi-angle-left")){
			e.target.className = "xi-user-plus";
		
			chatHeaderText.textContent = "친구 목록";
			chatMessageBoxInner.innerHTML = "";
			
			prevMember = "";

			prevSearchNickname = "";
	
			chatFriendList.classList.remove("d-none");
			chatSendBox.classList.add("d-none");
			chatMessageBox.classList.add("d-none");
			chatFriendSearch.classList.add("d-none");
			friendSearchBox.classList.add("d-none");
			topAlertBox.classList.add("d-none");
			newFriendList.classList.add("d-none");

			if( newFriendListInner.children.length ){
				topAlertBox.classList.remove("d-none");
				topAlertBox.classList.remove("smaller");
			}

			return;
		}

		if(e.target.classList.contains("xi-user-plus")){
			chatHeaderText.textContent = "친구 검색";


			chatLeftBtn.className = "xi-angle-left";
			chatFriendSearch.classList.remove("d-none");
			friendSearchBox.classList.remove("d-none");
			chatFriendList.classList.add("d-none");

			prevSearchNickname = "";
			searchFriendList.innerHTML = "";
			searchFriendList.insertAdjacentHTML("beforeend", friendSearchText);

			return;
		}
	});
	
	chatRightBth.addEventListener("click", (e)=>{
		chatBox.classList.add("d-none");
    });

	// 친구 리스트 클릭 이벤트 ==================================================
	chatFriendListInner.addEventListener("click", (e)=>{
		let target = e.target.closest('li');
		if (!target) return; 
		if (!chatFriendListInner.contains(target)) return;
		
		
		// target   = li 태그
		// e.target = 클릭한 태그
		console.log(target)
		console.log(target.dataset.friendId)
		otherMemberId = target.dataset.friendId;
		let friendNickname = target.querySelector(".friend-nickname").textContent;

		if( e.target.classList.contains("action-friend-btn") || 
			e.target.classList.contains("xi-close") ){

			confirmTextBox.innerHTML = `<span class="bold">${friendNickname}</span>님을 삭제하시겠습니까??<br><br>채팅기록은 삭제되지 않습니다.`;
			confirmYesBtn.dataset.action = "delete";
			confirmYesBtn.classList.add("reject-box");
			confirmYesBtn.textContent = "삭제";
			
			friendElement = target;
			friendActionId = target.dataset.friendId;
			confirmBox.classList.remove("d-none");
			return;
		}
		
		chatHeaderText.textContent = friendNickname;
		chatLeftBtn.className = "xi-angle-left";
		chatFriendList.classList.add("d-none");
		chatSendBox.classList.remove("d-none");
		chatMessageBox.classList.remove("d-none");
		
		chatMessageBoxInner.innerHTML = "";
		getChatList({"memberId": memberId, "otherMemberId": otherMemberId});
	});

	// 채팅창 이벤트 =======================================================
	messageSendBtn.addEventListener("click", (e)=>{
		// if(confirm("전송하시겠습니까??"))
			sendMessage({"memberId": memberId, "otherMemberId": otherMemberId, "content": chatMessageInput.value});
	});

	chatMessageInput.addEventListener("keypress", (e)=>{
		if(!e.target.classList.contains("message-input")) return;

		if( e.target.value.length != 0 )
			if( e.keyCode == 13 || e.key == "Enter" )
				// if(confirm("전송하시겠습니까??"))
					sendMessage({"memberId": memberId, "otherMemberId": otherMemberId, "content": chatMessageInput.value});
	});

	chatMessageBox.addEventListener("scroll", (e)=>{
		if( chatMessageBox.scrollTop + chatMessageBox.offsetHeight == chatMessageBox.scrollHeight )
			scrollFixedUnder = true;
		if( chatMessageBox.scrollTop == 0 && !chatLoading ){
			getChatList({"memberId": memberId, "otherMemberId": otherMemberId});
		}
	})

	// 회원 닉네임 검색 이벤트 ===============================================
	friendSearchBtn.addEventListener("click", (e)=>{
		prevSearchNickname = "";
		if(!searchLoading)
			nicknameSearch({"memberId": memberId, "nickname": friendSearchInput.value});
	});

	friendSearchInput.addEventListener("keypress", (e)=>{
		if( e.target.value.length != 0 && !searchLoading )
			if( e.keyCode == 13 || e.key == "Enter" ){
				prevSearchNickname = "";
				nicknameSearch({"memberId": memberId, "nickname": friendSearchInput.value});
			}
	});

	chatFriendSearch.addEventListener("scroll", (e)=>{
		if( chatFriendSearch.scrollTop + chatFriendSearch.offsetHeight != chatFriendSearch.scrollHeight && !searchLoading )
			return;
		nicknameSearch({"memberId": memberId, "nickname": prevSearchNickname});
	})

	// 친구 신청 버튼 =======================================================
	chatFriendSearch.addEventListener("click", (e)=>{
		let target = e.target.closest('div');
		if (!target) return; 
		if (!chatFriendSearch.contains(target)) return;

		if(!target.classList.contains("action-friend-btn")) return;

		let friendId = target.dataset.friendId;
		let action = target.dataset.action;

		if( friendId == undefined || friendId == 0 || 
			!(action == "add" || action == "cancel") ) 
			return;

		friendActionId = friendId;
		friendElement = target.parentElement;
		let addFriendNickname = target.parentElement.querySelector(".friend-nickname").textContent;

		if( action == "add" ){
			confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님한테 친구 신청을 보내겠습니까??`;
			confirmYesBtn.dataset.action = action;
		}
		if( action == "cancel" ){
			confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>한테 보낸 친구 요청을 취소할까요??`;
			confirmYesBtn.dataset.action = action;
		}

		showConfirmOkBtn(false);
		confirmBox.classList.remove("d-none");
	});
	

	// 친구 요청 받기 버튼 =======================================================
	newFriendList.addEventListener("click", (e)=>{
		
		let target = e.target.closest('div');
		if (!target) return; 
		if (!newFriendList.contains(target)) return;

		if(!target.classList.contains("action-friend-btn")) return;

		let friendId = target.dataset.friendId;
		let action = target.dataset.action;

		if( friendId == undefined || friendId == 0 ||
			!(action == "resolve" || action == "reject"))
			return;

		friendActionId = friendId;
		friendElement = target.parentElement;
		let addFriendNickname = target.parentElement.querySelector(".friend-nickname").textContent;

		if( action == "resolve" ){
			confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님의 친구 요청을 받으시겠습니까??`;
			confirmYesBtn.dataset.action = "resolve";
		}
		if( action == "reject" ){
			confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님의 친구 요청을 거절할까요??`;
			confirmYesBtn.classList.add("reject-box");
			confirmYesBtn.dataset.action = "reject";
			confirmYesBtn.textContent = "거절";
		}
		showConfirmOkBtn(false);
		confirmBox.classList.remove("d-none");
	});
	// let confirmBox = chatBox.querySelector(".friend-add-confirm");
	// let confirmTextBox = confirmBox.querySelector(".confirm-text-box");
	// let confirmBtnBox = confirmBox.querySelector(".confirm-btn-box");
	// let confirmYesBtn = confirmBtnBox.querySelector(".confirm-yes-btn");
	// let confirmNoBtn = confirmBtnBox.querySelector(".confirm-no-btn");
	// let friendSearchBox = chatBox.querySelector(".friend-search-input-box");
	// let friendSearchInput = friendSearchBox.querySelector(".friend-search-input");
	// let friendSearchBtn = friendSearchBox.querySelector(".friend-search-btn");


	// 사용자 입력창 =============================================================
	confirmBox.addEventListener("click", (e)=>{
		if( e.target.classList.contains("friend-add-confirm") || 
			e.target === confirmOkBtn || 
			e.target === confirmNoBtn ){
			confirmBox.classList.add("d-none");
			confirmActionClear();
			return;
		}
		if( e.target === confirmYesBtn ){
			switch(e.target.dataset.action){
				case "add": {
					addFriend({"memberId": memberId, "otherMemberId": friendActionId});
					break;
				}
				case "cancel": {
					addFriendCancel({"memberId": memberId, "otherMemberId": friendActionId});
					break;
				}
				case "resolve": {
					addFriendResolve({"memberId": memberId, "otherMemberId": friendActionId});
					break;
				}
				case "reject": {
					addFriendReject({"memberId": memberId, "otherMemberId": friendActionId});
					return;
				}
				case "delete": {
					friendDelete({"memberId": memberId, "otherMemberId": friendActionId});
					return;
				}
			}
			confirmActionClear();
			return;
		}
	})

	// 친구 기능 =============================================================================================
	function addFriend({memberId = 0, otherMemberId = 0}){
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}`, "method": "POST", "url": "/api/friend/add"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let result = JSON.parse(xhr.responseText);
				
				showConfirmOkBtn(true);

				if( !result ){
					confirmTextBox.textContent = `실패하였습니다`;
					return;
				}
				if( result.result == "exist" ){
					confirmTextBox.textContent = `이미 요청하였거나 친구상태 입니다`;
					return;
				}
				if( result.result != "sussess" || result.datas[0].result == 0 ){
					confirmTextBox.textContent = `요청하려는 친구가 없거나 실패하였습니다`;
					return;
				}

				let addFriendNickname = confirmTextBox.querySelector("span").textContent;
				confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님한테 요청을 보냈습니다`;

				let current = friendElement.querySelector(".action-friend-btn");
				current.dataset.action = "cancel";
				current.querySelector("i").className = "xi-check";
			}
		})
		.catch((xhr) => console.log(xhr));
	}
	function addFriendResolve({memberId = 0, otherMemberId = 0}){
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}&state=1`, "method": "POST", "url": "/api/friend/resolve"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let result = JSON.parse(xhr.responseText);
				
				showConfirmOkBtn(true);

				if( result?.result != "sussess" || result?.datas[0].result == 0 ){
					confirmTextBox.textContent = `실패하였습니다`;
					return;
				}
				let addFriendNickname = confirmTextBox.querySelector("span").textContent;
				confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님의 친구 요청을 받았습니다`;
				getFriendList({"reqId": memberId, "state": 0});
			}
		})
		.catch((xhr) => console.log(xhr));
	}
	function addFriendReject({memberId = 0, otherMemberId = 0}){
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}`, "method": "POST", "url": "/api/friend/reject"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let result = JSON.parse(xhr.responseText);
				
				showConfirmOkBtn(true);

				if( result?.result != "sussess" || result?.datas[0].result == 0 ){
					confirmTextBox.textContent = `실패하였습니다`;
					return;
				}
				let addFriendNickname = confirmTextBox.querySelector("span").textContent;
				confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님의 친구 요청을 거절했습니다`;
				friendElement.remove();
			}
		})
		.catch((xhr) => console.log(xhr));
	}
	function addFriendCancel({memberId = 0, otherMemberId = 0}){
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}&state=2`, "method": "POST", "url": "/api/friend/cancel"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let result = JSON.parse(xhr.responseText);
				
				showConfirmOkBtn(true);

				if( result?.result != "sussess" || result.datas[0].result == 0 ){
					confirmTextBox.textContent = `실패하였습니다`;
					return;
				}
				let addFriendNickname = confirmTextBox.querySelector("span").textContent;
				confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님 한테 보낸 요청을 취소하였습니다`;
				let current = friendElement.querySelector(".action-friend-btn");
				current.dataset.action = "add";
				current.querySelector("i").className = "xi-plus";
			}
		})
		.catch((xhr) => console.log(xhr));
	}
	function friendDelete({memberId = 0, otherMemberId = 0}){
		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}`, "method": "POST", "url": "/api/friend/delete"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				let result = JSON.parse(xhr.responseText);
				
				showConfirmOkBtn(true);

				if( result?.result != "sussess" || result?.datas[0].result == 0 ){
					confirmTextBox.textContent = `실패하였습니다`;
					return;
				}
				let addFriendNickname = confirmTextBox.querySelector("span").textContent;
				confirmTextBox.innerHTML = `<span class="bold">${addFriendNickname}</span>님이랑 이제 모르는 사이입니다.`;
				friendElement.remove();
			}
		})
		.catch((xhr) => console.log(xhr));
	}
	// 사용자 입력 초기화 =============================================================================================
	function showConfirmOkBtn(showOkBtn){
		if(showOkBtn){
			confirmYesBtn.classList.add("d-none");
			confirmNoBtn.classList.add("d-none");
			confirmOkBtn.classList.remove("d-none");
		} else {
			confirmYesBtn.classList.remove("d-none");
			confirmNoBtn.classList.remove("d-none");
			confirmOkBtn.classList.add("d-none");
		}
		confirmActionClear()
	}
	function confirmActionClear(){
		confirmYesBtn.dataset.action = "";
		confirmNoBtn.dataset.action = "";
		confirmOkBtn.dataset.action = "";
		confirmYesBtn.textContent = "확인";
		confirmNoBtn.textContent = "취소";
		confirmOkBtn.textContent = "확인";
		confirmYesBtn.classList.remove("reject-box");
	}

	// 닉네임 검색 =============================================================================================
	function nicknameSearch({memberId = memberId, nickname = "", page = 1, size = searchSize}){
		
		if(prevSearchNickname != nickname){
			searchPage = 0;
			searchFriendList.innerHTML = "";
			noMoreSearchingResult = false;
			searchLoading = false;
		}

		if( noMoreSearchingResult || searchLoading || nickname == "")
			return;

		searchLoading = true;
		searchPage++;
			
		prevSearchNickname = nickname;
		
		searchFriendList.insertAdjacentHTML("beforeend", friendSearching);

		let bottomNode = searchFriendList.children[searchFriendList.children.length - 1];

		getXHR({"notEncodeParams": `memberId=${memberId}&nickname=${nickname}&page=${searchPage}&size=${size}`, "method": "POST", "url": "/api/friend/search"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				searchLoading=false;
				bottomNode.remove();

				let friendListData = JSON.parse(xhr.responseText);
				
				if(friendListData?.result == "fail"){
					searchFriendList.insertAdjacentHTML("beforeend", failText);
					return;
				}
				if(friendListData.result == "empty"){
					searchFriendList.insertAdjacentHTML("beforeend", `<div class="chat-alert"><span class="bold">${nickname}</span>의 검색 결과가 없습니다.</div>`);
					return;
				}
				if(friendListData.result != "sussess"){
					searchFriendList.insertAdjacentHTML("beforeend", notKnowErrorText);
					return;
				}
				
				friendListData = friendListData.datas;
	
				// console.log(friendListData);
				let insertNode = "";
				friendListData.forEach(f => {
					insertNode += `<li class="friend-search-result"><div class="profile-image"><i class="xi-profile"></i></div><div class="friend-nickname">${f.nickname}</div><div class="action-friend-btn" data-friend-id="${f.id}" data-action="add"><i class="xi-plus"></i></div></li>`;
				});

				searchFriendList.insertAdjacentHTML("beforeend", insertNode)
				
				if( friendListData.length != searchSize ){
					noMoreSearchingResult = true;
					searchFriendList.insertAdjacentHTML("beforeend", noMoreText);
				} else {
					noMoreSearchingResult = false;
				}
				
				// 화면이 커서 더 불러와야 하는 경우
				if( !noMoreSearchingResult && chatFriendSearch.scrollTop + chatFriendSearch.offsetHeight == chatFriendSearch.scrollHeight )
					nicknameSearch({"memberId": memberId, "nickname": nickname, "page": page, "size": size});
			}
		})
		.catch((xhr) => console.log(xhr));
	}

	// 친구 목록 불러오기 =============================================================================================
	function getFriendList({reqId = 0, state = 0}){

		chatFriendListInner.innerHTML = "";
		chatFriendListInner.insertAdjacentHTML("beforeend", loadingText);
		newFriendListInner.innerHTML = "";
		newFriendListInner.insertAdjacentHTML("beforeend", loadingText);
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
				newFriendListInner.innerHTML = "";
				let friendNode = "";
				let newFriendNode = "";
				friendListData.forEach(f => {
					let temp = `<li class="friend-detail" data-friend-id="${f.id}"><div class="profile-image"><i class="xi-profile"></i></div><div class="friend-nickname">${f.nickname}</div>`;
					if( f.state == 1 )
						friendNode += `${temp}<div class="action-friend-btn reject d-none" data-friend-id="${f.id}" data-action="delete"><i class="xi-close"></i></div></li>`
					else if(f.state == 2)
						newFriendNode += `${temp}<div class="action-friend-btn resolve" data-friend-id="${f.id}" data-action="resolve"><i class="xi-plus"></i></div><div class="action-friend-btn reject" data-friend-id="${f.id}" data-action="reject"><i class="xi-close"></i></div></li>`;
				});
				chatFriendListInner.insertAdjacentHTML("beforeend", friendNode);
				chatFriendListInner.insertAdjacentHTML("beforeend", friendDeleteText);
				
				newFriendListInner.insertAdjacentHTML("beforeend", newFriendNode);
				if( newFriendNode && chatHeaderText.textContent == "친구 목록" ){
					topAlertBox.classList.remove("smaller");
				}
			}
		})
		.catch((xhr) => console.log(xhr));
	}

	// 채팅 기록 불러오기 =============================================================================================
	function getChatList({memberId = 0, otherMemberId = 0}){

		if(prevMember != otherMemberId){
			chatMessageBoxInner.innerHTML = "";
			chatPage = 0;
			noMoreChat = false;
			chatLoading = false;
		}

		if( noMoreChat || chatLoading )
			return;

		chatPage++;
		chatLoading = true;
		
		if( chatMessageBoxInner.children.length == 0 )
			scrollFixedUnder = true;
		else
			scrollFixedUnder = false;
		

		prevMember = otherMemberId;

		chatMessageBoxInner.insertAdjacentHTML("afterbegin", friendSearching);
		let topNode = chatMessageBoxInner.children[0];

		getXHR({"notEncodeParams": `memberId=${memberId}&otherMemberId=${otherMemberId}&page=${chatPage}&size=${chatSize}`, "method": "POST", "url": "/api/chat/get"})
		.then((xhr) => {
			if( xhr.status === 200 || xhr.status === 201 ){
				chatLoading = false;
				let chatData = JSON.parse(xhr.responseText);
	
				if(chatData?.result == "fail"){
					topNode.remove();
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", failText);
					return;
				}
				if(chatData.result == "empty"){
					topNode.remove();
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", noMoreChatText);
					return;
				}
				if(chatData.result != "sussess"){
					topNode.remove();
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", notKnowErrorText);
					return;
				}

				chatData = chatData.datas;
				let insertNode = "";
				let continueMessage = true;

				let friendMessages = "";
				let myMessages = "";
				let prevRegMember = "";

				chatData.forEach(c => {
					let whoSent = "my";
					let regDate = new Date(c.registrantionDate);
					let regDateFmt = MMddHHmm(regDate);

					if(c.regMemberId != memberId){
					// 상대방이 보낸 메시지
						whoSent = "friend";
						if( prevRegMember != whoSent ){
							insertNode += `</div>`;
							insertNode += `<div class="other-message"><div class="profile-image"><i class="xi-profile"></i></div><div class="other-message-content">`;
						}
						insertNode += `<div class="message"><div><div>${c.contents}</div><div class="message-reg-date">${regDateFmt}</div></div></div>`; 
					} else {
					// 내가 보낸 메시지
						if( prevRegMember != whoSent ){
							insertNode += `</div></div>`;
							insertNode += `<div class="my-message">`
						}
						insertNode += `<div class="message"><div><div>${c.contents}</div><div class="message-reg-date">${regDateFmt}</div></div></div>`;
					}
					prevRegMember = whoSent;
				});

				if( prevRegMember != "friend" )
					insertNode += `</div>`;
				else 
					insertNode += `</div></div>`;

				chatMessageBoxInner.insertAdjacentHTML("afterbegin", insertNode);
				
				
				if( chatData.length != chatSize ){
					noMoreChat = true;
					chatMessageBoxInner.insertAdjacentHTML("afterbegin", noMoreText);
				} else {
					noMoreChat = false;
				}

				// 불러오기로 스크롤 고정 후 node 삭제
				if( chatPage > 1 && !scrollFixedUnder )
					chatMessageBox.scrollTop =  topNode.offsetTop - topNode.offsetHeight - 21;
				topNode.remove();

				if( scrollFixedUnder ){
					chatMessageBox.scrollTop = chatMessageBox.scrollHeight;
				}
				
				// 화면이 커서 더 불러와야 하는 경우
				if( !noMoreChat && chatMessageBox.scrollTop == 0 ){
					getChatList({"memberId": memberId, "otherMemberId": otherMemberId});
				}
			}
		})
		.catch((error) => console.log(error));
	}

	// 메시지 전송 =============================================================================================
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
				let insertNode = `<div class="my-message"><div>${content}</div><div class="message-reg-date">${regDateFmt}</div></div>`;

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
});