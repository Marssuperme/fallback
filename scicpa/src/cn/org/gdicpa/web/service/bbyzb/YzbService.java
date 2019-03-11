package cn.org.gdicpa.web.service.bbyzb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbyzb.model.YzbTable;

public class YzbService {
	private Connection conn;
	public YzbService(Connection conn){
		this.conn = conn;
	}
	
	/** 
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public YzbTable getYzbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		YzbTable yt = new YzbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,yzbz,yzhl,yzbzje,yzswje,yztdsyje,yzqtwszcje,yzqtje,bqyzwfczxhje,bqyzwfczswje,"
				+ " bqyzwfczlyztzje,bqyzwfczwxzcje,bqyzwfczqtje,yzzl,zj,gfzy,jz,yzjzr,gd1,gd2,gd3,gd4,qtgd,sjbgyjlx,blyjlx,notblyjlx "
				+ " from BB_YZB where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				yt.setGuid(rs.getString(i++));
				yt.setYzbz(rs.getString(i++));
				yt.setYzhl(rs.getString(i++));
				yt.setYzbzje(rs.getString(i++));
				yt.setYzswje(rs.getString(i++));
				yt.setYztdsyje(rs.getString(i++));
				yt.setYzqtwszcje(rs.getString(i++));
				yt.setYzqtje(rs.getString(i++));
				yt.setBqyzwfczxhje(rs.getString(i++));
				yt.setBqyzwfczswje(rs.getString(i++));
				yt.setBqyzwfczlyztzje(rs.getString(i++));
				yt.setBqyzwfczwxzcje(rs.getString(i++));
				yt.setBqyzwfczqtje(rs.getString(i++));
				yt.setYzzl(rs.getString(i++));
				yt.setZj(rs.getString(i++));
				yt.setGfzy(rs.getString(i++));
				yt.setJz(rs.getString(i++));
				yt.setYzjzr(rs.getString(i++));
				yt.setGd1(rs.getString(i++));
				yt.setGd2(rs.getString(i++));
				yt.setGd3(rs.getString(i++));
				yt.setGd4(rs.getString(i++));
				yt.setQtgd(rs.getString(i++));
				yt.setSjbgyjlx(rs.getString(i++));
				yt.setBlyjlx(rs.getString(i++));
				yt.setNotblyjlx(rs.getString(i++));
			}
			return yt;
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
	public boolean addYzbTable(YzbTable yt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into BB_YZB (guid,yzbz,yzhl,yzbzje,yzswje,yztdsyje,yzqtwszcje,yzqtje,bqyzwfczxhje,bqyzwfczswje,"
				+ " bqyzwfczlyztzje,bqyzwfczwxzcje,bqyzwfczqtje,yzzl,zj,gfzy,jz,yzjzr,gd1,gd2,gd3,gd4,qtgd,sjbgyjlx,blyjlx,notblyjlx) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, yt.getGuid());
			ps.setString(i++, yt.getYzbz());
			ps.setString(i++, yt.getYzhl());
			ps.setString(i++, yt.getYzbzje());
			ps.setString(i++, yt.getYzswje());
			ps.setString(i++, yt.getYztdsyje());
			ps.setString(i++, yt.getYzqtwszcje());
			ps.setString(i++, yt.getYzqtje());
			ps.setString(i++, yt.getBqyzwfczxhje());
			ps.setString(i++, yt.getBqyzwfczswje());
			ps.setString(i++, yt.getBqyzwfczlyztzje());
			ps.setString(i++, yt.getBqyzwfczwxzcje());
			ps.setString(i++, yt.getBqyzwfczqtje());
			ps.setString(i++, yt.getYzzl());
			ps.setString(i++, yt.getZj());
			ps.setString(i++, yt.getGfzy());
			ps.setString(i++, yt.getJz());
			ps.setString(i++, yt.getYzjzr());
			ps.setString(i++, yt.getGd1());
			ps.setString(i++, yt.getGd2());
			ps.setString(i++, yt.getGd3());
			ps.setString(i++, yt.getGd4());
			ps.setString(i++, yt.getQtgd());
			ps.setString(i++, yt.getSjbgyjlx());
			ps.setString(i++, yt.getBlyjlx());
			ps.setString(i++, yt.getNotblyjlx());
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
	public boolean updateYzbTable(YzbTable yt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update BB_YZB set yzbz=?,yzhl=?,yzbzje=?,yzswje=?,yztdsyje=?,yzqtwszcje=?,yzqtje=?,"
				+ " bqyzwfczxhje=?,bqyzwfczswje=?,bqyzwfczlyztzje=?,bqyzwfczwxzcje=?,bqyzwfczqtje=?,"
				+ " yzzl=?,zj=?,gfzy=?,jz=?,yzjzr=?,gd1=?,gd2=?,gd3=?,gd4=?,qtgd=?,sjbgyjlx=?,blyjlx=?,notblyjlx=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, yt.getYzbz());
			ps.setString(i++, yt.getYzhl());
			ps.setString(i++, yt.getYzbzje());
			ps.setString(i++, yt.getYzswje());
			ps.setString(i++, yt.getYztdsyje());
			ps.setString(i++, yt.getYzqtwszcje());
			ps.setString(i++, yt.getYzqtje());
			ps.setString(i++, yt.getBqyzwfczxhje());
			ps.setString(i++, yt.getBqyzwfczswje());
			ps.setString(i++, yt.getBqyzwfczlyztzje());
			ps.setString(i++, yt.getBqyzwfczwxzcje());
			ps.setString(i++, yt.getBqyzwfczqtje());
			ps.setString(i++, yt.getYzzl());
			ps.setString(i++, yt.getZj());
			ps.setString(i++, yt.getGfzy());
			ps.setString(i++, yt.getJz());
			ps.setString(i++, yt.getYzjzr());
			ps.setString(i++, yt.getGd1());
			ps.setString(i++, yt.getGd2());
			ps.setString(i++, yt.getGd3());
			ps.setString(i++, yt.getGd4());
			ps.setString(i++, yt.getQtgd());
			ps.setString(i++, yt.getSjbgyjlx());
			ps.setString(i++, yt.getBlyjlx());
			ps.setString(i++, yt.getNotblyjlx());
			ps.setString(i++, yt.getGuid());
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
	public boolean deleteYzbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from BB_YZB where guid = ?" ;
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
