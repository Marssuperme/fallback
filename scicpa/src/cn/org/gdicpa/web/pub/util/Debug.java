package cn.org.gdicpa.web.pub.util;

import java.net.URL;
import java.io.*;
import cn.org.gdicpa.web.pub.sys.UTILSysProperty;

/**
 *
 * <p>Title: 封装日志的类</p>
 *
 * <p>Description: 基于LOG4J和commn-log实现，
 * 但是不需要为每个类都定义了一个LOG对象</p>
 *
 * <p>Copyright: Copyright  Matech(c) 2007</p>
 *
 * <p>Company: 铭太科技</p>
 *
 * @author winnerQ
 * @version 3.0
 */
public class Debug {
    /**
     * 公共常量，用于制定错误级别
     */
     final public static int iDebug=1;
     final public static int iInfo=2;
     final public static int iWarn=3;
     final public static int iError=4;
     final public static int iFatal=5;

    /**
     * 简化版本的日志记录函数，内部调用loj4j
     * 提供2个级别（info和debug）的日志调用
     * @param str String
     */
    public static void print(String str) {
        if (UTILSysProperty.DEBUGPRINTLN)
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str);
        else
            org.apache.commons.logging.LogFactory.getLog(Object.class).debug(str);
    }

    /**
     * 公共版本版本的函数，可以直接使用
     *
     * @param iMode int
     * @param str String
     */
    public static void print(int iMode, String str) {
        switch (iMode) {
        case iDebug:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str);
            break;
        case iInfo:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str);
            break;
        case iWarn:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str);
            break;
        case iError:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str);
            break;
        case iFatal:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str);
            break;
        }

    }

    /**
     * 把异常一块记录日志
     * @param iMode int
     * @param str String
     * @param e Exception
     */
    public static void print(int iMode, String str,Exception e) {
        switch (iMode) {
        case iDebug:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str,e);
            break;
        case iInfo:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str,e);
            break;
        case iWarn:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str,e);
            break;
        case iError:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str,e);
            break;
        case iFatal:
            org.apache.commons.logging.LogFactory.getLog(Object.class).info(str,e);
            break;
        }
    }

    public static void printErr(String str) {
        if (UTILSysProperty.DEBUGPRINTLN)
            System.err.println(str);
    }

    public static void printOut(String str) {
        if (UTILSysProperty.DEBUGPRINTLN)
            System.out.println(str);
    }

    private static String getClassRootPath(String file) {

        URL url = null;
        try {
            url = (new Debug()).getClass().getClassLoader().getResource(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String path = null;
        if (url == null)
            System.err.println("读取日志文件出错！");
        else
            path = url.getPath();
        printErr("path=" + path);
        return path;
    }

    public static void writeLog(String text) {

        if (!UTILSysProperty.DEBUGPRINTLN)
            return;
        String file = "conn.log";
        try {
            FileWriter theFile = new FileWriter(getClassRootPath(file), true);
            PrintWriter out = new PrintWriter(theFile);
            printErr(text);
            out.println(text);
            out.close();
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        Debug bug = new Debug();
        bug.writeLog("123123123");
    }

}
