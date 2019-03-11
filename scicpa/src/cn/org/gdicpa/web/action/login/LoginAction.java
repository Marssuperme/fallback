package cn.org.gdicpa.web.action.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.log.LogService;
import cn.org.gdicpa.web.service.log.model.LogTable;
import cn.org.gdicpa.web.service.login.LoginService;
import cn.org.gdicpa.web.service.user.UserService;
import et.otp.ETOtpOpp;

public class LoginAction extends MultiActionController {

	private final String LOGIN_VIEW = "/login.jsp";
	private final String MAIN_VIEW = "/main.jsp";

	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("登录......");
		return login(request, response);
	}

	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		
		Connection conn = null;
		HashMap mapResult = new HashMap();
		String strResult = "AS_usr";

		try {
			UserSession userSession = new UserSession();
			conn = new DBConnect().getConnect();

			String usr = request.getParameter("AS_usr");
			String psw = request.getParameter("AS_psw");
			String dynamicPwd = request.getParameter("AS_dynamicPwd") ;
			String userType = request.getParameter("userType") ; //1代表事务所用户 0代表个人用户
			
			String cookiesValue = "";
			//读取cookie值
			try {
				Cookie cookies[] = request.getCookies();
				
				
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if ("WebLastLogin".equals(cookies[i].getName())){
							cookiesValue = cookies[i].getValue();
						}
					}

				}
			} catch (Exception ex) {
				throw new Exception("读取cookie出现异常:" + ex.getMessage());
			}
			
			
			//mapResult.put("cookiesValue", cookiesValue);
