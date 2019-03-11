package cn.org.gdicpa.web.service.projectFill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.projectFill.model.ProjectFill;

public class ProjectFillService {
	private Connection conn;
	public ProjectFillService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public ProjectFill getProjectFillById(String id) throws Exception{
		ProjectFill pf = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,companyId,companyName,projectName,fillUserId,fillUserName,fillTime,propertys "
				+ " from k_projectFill "
				+ " where id = ?";
			
			ps = conn.prepareStatement(sql); 
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			pf = new ProjectFill();
			if(rs.next()){
				pf.setId(rs.getString("id"));
				pf.setCompanyId(rs.getString("companyId"));
				pf.setCompanyName(rs.getString("companyName"));
				pf.setProjectName(rs.getString("projectName"));
				pf.setFillUserId(rs.getString("fillUserId"));
				pf.setFillUserName(rs.getString("fillUserName"));
				pf.setFillTime(rs.getString("fillTime"));
				pf.setPropertys(rs.getString("propertys"));
			}
			return pf;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return pf;
	}
	
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public Map getSupervisionSub(String id) throws Exception{
		Map map = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,mainid,projectid,s.loginid,lstuserid," 
				+ " lstusername,projectname,qmzs1,qmzs2,qmzs3," 
				+ " qmzs4,qmzs5,qmzs6,fillby,filltime,c.loginname as companyname,m.loginname as fillPerson " 
				+ " from k_SuperviseSub s left join k_company c on s.loginid = c.loginid "
				+ " left join k_micfo m on s.fillBy = m.loginid "
				+ " where id = ?";
			
			ps = conn.prepareStatement(sql); 
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			map = new HashMap();
			if(rs.next()){
				map.put("id",rs.getString("id"));
				map.put("mainid",rs.getString("mainid"));
				map.put("projectid",rs.getString("projectid"));
				map.put("loginid",rs.getString("loginid"));
				map.put("lstuserid",rs.getString("lstuserid"));
				
				map.put("lstusername",rs.getString("lstusername"));
				map.put("projectname",rs.getString("projectname"));
				map.put("qmzs1",rs.getString("qmzs1"));
				map.put("qmzs2",rs.getString("qmzs2"));
				map.put("qmzs3",rs.getString("qmzs3"));
				
				map.put("qmzs4",rs.getString("qmzs4"));
				map.put("qmzs5",rs.getString("qmzs5"));
				map.put("qmzs6",rs.getString("qmzs6"));
				map.put("fillby",rs.getString("fillby"));
				map.put("filltime",rs.getString("filltime"));
				
				map.put("companyname",rs.getString("companyname"));
				map.put("fillPerson",rs.getString("fillPerson"));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return map;
	}
	
	
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public Map getContentInfo(String bbPerson,String bgwh) throws Exception{
		Map map = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select guid,qmzs1,qmzs2,qmzs3,qmzs4,qmzs5,qmzs6,bbbh from bb_content1 "
				+ " where bbPerson = ? and bgwh = ? ";
			
			ps = conn.prepareStatement(sql); 
			
			ps.setString(1, bbPerson);
			ps.setString(2, bgwh);
			rs = ps.executeQuery();
			map = new HashMap();
			if(rs.next()){
				map.put("guid",rs.getString("guid"));
				map.put("qmzs1",rs.getString("qmzs1"));
				map.put("qmzs2",rs.getString("qmzs2"));
				map.put("qmzs3",rs.getString("qmzs3"));
				map.put("qmzs4",rs.getString("qmzs4"));
				
				map.put("qmzs5",rs.getString("qmzs5"));
				map.put("qmzs6",rs.getString("qmzs6"));
				map.put("bbbh",rs.getString("bbbh"));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return map;
	}
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public Map getContentInfo2(String guid) throws Exception{
		Map map = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select guid,qmzs1,qmzs2,qmzs3,qmzs4,qmzs5,qmzs6,bbbh from bb_content1 "
				+ " where guid = ? ";
			
			ps = conn.prepareStatement(sql); 
			
			ps.setString(1, guid);
			rs = ps.executeQuery();
			map = new HashMap();
			if(rs.next()){
				map.put("guid",rs.getString("guid"));
				map.put("qmzs1",rs.getString("qmzs1"));
				map.put("qmzs2",rs.getString("qmzs2"));
				map.put("qmzs3",rs.getString("qmzs3"));
				map.put("qmzs4",rs.getString("qmzs4"));
				
				map.put("qmzs5",rs.getString("qmzs5"));
				map.put("qmzs6",rs.getString("qmzs6"));
				map.put("bbbh",rs.getString("bbbh"));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return map;
	}
	

	/**
	 * 根据属性得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public ProjectFill getProjectFillByField(String fieldName,String fieldValue) throws Exception{
		ProjectFill pf = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,companyId,companyName,projectName,fillUserId,fillUserName,fillTime,propertys "
				+ " from k_projectFill "
				+ " where "+fieldName+" = '"+fieldValue+"'";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			pf = new ProjectFill();
			if(rs.next()){
				pf.setId(rs.getString("id"));
				pf.setCompanyId(rs.getString("companyId"));
				pf.setCompanyName(rs.getString("companyName"));
				pf.setProjectName(rs.getString("projectName"));
				pf.setFillUserId(rs.getString("fillUserId"));
				pf.setFillUserName(rs.getString("fillUserName"));
				pf.setFillTime(rs.getString("fillTime"));
				pf.setPropertys(rs.getString("propertys"));
			}
			return pf;
		} catch (Exception e) {
			System.out.println("表 k_projectFill 不存在"+fieldName+"字段");
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return pf;
	}
	
	
	/**
	 * 根据sql 得到 多个对象
	 * @param sql
	 * @return
	 */
	public List getListBySql(String sql) {

		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql) ;
			rs = ps.executeQuery() ;
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i<=RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(),rs.getString(RSMD.getColumnName(i).toLowerCase()));
				}
				list.add(map);
			}
			return list ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	/**
	 * 根据sql 得到 单个对象
	 * @param sql
	 * @return
	 */
	public Map getMapBySql(String sql) {

		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			ps = conn.prepareStatement(sql) ;
			rs = ps.executeQuery() ;
			ResultSetMetaData RSMD = rs.getMetaData();
			Map map = new HashMap();
			if(rs.next()){
				for (int i = 1; i<=RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(),rs.getString(RSMD.getColumnName(i).toLowerCase()));
				}
			}
			return map ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	
	
