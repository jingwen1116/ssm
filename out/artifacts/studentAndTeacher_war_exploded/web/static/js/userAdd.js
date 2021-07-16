
//状态栏提示
window.onload=function(){
    var val =  document.getElementById("IBody").querySelector("div").querySelector("h3").innerHTML;
    if(document.getElementsByClassName("pathId")[0]!=undefined){
        document.getElementsByClassName("pathId")[0].innerHTML=val;
    }

};








