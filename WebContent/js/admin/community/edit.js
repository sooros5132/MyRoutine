window.addEventListener("load",function(){
	
	var fileDiv = document.querySelector(".file-div");
	var fileDel = document.querySelector(".file_div_del");
	var oldFile = document.querySelector(".old_file");
	var selectBox = document.querySelector(".select-box");
	var categoryId = document.querySelector(".category-id");
	var delFileName = "";		
	
	
	selectBox.onchange = function(){		
		 categoryId.value = selectBox.options[selectBox.selectedIndex].value;
		
		console.log(categoryId.value);	 
	}
	
	fileDiv.onclick = function(e){
		e.stopPropagation();
		if(e.target.innerText=="(X)"){		
			e.preventDefault();		
			delFileName += e.target.previousElementSibling.innerText;
			delFileName += ",";
			console.log(delFileName);
			e.target.previousElementSibling.remove();
			e.target.previousElementSibling.remove();
			e.target.remove();
			oldFile.value = delFileName;  			
//			var input= '<input  name="oldfile" value="'+delFileName+'">';
//			fileDiv.insertAdjacentHTML('beforeend',input);
		}
		else
			return true;
		
	}
	
});