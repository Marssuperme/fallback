package cn.org.gdicpa.web.service.planManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.planManage.model.PlanManage;

public class PlanManageService {
	private Connection conn;
	public PlanManageService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public PlanManage getPlanManageById(String id) throws Exception{
		PlanManage pm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,supid,begindate,enddate,userid, "
				+ " companyid,projectid,comevaluation,proevaluation,progresscnt, "
				+ " changedate,initflag,timeflag "
				+ " from K_SupProgress "
				+ " where id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			pm = new PlanManage();
			if(rs.next()){
				pm.setId(rs.getString("id"));
				pm.setSupID(rs.getString("supID"));
				pm.setBeginDate(rs.getString("beginDate"));
				pm.setEndDate(rs.getString("endDate"));
				pm.setUserID(rs.getString("userID"));
				
				pm.setCompanyID(rs.getString("companyID"));
				pm.setProjectID(rs.getString("projectID"));
				pm.setComEvaluation(rs.getString("comEvaluation"));
				pm.setProEvaluation(rs.getString("proEvaluation"));
				pm.setProgressCnt(rs.getString("progressCnt"));
				
				pm.setChangeDate(rs.getString("changeDate"));
				pm.setInitFlag(rs.getString("initFlag"));
				pm.setTimeFlag(rs.getString("timeFlag"));
			}
			return pm;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return pm;
	}
	
	

	/**
	 * 根据属性得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public PlanManage getProjectFillByField(String fieldName,String fieldValue) throws Exception{
		PlanManage pm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,supid,begindate,enddate,userid, "
				+ " companyid,projectid,comevaluation,proevaluation,progresscnt, "
				+ " changedate,initflag,timeflag "
				+ " from k_supprogress "
				+ " where "+fieldName+" = '"+fieldValue+"'";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			pm = new PlanManage();
			if(rs.next()){
				pm.setId(rs.getString("id"));
				pm.setSupID(rs.getString("supID"));
				pm.setBeginDate(rs.getString("beginDate"));
				pm.setEndDate(rs.getString("endDate"));
				pm.setUserID(rs.getString("userID"));
				
				pm.setCompanyID(rs.getString("companyID"));
				pm.setProjectID(rs.getString("projectID"));
				pm.setComEvaluation(rs.getString("comEvaluation"));
				pm.setProEvaluation(rs.getString("proEvaluation"));
				pm.setProgressCnt(rs.getString("progressCnt"));
				
				pm.setChangeDate(rs.getString("changeDate"));
				pm.setInitFlag(rs.getString("initFlag"));
				pm.setTimeFlag(rs.getString("timeFlag"));
			}
			return pm;
		} catch (Exception e) {
			System.out.println("表 k_projectFill 不存在"+fieldName+"字段");
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return pm;
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
	public void addPlanManage(PlanManage pm) throws Exception{
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " insert into k_supprogress ( "
				+ " id,supid,begindate,enddate,userid, "
				+ " companyid,projectid,comevaluation,proevaluation,progresscnt, "
				+ " changedate,initflag,timeflag) " 
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++, pm.getId());
			ps.setString(i++, pm.getSupID());
			ps.setString(i++, pm.getBeginDate());
			ps.setString(i++, pm.getEndDate());
			ps.setString(i++, pm.getUserID());
			
			ps.setString(i++, pm.getCompanyID());
			ps.setString(i++, pm.getProjectID());
			ps.setString(i++, pm.getComEvaluation());
			ps.setString(i++, pm.getProEvaluation());
			ps.setString(i++, pm.getProgressCnt());

			ps.setString(i++, pm.getChangeDate());
			ps.setString(i++, pm.getInitFlag());
			ps.setString(i++, pm.getTimeFlag());
			
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
	public void updatePlanManage(PlanManage pm) throws Exception{
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " update k_supprogress "
				+ " set supid=?,begindate=?,enddate=?,userid=?,companyid=?, "
				+ " projectid=?,comevaluation=?,proevaluation=?,progresscnt=?,changedate=?, "
				+ " initflag=?,timeflag=? " 
				+ " where id = ? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			

			ps.setString(i++, pm.getSupID());
			ps.setString(i++, pm.getBeginDate());
			ps.setString(i++, pm.getEndDate());
			ps.setString(i++, pm.getUserID());
			
			ps.setString(i++, pm.getCompanyID());
			ps.setString(i++, pm.getProjectID());
			ps.setString(i++, pm.getComEvaluation());
			ps.setString(i++, pm.getProEvaluation());
			ps.setString(i++, pm.getProgressCnt());

			ps.setString(i++, pm.getChangeDate());
			ps.setString(i++, pm.getInitFlag());
			ps.setString(i++, pm.getTimeFlag());
			
			
			ps.setString(i++, pm.getId());
			
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
	public void deletePlanManageById(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " delete from k_supprogress where id = ? ";
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
