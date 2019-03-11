package cn.org.gdicpa.web.pub.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

//import org.db.DBTransaction;
//import org.excep.Exception;
//import org.util.Config;
//import org.util.Debug;

public class UTILPublic {
  FileReader fReader;
  BufferedReader bufReader;
  FileWriter fWriter;
  BufferedWriter bufWriter;
  String sLine;
  File f1, f2;

  //得到用户目录
  public static String getUserHome() {
    return System.getProperty("user.home");
  }
  
//将指定double转换为2位的字符串，否则为155.66=155.6599999995
  private String getFormatDouble1(double d) {  
  	DecimalFormat formatter = new DecimalFormat("0.00");
  	
    return formatter.format(d);
	}
  
  public String getFormatDouble2(String s) {
  	//s = "100.0128";
    BigDecimal money= new BigDecimal(s);
    //设置精度，以及舍入规则
    money= money.setScale(2, BigDecimal.ROUND_HALF_UP);
    System.out.println(money);
    return money.toString();
	}
  
//javascript中有一个方法“toFixed()”,
  //这个方法就是用来截取小数点后尾数的长度的
  public String getFormatDouble2(double s) {
  	//s = "100.0128";
    BigDecimal money= new BigDecimal(s);
    //设置精度，以及舍入规则
    money= money.setScale(2, BigDecimal.ROUND_HALF_UP);
    System.out.println(money);
    return money.toString();
	}

  /**
	 * 拷贝字节数组from中的数据，从offSet开始，拷贝len个
	 * 
	 * @param offSet
	 * @param len
	 * @param from
	 * @return
	 * @since 1.0
	 */
	public static byte[] copyTo(int offSet, int len, byte[] from) {
		byte[] to = new byte[len];
		if ((offSet + len) > from.length)
			len = from.length - offSet;
		for (int i = 0; i < len; i++) {
			to[i] = from[offSet + i];
		}
		return to;
	}

	/**
	 * 从0开始拷贝from的数据到to中，to从offSet开始，长度=len个
	 * 
	 * @param from
	 * @param offSet
	 * @param len
	 * @param to
	 * @return
	 * @since 1.0
	 */
	public static byte[] mergeTo(byte[] from, int offSet, int len, byte[] to) {
		if ((offSet + len) > to.length)
			len = to.length - offSet;
		for (int i = 0; i < len; i++) {
			to[offSet + i] = from[i];
		}
		return to;
	}
  
  //读取一个xml文件
  public static java.util.Date str2DateTime(String str) {
    Locale locale = Locale.FRENCH;
    java.util.Date date = null;
    java.text.Format formatter = null;
    try {
      formatter = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
      date = (java.util.Date) formatter.parseObject(str);
    }
    catch (Exception e) {
    	formatter = new java.text.SimpleDateFormat("yyyy-MM-dd", locale);
      try {
				date = (java.util.Date) formatter.parseObject(str);
			} catch (ParseException e1) {
				return null;
			}
    }
    return date;
  }
  
  public static java.util.Date str2Date(String str) {
    Locale locale = Locale.FRENCH;
    java.util.Date date = null;
    try {
      java.text.Format formatter = new java.text.SimpleDateFormat("yyyy-MM-dd", locale);
      date = (java.util.Date) formatter.parseObject(str);
    }
    catch (Exception e) {
    }
    return date;
  }

