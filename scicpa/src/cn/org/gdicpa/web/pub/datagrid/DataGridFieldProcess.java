package cn.org.gdicpa.web.pub.datagrid;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public abstract class DataGridFieldProcess {
	public abstract String fieldProcess(DataGridProperty pp,int rowIndex,int colIndex,int length,final ResultSet rs,String value) throws Exception;

	private Object obj = null ;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	protected Map getResultSetMap(ResultSet rs) throws Exception{
		HashMap m =new HashMap();

		java.sql.ResultSetMetaData rsmd=rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			m.put(rsmd.getColumnName(i), rs.getString(i));
		}

		return m;
	}
}
