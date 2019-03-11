package cn.org.gdicpa.web.action.uploadProcess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.util.ASFuntion;


public class FrontProcessAction extends MultiActionController {
	
	public static Map map =  new HashedMap() ;
	
	public static void printMessage(String key,String message) {
		
		if(map != null) {
			map.put(key,message) ;
		}
	}	
	
	 public void getMessage(HttpServletRequest request,HttpServletResponse response) {
		 	
		 
		 ASFuntion ASF = new ASFuntion() ;
		 PrintWriter out = null ;
	    response.setContentType("text/xml");   
        response.setCharacterEncoding("UTF-8");   
        response.setHeader("Cache-Control", "no-cache");
		 String key = ASF.showNull(request.getParameter("key")) ;
		 try {
			out = response.getWriter() ;
			String message = "" ;
			if(map != null) { 
				 message = (String)map.get(key) ;
				 out.write(message) ;
				 
				 if(message.indexOf("end") > -1) {
					 map.remove(key) ;
				 }
				 
			}else {
				out.write("请等待...")  ;
			}
			
		} catch (IOException e) {
			out.write("请等待...") ;
		}finally {
			if(out != null) 
			{
				out.close() ;
			}
		}
		 
		 
	 }
	 
	 public void test(HttpServletRequest request,HttpServletResponse response) {
		 	
		 	FrontProcessAction.printMessage("key","显示信息11111...") ;
		 	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 	
		 	FrontProcessAction.printMessage("key","显示信息22222...") ;
		 	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			FrontProcessAction.printMessage("key","显示信息33333...") ;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			FrontProcessAction.printMessage("key","end") ;
	 }

}
