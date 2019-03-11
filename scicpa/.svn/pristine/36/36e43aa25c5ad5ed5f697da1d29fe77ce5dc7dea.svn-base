<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
</head>

<body bgcolor="#DEEFF6";>
<%!

//简体中文的编码范围从B0A1（45217）一直到F7FE（63486）
private static int BEGIN = 45217;
private static int END = 63486;

// 按照声母表示，这个表是在GB2312中的出现的第一个汉字，也就是说“啊”是代表首字母a的第一个汉字。
// i, u, v都不做声母, 自定规则跟随前面的字母
private static char[] chartable = { '啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈',
'哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌',
'塌', '挖', '昔', '压', '匝', };

// 二十六个字母区间对应二十七个端点
// GB2312码汉字区间十进制表示
private static int[] table = new int[27];

// 对应首字母区间表
private static char[] initialtable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
'h', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
't', 't', 'w', 'x', 'y', 'z', };


// ------------------------public方法区------------------------
/**
* 根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串 最重要的一个方法，思路如下：一个个字符读入、判断、输出
*/
public static String cn2py(String SourceStr) {
	
	//初始化
	{
	for (int i = 0; i < 26; i++) {
	table[i] = gbValue(chartable[i]);// 得到GB2312码的首字母区间端点表，十进制。
	}
	table[26] = END;// 区间表结尾
	}
	
String Result = "";
int StrLength = SourceStr.length();
int i;
try {
for (i = 0; i < StrLength; i++) {
Result += Char2Initial(SourceStr.charAt(i));
}
} catch (Exception e) {
Result = "";
}
return Result;
}

// ------------------------private方法区------------------------
/**
* 输入字符,得到他的声母,英文字母返回对应的大写字母,其他非简体汉字返回 '0'
* 
*/
private static char Char2Initial(char ch) {
// 对英文字母的处理：小写字母转换为大写，大写的直接返回
if (ch >= 'a' && ch <= 'z')
return (char) (ch - 'a' + 'A');
if (ch >= 'A' && ch <= 'Z')
return ch;

// 对非英文字母的处理：转化为首字母，然后判断是否在码表范围内，
// 若不是，则直接返回。
// 若是，则在码表内的进行判断。
int gb = gbValue(ch);// 汉字转换首字母

if ((gb < BEGIN) || (gb > END))// 在码表区间之前，直接返回
return ch;

int i;
for (i = 0; i < 26; i++) {// 判断匹配码表区间，匹配到就break,判断区间形如“[,)”
if ((gb >= table[i]) && (gb < table[i + 1]))
break;
}

if (gb == END) {// 补上GB2312区间最右端
i = 25;
}
return initialtable[i]; // 在码表区间中，返回首字母
}

/**
* 取出汉字的编码 cn 汉字
*/
private static int gbValue(char ch) {// 将一个汉字（GB2312）转换为十进制表示。
String str = new String();
str += ch;
try {
byte[] bytes = str.getBytes("GB2312");
if (bytes.length < 2)
return 0;
return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
} catch (Exception e) {
return 0;
}
}



   void mkdir(String path) {
	   try{
    String[]   st=path.split("/");
    String   path1=st[0]+"/";
   	for (int i=1;i<st.length-1;i++) {
          path1+=st[i]+"/";;
          File inbox   =   new File(path1);
          if(!inbox.exists())
               inbox.mkdir();
    }
	   }catch(Exception e){
		   System.out.println("mkdir处理"+path+"失败："+e.getMessage());
	   }
}

	public long copyFile(String path1,String path2){
		File f1   =   new File(path1);
		File f2   =   new File(path2);
		
		try{
			  int length=2097152;
			  FileInputStream in=new FileInputStream(f1);
			  FileOutputStream out=new FileOutputStream(f2);
			  byte[] buffer=new byte[length];
			  while(true){			  
			   int ins=in.read(buffer);
			   if(ins==-1){
				    in.close();
				    out.flush();
				    out.close();
				    return 0;
			   }else{
			    	out.write(buffer,0,ins);
			   }
			  }
			  
		}catch(Exception e){
			   System.out.println("copyFile拷贝"+path1+"到"+path2+"失败："+e.getMessage());
		}
	  		return -1;
	 }
%>

<%

	Connection conn = null;
	PreparedStatement ps = null,ps1=null;
	ResultSet rs = null;
	
	//String basedir="D:/广东省注协/webRoot/web/";
	String basedir="D:/workspace/GDZX/WebContent/";
	String newbasedir="D:/output/";
	FileWriter resultFile=null;
	try {
		conn = new DBConnect().getConnect();
		
		String oldfilename="",newfilename="",legislationid="";
		String sql="select legislationid,filename from p_policyAttachmentTable";
		ps = conn.prepareStatement(sql);
		ps1 = conn.prepareStatement("update p_policyAttachmentTable set filename=? where legislationid=?");
        rs = ps.executeQuery();
        int i=0;
        while (rs.next() ) {
        	oldfilename=rs.getString("filename").replace("\\","/");
        	legislationid=rs.getString("legislationid");
        	newfilename=cn2py(oldfilename);
        	
        	mkdir(newbasedir+newfilename);
        	
        	copyFile(basedir+oldfilename,newbasedir+newfilename);
        	
        	out.println("拷贝"+(i++)+"：["+basedir+oldfilename+"到["+newbasedir+newfilename+"]<br>");
        	
        	//更新数据
        	ps1.setString(1,newfilename);
        	ps1.setString(2,legislationid);
        	ps1.execute();
        }
		
        ps1.close();
        ps.close();
        //
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		if(resultFile!=null)
			resultFile.close();
		 
		DbUtil.close(rs);
		DbUtil.close(ps);
	}
%>

</body>


</html>