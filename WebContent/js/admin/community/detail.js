window.addEventListener("load",function(){
	var apBtn = document.querySelector(".ap-btn");
	var tbody = document.querySelector(".tbody");
	var communityId= document.querySelector(".community_id").value;
	var memberId= document.querySelector(".member_id").value;
	var cmtId= document.querySelector(".cmt-id");
	
	var report = document.querySelector(".report");
	var commReport= document.querySelector(".comn-report");
	var data = new FormData();
	

	report.onclick= function(){
		var url= '/api/community/report?communityId='+communityId;		
		openPrompt(url);
	}
	
	
		
	commReport.onclick= function(){
		console.log(cmtId);
		var url= '/api/community/commReport?commentId='+cmtId.value;
		openPrompt(url);
	};

	


	function openPrompt(url){
		var result  = prompt("신고사유를 입력하세요.");
		
		if(result!=null){
			var request = new XMLHttpRequest();
			request.onload = function(){
				alert("신고되었습니다.");			
			}
			
//			data.append('contents',result);
//			data.append('memberId',memberId);//로그인한아이디넘겨야함..
//			data.append('communityId',communityId);
//			console.log(result, membe``rId, communityId);
			for(let value of data.values()){
				console.log(value);
			}
			
			request.open('GET',url+'&contents='+result+'&memberId='+memberId);
			request.send();
			
		}
		
		
	};


	apBtn.onclick = function(){

		var request = new XMLHttpRequest();
		request.onreadystatechange = function(e){
			e.stopPropagation();
			e.preventDefault();;
			if(request.readyState==4){
				var commList = new JSON.parse(request.responseText);
				
				for(var i=0; i<commList.length; i++){
					var n = commList[i];
					var tr ='<tr class="cmd-tr"> \
			                 <td class="comt-list"'+n.contents+'<button class="cmt-del-btn" > X </button></td> \
			                 <td class="comt-writer">'+n.regdate+'</td> \
			                 <td class="comt-writer">'+n.writerName+'</td> \
			                 <td class="comt-writer">'+n.memberId+' \
			                 <input type="hidden" name="id" value="'+n.id+'"> \
			                 <input type="hidden" name="detailId" value="'+m.id+'"> \
			                 </td> \
			                 </tr>';
				}
					tbody.insertAdjacentHTML(tr);							
			}
		}
		
		request.open('GET','/admin/community/commentList',false);
		request.send();
	};
	
});