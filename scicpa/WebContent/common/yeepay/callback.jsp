<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@ page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@ page import="cn.org.gdicpa.web.service.yeepay.*" %>
<%@ page import="cn.org.gdicpa.web.service.annualInspection.*" %>

<%! String formatString(String text) {
		return (text == null) ? "" : text.trim();
	}
%>
<%
	request.setCharacterEncoding("GBK");
	Connection conn = null;
	DbUtil db = null;
	PreparedStatement pstm = null;
	
	String p1_MerId				= formatString(request.getParameter("p1_MerId"));
	String r0_Cmd               = formatString(request.getParameter("r0_Cmd"));
	String r1_Code              = formatString(request.getParameter("r1_Code"));
	String r2_TrxId             = formatString(request.getParameter("r2_TrxId"));
	String r3_Amt               = formatString(request.getParameter("r3_Amt"));
	String r4_Cur               = formatString(request.getParameter("r4_Cur"));
	String r5_Pid               = formatString(request.getParameter("r5_Pid"));
	r5_Pid =new String(r5_Pid.getBytes("ISO-8859-1"),"gbk");
	//System.out.println(URLDecoder.decode(r5_Pid,"gb2312"));
	System.out.println("������������  "+r5_Pid);
	String r6_Order             = formatString(request.getParameter("r6_Order"));
	String r7_Uid               = formatString(request.getParameter("r7_Uid"));
	String r8_MP                = formatString(request.getParameter("r8_MP"));
	String r9_BType             = formatString(request.getParameter("r9_BType"));
	String rb_BankId            = formatString(request.getParameter("rb_BankId"));
	String ro_BankOrderId       = formatString(request.getParameter("ro_BankOrderId"));
	String rp_PayDate           = formatString(request.getParameter("rp_PayDate"));
	String rq_CardNo            = formatString(request.getParameter("rq_CardNo"));
	String ru_Trxtime           = formatString(request.getParameter("ru_Trxtime"));
	String rq_SourceFee         = formatString(request.getParameter("rq_SourceFee"));
	String rq_TargetFee         = formatString(request.getParameter("rq_TargetFee"));
	String hmac		            = formatString(request.getParameter("hmac"));
	
	String[] strArr	= {p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType };
	String area = r6_Order.substring(r6_Order.length()-2,r6_Order.length());
	boolean hmacIsCorrect =new  YeepayService(area).verifyCallbackHmac(strArr, hmac);
	System.out.println("�ص�����~~~~~~~~~~strArr~~~~~~~~~~~=" + strArr[0]+strArr[1]+strArr[2]+strArr[3]+strArr[4]+strArr[5]+strArr[6]+strArr[7]+strArr[8]+strArr[9]+strArr[10]);
	
	if(hmacIsCorrect) {
		
		try{
			
			conn = new DBConnect().getConnect();
			db   = new DbUtil(conn);
			InspectionService ins = new InspectionService(conn);
			
			Map map = db.getMap("select loginid,isyear from k_yeepay where uuid='"+r8_MP+"'");
			
			String loginid = map.get("loginid").toString();
			String year    = map.get("isyear").toString();
			
			String sql ="update k_yeepay set p3_amt=?,r1_code=?,r2_trxid=?,ro_bankorderid=?,rp_paydate=?,rq_cardno=?,p2_order=? where uuid=?";
			
			r3_Amt = r3_Amt == "0.01" ? "100.0" : "100.0";
			
			if(r9_BType.equals("2")) {
				
				db.update(sql, new Object[]{r3_Amt, r1_Code, r2_TrxId, ro_BankOrderId, rp_PayDate, rq_CardNo, r6_Order, r8_MP});
				
				// �޸������Ϣ�е��Ƿ�ɷѡ�
				// �����Ƿ����
				boolean rs = ins.isExistYearcheckReport(loginid, year);
				
				if(rs){ // ��������½ɷ����
					
					sql = "update k_yckcpano set auditreason=replace(replace(auditreason,'δ���ɻ��,',''),'δ���ɻ��','') where loginid=? and year =?";
					db.update(sql, new Object[]{loginid, year});
				
				}else{	// ���������Զ�ͨ�����
				
					ins.autoPass(loginid, year);
					
				}
				
			}else{
				
				db.update(sql, new Object[]{r3_Amt, r1_Code, r2_TrxId, ro_BankOrderId, rp_PayDate, rq_CardNo, r6_Order, r8_MP});
				
				// �޸������Ϣ�е��Ƿ�ɷѡ�
				// �����Ƿ����
				boolean rs = ins.isExistYearcheckReport(loginid, year);
				
				if(rs){ // ��������½ɷ����
					
					sql = "update k_yckcpano set auditreason=replace(replace(auditreason,'δ���ɻ��,',''),'δ���ɻ��','') where loginid=? and year =?";
					db.update(sql, new Object[]{loginid, year});
				
				}else{	// ���������Զ�ͨ�����
				
					ins.autoPass(loginid, year);
					
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstm);
			DbUtil.close(conn);
		}
			
		out.println("SUCCESS");
		System.out.println("�������ص�~~~~~~~~~~SUCCESS~~~~~~~~~~~");
		
	} else {
		out.println("Hmac Not Correction!");
		return;
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>֧���ɹ���Ϣ</title>
</head>
	<body>
		<br /> <br />
		<table width="70%" border="0" align="center" cellpadding="5" cellspacing="0" style="border:solid 1px #107929">
			<tr>
		  		<th align="center" height="30" colspan="3" bgcolor="#6BBE18">
					֧���ɹ���Ϣ
				</th>
		  	</tr>
			
			<tr >
				<td width="25%" align="left">&nbsp;�̻����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="45"  align="left"> <%=p1_MerId%> </td>
				
			</tr>

			<tr >
				<td width="25%" align="left">&nbsp;ҵ������</td>
				<td width="5%"  align="center"> : </td> 
				<td width="45"  align="left"> <%=r0_Cmd%> </td>
				
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;֧�����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r1_Code%> </td>
				
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;�ױ���ˮ��</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r2_TrxId%> </td>
				
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;֧�����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r3_Amt%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;���ױ���</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r4_Cur%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;��Ʒ����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r5_Pid%> </td>
			</tr> 

			<tr>
				<td width="25%" align="left">&nbsp;�̻�������</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r6_Order%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;�ױ���ԱID</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r7_Uid%> </td>
			</tr>

			<%-- <tr>
				<td width="25%" align="left">&nbsp;��չ��Ϣ</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r8_MP%> </td>
			</tr>


			<tr>
				<td width="25%" align="left">&nbsp;֪ͨ����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=r9_BType%> </td>
			</tr>  --%>

			<tr>
				<td width="25%" align="left">&nbsp;֧��ͨ������</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=rb_BankId%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;���ж�����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=ro_BankOrderId%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;֧���ɹ�ʱ��</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=rp_PayDate%> </td>
			</tr> 

			<tr>
				<td width="25%" align="left">&nbsp;�����г�ֵ����</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=rq_CardNo%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;֪ͨʱ��</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=ru_Trxtime%> </td>
			</tr>

			<tr>
				<td width="25%" align="left">&nbsp;�û�������</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=rq_SourceFee%> </td>
			</tr>


			<tr>
				<td width="25%" align="left">&nbsp;�̻�������</td>
				<td width="5%"  align="center"> : </td> 
				<td width="35%" align="left"> <%=rq_TargetFee%> </td>
			</tr> 

		</table>

	</body>
</html>
