window.addEventListener('load',function(){
    var btnLeft = document.querySelector(".btn-left");
    var btnRight = document.querySelector(".btn-right");
    var showRoom = document.querySelector(".show-room");
	var current = showRoom.querySelector("img")

    var index = 0;
    btnLeft.onclick=function(){
        if(current.previousElementSibling==null){
            alert("이전 항목이 없습니다");
            return;
        }
        current.classList.remove("current");
        current = current.previousElementSibling;
        current.classList.add("current");
        index++;
        var x=index*250+"px";
        showRoom.style.transform="translateX("+x+")";
    }
    btnRight.onclick=function(){
        if(current.nextElementSibling==null){
            alert("다음 항목이 없습니다");
            return;
        }
        console.log("오른쪽버튼 눌렸니");
        current.classList.remove("current");
        current = current.nextElementSibling;
        current.classList.add("current");
        index--;
        var x=index*250+"px";
        showRoom.style.transform="translateX("+x+")";
    }
});