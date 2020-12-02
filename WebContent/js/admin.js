window.addEventListener("load", () => {
   
   let exMenu = document.querySelectorAll(".ex-menu");
   let exCon = document.querySelectorAll(".ex-con");

   //운동등록 항목선택시
   exMenu.forEach(radioBtn => {
      radioBtn.addEventListener("change", function () {
         let radioValue = radioBtn.getAttribute("value");

         //클래스 제거
         exCon.forEach(con => {
            con.classList.remove("active");
         })

         //클래스 추가
         if (radioValue == "re") {
            // console.log(exCon[0]); ss
            exCon[0].classList.add("active");

         } else if (radioValue == "ex") {
            //console.log(exCon[1]); 
            exCon[1].classList.add("active");
         }
      })
   });

   //템플릿 추가
   let fileFormAdd = document.querySelector('.file-form-add');
   let attachTemp = document.querySelector('.attach-template');
   let attachList = document.querySelector('.attach-box-list');
   fileFormAdd.addEventListener('click', (e)=>{
      let copy = attachTemp.content.cloneNode(true);
      attachList.appendChild(copy);
   });

})


 //운동등록 첨부파일
 function fileInputClick(){
   let e = this.event.target;
   let fileInput = e.parentElement.previousElementSibling;
   const fileTrigger = new MouseEvent('click', {
      view: window,
      bubbles: true,
      cancelable: true
      });

      fileInput.dispatchEvent(fileTrigger);
      fileInput.addEventListener('change', (e)=>{
      let fileTxt = fileInput.value;
      let fileTxtIndex = fileTxt.lastIndexOf("\\")+1;
      fileTxt = fileTxt.slice(fileTxtIndex);
      let fileReadTxt =  e.target.nextElementSibling.querySelector('.attach-read');
      fileReadTxt.value=fileTxt;       
   });
}
 //운동등록 첨부파일 삭제
function fileInputDel(){
   let e = this.event.target;
   console.log(e);
   e.closest('.attach-box').remove();
}
