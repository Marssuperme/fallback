package cn.org.gdicpa.web.service.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.ticket.model.TicketCountTable;
import cn.org.gdicpa.web.service.ticket.model.TicketTable;

public class TicketService {
	private Connection conn = null;
	public TicketService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 得到投票记录
	 * @return
	 * @throws Exception
	 */
	public List<TicketTable> getTicket() throws Exception{
		System.out.println(this.getClass()+"       >>>>>>>>getTicket() ....");
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TicketTable> list = new ArrayList<TicketTable>();
		String total = "";// 总的标题数
		String countTitle = "";// 对应标题总数
		String percent = "";// 百分比
		String div = "";
		try {
			String sql = " select *,round((ct+0.0)*100 / total,2)  as percents"
					   + " from(select tctitle,count(tctitle) as ct"
					   + " from k_ticket a group by tctitle"
					   + " ) a ,(select count(*) as total from k_ticket) b"
					   + " where 1=1";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				TicketTable tc = new TicketTable();
				tc.setTctitle(rs.getString("tctitle"));		// 标题            #ececec
				countTitle=rs.getString("ct");				// 对应标题总数     #0077aa
				total = rs.getString("total");              // 总的标题数
				percent = rs.getString("percents").substring(0,5);  // 百分比
				tc.setTctruename(countTitle);	
				
				div = "<table> <tr><td><div align='left' style='width: "+Integer.parseInt(total)*10+";height:2px;border:1px #808080 solid;background: #EDEDED;z-index: 1;'>"
				    + "<div align='left' style='width: "+Integer.parseInt(countTitle)*10+";height:100%;background-image:url(../images/process.png);z-index: 2>'"
				    + "<div>"
				    + "</div></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" 
				    + "<td>"+percent+"%</td></tr></table>";
				
				
				tc.setTcproperty(div);  // 比例图层
				
				list.add(tc);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	/**
	 * 投票方法
	 * @param tid
	 * @param choose
	 * @param userid
	 * @return  结果
	 * @throws Exception
	 */
	public String tpTicket(String tid,String choose,String userid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String strResult="";
		try {
			
			String strReduplicate="否";
			
			//取出属性
			sql="select * from k_ticket where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tid);
			rs = ps.executeQuery();
			if(rs.next()){
				strReduplicate=rs.getString("reduplicate");
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			//看已经投票次数
			sql="select count(*) as hj from k_ticketResult where tid=? and iuser=?";
			ps = conn.prepareStatement(sql);
			int iHaspost=0;
			ps.setString(1, tid);
			ps.setString(2, userid);
			rs = ps.executeQuery();
			if(rs.next()){
				iHaspost=rs.getInt("hj");
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			//如果允许重复投票或还没有投票，就插入新纪录
			// 票数加1
			if ("是".equals(strReduplicate) || ("否".equals(strReduplicate)&& iHaspost ==0 )){
				sql = "INSERT INTO k_ticketResult (id,tid, choice, iuser, idate) VALUES (?,?,?,?,?)";
				int i=1;
				ps = conn.prepareStatement(sql);
				ps.setString(i++,UUID.randomUUID().toString());
				ps.setString(i++,tid);
				ps.setString(i++,choose);
				ps.setString(i++,userid);
				ps.setString(i++,new ASFuntion().getDateAndTime1());
				ps.execute();
				
				strResult="投票成功！";
			}else{
				strResult="您已经投过票了！";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			strResult="保存遇到错误:"+e.getMessage();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return strResult;
				
	}
	
	/**
	 * 查看投票结果
	 * @param tid
	 * @return
	 * @throws Exception 
	 */
	public TicketCountTable viewTicketCountResult(String tid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		TicketCountTable tct = null;
		String sql = "";
		try {
			sql = "SELECT count(*) FROM k_ticketResult where tid=? and choice=?";
			ps = conn.prepareStatement(sql);
			
			int hj=0;
			int[] op=new int[4];
			for (int i=0;i<4;i++){
				
				ps.setString(1, tid);
				ps.setInt(2, i+1);
				rs = ps.executeQuery();
				
				if (rs.next()){
					op[i]=rs.getInt(1);
					hj+=op[i];
				}
				
				DbUtil.close(rs);
			}
			
			
			tct = new TicketCountTable();
			tct.setId(tid);
			tct.setTid(tid);
			
			if (hj>0){
				java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");
				
				tct.setTcchooseonecount(op[0]);
				tct.setPercente1(df.format(op[0]*100/Float.valueOf(hj)));
				tct.setTcchoosetwocount(op[1]);
				tct.setPercente2(df.format(op[1]*100/Float.valueOf(hj)));
				tct.setTcchoosethreecount(op[2]);
				tct.setPercente3(df.format(op[2]*100/Float.valueOf(hj)));
				tct.setTcchoosefourcount(op[3]);
				tct.setPercente4(df.format(op[3]*100/Float.valueOf(hj)));
			}else{
				tct.setTcchooseonecount(0);
				tct.setPercente1("0.00");
				tct.setTcchoosetwocount(0);
				tct.setPercente2("0.00");
				tct.setTcchoosethreecount(0);
				tct.setPercente3("0.00");
				tct.setTcchoosefourcount(0);
				tct.setPercente4("0.00");
			}
			
			tct.setTotal(hj);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return tct;
	}
	
	/**
	 * 投票设置表
	 * @param tid
	 * @return
	 * @throws Exception 
	 */
	public TicketTable viewTicketResult(String tid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		TicketTable tt = null;
		String sql = "";
		try {
			
			for (int i=1;i<=4;i++){
				sql = "select id,tctitle,tccontent,tcchooseone,tcchoosetwo,tcchoosethree,tcchoosefour from k_ticket where id = ?";
			}
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, tid);
			rs = ps.executeQuery();
			if(rs.next()){
				tt = new TicketTable();
				tt.setId(tid);
				tt.setTctitle(rs.getString(2));
				tt.setTccontent(rs.getString(3));
				tt.setTcchooseone(rs.getString(4));
				tt.setTcchoosetwo(rs.getString(5));
				tt.setTcchoosethree(rs.getString(6));
				tt.setTcchoosefour(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return tt;
	}
	
	/**
	 * 得到投票对象
	 * @param tid
	 * @return
	 * @throws Exception
	 */
	public TicketTable getTicket(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		TicketTable tt = null;
		String sql = "";
		try {
			sql = " select id,tctitle,tccontent,tcchooseone,tcchoosetwo,tcchoosethree,tcchoosefour,tcenddate,anonymous,reduplicate,idate"
				+ " from k_ticket where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				int i = 1;
				tt = new TicketTable();
				tt.setId(rs.getString(i++));
				tt.setTctitle(rs.getString(i++));
				tt.setTccontent(rs.getString(i++));
				tt.setTcchooseone(rs.getString(i++));
				tt.setTcchoosetwo(rs.getString(i++));
				tt.setTcchoosethree(rs.getString(i++));
				tt.setTcchoosefour(rs.getString(i++));
				tt.setTcenddate(rs.getString(i++));
				tt.setAnonymous(rs.getString(i++));
				tt.setReduplicate(rs.getString(i++));
				tt.setIdate(rs.getString(i++));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return tt;
	}
	
	/**
	 * 得到对应投票的截止日期
	 * @param id
	 * @return
	 */
	public String getTicketEndDate(String id){
		PreparedStatement ps = null;
		ResultSet  rs = null;
		String sql = null;
		String enddate = null;
		try {
			sql = "select tcenddate from k_ticket where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				enddate = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return enddate;
	}
	
	/**
	 * 得到对应投票是否允许匿名
	 * @param id
	 * @return
	 */
	public String getTicketAnonymous(String id){
		PreparedStatement ps = null;
		ResultSet  rs = null;
		String sql = null;
		String anonymous = null;
		try {
			sql = "select anonymous from k_ticket where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				anonymous = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return anonymous;
	}
	
	/**
	 * 得到对应投票是否允许重复投票
	 * @param id
	 * @return
	 */
	public String getTicketReduplicate(String id){
		PreparedStatement ps = null;
		ResultSet  rs = null;
		String sql = null;
		String reduplicate = null;
		try {
			sql = "select reduplicate from k_ticket where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				reduplicate = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return reduplicate;
	}
	
	/**
	 * 得到对应投票次数
	 * @param id
	 * @return
	 */
	public int getTicketCount(String id,String userid){
		PreparedStatement ps = null;
		ResultSet  rs = null;
		String sql = null;
		int iHaspost=0;
		try {
			//看已经投票次数
			sql="select count(*) as hj from k_ticketResult where tid=? and iuser=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, userid);
			rs = ps.executeQuery();
			if(rs.next()){
				iHaspost=rs.getInt("hj");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return iHaspost;
	}
}
