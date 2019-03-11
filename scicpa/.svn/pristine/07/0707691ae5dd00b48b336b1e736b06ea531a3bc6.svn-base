package cn.org.gdicpa.web.action.hint;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.pub.db.DbUtil;

/**
 *
 * <p>Title: 提供在线提示的方法</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 *
 * @author WinnreQ
 * @version 3.0
 */
public class SysHintAction extends MultiActionController {

    private final String _strSuccess = "/hint/SysHint.jsp";

    /**
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @return ModelAndView
     */
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {

        Connection conn = null;

        StringBuffer stringbuffer = null;

        try {
            req.setCharacterEncoding("UTF-8");
            conn = new DBConnect().getConnect();

            //这里是你的处理代码，以及调用SERVICE的代码
            String s = req.getParameter("autoid");
            System.out.println("%%%%%%%%%%%%%%%%%%%---s-----:"+s);
            
            //获取前台输入或者选中的PK；
            String pk1 = req.getParameter("pk1");
            
            System.out.println("%%%%%%%%%%%%%%%%%%%---pk1-----:"+pk1);
            
            if(pk1!=null&&!"".equals(pk1))
            	pk1 = pk1.replaceAll("'", "\\\\\\\\'");
            //if (pk1!=null)pk1=new String(pk1.getBytes("ISO8859-1"));
            //Debug.printErr("pk1="+pk1);


            //获取前台提交的联动参数
            String refer = req.getParameter("refer");
            String refer1 = req.getParameter("refer1");
            String refer2 = req.getParameter("refer2");
            //if (refer!=null)refer=new String(refer.getBytes("ISO8859-1"));

            //前台提交的模式是检查值有效性还是返回待选列表
            String checkmode = req.getParameter("checkmode");
//            org.util.Debug.prtOut("checkmode11=" + checkmode);
//            org.util.Debug.prtOut("pk1=" + pk1);
//            org.util.Debug.prtOut("refer=" + refer);
//            org.util.Debug.prtOut("refer1=" + refer1);
//            org.util.Debug.prtOut("refer2=" + refer2);

            String strsql = "";
           

            //缓存返回的数据
            PreparedStatement preparedstatement = null;
            ResultSet resultset = null;
            if (s != null) {
            	int iMode=0;
                if (checkmode == null || checkmode.equals("")) {
                    if (pk1 != null && !pk1.trim().equals("")) {
                        strsql ="select strsql,departfield,classpath from s_autohintselect where id='" +
                                s + "'";
                        iMode=1;
                    } else {
                        strsql ="select strinitsql,departfield,classpath from s_autohintselect where id='" +
                                s + "'";
                        iMode=2;
                    }
                } else {
                    strsql ="select strchecksql,departfield,classpath from s_autohintselect where id='" +
                            s + "'";
                    iMode=3;
                }
                
                //增加系统编号判断为哪个系统加的下拉
                String systemId =  ""; 
                
                if(!"".equals(systemId) && systemId != null) {
                	
                	String sqlTemp = strsql+" and SystemId="+Integer.parseInt(systemId);
                	preparedstatement = conn.prepareStatement(sqlTemp) ;
                	 resultset = preparedstatement.executeQuery();
                	 
                	 if(resultset.next()) {
                		 strsql = sqlTemp ;
                	 }else {
                		 //如果用系统编号找不到SQL,则使用通用的系统编号0去找
                			 strsql += " and SystemId=0";
                	 }
                }else {
                	//如果环境变量中没设置,就找默认SystemId为0的
                	strsql += " and SystemId=0";
                }
                
                preparedstatement = conn.prepareStatement(strsql);
                resultset = preparedstatement.executeQuery();
                if (resultset.next()) {

                    //如果访问的主键不为空，就取strsql
                    strsql = resultset.getString(1);
                    //选择数据库的时候需要用到

                    UserSession us=(UserSession)req.getSession().getAttribute("userSession");
                    //增加这句话以免用户没有登陆的时候，就不能使用在线提示；
                    if (us==null) us=new UserSession();
                    //使用\\是因为转义
                    
                    String strCurUserId ="";
                    String curDepartmentid ="";
                    if (us.getUserMap()!=null){
                    	//当前用户编号，注意，是userid,不是loginid或者username；
	                    strCurUserId = (String)us.getUserMap().get("loginid");
	                    //"curDepartmentid");当前用户所在机构的编号
	                    curDepartmentid =(String)us.getUserMap().get("机构编号");
                    }
                    
                    if (strsql != null &&  !"".equals(strsql)) {

                        //使用\\是因为转义
                        if (pk1 != null)
                            strsql = strsql.replaceAll("\\$1", pk1);
                        if (refer != null)
                            strsql = strsql.replaceAll("\\$2", refer);
                        if (refer1 != null)
                            strsql = strsql.replaceAll("\\$3", refer1);
                        if (refer2 != null)
                            strsql = strsql.replaceAll("\\$4", refer2);

                        if (strCurUserId != null)
                            strsql = strsql.replaceAll("\\$CURUSER",
                            		strCurUserId);
                        if (curDepartmentid != null)
                            strsql = strsql.replaceAll("\\$curDepartmentid",
                                    curDepartmentid);
//                        org.util.Debug.prtOut(strsql);
                        
                        //执行指定的SQL
                        
                        //切换到需要的数据库。
                        preparedstatement = conn.prepareStatement(strsql);
                        resultset = preparedstatement.executeQuery();
                        
                        int count = 0 ;
                        //求记录数
                        preparedstatement = conn.prepareStatement(strsql);
                        resultset = preparedstatement.executeQuery();
                       
                        if (resultset.next()) {
                            stringbuffer = new StringBuffer("OK|");
                            stringbuffer.append(pk1 + "|");
                            stringbuffer.append(resultset.getString(1) + "`");
                            stringbuffer.append(resultset.getString(2));
                            stringbuffer.append("|");
                            for (; resultset.next() ; count++,stringbuffer.append("|")) {
                                stringbuffer.append(resultset.getString(1) +
                                        "`");
                                stringbuffer.append(resultset.getString(2));
                            }
                        } else {
                            //没有找到，在检查模式下就返回出错信息；在非检查模式下，就返回正常信息
                        	if (checkmode == null || checkmode.equals("")){
                        		stringbuffer = new StringBuffer("OK|");
                        		stringbuffer.append(s + "|");
                        	}else{
	                            stringbuffer = new StringBuffer("ERROR|");
	                            stringbuffer.append(s + "|值不存在！");
                        	}
                        }
                    }
                } else {
                	
                    //没有找到，就返回出错信息
                    stringbuffer = new StringBuffer("ERROR|");
                    stringbuffer.append("指定的AUTOID"+s + "不存在|");
                }
            }

        } catch (Exception e) {
            stringbuffer = new StringBuffer("ERROR|");
            stringbuffer.append("出错原因:"+e.getMessage()+"|");
        } finally {
            DbUtil.close(conn);
        }
        
        //返回结果，这个是给页面的数据库游标
        return new ModelAndView(_strSuccess, "stringbuffer", stringbuffer);
    }
    
