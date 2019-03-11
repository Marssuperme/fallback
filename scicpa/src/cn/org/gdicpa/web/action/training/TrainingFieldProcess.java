package cn.org.gdicpa.web.action.training;

import java.sql.ResultSet;


import cn.org.gdicpa.web.pub.datagrid.DataGridFieldProcess;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.util.ASFuntion;

public class TrainingFieldProcess extends DataGridFieldProcess{

	@Override
	public String fieldProcess(DataGridProperty pp, int rowIndex, int colIndex,
			int length, ResultSet rs, String value) throws Exception {
		// TODO Auto-generated method stub
		ASFuntion CHF=new ASFuntion();		
		String result = "";
		String isJoin = CHF.showNull(rs.getString("isJoin"));
		String notJoinReason = CHF.showNull(rs.getString("notJoinReason"));
		notJoinReason = notJoinReason.replaceAll("\r\n", "");
		
		if(!"".equals(isJoin)){
			result = "<td align='center'><lable><font color='grey' title='"+CHF.showNull(rs.getString("notJoinReason"))+"' >"+isJoin+"</font></lable></td>";
		}else{
			if("批准".equals(value)){
				result = "<td align='center' ><a href='###' style='font-size:14px;' onclick='f_join(\"YES\",\""+CHF.showNull(rs.getString("id"))+"\",\""+notJoinReason+"\")' >参加</a>&nbsp;|&nbsp;<a href='###' title='"+CHF.showNull(rs.getString("notJoinReason"))+"' style='font-size:14px;' onclick='f_join(\"NO\",\""+ CHF.showNull(rs.getString("id")) +"\",\""+notJoinReason+"\")' >不参加</a></td>";
			}else{
				result = "<td align='center'><lable><font color='grey'>参加</font></lable>&nbsp;|&nbsp;<lable><font color='grey' title='"+CHF.showNull(rs.getString("notJoinReason"))+"' >不参加</font></lable></td>";
			}
		}
		return result;
	}

}
