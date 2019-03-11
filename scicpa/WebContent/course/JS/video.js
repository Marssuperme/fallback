function mOver(obj) {
    if (obj.style.paddingRight != "10px") {
        obj.style.backgroundColor = "#fffec9";
        obj.style.border = "1px solid gray"
    }
}

function mOut(obj) {
    if (obj.style.paddingRight != "10px") {
        obj.style.backgroundColor = "#fffee2";
        obj.style.border = "0px solid gray"
    }
}

function setVideoTime(obj) {
	var time = obj.time ;
	alert(time)
	var seconds = convertToSeconds(time);
	var video = document.getElementById("videoplayer");
	video.seekTime(seconds);
}

function convertToSeconds(sTime) 
{
	var asTemp = sTime.split(":");
	var lTemp = 0;
	lTemp = parseInt((asTemp[0] * 3600), 10) + parseInt((asTemp[1] * 60), 10) + parseInt(asTemp[2], 10);
	return(lTemp);
}