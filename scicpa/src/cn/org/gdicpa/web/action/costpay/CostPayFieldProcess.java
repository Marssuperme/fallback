package cn.org.gdicpa.web.action.costpay;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


import cn.org.gdicpa.web.pub.datagrid.DataGridFieldProcess;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.util.ASFuntion;

public class CostPayFieldProcess extends DataGridFieldProcess{

	@Override
	public String fieldProcess(DataGridProperty pp, int rowIndex, int colIndex,
			int length, ResultSet rs, String value) throws Exception {
		// TODO Auto-generated method stub
		ASFuntion CHF=new ASFuntion();		
		String result = "";
		ResultSetMetaData rsmd = rs.getMetaData();
		if("已缴费".equals(value)){
			result = "<td align='center'>修改" 
				+"&nbsp;&nbsp;&nbsp;删除</td>";
		}else{
			result = "<td align='center'><a href='###' style='font-size: 14px;' onclick=\"goUpdate('"+CHF.showNull(rs.getString("UUID"))+" ','"+CHF.showNull(rs.getString("property"))+"');\">修改</a>" 
				+"&nbsp;&nbsp;&nbsp;<a  href='###' style='font-size: 14px;' onclick=\"goDel('"+CHF.showNull(rs.getString("UUID"))+"','"+CHF.showNull(rs.getString("property"))+"');\">删除</a></td>";
		}
		return result;
	}

}
