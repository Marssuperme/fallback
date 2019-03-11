package cn.org.gdicpa.web.service.noteInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;

public class NoteInfoService {
	private Connection conn;
	public NoteInfoService(Connection conn){
		this.conn = conn;
	}
	
	public List getLists(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = null;
		try {
			list = new ArrayList();
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
		
		
}
