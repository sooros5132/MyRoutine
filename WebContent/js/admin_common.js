window.addEventListener("load", () => {

   //관리자 페이지 사이드 보기
   let snb = document.querySelector('.snb');
   let dep1List = snb.querySelectorAll('.dep1 > li');
   
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

