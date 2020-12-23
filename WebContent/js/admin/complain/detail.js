window.addEventListener("load",function(){
	var tbody = document.querySelector(".tbody");
	var memberId= document.querySelector(".member_id").value;
	
	var report = document.querySelector(".report");
	var data = new FormData();
	

	report.onclick= function(){
		var url= '/api/complain/report?complainId='+complainId;		
		openPrompt(url);
	}
	

	function openPrompt(url){
		var result  = prompt("신고사유를 입력하세요.");
		
		if(result!=null){
			var request = new XMLHttpRequest();
			request.onload = function(){
				alert("신고되었습니다.");			
			}
			
//			data.append('contents',result);
//			data.append('memberId',memberId);//로그인한아이디넘겨야함..
//			data.append('complainId',complainId);
//			console.log(result, membe``rId, complainId);
			for(let value of data.values()){
				console.log(value);
			}
			
			request.open('GET',url+'&contents='+result+'&memberId='+memberId);
			request.send();
			
		}
		
		
	};

	
});