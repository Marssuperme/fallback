package cn.org.gdicpa.web.action.inspection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


import cn.org.gdicpa.web.pub.datagrid.DataGridFieldProcess;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.util.ASFuntion;

public class InspectionFieldProcess extends DataGridFieldProcess{

	@Override
	public String fieldProcess(DataGridProperty pp, int rowIndex, int colIndex,
			int length, ResultSet rs, String value) throws Exception {
		// TODO Auto-generated method stub
		ASFuntion CHF=new ASFuntion();		
		String result = "";
		ResultSetMetaData rsmd = rs.getMetaData();
		
		if("是".equals(value)){
			result = "<td align='center'><input type='checkbox' checked  id='iuser' name='yearcheckName' value=\""+ CHF.showNull(rs.getString("iuser"))  +"\" ></td>";
		}else{
			result = "<td align='center'><input type='checkbox' id='iuser' name='yearcheckName' value=\""+ CHF.showNull(rs.getString("iuser"))  +"\" ></td>";
			
		}
		
		return result;
	}

}
