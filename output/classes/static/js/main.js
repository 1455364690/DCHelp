//初始化高度
var h=window.innerHeight
    || document.documentElement.clientHeight
    || document.body.clientHeight;
document.getElementById("top").style.height=h*0.08+"px";
document.getElementById("content").style.height=h*0.87+"px";
document.getElementById("bottem").style.height=h*0.05+"px";
//响应菜单事件
document.getElementsByTagName("p")[0].onclick=function(){clickP1()};
document.getElementsByTagName("p")[1].onclick=function(){clickP2()};
document.getElementsByTagName("p")[2].onclick=function(){clickP(1)};
document.getElementsByTagName("p")[3].onclick=function(){clickP(2)};
document.getElementsByTagName("p")[4].onclick=function(){clickP(3)};
document.getElementsByTagName("p")[5].onclick=function(){clickP(4)};
document.getElementsByTagName("p")[6].onclick=function(){clickP(5)};
function clickP1() {
    document.getElementById("content_left_son1_left").style.backgroundColor = '#B3B3B3';
    document.getElementById("content_left_son1_right").style.backgroundColor = '#E0E0E0';
    for(var i =1;i<7;i++){
            document.getElementsByClassName("content_left_son")[i].style.backgroundColor = '#E0E0E0';
    }
}
function clickP2() {
    //document.getElementById("content_right_son2").style.display="inline";
    document.getElementById("content_left_son1_right").style.backgroundColor = '#B3B3B3';
    document.getElementById("content_left_son1_left").style.backgroundColor = '#E0E0E0';
    for(var i =1;i<7;i++){
        document.getElementsByClassName("content_left_son")[i].style.backgroundColor = '#E0E0E0';
    }
}
function clickP(num) {
    //document.getElementById("content_right_son2").style.display="none";
    document.getElementById("content_left_son1_right").style.backgroundColor = '#E0E0E0';
    document.getElementById("content_left_son1_left").style.backgroundColor = '#E0E0E0';
    for(var i =1;i<6;i++){
        if(i!==num)
            document.getElementsByClassName("content_left_son")[i].style.backgroundColor = '#E0E0E0';
        else
            document.getElementsByClassName("content_left_son")[i].style.backgroundColor = '#B3B3B3';
    }
}

//按钮点击事件
document.getElementsByTagName("p")[8].onclick=function () {
    //
};
document.getElementsByTagName("p")[9].onclick=function () {
    //
};
document.getElementsByTagName("p")[10].onclick=function () {
    //
};
document.getElementsByTagName("p")[8].onmousedown=function () {
    changeColor(8)
};
document.getElementsByTagName("p")[9].onmousedown=function () {
    changeColor(9)
};
document.getElementsByTagName("p")[10].onmousedown=function () {
    changeColor(10)
};
document.getElementsByTagName("p")[8].onmouseup=function () {
    backColor(8)
};
document.getElementsByTagName("p")[9].onmouseup=function () {
    backColor(9)
};
document.getElementsByTagName("p")[10].onmouseup=function () {
    backColor(10)
};
function changeColor(num) {
    if(num===8){
        document.getElementById("btn_get").style.backgroundColor = "#7171C6"
    }else if(num===9){
        document.getElementById("btn_start").style.backgroundColor = "#7171C6"
    }else if(num===10){
        document.getElementById("btn_end").style.backgroundColor = "#7171C6"
    }
}
function backColor(num) {
    if(num===8){
        document.getElementById("btn_get").style.backgroundColor = "#7EC0EE"
    }else if(num===9){
        document.getElementById("btn_start").style.backgroundColor = "#7EC0EE"
    }else if(num===10){
        document.getElementById("btn_end").style.backgroundColor = "#7EC0EE"
    }
}
function moveright() {
    var temp = document.getElementById("img5").src;
    document.getElementById("img5").src=document.getElementById("img4").src;
    document.getElementById("img4").src=document.getElementById("img3").src;
    document.getElementById("img3").src=document.getElementById("img2").src;
    document.getElementById("img2").src=document.getElementById("img1").src;
    document.getElementById("img1").src=temp;
}
function moveleft() {
    var temp = document.getElementById("img1").src;
    document.getElementById("img1").src=document.getElementById("img2").src;
    document.getElementById("img2").src=document.getElementById("img3").src;
    document.getElementById("img3").src=document.getElementById("img4").src;
    document.getElementById("img4").src=document.getElementById("img5").src;
    document.getElementById("img5").src=temp;
}
function move_click(num) {
    var temp = document.getElementsByClassName("imgs")[num].src;
    document.getElementsByClassName("imgs")[num].src=document.getElementsByClassName("imgs")[2].src;
    document.getElementsByClassName("imgs")[2].src=temp;
}
function putURL() {
    var arr=document.getElementsByClassName("imgs")[2].src.split("/");
    document.getElementById("upload").href="/adopt/"+arr[arr.length-1];
}