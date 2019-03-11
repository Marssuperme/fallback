package cn.org.gdicpa.web.pub.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logicalcobwebs.proxool.configuration.ServletConfigurator;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;




/**
 * 重写org.logicalcobwebs.proxool.ProxoolDataSource
 * 重置数据库密码为明文
 * @author Administrator
 *
 */
	public class PropertyPlaceholderConfigurerEX extends PropertyPlaceholderConfigurer {
		 private boolean secutiry = false;
		 
	     //
	     protected String resolvePlaceholder(String placeholder, Properties props) {
	         String placeholderValue = props.getProperty(placeholder);
	         if(this.secutiry){
	        	 if("user".equals(placeholder)||"password".equals(placeholder)){
	              placeholderValue = deEncrypt(placeholderValue);
	        	 }
	         }
	         return placeholderValue;
	     }
	     //
	     public boolean isSecutiry() {
	         return secutiry;
	     }
	     public void setSecutiry(boolean secutiry) {
	         this.secutiry = secutiry;
	     }
	    
	     private String deEncrypt(String miwen){
	    	 //DESUtil des = new DESUtil();
	          return DESUtils .getDecryptString(miwen);//解密后的字符串
	     }
/**
  * 重置数据库链接信息为明文
  */
/* public void setPassword(String mi) {
  super.setPassword(mi);
  String passWord = DesDecode(mi);
  super.setPassword(passWord);
  //String url = reSetUrl(super.getDriverUrl(), super.getPassword());
 // super.setDriverUrl(url);
 }*/
    /*替换url的密码为明文*/
 public String reSetUrl(String url, String pwd) {
  int begin = url.indexOf('/');
  int end = url.indexOf('@');
  String url2 = url.substring(0, begin + 1) + pwd + url.substring(end);
  return url2;
 }
    
/* public String getPassword() {
  return super.getPassword();
 }*/

 }