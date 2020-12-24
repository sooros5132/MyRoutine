window.addEventListener("load", () => {
      let gnb = document.querySelector(".gnb");
      let ul = gnb.querySelector("ul")

      var Regex = /^(\/admin\/)([0-9a-zA-Z]*)/;
      let selectedMenu = Regex.exec(location.pathname)[2];
      
      var current = ul.querySelector(`.${selectedMenu}-menu`);
      current?.classList.add("active");

      // ul.onmouseover = function(e){
      //    let target = e.target;

      //    if(target.nodeName !='A') return;

      // current?.classList.remove("active");
      //    current = target;
      //    current.classList.add("active");   
      // }
      // ul.onclick =function(e){
      //    let target = e.target;
      //    if(target.nodeName =="A" || target.nodeName =='I') 
      //       target.classList.add("active");


      // }

  



   //관리자 페이지 사이드 보기
   let snb = document.querySelector('.snb');
   let dep1List = snb?.querySelectorAll('.dep1 > li') || [];
   
   dep1List.forEach((list)=>{
      list.addEventListener('click', (e)=>{
         if(list.getAttribute('data-type') == "true"){
            let dep2List = list.querySelector('.dep2');
            if(list.classList.contains('active')){
               list.classList.remove('active');
            }else{
               list.classList.add('active');
            }
            
         }
      });
   })
})

