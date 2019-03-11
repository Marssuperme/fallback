package cn.org.gdicpa.web.pub.autocode;

import java.util.Date;

import cn.org.gdicpa.web.pub.util.MD5;

public class DELUnid {
  public DELUnid() {
  }

  public synchronized static String getNumUnid(){
    return String.valueOf (new Date().getTime());
  }

  public static String getCharUnid(){
    return MD5.getMD5String(getNumUnid());
  }
}