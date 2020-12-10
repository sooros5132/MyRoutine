window.addEventListener("load", () => {
   console.log("A")
   let exMenu = document.querySelectorAll(".ex-menu");
   let exCon = document.querySelectorAll(".ex-con");

   //운동등록 항목선택시
   exMenu.forEach(radioBtn => {
      radioBtn.addEventListener("change", function () {
         let radioValue = radioBtn.getAttribute("value");

         //클래스 제거
         exCon.forEach(con => {
            con.classList.remove("current");
         })

         //클래스 추가
         if (radioValue == "1") {
            exCon[0].classList.add("current");
         } else if (radioValue == "2") {
            exCon[1].classList.add("current");
         }
         
      })
   });


   //첨부 파일 템플릿 추가
   let fileFormAdd = document.querySelector('.file-form-add');
   let fileFormTemp = '<div class="attach-box">\
                        <input class="attach-input" type="file"  name="file" accept="image/*">\
                        <div class="attach-box-inner">\
                           <button class="attach-btn" type="button" onclick ="fileInputClick();">파일선택</button>\
                           <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="">\
                           <button class="attach-cancel-btn" type="button" onclick="fileInputDel();"><i class="xi-close-min"></i></button>\
                        </div>\
                     </div>'

   fileFormAdd.addEventListener('click', (e)=>{
      //파일 폼 비었는지 확인
      let attachInput = document.querySelectorAll('.attach-input');
      let fileEmpty = false;
      attachInput.forEach((item) =>{
         console.log(item.value);
         if(item.value.length == 0){
            alert("첨부파일이 비어있는 곳이 있습니다. 비어 있는 곳을 먼저 채워주세요.");
            fileEmpty = true;
            return;
         }
      })
      //파일 폼 추가
      if(fileEmpty == false){
         fileFormAdd.insertAdjacentHTML('beforebegin',fileFormTemp);
      }
   });


});


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
      // alert(e.value)    
      // alert(e)   
      console.log(fileInput.value)
   });
}
 //운동등록 첨부파일 삭제
function fileInputDel(){
   let e = this.event.target;
   e.closest('.attach-box').remove();
}