  //将某文件以新名字拷贝，如果oldPathName是目录，则newPathName也为目录，创建后即可返回
  public static void copy2(String oldPathName ,String newPathName) {
    File f= new File(oldPathName);
    if(f.isDirectory()) {
      new File(newPathName).mkdir();
      return;
    }
    java.io.FileInputStream in;
    java.io.FileOutputStream out;
    try {
      in = new java.io.FileInputStream(new File(oldPathName));
      out = new java.io.FileOutputStream(new File(newPathName));
      int bRead = -1;
      while ( (bRead = in.read()) != -1)
        out.write(bRead);
      out.close();
      in.close();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  public static void copyDir2(String oldPath ,String newPath) throws Exception{
    check(oldPath);
    
    File _f1= new File(oldPath);
    File _f2= new File(newPath);
    if(_f1.isDirectory()) {
    	if(!_f2.exists()) {
    		_f2.mkdirs();
    	}
    }
    _f1 = null;
    _f2 = null;

    File[] files = getFiles(oldPath, null);
    for (int i = 0; i < files.length; i++) {
      File f1 = files[i];
      System.out.println(f1.getPath()+";"+f1.getName());
      if (f1.isDirectory()) {
        copy2(f1.getPath(),newPath+File.separator+f1.getName());
        copyDir2(f1.getPath(), newPath+File.separator+f1.getName());
      }
      copy2(f1.getPath(),newPath+File.separator+f1.getName());
    }

  }

  public static void delete(String filePath) {
    File f = new File(filePath);
    f.deleteOnExit();
  }

  public static void rename(String oldFilePath, String newFilePath) {
    File f1 = new File(oldFilePath);
    File f2 = new File(newFilePath);
    f1.renameTo(f2);
  }

  //解析日期字符串，如将"Wed Aug 02 12:50:05 CST 2006"解析成2006-08-02 12:50:05
  public String parseDate(String str) {
    Locale locale = Locale.US;
    Format formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy",locale);
    java.util.Date date = null;
    try {
      date = (java.util.Date) formatter.parseObject(str);
    }
    catch (ParseException ex) {
      ex.printStackTrace();
    }
    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(date);
  }

  /**
   * Tomcat的bug，在servlet的返回路径中有根目录，在JSP跳转中又不带
   * ROOTPAGE缺省是为jsp用的值为根目录，在servlet跳转时将其去掉
   */
  public static void doWithUrl(HttpServletRequest request) {
    /*
    String url = request.getRequestURI();
    if (url.indexOf(Config.ROOTPAGE) != -1) {
      Config.LOGINPAGE = Config.LOGINPAGE1;
      Config.ERRORPAGE = Config.ERRORPAGE1;
      Config.INFOPAGE = Config.INFOPAGE1;
      Config.SUCPAGE = Config.SUCPAGE1;
    }else{
      Config.LOGINPAGE = Config.LOGINPAGE2;
      Config.ERRORPAGE = Config.ERRORPAGE2;
      Config.INFOPAGE = Config.INFOPAGE2;
      Config.SUCPAGE = Config.SUCPAGE2;
    }
    */
  }

//  public static String doWithUrl(HttpServletRequest request,String page) {
//    if(page==null) return page;
//    String url = request.getRequestURI();
//    if (url.indexOf(Config.ROOTPAGE) != -1) {
//      page = page.replaceAll(Config.ROOTPAGE, "");
//    }else{
//      if(page.indexOf(Config.ROOTPAGE)==-1)
//        page=Config.ROOTPAGE+page;
//    }
//    return page;
//  }

  private static StringBuffer buffer ;
  public static String bytes2HEX(byte[] ib) {
    buffer = new StringBuffer();
    for(int i=0; i<ib.length; i++) {
      buffer.append(byte2HEX(ib[i]));
    }
    return buffer.toString();
  }
  private static char[] Digit = { '0','1','2','3','4','5','6','7','8','9',
      'A','B','C','D','E','F' };
  public static String byte2HEX(byte ib) {
    char [] ob = new char[2];
    ob[0] = Digit[(ib >>> 4) & 0X0F]; //右移后高四位成了低四位,0X0F=1111=15
    ob[1] = Digit[ib & 0X0F];  //与1111后高四位全部丢失
    return new String(ob);
  }

  /**
   * 把1个16进制数的ASCII码字符串转换成一个byte[]数组
   */
  public static byte[] HEX2bytes(String s) {
    char[] c = s.toCharArray();
    if(c.length%2!=0)
      return new byte[]{0};
    byte[] b = new byte[c.length/2];
    byte b0, b1;
    int j = 0;

    for(int i=0; i<c.length; i=i+2) {
      b0 = Byte.parseByte("0" + c[i], 16);
      b1 = Byte.parseByte("0" + c[i+1], 16);
      b[j++] = (byte)((b0 << 4) | b1);
    }
    return b;
  }

  //分离特定的变量如："'${aaa}' CONCAT('${bbb}','%') 返回[]{'aaa','bbb'}
  public final static String[] getVaribles(String str) {
    if (str == null || str.equals(""))return null;
    int i1 = 0, i2 = 0, i = 0;
    String[] _retStr = new String[str.length() / 3];
    String[] retStr;
    while ( (i1 = str.indexOf("${", i2)) != -1) {
      i2 = str.indexOf("}", i1);
      _retStr[i++] = str.substring(i1 + 2, i2);
    }
    retStr = new String[i];
    for (int j = 0; j < i; j++) {
      retStr[j] = _retStr[j];
    }
    return retStr;
  }

  /**
   * 动态调用一个类的方法
   * @param className String 类名
   * @param strMethod String 方法名
   * @param classes Class[] 参数对象
   * @param paras Object[]  参数值
   * @throws Exception
   * @return Object 返回一个对象
   */
  public Object dymInvoke(String className,String strMethod,
                      Class[] classes,
                      Object[] paras) throws Exception{
    Class mainClass = Class.forName(className);
    Object mainObj = mainClass.newInstance();
    //Object paras[] = new Object[1];
    //Class classes[] = new Class[1];
    //classes[0] = String.class;
    //paras[0] = "1";
    Method method = mainClass.getMethod(strMethod, classes);
    return method.invoke(mainObj, paras);
  }

  //排序
  public static Collection sort(Collection col) {
    Object[] uvos = (Object[]) col.toArray(new Object[col.size()]);
    Arrays.sort(uvos);

    return Arrays.asList(uvos);
  }

  //替换某个文件夹下所有的文件的内容
  public void _replace(File f, String oldText, String newText) throws
      Exception {
    if (f.isDirectory())return;
    f2 = new File(f.getPath() + "1");
    try {
      fReader = new FileReader(f);
      bufReader = new BufferedReader(fReader);
      fWriter = new FileWriter(f2);
      bufWriter = new BufferedWriter(fWriter);
      while ( (sLine = bufReader.readLine()) != null) {
        bufWriter.write(sLine.replaceAll(oldText, newText) + "\n");
      }
      bufWriter.close();
      fWriter.close();
      fReader.close();
      bufReader.close();
      f.delete();
      f2.renameTo(f);
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
      throw new Exception(ex);
    }
    catch (IOException ex) {
      ex.printStackTrace();
      throw new Exception(ex);
    }
  }

  public void replace(String path, String oldText, String newText) throws
      Exception {
    check(path);
    File[] files = getFiles(path, null);
    for (int i = 0; i < files.length; i++) {
      f1 = files[i];
      System.out.println(f1.getPath());
      if (f1.isDirectory()) {
        replace(f1.getPath(), oldText, newText);
      }
      _replace(f1, oldText, newText);
    }
    System.out.println("finish!");
  }

  /**
   * 得到某个目录下的所有文件对象
   * 可以过滤得到某类特定的带扩展名的或包含某名字的文件
   */
  public static String[] getFilesAndDir(String path, final String sFilter) {
    if (path == null)
      return null;
    File dir = new File(path);
    String filename;
    String[] children;
    FilenameFilter filter;

    if (sFilter != null) {
      filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.indexOf(sFilter) != -1;
        }
      };
      children = dir.list(filter);
    }
    else {
      children = dir.list();
    }

    return children;
  }

