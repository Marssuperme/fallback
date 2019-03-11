package cn.org.gdicpa.web.action.pay;

import java.io.Writer;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.pay.Order;
import cn.org.gdicpa.web.service.pay.OrderService;
import cn.org.gdicpa.web.service.pay.Pay;
import cn.org.gdicpa.web.service.user.UserService;

import com.yeepay.Configuration;
import com.yeepay.PaymentForOnlineService;

public class PayAction extends MultiActionController {
	private static final String PAY_INFO_VIEW = "/pay/payInfo.jsp"; 
	private static final String PAY_VIEW = "/pay/pay.jsp"; 
	private static final String CALL_BACK_VIEW = "/pay/callback.jsp"; 
	private static final String TEST_VIEW = "/pay/test.jsp"; 
	private static final String ORDER_LIST_VIEW = "/pay/orderList.jsp"; 
	private static final String ORDER_VIEW = "/pay/orderView.jsp"; 
	
	
	private static final String CMD = "Buy";
	private static final String CUR = "CNY";
	private static final String CALLBACK_URL = "/common/pay.do?method=callback"; // 商户接收支付成功数据的地址
	private static final String NEED_RESPONSE = "1"; // 默认为"1"，需要应答机制

	/**
	 * 支付
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView pay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String order = request.getParameter("order");
		String amount = StringUtil.showNull(request.getParameter("amount"));
		String productName = StringUtil.showNull(request.getParameter("productName"));
		String productType = StringUtil.showNull(request.getParameter("productType"));
		String productDesc = StringUtil.showNull(request.getParameter("productDesc"));
		String productReMark = StringUtil.showNull(request.getParameter("productReMark"));
		String frpId = StringUtil.showNull(request.getParameter("frpId"));
		
		String keyValue = StringUtil.showNull(Configuration.getInstance().getValue("keyValue")); // 商家密钥
		String nodeAuthorizationURL = StringUtil.showNull(Configuration.getInstance().getValue("yeepayCommonReqURL")); // 交易请求地址
		
		
		// 商家设置用户购买商品的支付信息
		String p0_Cmd = CMD; // 在线支付请求，固定值 ”Buy”
		String p1_MerId = StringUtil.showNull(Configuration.getInstance().getValue("p1_MerId")); // 商户编号
		String p2_Order = order; // 商户订单号
		String p3_Amt = amount; // 支付金额
		String p4_Cur = CUR; // 交易币种
		String p5_Pid = productName; // 商品名称
		String p6_Pcat = productType; // 商品种类
		String p7_Pdesc = productDesc; // 商品描述
		String p8_Url = "http://" + request.getServerName() + ":"+request.getServerPort()+request.getContextPath() + CALLBACK_URL; // 商户接收支付成功数据的地址
		String p9_SAF = "0"; // 需要填写送货信息 0：不需要  1:需要
		String pa_MP = productReMark; // 商户扩展信息
		String pd_FrpId = frpId.toUpperCase();; // 支付通道编码， 银行编号必须大写
		String pr_NeedResponse = NEED_RESPONSE; // 默认为"1"，需要应答机制
		String hmac = StringUtil.showNull(""); // 交易签名串

		// 获得MD5-HMAC签名
		hmac = PaymentForOnlineService.getReqMd5HmacForOnlinePayment(p0_Cmd,
				p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		
		ModelAndView modelAndView = new ModelAndView(PAY_VIEW);
		
		modelAndView.addObject("p0_Cmd", p0_Cmd);
		modelAndView.addObject("p1_MerId", p1_MerId);
		modelAndView.addObject("p2_Order", p2_Order);
		modelAndView.addObject("p3_Amt", p3_Amt);
		modelAndView.addObject("p4_Cur", p4_Cur);
		modelAndView.addObject("p5_Pid", p5_Pid);
		modelAndView.addObject("p6_Pcat", p6_Pcat);
		modelAndView.addObject("p7_Pdesc", p7_Pdesc);
		modelAndView.addObject("p8_Url", p8_Url);
		modelAndView.addObject("p9_SAF", p9_SAF);
		modelAndView.addObject("pa_MP", pa_MP);
		modelAndView.addObject("pd_FrpId", pd_FrpId);
		modelAndView.addObject("pr_NeedResponse", pr_NeedResponse);
		modelAndView.addObject("hmac", hmac);
		modelAndView.addObject("nodeAuthorizationURL", nodeAuthorizationURL);

		return modelAndView;
	}
	
	/**
	 * 选择支付类型
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView payInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(PAY_INFO_VIEW);
		
		String orderId = request.getParameter("orderId");
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			
			OrderService orderService = new OrderService(conn);
			Order order = orderService.getOrder(orderId);
			modelAndView.addObject("order", order);
	
			Pay pay = new Pay();
			pay.setOrder(order.getOrderId());
			pay.setAmount(order.getOrderAmount());
			pay.setProductName(order.getOrderContent());
			pay.setProductType("");
			pay.setProductDesc("");
			pay.setProductReMark("");
			
			modelAndView.addObject("pay", pay);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}

	/**
	 * 回调
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView callback(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(CALL_BACK_VIEW);
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		Writer out = null ;
		response.setContentType("text/html;charset=UTF-8") ;
		out = response.getWriter() ;
		
		
		String keyValue   = StringUtil.showNull(Configuration.getInstance().getValue("keyValue"));   // 商家密钥
		String r0_Cmd 	  = StringUtil.showNull(request.getParameter("r0_Cmd")); // 业务类型
		String p1_MerId   = StringUtil.showNull(Configuration.getInstance().getValue("p1_MerId"));   // 商户编号
		String r1_Code    = StringUtil.showNull(request.getParameter("r1_Code"));// 支付结果
		String r2_TrxId   = StringUtil.showNull(request.getParameter("r2_TrxId"));// 易宝支付交易流水号
		String r3_Amt     = StringUtil.showNull(request.getParameter("r3_Amt"));// 支付金额
		String r4_Cur     = StringUtil.showNull(request.getParameter("r4_Cur"));// 交易币种
		String r5_Pid     = new String(StringUtil.showNull(request.getParameter("r5_Pid")).getBytes("iso-8859-1"),"gbk");// 商品名称
		String r6_Order   = StringUtil.showNull(request.getParameter("r6_Order"));// 商户订单号
		String r7_Uid     = StringUtil.showNull(request.getParameter("r7_Uid"));// 易宝支付会员ID
		String r8_MP      = new String(StringUtil.showNull(request.getParameter("r8_MP")).getBytes("iso-8859-1"),"gbk");// 商户扩展信息
		String r9_BType   = StringUtil.showNull(request.getParameter("r9_BType"));// 交易结果返回类型
		String hmac       = StringUtil.showNull(request.getParameter("hmac"));// 签名数据
		boolean isOK = false;
		// 校验返回数据包
		isOK = PaymentForOnlineService.verifyCallback(hmac,p1_MerId,r0_Cmd,r1_Code, 
				r2_TrxId,r3_Amt,r4_Cur,r5_Pid,r6_Order,r7_Uid,r8_MP,r9_BType,keyValue);
		
		
		String result = "";
		if(isOK) {
			if(r1_Code.equals("1")) {
				// 产品通用接口支付成功返回-浏览器重定向
				if(r9_BType.equals("1")) {
					
					result = "支付成功!!";
					
					//更新订单信息，修改成已支付状态
					Connection conn = null;
					
					try {
						
						conn = new DBConnect().getConnect();
						OrderService orderService = new OrderService(conn);
						Order order = orderService.getOrder(r6_Order);
						// 找出支付人 是个人还是事务所
						String payTarget = "个人缴费";
						String ctypeTabName=new DbUtil(conn).queryForString("select ctypetabname from k_user where loginid = ?",new Object[]{order.getUserId()});
						if("k_company".equalsIgnoreCase(ctypeTabName)){
							payTarget = "团体代缴费";
						}
						
						if(order != null) {
							order.setOrderState(OrderService.ORDER_STATE_PAID);
							order.setPayType("易宝支付");
							order.setPayDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							order.setSerialNumber(r2_TrxId);
							order.setPayTarget(payTarget);
							orderService.update(order);
						}
						
					} catch (Exception e) {
						result = "支付成功!!但更新订单信息失败，请联系系统管理员";
						e.printStackTrace();
					} finally {
						DbUtil.close(conn);
					}
					
					
					// 产品通用接口支付成功返回-服务器点对点通讯
				} else if(r9_BType.equals("2")) {
					// 如果在发起交易请求时	设置使用应答机制时，必须应答以"success"开头的字符串，大小写不敏感
					//out.write("SUCCESS");
				  // 产品通用接口支付成功返回-电话支付返回		
				}
				
				// 下面页面输出是测试时观察结果使用
				//out.write("<br>交易成功!<br>商家订单号:" + r6_Order + "<br>商家备注:" + r8_MP + "<br>支付金额:" + r3_Amt + "<br>易宝支付交易流水号:" + r2_TrxId);
				modelAndView.addObject("result", result);
				modelAndView.addObject("orderId", r6_Order);
				modelAndView.addObject("amount", r3_Amt);
				modelAndView.addObject("serialNumber", r2_TrxId);
			}
		} else {
			result = "支付失败!!交易签名被篡改";
			//out.write("交易签名被篡改!");
		}
		

		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
	
	public ModelAndView test(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(TEST_VIEW);
		return modelAndView;
	}
	
	public ModelAndView orderView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(ORDER_VIEW);
		
		Connection conn = null;
		
		String orderId = request.getParameter("orderId");
		
		try {
			conn = new DBConnect().getConnect();
			
			OrderService orderService = new OrderService(conn);
			Order order = orderService.getOrder(orderId);
			
			modelAndView.addObject("order", order);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return modelAndView;
	}
	
	public ModelAndView orderList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");

		Map map = userSession.getUserMap();
		
		String loginId = (String) map.get("loginid");

		String sql = " select orderId,orderDate,orderContent,orderamount,orderstate "
					+ " from k_order "
					+ " where orderstate=0 "
					+ " and userid='" + loginId + "' "; 
		DataGridProperty pp = new DataGridProperty();

		pp.setTitle("未缴费列表");
		pp.setTableID("orderList");
		pp.setWhichFieldIsValue(1);
		pp.addColumn("支付号", "orderId", "showCenter");
		pp.addColumn("开单日期", "orderDate", "showCenter");
		pp.addColumn("支付内容", "orderContent");
		pp.addColumn("支付金额", "orderamount");
		pp.addColumn("操作", "").setColContent("<center><a style='text-decoration:underline;' href='###' onclick=\"pay('${orderId}');\">缴费</a></center>");

		pp.setSQL(sql);
		pp.setOrderBy_CH("orderId");
		pp.setDirection("desc");
		request.getSession().setAttribute(
				DataGrid.sessionPre + pp.getTableID(), pp);
		
		String sql1 = " select orderId,orderDate,orderContent,orderamount,orderstate,payDate,payType,serialnumber "
					+ " from k_order "
					+ " where orderstate=1 "
					+ " and userid='" + loginId + "' "; 
		DataGridProperty pp2 = new DataGridProperty();
		
		pp2.setTitle("已缴费列表");
		pp2.setTableID("orderList2");
		pp2.setWhichFieldIsValue(1);
		pp2.addColumn("支付号", "orderId", "showCenter");
		pp2.addColumn("开单日期", "orderDate", "showCenter");
		pp2.addColumn("支付内容", "orderContent");
		pp2.addColumn("支付金额", "orderamount");
		pp2.addColumn("支付日期", "payDate", "showCenter");
		pp2.addColumn("支付类型", "payType");
		pp2.addColumn("支付流水号", "serialnumber", "showCenter");
		
		
		pp2.setSQL(sql1);
		pp2.setOrderBy_CH("orderId");
		pp2.setDirection("desc");
		request.getSession().setAttribute(
		DataGrid.sessionPre + pp2.getTableID(), pp2);

		ModelAndView modelAndView = new ModelAndView(ORDER_LIST_VIEW);
		return modelAndView;
	}
}