	/**
	 * 添加 对象
	 * @param at
	 * @return
	 * @throws Exception 
	 */
	public void addProjectFill(ProjectFill pf) throws Exception{
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " insert into k_projectFill ( "
				+ " id,companyId,companyName,projectName,fillUserId,fillUserName,fillTime,propertys) " 
				+ " values(?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++, pf.getId());
			ps.setString(i++, pf.getCompanyId());
			ps.setString(i++, pf.getCompanyName());
			ps.setString(i++, pf.getProjectName());
			ps.setString(i++, pf.getFillUserId());
			
			ps.setString(i++, pf.getFillUserName());
			ps.setString(i++, pf.getFillTime());
			ps.setString(i++, pf.getPropertys());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	

	/**
	 * 添加 对象
	 * @param at
	 * @return
	 * @throws Exception 
	 */
	public void addProjectFill2(Map map) throws Exception{
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " insert into k_SuperviseSub ( "
				+ " id,mainid,projectid,loginid,lstuserid," 
				+ " lstusername,projectname,qmzs1,qmzs2,qmzs3," 
				+ " qmzs4,qmzs5,qmzs6,initflag,timeflag," 
				+ " fillby,filltime) " 
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++, (String)map.get("id"));
			ps.setString(i++, (String)map.get("mainid"));
			ps.setString(i++, (String)map.get("projectid"));
			ps.setString(i++, (String)map.get("loginid"));
			ps.setString(i++, (String)map.get("lstuserid"));
			
			ps.setString(i++, (String)map.get("lstusername"));
			ps.setString(i++, (String)map.get("projectname"));
			ps.setString(i++, (String)map.get("qmzs1"));
			ps.setString(i++, (String)map.get("qmzs2"));
			ps.setString(i++, (String)map.get("qmzs3"));
			
			ps.setString(i++, (String)map.get("qmzs4"));
			ps.setString(i++, (String)map.get("qmzs5"));
			ps.setString(i++, (String)map.get("qmzs6"));
			ps.setString(i++, (String)map.get("initflag"));
			ps.setString(i++, (String)map.get("timeflag"));
			
			ps.setString(i++, (String)map.get("fillby"));
			ps.setString(i++, (String)map.get("filltime"));
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 修改 对象
	 * @param at
	 * @return
	 * @throws Exception 
	 */
	public void updateProjectFill(ProjectFill pf) throws Exception{
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " update k_projectFill  "
				+ " set companyId=?,companyName=?,projectName=?,fillUserId=?,fillUserName=?,fillTime=?,propertys=? " 
				+ " where id = ? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++, pf.getCompanyId());
			ps.setString(i++, pf.getCompanyName());
			ps.setString(i++, pf.getProjectName());
			ps.setString(i++, pf.getFillUserId());
			ps.setString(i++, pf.getFillUserName());
			
			ps.setString(i++, pf.getFillTime());
			ps.setString(i++, pf.getPropertys());
			ps.setString(i++, pf.getId());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 修改 对象
	 * @param at
	 * @return
	 * @throws Exception 
	 */
	public void updateProjectFill2(Map map) throws Exception{
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " update k_SuperviseSub "
				+ " set mainid=?,projectid=?,loginid=?,lstuserid=?,lstusername=?, " 
				+ " projectname=?,qmzs1=?,qmzs2=?,qmzs3=?,qmzs4=?, "   
				+ " qmzs5=?,qmzs6=?,initflag=?,timeflag=?,fillby=?, "
				+ " filltime=? "
				+ " where id = ? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++, (String)map.get("mainid"));
			ps.setString(i++, (String)map.get("projectid"));
			ps.setString(i++, (String)map.get("loginid"));
			ps.setString(i++, (String)map.get("lstuserid"));
			ps.setString(i++, (String)map.get("lstusername"));
			ps.setString(i++, (String)map.get("projectname"));
			
			ps.setString(i++, (String)map.get("qmzs1"));
			ps.setString(i++, (String)map.get("qmzs2"));
			ps.setString(i++, (String)map.get("qmzs3"));
			ps.setString(i++, (String)map.get("qmzs4"));
			ps.setString(i++, (String)map.get("qmzs5"));
			
			ps.setString(i++, (String)map.get("qmzs6"));
			ps.setString(i++, (String)map.get("initflag"));
			ps.setString(i++, (String)map.get("timeflag"));
			ps.setString(i++, (String)map.get("fillby"));
			ps.setString(i++, (String)map.get("filltime"));
			
			ps.setString(i++, (String)map.get("id"));
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteProjectFillById(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " delete from k_projectFill where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void delete2(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " delete from k_SuperviseSub where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
}