  /**
   * 得到某个目录下的所有文件对象
   * 可以过滤得到某类特定的带扩展名的或包含某名字的文件
   */
  public static File[] getFiles(String path, final String sFilter) {
    if (path == null)
      return null;
    File dir = new File(path);
    String filename;
    File[] children;
    FilenameFilter filter;

    if (sFilter != null) {
      filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.indexOf(sFilter) != -1;
        }
      };
      children = dir.listFiles(filter);
    }
    else {
      children = dir.listFiles();
    }

    return children;
  }

  /**
   * 清除当前目录下指定的文件对象
   * 可以过滤得到某类特定的带扩展名的或包含某名字的文件
   */
  public static void delCurDir(String path, final String sFilter) {
    if (path == null)
      return;
    File dir = new File(path);
    String filename;
    File[] children;
    FilenameFilter filter;

    if (sFilter != null) {
      filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.indexOf(sFilter) != -1;
        }
      };
      children = dir.listFiles(filter);
    }
    else {
      children = dir.listFiles();
    }

    for(int i=0; i<children.length; i++) {
      boolean success = children[i].delete();
      if(!success)  children[i].deleteOnExit();
    }
  }

  /**
   * 清除整个目录及其子目录下的所有文件
   */
  public static void delDir(final String path) {
    if (path == null || path.equals(""))
      return;
    File dir = new File(path);
    File[] children = dir.listFiles();
    for (int i = 0; i < children.length; i++) {
      if (children[i].isDirectory())
        delDir(children[i].getPath());
      children[i].delete();
    }
    dir.delete();
  }


  /**
   * 读取文件在字节数组中
   * @param file File
   * @throws IOException
   * @return byte[]
   */
  public static byte[] getBytesFromFile(File file) throws Exception {
    InputStream is = new FileInputStream(file);
    long length = file.length();
    if (length > Integer.MAX_VALUE) {
      throw new Exception("文件太长啦！");
    }
    byte[] bytes = new byte[ (int) length];
    int offset = 0;
    int numRead = 0;
    while (offset < bytes.length &&
           (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
      offset += numRead;
    }
    if (offset < bytes.length) {
      throw new Exception("读取文件出错啦！");
    }
    is.close();
    return bytes;
  }

  //由位数得到各位操作，如取number的二进制的第bit位是0:false还是1:true
  public static boolean getBits(int number, int bit) {
    return (number & (1 << (bit - 1))) > 0;
  }

  //连续取多位，并去掉末尾的0。如101100取第3,4位得11=3
  public static int getBits(int number, int[] bits) {
    int andNum = 0;
    int budge = bits[0] - 1;
    for (int i = 0; i < bits.length; i++) {
      andNum += 1 << (bits[i] - 1);
    }
    return (number & andNum) >> budge;
  }

  //设置位,第一个参数为第一位，依此类推,如:101=5
  public static int setBits(int isNull, int isCreate, int isList,
                            int isForm, int isGroup, int isAsc, int isDesc) {
    return isNull + (isCreate << 1) + (isList << 2) + (isForm << 3) +
        (isGroup << 4) + (isAsc << 5) + (isDesc << 6);
  }

  public static int setBits(int[] bits) {
    int ib = bits[0];
    for (int i = 1; i < bits.length; i++) {
      ib += bits[i] << i;
    }
    return ib;
  }

  /**
   * 得到工程目录下WEB-INF/classes的路径
   * @return
   */
  public static String getClassRoot() {
    URL url = null;
    try {
      url = UTILPublic.class.getClassLoader().getResource("");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return url.getPath();
  }

  /**
   * 得到工程目录下WEB-INF的路径
   * @return
   */
  public static String getWebInfoPath() {
    String path = getCurClsPath(null);
    if (path != null)
      return path.substring(0, path.indexOf("classes"));
    return null;
  }

  /**
   * 得到工程目录下WEB-INF的上一级目录，即war包的路径
   * @return
   */
  public static String getWarPath() {
    String path = getClassRoot();
    if (path != null) {
      System.out.println("getCurClsPath = "+getCurClsPath(null));
      System.out.println("getClassRoot = "+getClassRoot());
      String war = "";
      try{
      	war = path.substring(0, (path.indexOf("-") - 3));      	
      }catch(Exception e) {
      	war = UTILPublic.getClassRoot();
      }
      return war;
    }
    return null;
  }

  /**
   *得到当前class的路径
   * @return
   */
  public static String getCurClsPath(Class cls) {
    URL url = null;
    try {
      if (cls != null)
        url = cls.getClass().getResource("");
      else
        url = UTILPublic.class.getResource("");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return url.getPath();
  }

  /**
   *得到当前war的路径
   * @return
   */
  public static String getWarPath(ServletConfig config) {
    String path = config.getServletContext().getRealPath("/");
    return path;
  }

  //将数组转换成集合对象
  public static Collection array2Coll(Object[] oes) {
    return Arrays.asList(oes);
  }

  //合并两个集合
  public static Collection emerge(Collection c1, Collection c2) {
    c1.addAll(c2);
    return c1;
  }

  public static void check(String s) throws Exception {
    if (s == null || s.trim().equals("") ||
        s.trim().equalsIgnoreCase("null") ||
        s.trim().equals("0"))
      throw new Exception("传来的参数为:" + s);
  }

  public static void check(int i) throws Exception {
    if (i == 0)
      throw new Exception("传来的参数为:" + i);
  }

  public static void check(Object o) throws Exception {
    if (o == null)
      throw new Exception("传来的参数为空");
    if (o instanceof Collection && ( (Collection) o).size() < 1)
      throw new Exception("传来的参数-集合尺寸为0");
  }

  public static boolean isNull(String s) {
    if (s == null || s.trim().equals("") ||
        s.trim().equalsIgnoreCase("null") ||
        s.trim().equals("0"))
      return true;
    return false;
  }

  public static boolean isNull(Object o) {
    if (o == null)
      return true;
    if (o instanceof Collection && ( (Collection) o).size() < 1)
      return true;
    return false;
  }

  public static boolean isZero(int i) {
    return i == 0;
  }

  public static java.sql.Date getDateValue() {
    java.sql.Date columnValue = new java.sql.Date(System.currentTimeMillis());
    return columnValue;
  }

  public static Time getTimeValue() {
    Time columnValue = new Time(System.currentTimeMillis());
    return columnValue;
  }

  public static Timestamp getTimestampValue() {
    Timestamp columnValue = new Timestamp(System.currentTimeMillis());
    return columnValue;
  }





  /**
   * 将字符串转化成ASCII编码
   * @param args String[]
   */
  public static String String2Ascii(String str) throws Exception {
    String s = "";
    String _s = null;

    byte[] b = str.getBytes("utf-8");
    for (int i = 0; i < b.length; i++) {
      _s = Integer.toHexString( (int) b[i]);
      s += "%" + _s.substring(_s.length() - 2);
    }
    return s;
  }

  /**
   * 将ASCII转换成字符串
   * @param s String
   * @return String
   */
  public static String Ascii2String(String s) throws Exception {
    String s1 = null;
    String s2 = null;
    int i = 0, j = 0;
    while (s.indexOf("%") != -1) {
      i = s.indexOf("%") + 1;
      j = i + 8;
      s1 = s.substring(0, i - 1);
      s2 = s.substring(j);
      s = s.substring(i, j);

      s = s1 +
          new String(new byte[] { (byte) Integer.parseInt(s.substring(0, 2),16),
                     (byte) Integer.parseInt(s.substring(3, 5), 16),
                     (byte) Integer.parseInt(s.substring(6, 8), 16)}
                     , "utf-8") +s2;
    }

    return s;
  }


  public static void writeObject2File(Object o, String file) throws Exception {
    ObjectOutputStream out = null;
    out = new ObjectOutputStream(new FileOutputStream(file));
    //getClassPath()+"key.dat"
    out.writeObject(o);
    out.close();
  }

  public static Object readObject2File(String file) throws Exception {
    ObjectInputStream in = null;
    Object o = null;
    in = new ObjectInputStream(new FileInputStream(file));
    o = in.readObject();
    in.close();
    return o;
  }

  public static void main1(String[] args) {
    try {
      Collection coll = new ArrayList();
      coll.add("10");
      coll.add("9");
      coll.add("8");
      coll.add("7");
      coll.add("6");
      coll.add("5");
      for(Iterator it = coll.iterator(); it.hasNext();) {
        System.out.println(it.next());
      }

      Vector v = new Vector();
      v.add("10");
      v.add("9");
      v.add("8");
      v.add("7");
      v.add("6");
      v.add("5");
      for(Iterator it = v.iterator(); it.hasNext();) {
        System.out.println(it.next());
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void listDir(String path) {
    try {
      File[] files = getFiles(path, null);
      File f1;
      for (int i = 0; i < files.length; i++) {
        f1 = files[i];
        if (f1.isDirectory()) {
          System.out.println("-keep public class "+f1.getPath()+".**");
          listDir(f1.getPath());
        }
      }

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }


}