    /**
     * 检查下拉是否存在值
     * @param req
     * @param res
     * @return
     */
    public ModelAndView checkValeExists(HttpServletRequest req, HttpServletResponse res) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
        PrintWriter out = null;
        try {
        	req.setCharacterEncoding("UTF-8");
        	res.setContentType("text/html;charset=utf-8");
        	
        	out = res.getWriter();
        	String autoid = req.getParameter("autoid");
        	String refer = req.getParameter("refer");
        	String value = req.getParameter("value");
        	
        	System.out.println("autoid == " + autoid);
        	System.out.println("refer == " + refer);
        	System.out.println("value == " + value);
        	
            conn = new DBConnect().getConnect();            
            
            String sql = "select strchecksql from s_autohintselect where id=?";
            
            String selectSql = StringUtil.showNull(new DbUtil(conn).queryForString(sql,new Object[]{autoid}));
            
            if("".equals(selectSql)){
            	out.write("NoSQL");
            	out.flush();
            }else{
            
	            selectSql = selectSql.replaceAll("\\$2", refer);
	            selectSql = selectSql.replaceAll("\\$1", value);
	            pstmt = conn.prepareStatement(selectSql);
	            int count = 0;
	            rs = pstmt.executeQuery();
	            while(rs.next()){
	            	count++;
	            }
	            
	            if(count>0){
	            	out.write("OK|count="+count);
	            }else{
	            	out.write("NO");
	            }
	            out.flush();
            }
        }catch(Exception e){
        	out.write("ERROR|出错原因:"+e.getMessage());
        	out.flush();
        }finally{
        	out.close();
        	DbUtil.close(rs);
        	DbUtil.close(pstmt);
        	DbUtil.close(conn);
        }
    	return null;
    }
}
