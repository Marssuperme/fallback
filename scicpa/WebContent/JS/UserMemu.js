var userDivDisplay=0;
document.write("<div id='UserUCDiv' style='FILTER: alpha(opacity=100);position:absolute;top:0px;left:0px; font-size:12px; padding:2px;display:none;cursor:hand' onmouseout='hiddenUC_1();' onmouseover='userDivDisplay=1;'  >asdf</div>");

var UserDivHTML = "";
UserDivHTML+=("<table width='80' border='0' align='center' cellpadding='0' cellspacing='0'>");
UserDivHTML+=("<tr><td width='11'><img src='images/userdiv1.gif' width='11' height='25' /></td>");
UserDivHTML+=("<td background='images/userdivtpbg.gif' style='border-bottom:1px dashed #FF9900; padding-left:4px;'><font color='#FE6903'><nobr>{nickname}</nobr></font></td>");
UserDivHTML+=("<td width='5' align='right'><img src='images/userdivrg1.gif' width='5' height='25' /></td>");
UserDivHTML+=("</tr>");
UserDivHTML+=("<tr>");
UserDivHTML+=("<td background='images/userdivleft.gif'></td><td bgcolor='#FFF9EB'><table width='100%' border='0' cellpadding='2' cellspacing='2'>");
UserDivHTML+=("<tr><td ><a href='userinfo.asp?classid={classid}&showuserid={userid}' onclick='hiddenUC();' target='_blank'>查看资料</a></td></tr>");

UserDivHTML+=("<tr><td><a href='MyNote_Send.asp?classid={classid}&touserid={userid}' onclick='hiddenUC();' target='_blank'>发送短信</a></td></tr>");

UserDivHTML+=("<tr><td><a href='sendAc.asp?classid={classid}&touserid={userid}' onclick='hiddenUC();' >邀请聊天</a></td></tr>");

UserDivHTML+=("<tr><td></td></tr></table></td><td width='5' background='images/userdivrg.gif'></td>");
UserDivHTML+=("</tr>");
UserDivHTML+=("<tr><td height='4' align='left' valign='bottom'><img src='images/userdivleft2.gif' width='11' height='4' /></td><td height='4' background='images/userdivbtbg.gif'></td><td align='right' valign='bottom'><img src='images/userdivrg2.gif' width='5' height='4' /></td>");
UserDivHTML+=("</tr>");
UserDivHTML+=("</table>");


function ShowUC(nickName,userid,classid,sss,xsize,ysize)
{
	
	var UserUCDiv = document.getElementById("UserUCDiv");
	
	var x=0,y=0;
	var o = sss;
	
	x=o.offsetLeft;
    y=o.offsetTop;
    while(o=o.offsetParent)
    { 
        x+=o.offsetLeft;
        y+=o.offsetTop;
    }
	
	UserUCDiv.style.top = y+ysize;
	UserUCDiv.style.left = x-xsize-40;
	
	var myhtml = UserDivHTML;
	myhtml = myhtml.replace(/{nickname}/g,unescape(nickName));
	myhtml = myhtml.replace(/{classid}/g,classid);
	myhtml = myhtml.replace(/{userid}/g,userid);
	UserUCDiv.innerHTML = myhtml;
	UserUCDiv.style.display = "";
}

function hiddenUC()
{
	if(userDivDisplay==0){
		var UserUCDiv = document.getElementById("UserUCDiv");
		UserUCDiv.innerHTML = "";
		UserUCDiv.style.display = "none";
	}
	
}

function hiddenUC_1(){
	userDivDisplay=0;
	if(userDivDisplay==0){
		setTimeout(function(){
			hiddenUC();					
		},500)
	}	
}
