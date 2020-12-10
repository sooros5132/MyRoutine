window.addEventListener("load",function(){
  var notice = document.querySelector("#notice");
  

var noticeList = notice.querySelector(".notice-list");
var allCheckbox = noticeList.querySelector(".overall-checkbox");
var tbody = noticeList.querySelector("tbody");
var delButton = noticeList.querySelectorAll(".del-button");
var delButtonAll = noticeList.querySelector(".del-button-all");
allCheckbox.onchange = function(){

    var inputs = tbody.querySelectorAll("input[type='checkbox']");
    for( var i=0; i<inputs.length; i++)
       inputs[i].checked = allCheckbox.checked;

}

tbody.onclick = function(e){

    //e.preventDefault(); //기본 설정값 방지
    var target = e.target;
    //var inputs=tbody.querySelectorAll("input[type='checkbox']:checked");
    
    if(target.nodeName!="INPUT")return;

    if(target.classList.contains("del-button")){
        var tr = target.parentElement;
        for(; tr.nodeName!="TR"; tr=tr.parentElement);
        tr.remove();
    }
}

// for(var i=0; i<delButton.length; i++){
//     delButton[i].onclick = function(){
//         var inputs=tbody.querySelectorAll("input[type='checkbox']:checked");
        
//         for(var i=0; i<inputs.length;i++)
//         inputs[i].parentElement.parentElement.remove();
//     }
//    }

  
    delButtonAll.onclick = function(){
        var inputs=tbody.querySelectorAll("input[type='checkbox']:checked");
        
        for(var i=0; i<inputs.length;i++)
           inputs[i].parentElement.parentElement.remove();
    }
  
})