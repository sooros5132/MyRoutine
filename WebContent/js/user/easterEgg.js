let easterEgg = ["t", "a", "e", "b", "o"];
let inputText = [];
let textIndex = 0;
let gameStart = false;
document.addEventListener("keydown", (e) => {
    
    if ( gameStart ){
        console.log("태보해");
        let imgNode = document.getElementsByClassName("taebo-game-img")[0];

        let volume = 1;
        switch(e.key){
            case "w":{
                imgNode.style.backgroundPosition = "-520px 0";
                soundPlay("/audio/up.wav", "taebo-game-inner", volume);
                break;
            }
            case "a":{
                imgNode.style.backgroundPosition = "0 0";
                soundPlay("/audio/jap.wav", "taebo-game-inner", volume);
                break;
            }
            case "s":{
                imgNode.style.backgroundPosition = "-1560px 0";
                soundPlay("/audio/down.wav", "taebo-game-inner", volume);
                break;
            }
            case "d":{
                imgNode.style.backgroundPosition = "-1040px 0";
                soundPlay("/audio/jap.wav", "taebo-game-inner", volume);
                break;
            }
        }

    } else {
        let chk = true;
        inputText[textIndex] = e.key;
        
        if(e.key != easterEgg[textIndex]){
            chk = false;
            inputText = [];
            textIndex = 0;
        } else {
            textIndex++;
        }

        console.log( inputText );

        if( chk && easterEgg.length == textIndex ){
            let taeboTag = document.createElement("div");
            taeboTag.classList.add("taebo-game");
            
            document.body.appendChild(taeboTag);

            document.getElementsByClassName("taebo-game")[0].addEventListener("keydown", (e) => {
                
            });

            let taeboInner = document.createElement("div");
            taeboInner.classList.add("taebo-game-inner");
            taeboTag.append(taeboInner);
            
            let taeboImg = document.createElement("div");
            taeboImg.classList.add("taebo-game-img");
            taeboImg.style.backgroundPosition = "-2080px 0";
            taeboInner.append(taeboImg);
            
            gameStart = true;
            soundPlay("/audio/opening.wav", "taebo-game-inner", 1, 80000);

        }
    }

});

function soundPlay(soundSrc, targetNode, volume, time = 2000){
    let audio = document.createElement('audio');
    audio.setAttribute('type', 'audio/mpeg');
    audio.className = soundSrc + (new Date().getTime());
    audio.src = soundSrc;
    audio.volume = volume;
    document.getElementsByClassName(targetNode)[0].append(audio);
    document.getElementsByClassName(audio.className)[0].play();
    setTimeout(function() {
        document.getElementsByClassName(audio.className)[0].remove();
    }, time);
}