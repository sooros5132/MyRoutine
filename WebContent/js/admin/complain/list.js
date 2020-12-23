window.addEventListener("load",function(){
    var tbody = document.querySelector(".tbody");
    var prevPage = document.querySelector(".prev-page");
    var nextPage = document.querySelector(".next-page");
    var pager = document.querySelector(".pager");
    var group = document.querySelector(".group").value;
	var page = 1;

//	prevPage.onclick = function(e){
//		e.preventDefault();
//		page = page-1;		
//		load(page);
//	}
//	
//	nextPage.onclick = function(e){
//		e.preventDefault();		
//		page = page+1;		
//		load(page);	
//	}

	pager.onclick = function(e){
		e.preventDefault();
		 console.log(event.target.className);
		 console.log(page);			
		if(event.target.className == "prev-page"){
			if(page > 1)
				page = page - 1;	
		}
	    else if(event.target.className == "next-page"){
		 console.log(page);	
			if(page < group)	
				page += 1;	
		}else
			page = parseInt(e.target.innerText)
		
	
		load(page);
	};
	
	function load(page){
		if(page==undefined)
			page=1;
		
		var request = new XMLHttpRequest();
		
		request.onload = function(){
			
			tbody.innerHTML = '';
			
			var complainList = JSON.parse(request.responseText);
			
			for(var i=0; i<complainList.length; i++){
				var n = complainList[i];
				var tr = '<tr> \
	                      <td>'+n.writerName+'</td> \
	                        <td>'+n.categoryType+'</td> \
	                        <td><a href="detail?id='+n.id+'"> '+n.title+'['+n.commCount+']</a></td> \
	                        <td>'+n.regdate+'</td> \
	                        <td>'+n.hit+'</td> \
		                  </tr>';
	
				tbody.insertAdjacentHTML('beforeend',tr);
			}
		}
		request.open("GET","/api/complain/list?page="+page);	
		request.send();
		
	};
	
	

});