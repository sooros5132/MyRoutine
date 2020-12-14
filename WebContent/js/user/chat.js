window.addEventListener("load", (e)=>{

	let chatToggleBtn = document.querySelector(".chat-toggle-btn");

	let chatBox = document.querySelector(".chat-container");
	let chatCloseBtn = chatBox.querySelector(".chat-close-btn");

	let chatFriendList = chatBox.querySelector(".chat-friend-list");
	let chatMessageBox = chatBox.querySelector(".chat-message-box");

	let chatHeaderBox = chatBox.querySelector(".chat-header-box");
	let chatHeaderText = chatHeaderBox.querySelector(".chat-header-text");

	let chatInputBox = chatBox.querySelector(".chat-input-box");
	let messageSendBtn = chatInputBox.querySelector(".chat-send");

    chatToggleBtn.addEventListener("click", ()=>{
        if(chatBox.classList.contains("d-none")){
			chatBox.classList.remove("d-none");
			return;
		}
		chatBox.classList.add("d-none");
    })

	chatCloseBtn.addEventListener("click", ()=>{
		chatBox.classList.add("d-none");
    });

	let chattingOpenBtns = chatBox.querySelectorAll(".chat-friend-inner > div");
	chattingOpenBtns.forEach(chattingOpenBtn => {
		chattingOpenBtn.addEventListener("click", (e)=>{
			let friendNickname = chattingOpenBtn.querySelector(".friend-nickname").textContent;
			chatHeaderText.textContent = friendNickname;

			chatFriendList.classList.add("d-none");
			chatHeaderBox.children[0].classList.remove("hide");
			chatInputBox.classList.remove("d-none");
			chatMessageBox.classList.remove("d-none");
		});
	});

	chatHeaderBox.children[0].addEventListener("click", (e)=>{
		chatHeaderText.textContent = "친구 목록";
		
		chatFriendList.classList.remove("d-none");
		chatHeaderBox.children[0].classList.add("hide");
		chatInputBox.classList.add("d-none");
		chatMessageBox.classList.add("d-none");
	});

});