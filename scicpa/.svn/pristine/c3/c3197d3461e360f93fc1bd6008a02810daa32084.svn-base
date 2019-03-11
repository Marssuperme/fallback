// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 2013/5/27 9:49:43
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NianjianAction.java

package cn.org.gdicpa.web.action.nianjian;

import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.contentExemptionNot.model.ContentExemptionNot;
import cn.org.gdicpa.web.service.inspection.InspectionService;
import cn.org.gdicpa.web.service.user.UserService;
import java.io.*;
import java.sql.Connection;
import java.util.*;

import javax.servlet.http.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NianjianAction extends MultiActionController
{

    public NianjianAction()
    {
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
        Map map = userSession.getUserMap();
        String ctypetabname = (String)map.get("ctypetabname");
        String loginid = (String)map.get("loginid");
        ModelAndView modelandview = new ModelAndView("/nianjian/list.jsp");
        try
        {
            String sql = (new StringBuilder(" select *,case approval when '1' then '\u6B63\u5F0F' else '\u6682\u5B58' end as status from t_inspectionno a  where a.iuser = '")).append(loginid).append("' ").toString();
            DataGridProperty pp = new DataGridProperty();
            pp.setWhichFieldIsValue(1);
            pp.setSQL(sql);
            pp.setOrderBy_CH("iyear");
            pp.setDirection("desc");
            pp.setTableID("FconExemList");
            pp.setInputType("");
            pp.setPageSize_CH("10");
            pp.setWhichFieldIsValue(1);
            pp.setTitle("\u975E\u6267\u4E1A\u4F1A\u5458\u5E74\u68C0\u767B\u8BB0\u8868");
            pp.addColumn("\u5E74\u68C0\u5E74\u4EFD", "iyear", "showCenter");
            pp.addColumn("\u662F\u5426\u53C2\u52A0\u5E74\u68C0", "yearcheck", "showCenter");
            pp.addColumn("\u5B66\u65F6\u6570", "schooldate", "showCenter");
            pp.addColumn("\u662F\u5426\u7F34\u8D39", "dues", "showCenter");
            pp.addColumn("\u662F\u5426\u6C11\u4E8B\u80FD\u529B", "msnl", "showCenter");
            pp.addColumn("\u662F\u5426\u5211\u4E8B\u5904\u7F5A", "xscf", "showCenter");
            pp.addColumn("\u662F\u5426\u884C\u4E1A\u5904\u7F5A", "hycf", "showCenter");
            pp.addColumn("\u4FDD\u5B58\u72B6\u6001", "status", "showCenter");
            request.getSession().setAttribute((new StringBuilder("DGProperty_")).append(pp.getTableID()).toString(), pp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        modelandview.addObject("ctypetabname", ctypetabname.toLowerCase());
        return modelandview;
    }

    public ModelAndView addGo(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView modelandview;
        Connection conn;
        modelandview = new ModelAndView("/nianjian/add.jsp");
        conn = null;
        try
        {
            UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
            conn = (new DBConnect()).getConnect();
            Map map = userSession.getUserMap();
            UserService user = new UserService(conn);
            String tabname = (String)map.get("ctypetabname");
            String loginid = (String)map.get("loginid");
            Map userMap = user.getUser(tabname, loginid);
            InspectionService is = new InspectionService(conn);
            String year = request.getParameter("year");
            Map isMap = is.getInspectionNo(loginid, year);
            modelandview.addObject("userMap", userMap);
            modelandview.addObject("isMap", isMap);
            modelandview.addObject("year", year);
            if("1".equals(isMap.get("approval")))
            {
                modelandview.addObject("readonly", "readonly");
                modelandview.addObject("print", "");
                modelandview.addObject("save", "disabled");
            } else
            {
                modelandview.addObject("readonly", "");
                modelandview.addObject("print", "disabled");
                modelandview.addObject("save", "");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }finally{
        	DbUtil.close(conn);
        }
        return modelandview;
    }

    public ModelAndView save(HttpServletRequest request, HttpServletResponse response, ContentExemptionNot cExemptionNot)
        throws Exception
    {
        Connection conn = null;
        String err = "";
        ASFuntion asf = new ASFuntion();
        String year = asf.showNull(request.getParameter("year"));
        String msnl = asf.showNull(request.getParameter("msnl"));
        String xscf = asf.showNull(request.getParameter("xscf"));
        String hycf = asf.showNull(request.getParameter("hycf"));
        
        conn = (new DBConnect()).getConnect();
        UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
        Map userMap = userSession.getUserMap();
        Map parameters = new HashMap();
        String paramName;
        String paramValue;
        for(Enumeration enum1 = request.getParameterNames(); enum1.hasMoreElements(); parameters.put(paramName, paramValue)){
            paramName = (String)enum1.nextElement();
            paramValue = request.getParameter(paramName);
        }

        parameters.put("loginid", (String)userMap.get("loginid"));
        parameters.put("ctypetabname", (String)userMap.get("ctypetabname"));
        System.out.println((new StringBuilder("approval=")).append(parameters.get("approval")).toString());
        UserService user = new UserService(conn);
        user.saveInfo(parameters);
        parameters.put("iuser", (String)userMap.get("loginid"));
        parameters.put("iyear", year);
        parameters.put("id", UUID.randomUUID().toString());
        parameters.put("msnl", msnl);
        parameters.put("xscf", xscf);
        parameters.put("hycf", hycf);
        
        parameters.put("flag", "all");//通过“填报年检表”提交的数据 
        InspectionService is = new InspectionService(conn);
        is.saveToInspectionno(parameters);
        PrintWriter out = null;
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        if("1".equals(parameters.get("approval")))
            out.println((new StringBuilder("<script>alert('\u586B\u62A5\u4FDD\u5B58\u6210\u529F');window.location=\"")).append(request.getContextPath()).append("/common/nianjian.do?method=goPrint&year="+year+"\"</script>").toString());
        else
            out.println((new StringBuilder("<script>alert('\u586B\u62A5\u4FDD\u5B58\u6210\u529F');window.location=\"")).append(request.getContextPath()).append("/common/nianjian.do?method=list\"</script>").toString());
        out.close();
        DbUtil.close(conn);
        return null;
    }

    public ModelAndView goPrint(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        ModelAndView modelandview;
        Connection conn;
        modelandview = new ModelAndView("/nianjian/print.jsp");
        conn = null;
        try
        {
            UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
            conn = (new DBConnect()).getConnect();
            Map map = userSession.getUserMap();
            UserService user = new UserService(conn);
            String tabname = (String)map.get("ctypetabname");
            String loginid = (String)map.get("loginid");
            Map userMap = user.getUser(tabname, loginid);
            InspectionService is = new InspectionService(conn);
            String year = request.getParameter("year");
            Map isMap = is.getInspectionNo(loginid, year);
            modelandview.addObject("userMap", userMap);
            modelandview.addObject("isMap", isMap);
            modelandview.addObject("year", year);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
        	DbUtil.close(conn);
        }
        return modelandview;
    }

    private static final String LIST = "/nianjian/list.jsp";
    private static final String ADD = "/nianjian/add.jsp";
    private static final String PRINT = "/nianjian/print.jsp";
}