package cn.org.gdicpa.web.service.bbsj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbsj.model.SjTable;

public class SjService {
	private Connection conn;
	public SjService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public SjTable getSjTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		SjTable st = new SjTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,sjlx,zxsjmc,bgyt,sjbgnd,hbhs,kgssgss,gpdm,sflxsj,qykjsswsmc,"
				+ " sjbgyjlx,notblyjlx,blyjlx,xssr,yysr,zcze,fzze,lrze,ylsde,jlr,"
				+ " ylsdse,xmzrs,wqgzts,cyry,sjns,zxsjje,sftzje,zczetzh,xssrtzh,yysrtzh," 
				+ " zxsjjetzh,syzqy,fzzetzh,syzqytzh,jlrtzh,xywtz,zctz,zctj,lrtz,lrtj,sstz,sstj,fzgyzclsje,xmjzje "
				+ " from bb_sjb where guid = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				st.setGuid(rs.getString(i++));
				st.setSjlx(rs.getString(i++));
				st.setZxsjmc(rs.getString(i++));
				st.setBgyt(rs.getString(i++));
				st.setSjbgnd(rs.getString(i++));
				st.setHbhs(rs.getString(i++));
				st.setKgssgss(rs.getString(i++));
				st.setGpdm(rs.getString(i++));
				st.setSflxsj(rs.getString(i++));
				st.setQykjsswsmc(rs.getString(i++));
				
				st.setSjbgyjlx(rs.getString(i++));
				st.setNotblyjlx(rs.getString(i++));
				st.setBlyjlx(rs.getString(i++));
				st.setXssr(rs.getString(i++));
				st.setYysr(rs.getString(i++));
				st.setZcze(rs.getString(i++));
				st.setFzze(rs.getString(i++));
				st.setLrze(rs.getString(i++));
				st.setYlsde(rs.getString(i++));
				st.setJlr(rs.getString(i++));
				
				st.setYlsdse(rs.getString(i++));
				st.setXmzrs(rs.getString(i++));
				st.setWqgzts(rs.getString(i++));
				st.setCyry(rs.getString(i++));
				st.setSjns(rs.getString(i++));
				st.setZxsjje(rs.getString(i++));
				st.setSftzje(rs.getString(i++));
				st.setZczetzh(rs.getString(i++));
				st.setXssrtzh(rs.getString(i++));
				st.setYysrtzh(rs.getString(i++));
				
				st.setZxsjjetzh(rs.getString(i++));
				//增加字段字syzqy,fzzetzh,syzqytzh,jlrtzh
				st.setSyzqy(rs.getString(i++));
				st.setFzzetzh(rs.getString(i++));
				st.setSyzqytzh(rs.getString(i++));
				st.setJlrtzh(rs.getString(i++));
				
