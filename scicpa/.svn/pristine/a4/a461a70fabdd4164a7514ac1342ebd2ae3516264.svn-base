package cn.org.gdicpa.web.service.partyBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.partyBranch.model.PartyBranchTable;

/**
 * 党组织对象
 * @author yuanbo
 *
 */
public class PartyBranchService {

	private Connection conn = null;
	
	public PartyBranchService(Connection conn) {
		this.conn = conn;
	}
	
	//id,branchname,builddate,branchtype,branchtype2,affiliation,pid,pname,email,mobile,phone
	//address,fax,web,area,lastby,lastmodify,officecode,state,ctype,fzqk,mzsh,dnbz
	
	/**
	 * 得到 党组织对象
	 */
	public PartyBranchTable getPartyBranchTableById(String id){
		PartyBranchTable pt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from k_partybranch where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			pt = new PartyBranchTable();
			if(rs.next()){
				pt.setId(rs.getString("id"));
				pt.setBranchname(rs.getString("branchname"));
				pt.setBuilddate(rs.getString("builddate"));
				pt.setBranchtype(rs.getString("branchtype"));
				pt.setBranchtype2(rs.getString("branchtype2"));
				pt.setAffiliation(rs.getString("affiliation"));
				pt.setPid(rs.getString("pid"));
				pt.setPname(rs.getString("pname"));
				pt.setEmail(rs.getString("email"));
				pt.setMobile(rs.getString("mobile"));
				
				pt.setPhone(rs.getString("phone"));
				pt.setAddress(rs.getString("address"));
				pt.setFax(rs.getString("fax"));
				pt.setWeb(rs.getString("web"));
				pt.setArea(rs.getString("area"));
				pt.setLastby(rs.getString("lastby"));
				pt.setLastmodify(rs.getString("lastmodify"));
				pt.setOfficecode(rs.getString("officecode"));
				pt.setState(rs.getString("state"));
				pt.setCtype(rs.getString("ctype"));
				
				pt.setFzqk(rs.getString("fzqk"));
				pt.setMzsh(rs.getString("mzsh"));
				pt.setDnbz(rs.getString("dnbz"));
				pt.setPartyNum(rs.getString("partynum"));
				pt.setCpaNum(rs.getString("cpanum"));
				pt.setaPartyName(rs.getString("apartynum"));
				pt.setaPhone(rs.getString("aphone"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return pt;
	}
	
	/**
	 * 修改 党组织对象
	 * @param pt
	 */
	public void updatePartyBranchTable(PartyBranchTable pt){
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			sql = " update K_PartyBranch set branchname=?,builddate=?,branchtype=?,branchtype2=?,affiliation=?, "
				+ " pid=?,pname=?,email=?,mobile=?,phone=?,address=?,fax=?,web=?,area=?,lastby=?,lastmodify=?, "
				+ " officecode=?,state=?,ctype=?,fzqk=?,mzsh=?,dnbz=?,partynum=?,cpanum=?,apartyname=?,aphone=? " 
				+ " where id = ?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, pt.getBranchname());
			ps.setString(i++, pt.getBuilddate());
			ps.setString(i++, pt.getBranchtype());
			ps.setString(i++, pt.getBranchtype2());
			ps.setString(i++, pt.getAffiliation());
			
			ps.setString(i++, pt.getPid());
			ps.setString(i++, pt.getPname());
			ps.setString(i++, pt.getEmail());
			ps.setString(i++, pt.getMobile());
			ps.setString(i++, pt.getPhone());
			
			ps.setString(i++, pt.getAddress());
			ps.setString(i++, pt.getFax());
			ps.setString(i++, pt.getWeb());
			ps.setString(i++, pt.getArea());
			ps.setString(i++, pt.getLastby());
			
			ps.setString(i++, pt.getLastmodify());
			ps.setString(i++, pt.getOfficecode());
			ps.setString(i++, pt.getState());
			ps.setString(i++, pt.getCtype());
			ps.setString(i++, pt.getFzqk());
			
			ps.setString(i++, pt.getMzsh());
			ps.setString(i++, pt.getDnbz());
			
			ps.setString(i++, pt.getPartyNum());
			ps.setString(i++, pt.getCpaNum());
			ps.setString(i++, pt.getaPartyName());
			ps.setString(i++, pt.getaPhone());
			
			ps.setString(i++, pt.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(this.getClass()+"　　update  sql ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 修改 党组织对象 修改部分信息
	 * @param pt
	 */
	public void updatePartyBranchTablePart(PartyBranchTable pt){
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			sql = " update K_PartyBranch set affiliation=?,email=?,mobile=?,phone=?,address=?,fax=?,web=?,lastby=?,lastmodify=?, "
				+ " fzqk=?,mzsh=?,dnbz=? " 
				+ " where id = ?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, pt.getAffiliation());
			
			ps.setString(i++, pt.getEmail());
			ps.setString(i++, pt.getMobile());
			ps.setString(i++, pt.getPhone());
			ps.setString(i++, pt.getAddress());
			ps.setString(i++, pt.getFax());
			
			ps.setString(i++, pt.getWeb());
			ps.setString(i++, pt.getLastby());
			ps.setString(i++, pt.getLastmodify());
			ps.setString(i++, pt.getFzqk());
			ps.setString(i++, pt.getMzsh());
			
			ps.setString(i++, pt.getDnbz());
			
			ps.setString(i++, pt.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(this.getClass()+"　　update  sql ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
	
	//===========================================================================================================
	//重写党建
	//===========================================================================================================
	/**
	 * 得到党组织
	 */
	public Map getBranch(String officeCode) throws Exception {
		
		System.out.println("PartyBranchService-->officeCode:" + officeCode);
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Map map = new HashMap();
			String sql = "select b.* from K_PartyBranch a ,K_PartyBranch b where a.officecode = ? and a.pid = b.id";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, officeCode);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = null;
			if(rs.next()){
				String type = rs.getString("branchtype2");//党支部的类型：如果是联合支部就取上级，否则取本级
				if(!"联合党支部".equals(type)){
					//取本级
					DbUtil.close(rs);
					DbUtil.close(ps);
					sql = "select * from K_PartyBranch a where a.officecode = ? ";
					ps = conn.prepareStatement(sql);
			        ps.setString(1, officeCode);
					rs = ps.executeQuery();
					RSMD = rs.getMetaData();
					if(rs.next()){
						for (int i = 1; i <= RSMD.getColumnCount(); i++) {
							map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
						}
					}
				}else{
					RSMD = rs.getMetaData();
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
					}
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 通过ID得到党组织
	 */
	public Map getBranchById(String id) throws Exception {
		
		System.out.println("PartyBranchService-->id:" + id);
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Map map = new HashMap();
			String sql = "select * from K_PartyBranch a where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = null;
			if(rs.next()){
				RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	 
	public void get(String branchID,Map map) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ResultSetMetaData RSMD = null;
			
			String [] sqls = new String[]{
					"select apartyname,partynum,cpanum,aphone from k_partyBranch where id=?",
					//统计支部成员数量
					//"Select Count(*) as PartyNum From K_PartyPost where BranchID=? ",
					//统计支部CPA成员数量
					//"select Count(*) as CPANum From K_Party a left join K_PartyPost b on a.ID=b.PID Where b.BranchID=? and a.General in (Select CPANO From K_micfo) and a.General<>'' ",
					//统计支部书记信息
					//"Select a.PartyName as aPartyName,a.Phone + ' '+ a.Mobile as  aPhone,Case When c.CPANO is null then '否' else '是' end as aCPA From K_Party a left join K_PartyPost b on a.ID=b.PID left join K_micfo c on a.General=c.CPANO Where b.BranchID= ? and b.PartyPost like '%书记%' and b.PartyPost not like '%副书记%' ",
					//统计支部党务工作者信息
					"Select a.PartyName as bPartyName,a.Phone + ' '+ a.Mobile as bPhone,'有' as isWorker From K_Party a left join K_PartyPost b on a.ID=b.PID Where b.BranchID=?  and b.PartyPost like '%党务工作者%' "
			};
			
			for(int j=0; j<sqls.length; j++){
				ps = conn.prepareStatement(sqls[j]);
				
				System.out.println("传参ID值："+ branchID);
				
				ps.setString(1, branchID);
				rs = ps.executeQuery();
				RSMD = rs.getMetaData();	
	    		if(rs.next()){
	    			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
	    				map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getString(RSMD.getColumnLabel(i)));
	    				System.out.println(RSMD.getColumnLabel(i).toLowerCase()+"  <-------||------->  "+ rs.getString(RSMD.getColumnLabel(i)));
					}
	    		}
	    		DbUtil.close(rs);
				DbUtil.close(ps);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 查询记录
	 * @param table : 表名 
	 * @param field : 主键字段名 
	 * @param value : 主键的值
	 * @return Map ：K=表的字段名(小写),V=表单的值
	 */
	public Map get(String table,String field,String value) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			Map map = new HashMap();
			String sql = "select * from "+table+" where "+field+"=? ";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, value);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	/**
	 * 新增记录
	 * @param table : 表名 
	 * @param field : 自动主键;新增时去掉自动主键,没有自动主键可以为空
	 * @param map : 新增记录,K=表的字段名(小写),V=表单的值
	 */
	public void add(String table,String field,Map map) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			ASFuntion CHF = new ASFuntion();
			String sql = "",sql1 = "",sql2 = "";
			sql = "select * from "+table+" where 1=2 " ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
					){
					sql1 += ","+RSMD.getColumnLabel(i).toLowerCase()+"";
					sql2 += ",?";
				}
			}

			sql = "insert into "+table+" ("+sql1.substring(1)+") values ("+sql2.substring(1)+") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
				){
					String string = (String)map.get(RSMD.getColumnLabel(i).toLowerCase());
					ps.setString(ii, (string == null) ? "" : string );
					ii++;
				}
			}
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 修改记录
	 * @param table : 表名 
	 * @param field : 主键字段名 
	 * @param map : 修改记录,K=表的字段名(小写),V=表单的值
	 */
	public void update(String table,String field,Map map) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			ASFuntion CHF = new ASFuntion();
			String sql = "",sql1 = "";
			sql = "select * from "+table+" where 1=2 " ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
					){
					sql1 += ","+RSMD.getColumnLabel(i).toLowerCase()+" = ? ";
				}
			}
			
			sql = "update "+table+" set " + sql1.substring(1) + " where "+field+" = ? ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
				){
					String string = (String)map.get(RSMD.getColumnLabel(i).toLowerCase());
					ps.setString(ii, (string == null) ? "" : string );
					ii++;
				}
			}
			ps.setString(ii, (String)map.get(CHF.showNull(field).toLowerCase()) );
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}	
	}
	
	/**
	 * 删除记录
	 * @param table : 表名 
	 * @param field : 主键字段名 
	 * @param value : 主键的值
	 */
	public void del(String table,String field,String value) throws Exception{
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM "+table+" WHERE "+field+" = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, value);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
}