//			mapResult.put("cookiesValue", "11111111");
			
			// String GroupOrUser = request.getParameter("GroupOrUser");
			if (usr != null && psw != null && !"".equals(usr)
					&& !"".equals(psw)) {
				LoginService ls = new LoginService(conn);
				
				String result = " ";
				// k_dogExcepect 有登陆用户就直接登陆
				//在此，可能同时存在着账号一致的用户
				
				String loginid = new ASFuntion().showNull(new DbUtil(conn).queryForString("select loginid from k_dogExcepect where loginid=? and propertys=?",new Object[]{usr,psw}));
				
				String dog = "1";
				
				if(loginid.equals(usr)){
					result = "0";
					dog = "0";
					
				}else{
					result = ls.isLogin(usr, psw,userType);// 是否可以登录
				}
				if("N".equals(result)||"N".equals(loginid)){
					strResult = this.LOGIN_VIEW;
					mapResult.put("AS_usr", usr);
					mapResult.put("AS_psw", psw);
					mapResult.put("AS_dynamicPwd", dynamicPwd);
					mapResult.put("typeError", "error");
					return new ModelAndView(strResult, mapResult);
				}
				
				System.out.println(this.getClass()+"   usr="+usr+"   loginid="+loginid);
				System.out.println(this.getClass()+" || result = "+result);
				
				if ("0".equals(result)) {
					UserService userService = new UserService(conn);
					Map map = userService.getUserLogin(usr,userType,dog);
					
					if(!loginid.equals(usr)){  
						if("1".equals(userType)) {
								//事务所用户
								String resultStr = new ETOtpOpp(conn).checkPwdz201(usr, dynamicPwd);
								
								if(!"ok".equals(resultStr)) {
									//失败
									//result = "动态口令输入错误！";
									mapResult.put("serverinfo", resultStr);
									strResult = this.LOGIN_VIEW;
									return new ModelAndView(strResult, mapResult);
								}
						}else {
							//个人用户
							if(((String)map.get("ctypetabname")).equalsIgnoreCase("k_company")) {
								//机构用户，但他选了个人
								mapResult.put("serverinfo", "您属于事务所用户，请在登录页中选择事务所用户！");
								strResult = this.LOGIN_VIEW;
								return new ModelAndView(strResult, mapResult);
							}
						}
					}
					
					if("1".equals(userType)){
						//如果团体会员 跟个人会员登录名一致
						
						String isTypeRight0 = new DbUtil(conn).queryForString(" select ctypetabname from k_company where loginid = ? ", new Object[]{usr});
						String isTypeRight = new DbUtil(conn).queryForString(" select ctypetabname from k_micfo where loginid = ? ", new Object[]{usr});
						String isTypeRight2 = new DbUtil(conn).queryForString(" select ctypetabname from k_micfoNo where loginid = ? ", new Object[]{usr});
						
						if("k_company".equalsIgnoreCase(isTypeRight0)){
							//表示选择的类型是正确的
							isTypeRight="k_company";
							isTypeRight2="k_company";
						}
						
						//注视选错了类型
						if("K_Micfo".equalsIgnoreCase(isTypeRight)){
							strResult = this.LOGIN_VIEW;
							mapResult.put("AS_usr", usr);
							mapResult.put("AS_psw", psw);
							mapResult.put("AS_dynamicPwd", dynamicPwd);
							mapResult.put("typeError", "error");
							return new ModelAndView(strResult, mapResult);
						}
						
						//非执业会员选错了类型
						if("K_MicfoNo".equalsIgnoreCase(isTypeRight2)){
							strResult = this.LOGIN_VIEW;
							mapResult.put("AS_usr", usr);
							mapResult.put("AS_psw", psw);
							mapResult.put("AS_dynamicPwd", dynamicPwd);
							mapResult.put("typeError", "error");
							return new ModelAndView(strResult, mapResult);
						}

						
						// 检查事务所是否设置过电话号码：省注协小梁需求(搜集各个事务所所长号码，以便发短信用)
						String isSetPhone = new DbUtil(conn).queryForString(" select issetphone from k_company where loginid = ? ", new Object[]{usr});
						
						//检查是否注师选错了用户登录类型
						
						
						// 还没有进行修改设置电话号码，不能进行登陆，必须设置手机号码才让登陆
						if(!"Y".equalsIgnoreCase(isSetPhone)){
							strResult = this.LOGIN_VIEW;
							mapResult.put("AS_usr", usr);
							mapResult.put("AS_psw", psw);
							mapResult.put("AS_dynamicPwd", dynamicPwd);
							mapResult.put("isSetPhone", "N");
							return new ModelAndView(strResult, mapResult);
						}
					}else if("0".equals(userType)){
						String isTypeRight0 = new DbUtil(conn).queryForString(" select ctypetabname from k_company where loginid = ? ", new Object[]{usr});
						String isTypeRight = new DbUtil(conn).queryForString(" select ctypetabname from k_micfo where loginid = ? ", new Object[]{usr});
						String isTypeRight2 = new DbUtil(conn).queryForString(" select ctypetabname from k_micfoNo where loginid = ? ", new Object[]{usr});

						
						if("K_company".equalsIgnoreCase(isTypeRight0)&&!"K_micfo".equalsIgnoreCase(isTypeRight)&&!"K_micfono".equalsIgnoreCase(isTypeRight2)){
							strResult = this.LOGIN_VIEW;
							mapResult.put("AS_usr", usr);
							mapResult.put("AS_psw", psw);
							mapResult.put("AS_dynamicPwd", dynamicPwd);
							mapResult.put("typeError", "error");
							return new ModelAndView(strResult, mapResult);
						}
					}
					
					
					/*
					// 封掉 注协 k_cicpa 中除了 admin 的其他用户
					if(((String)map.get("ctypetabname")).equalsIgnoreCase("k_cicpa") && !((String)map.get("loginid")).equalsIgnoreCase("admin")){
						result = "用户存在禁用状态，没法登录！";
						mapResult.put("serverinfo", result);
						strResult = this.LOGIN_VIEW;
						return new ModelAndView(strResult, mapResult);
					}*/
					///////////////////
					System.out.println(this.getClass()+"    ||  map =   "+map);
					userSession.setUserMap(map);

					// K_CICPA -- 省注协用户、各地市注协对口业务部门用户：
					// K_Company -- 团体会员表【公司会员表】:
					// K_Micfo -- 执业会员表：
					// K_MicfoNo -- 非执业会员：
					// K_Director -- 理事和专业委员会成员：
					// K_Government -- 政府查询用户：
					// K_Assesser
					// K_Assess

					String tableName = ((String) map.get("ctypetabname"))
							.split("\\_")[1].toLowerCase();
					
					if("Assess".equalsIgnoreCase(tableName)){
						tableName = "company";
					}
					if("Assesser".equalsIgnoreCase(tableName)){
						tableName = "assesser";
					}
					
					strResult = "/" + tableName + MAIN_VIEW;
					
					// 事务所用户换纵向菜单
					if("company".equalsIgnoreCase(tableName)){
						strResult = "/" + tableName + "/main1.jsp";
						System.out.println(strResult);
					}
					
					
					// 纵向 菜单
//					if("19870803".equals(usr) || "44040009".equals(usr)){
//						strResult = "/" + tableName + "/main1.jsp";
//					}
					
					
					System.out.println("主页：" + strResult);
					mapResult.put("tableName", tableName);
					
					String fileTempName = DELUnid.getNumUnid()  ; 
					String userPhotoSrc = userService.getPhoto((String) map.get("ctypetabname"), (String)map.get("loginid"), fileTempName);
					mapResult.put("userPhotoSrc", userPhotoSrc);
					
					// 记录登录日志信息  l_log 表
					ASFuntion CHF=new ASFuntion();
					LogService log = new LogService(conn);
					String date = CHF.getCurrentDate();
					String time = CHF.getCurrentTime();
					String userid = (String) map.get("loginid");
					String loginname = (String) map.get("loginname");

					LogTable lt = new LogTable();
					lt.setUserId(userid);
					lt.setUserName(loginname);
					lt.setIp(request.getRemoteAddr());//设置客户端IP
					lt.setLoginDate(date);
					lt.setLoginTime(time);
					lt.setOperation("登录"); 
					String tabname = map.get("ctypetabname")+"";
					lt.setCtype(tabname);
					String[] tables = {"K_Company","K_Micfo","K_MicfoNo"};
					String[] initFlags = {"3"," 4","5"};
					String initFlag = "3";
					for (int i = 0; i < tables.length; i++) {
						if(tables[i].equalsIgnoreCase(tabname)){
							initFlag = initFlags[i];
							break;
						}
					}
					lt.setInitFlag(initFlag);
					
					 

					//设置cookie值,用于记录用户的登陆名
					try {
						Cookie cookie = new Cookie("WebLastLogin",usr);
						//设置cookie存活30天
						cookie.setMaxAge(60 * 60 * 24 * 30);
						response.addCookie(cookie);

					} catch (Exception ex) {
						throw new Exception("设置cookie出现异常:"
								+ ex.getMessage());
					}
					
					log.saveLogInfo(lt);       //  记录用户登录日志信息
					
				} else {
					strResult = this.LOGIN_VIEW;
				}
				request.getSession().setAttribute("userSession", userSession);
				mapResult.put("serverinfo", result);

				// 日期
				mapResult.put("today", new SimpleDateFormat("yyyy年MM月dd日 E")
						.format(new Date()));

			} else {
				strResult = this.LOGIN_VIEW;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return new ModelAndView(strResult, mapResult);
	}

	public ModelAndView exit(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView(LOGIN_VIEW);
		try {
			
			
			String cookiesValue = "";
			//读取cookie值
			try {
				Cookie cookies[] = request.getCookies();
				
				
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if ("WebLastLogin".equals(cookies[i].getName())){
							cookiesValue = cookies[i].getValue();
						}
					}

				}
			} catch (Exception ex) {
				throw new Exception("读取cookie出现异常:" + ex.getMessage());
			}
			
			
			modelAndView.addObject("cookiesValue", cookiesValue);
			
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return modelAndView;
	}
	
	
	
	/**
	 * 得到客户信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView loginByIdentity(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 处理ajax返回中文出现乱码问题
		response.setContentType("text/html;charset=UTF-8");
		String sql = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		ASFuntion CHF = new ASFuntion();
		PrintWriter out  = response.getWriter() ;
		String idnumber = CHF.showNull(request.getParameter("idnumber"));
		//为兼容第一代身份证
		String idnumber2 = idnumber.subSequence(0, 6)+idnumber.substring(8, 17);
		
		try {
			conn = new DBConnect().getConnect();
			sql = " select * from ( "
				+ " select ctype,ctypetabname,departid,name,idnumber,loginid,'officecode' as officecode from K_CICPA c left join k_department d on c.departId = d.id "
				+ " union all  "
				+ " select ctype,ctypetabname,'departid' as departid,'name' as name,idnumber,loginid,officecode from K_Micfo "
				+ " union all "
				+ " select ctype,ctypetabname,'departid' as departid,'name' as name,idnumber,loginid,'officecode' as officecode from K_Micfono "
				+ " ) tt where idnumber = ? or idnumber = ?";
			
			System.out.println("idnumber="+idnumber);
			System.out.println("sql="+sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, idnumber);
			ps.setString(2, idnumber2);
			
			rs = ps.executeQuery();
			Map<String, String> map = new HashMap<String, String>();

			//用户类型
			String ctype = "";
			//用户类型
			String ctypetabname = "";
			//部门编号
			String departid = "";
			//部门名称
			String name = "";
			//loginid
			String loginid = "";
			//officecode
			String officecode = "";
			
			if (rs.next()) {
				ctype = rs.getString("ctype");
				ctypetabname = rs.getString("ctypetabname");
				departid = rs.getString("departid");
				name = rs.getString("name");
				idnumber = rs.getString("idnumber");
				loginid = rs.getString("loginid");
				officecode = rs.getString("officecode");
				
			}
			map.put("ctype", CHF.showNull(ctype));
			map.put("ctypetabname", CHF.showNull(ctypetabname).toLowerCase());
			map.put("departid", CHF.showNull(departid));
			map.put("name", CHF.showNull(name));
			map.put("idnumber", CHF.showNull(idnumber));
			map.put("loginid", CHF.showNull(loginid));
			map.put("officecode", CHF.showNull(officecode));
			String json = JSONArray.fromObject(map).toString();
			out.write(json) ;
			out.close() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	

	/**
	 * 修改电话号码
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView updatePhone(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String loginid = af.showNull(request.getParameter("loginid"));
		String corporationphone = af.showNull(request.getParameter("corporationphone"));
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String sql = " update k_company set corporatephone=?,linkphone=?,issetphone=? where loginid = ? ";
			new DbUtil(conn).executeUpdate(sql, new Object[]{corporationphone,corporationphone,"Y",loginid});
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			out.print("Y");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
}