				st.setXywtz(rs.getString(i++));
				st.setZctz(rs.getString(i++));
				st.setZctj(rs.getString(i++));
				st.setLrtz(rs.getString(i++));
				st.setLrtj(rs.getString(i++));
				st.setSstz(rs.getString(i++));
				st.setSstj(rs.getString(i++));
				st.setFzgyzclsje(rs.getString(i++));
				st.setXmjzje(rs.getString(i++));
			}
			return st;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	/**
	 * 添加对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean addSjTable(SjTable st) throws Exception{
		
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_sjb (guid,sjlx,zxsjmc,bgyt,sjbgnd,hbhs,kgssgss,gpdm,sflxsj,qykjsswsmc, "
				+ " sjbgyjlx,notblyjlx,blyjlx,xssr,yysr,zcze,fzze,lrze,ylsde,jlr, "
				+ " ylsdse,xmzrs,wqgzts,cyry,sjns,zxsjje,sftzje,zczetzh,xssrtzh,yysrtzh," 
				+ " zxsjjetzh,syzqy,fzzetzh,syzqytzh,jlrtzh,xywtz,zctz,zctj,lrtz,lrtj,sstz,sstj,fzgyzclsje,xmjzje) "
				+ " values(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, st.getGuid());
			ps.setString(i++, st.getSjlx());
			ps.setString(i++, st.getZxsjmc());
			ps.setString(i++, st.getBgyt());
			ps.setString(i++, st.getSjbgnd());
			ps.setString(i++, st.getHbhs());
			ps.setString(i++, st.getKgssgss());
			ps.setString(i++, st.getGpdm());
			ps.setString(i++, st.getSflxsj());
			ps.setString(i++, st.getQykjsswsmc());
			
			ps.setString(i++, st.getSjbgyjlx());
			ps.setString(i++, st.getNotblyjlx());
			ps.setString(i++, st.getBlyjlx());
			ps.setString(i++, st.getXssr());
			ps.setString(i++, st.getYysr());
			ps.setString(i++, st.getZcze());
			ps.setString(i++, st.getFzze());
			ps.setString(i++, st.getLrze());
			ps.setString(i++, st.getYlsde());
			ps.setString(i++, st.getJlr());
			
			ps.setString(i++, st.getYlsdse());
			ps.setString(i++, st.getXmzrs());
			ps.setString(i++, st.getWqgzts());
			ps.setString(i++, st.getCyry());
			ps.setString(i++, st.getSjns());
			ps.setString(i++, st.getZxsjje());
			ps.setString(i++, st.getSftzje());
			ps.setString(i++, st.getZczetzh());
			ps.setString(i++, st.getXssrtzh());
			ps.setString(i++, st.getYysrtzh());
			
			ps.setString(i++, st.getZxsjjetzh());
			
			//增加字段字syzqy,fzzetzh,syzqytzh,jlrtzh
			ps.setString(i++, st.getSyzqy());
			ps.setString(i++, st.getFzzetzh());
			ps.setString(i++, st.getSyzqytzh());
			ps.setString(i++, st.getJlrtzh());
			
			ps.setString(i++, st.getXywtz());
			ps.setString(i++, st.getZctz());
			ps.setString(i++, st.getZctj());
			ps.setString(i++, st.getLrtz());
			ps.setString(i++, st.getLrtj());
			ps.setString(i++, st.getSstz());
			ps.setString(i++, st.getSstj());
			ps.setString(i++, st.getFzgyzclsje());
			ps.setString(i++, st.getXmjzje());
			
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	/**
	 * 修改对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean updateSjTable(SjTable st) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update BB_SJB set sjlx=?,zxsjmc=?,bgyt=?,sjbgnd=?,hbhs=?,kgssgss=?,gpdm=?,sflxsj=?,qykjsswsmc=?,sjbgyjlx=?,"
				+ " notblyjlx=?,blyjlx=?,xssr=?,yysr=?,zcze=?,fzze=?,lrze=?,ylsde=?,jlr=?,ylsdse=?, "
				+ " xmzrs=?,wqgzts=?,cyry=?,sjns=?,zxsjje=?,sftzje=?,zczetzh=?,xssrtzh=?,yysrtzh=?,zxsjjetzh=?,syzqy=?,fzzetzh=?,syzqytzh=?,jlrtzh=?,"
				+ " xywtz=?,zctz=?,zctj=?,lrtz=?,lrtj=?,sstz=?,sstj=?,fzgyzclsje=?,xmjzje=? " 
				+ " where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, st.getSjlx());
			ps.setString(i++, st.getZxsjmc());
			ps.setString(i++, st.getBgyt());
			ps.setString(i++, st.getSjbgnd());
			ps.setString(i++, st.getHbhs());
			ps.setString(i++, st.getKgssgss());
			ps.setString(i++, st.getGpdm());
			ps.setString(i++, st.getSflxsj());
			ps.setString(i++, st.getQykjsswsmc());
			ps.setString(i++, st.getSjbgyjlx());
			
			ps.setString(i++, st.getNotblyjlx());
			ps.setString(i++, st.getBlyjlx());
			ps.setString(i++, st.getXssr());
			ps.setString(i++, st.getYysr());
			ps.setString(i++, st.getZcze());
			ps.setString(i++, st.getFzze());
			ps.setString(i++, st.getLrze());
			ps.setString(i++, st.getYlsde());
			ps.setString(i++, st.getJlr());
			ps.setString(i++, st.getYlsdse());
			
			ps.setString(i++, st.getXmzrs());
			ps.setString(i++, st.getWqgzts());
			ps.setString(i++, st.getCyry());
			ps.setString(i++, st.getSjns());
			ps.setString(i++, st.getZxsjje());
			ps.setString(i++, st.getSftzje());
			ps.setString(i++, st.getZczetzh());
			ps.setString(i++, st.getXssrtzh());
			ps.setString(i++, st.getYysrtzh());
			ps.setString(i++, st.getZxsjjetzh());
			
			//增加字段字syzqy,fzzetzh,syzqytzh,jlrtzh
			ps.setString(i++, st.getSyzqy());
			ps.setString(i++, st.getFzzetzh());
			ps.setString(i++, st.getSyzqytzh());
			ps.setString(i++, st.getJlrtzh());
			
			ps.setString(i++, st.getXywtz());
			ps.setString(i++, st.getZctz());
			ps.setString(i++, st.getZctj());
			ps.setString(i++, st.getLrtz());
			ps.setString(i++, st.getLrtj());
			ps.setString(i++, st.getSstz());
			ps.setString(i++, st.getSstj());
			ps.setString(i++, st.getFzgyzclsje());
			ps.setString(i++, st.getXmjzje());
			
			ps.setString(i++, st.getGuid());
			
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	
	/**
	 * 删除
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean deleteSjTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from BB_SJB where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
}

