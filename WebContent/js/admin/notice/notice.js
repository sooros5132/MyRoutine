window.addEventListener("load",function(){
  var notice = document.querySelector("#notice");
  

var noticeList = notice.querySelector(".notice-list");
var allCheckbox = noticeList.querySelector(".overall-checkbox");
var tbody = noticeList.querySelector("tbody");

//var delButtonAll = noticeList.querySelector(".del-button-all");



//페이징 오버
var numberlist = document.querySelector(".number-list");

var ul = numberlist.querySelector("ul");
var current = ul.querySelector(".number2");


ul.onclick =function(e){
  //e.preventDefault();
  let target = e.target;
  if(target.nodeName !='A')return;

  current.classList.remove("number2");
  current = target;
  current.classList.add("number2");

}
//이전,이후  버튼클릭
// var prevButton = ul.querySelector(".prev");
// var nextButton = ul.querySelector(".next");

// prevButton.addEventListener('click',function(e){
 
//   console.log(current.parentElement.previousElementSibling.nodeName);
//   if(current.parentElement.previousElementSibling.nodeName == 'SPAN')
// 	return;

 
//   current.classList.remove("number2");
//   current = current.parentElement.previousElementSibling.firstElementChild;
//   current.classList.add("number2");


//   location.href="/admin/notice/list?p="+current.innerText;
  
// })

// nextButton.addEventListener('click',function(){

//   if(current.parentElement.nextElementSibling.nodeName =='SPAN')
	
// 	return

//   current.classList.remove("number2");
//   current = current.parentElement.nextElementSibling.firstElementChild;
//   current.classList.add("number2");
 
//   location.href="/admin/notice/list?p="+current.innerText;
// })



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

  
   //delButtonAll.onclick = function(){
       //var inputs=tbody.querySelectorAll("input[type='checkbox']:checked");
       
      // for(var i=0; i<inputs.length;i++)
         // inputs[i].parentElement.parentElement.remove();
  // }

 




//트리거이벤트
  // var linkButton = document.querySelector(".link-button");
  // var triggerButton = document.querySelector(".trigger-button");


  //triggerButton.onclick =function(){
     //var event = new MouseEvent('click',{
       //  'view':window,
        // 'bubbles':true,
        // 'cancelable':true,
     //})

     //linkButton.dispatchEvent(event);

  //}


})

