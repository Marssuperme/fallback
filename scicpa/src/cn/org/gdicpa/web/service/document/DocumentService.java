package cn.org.gdicpa.web.service.document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;

public class DocumentService {

	private Connection conn = null;
	
	public DocumentService(Connection conn) {
		this.conn = conn;
	}
	
	//得到公文或通知
	public Map get(String table,String nid,String reader)throws Exception {
		
		System.out.println("-----------------get Map---------------------");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Map map = new HashMap();
			if("b_notice".equalsIgnoreCase(table)){
				sql = " select d.*,c.name as agencyname from " + table + " as d left join k_customer as c" 
					+ " on d.agencyid = c.id where d.id = ? ";
			}else if("b_document".equalsIgnoreCase(table)){
				sql = " select d.*,c.name as agencyname from " + table + " as d left join k_customer as c" 
					+ " on d.agency = c.id where d.id = ? ";
			}else{
				sql = " select d.*,c.name as agencyname from " + table + " as d left join k_customer as c" 
					+ " on d.agency = c.id where d.id = ? ";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			String attachmentid = "";	// 正文附件编号
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(RSMD.getColumnName(i).toLowerCase().equalsIgnoreCase("attachmentid")){
						attachmentid = rs.getString(RSMD.getColumnName(i));
					}
					if(RSMD.getColumnName(i).toLowerCase().equalsIgnoreCase("body")){
						if(rs.getString(RSMD.getColumnName(i))!=null && !"".equals(rs.getString(RSMD.getColumnName(i)))){
							if(rs.getString(RSMD.getColumnName(i)).indexOf("\n")>-1){
								String[] acontents = rs.getString(RSMD.getColumnName(i)).split("\n");
								String temp = "";
								for (int j = 0; j < acontents.length; j++) {
									temp=temp+acontents[j]+"<br>";
								}
								map.put(RSMD.getColumnName(i).toLowerCase() , temp);
								continue;
							}
						}
					}
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			
//			// 得到 正文
//			sql = " select indexid from k_attachfile Where indextable = 'b_document' and initflag = '1'";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			RSMD = rs.getMetaData();
//			if(rs.next()){
//				map.put("zhengwenIndexid" , rs.getString(RSMD.getColumnName(1)));
//				System.out.println(this.getClass()+"   || indexid 正文= "+rs.getString(RSMD.getColumnName(1)));
//			}
//			DbUtil.close(rs);
//			DbUtil.close(ps);
			
			// 得到 正文 对应的附件
			sql = " select indexid from k_attachfile Where indextable = '"+table+"' and initflag = '0' and property = '"+attachmentid+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				map.put("attachmentids", rs.getString(1));
			}
			
			DbUtil.close(rs);
			DbUtil.close(ps);
			 
			
			sql = "select * from b_reader where nid = ? and reader = ? and source = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.setString(2, reader);
			ps.setString(3, table);
			rs = ps.executeQuery();
			RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){
						map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					}
				}
			}
			
			return map;
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//最新通知
	public ArrayList get(String table,String reader,int count,String ctypetabname,String officecode)throws Exception {
		System.out.println("------------------------get ArrayList--------------------------");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			ArrayList list = new ArrayList();
			
			String top = "";
			
			if(count != 0){
				top = " top " + count;
			}
			
			// 非执业会员只能看到 已审核最新通知           看不到检查组人员通知
			if("k_micfono".equalsIgnoreCase(ctypetabname)){
				 sql = " select "+top+"  n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end," 
				 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status," 
				 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid," 
			         + " r.nid,r.source,r.reader,r.isview,r.viewtime,'notice' as p " 
					 + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id " 
					 + " where r.source='b_notice' and n.mode='已审核' and r.reader = ? and r.ctype='k_micfono' order by n.ntime desc ";
			}else{  // 执业和团体能看到 已审核的最新培训信息和检查组人员通知
				 sql = " select  n.id,caption = case when LEN(n.caption)>50  then substring(n.caption,1,50 )+'...' else n.caption end," 
				 	 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency as agencyInfo,c.name as agency,n.loginname,n.reference,n.status, "  
				 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid, "
				     + " r.nid,r.source,r.reader,r.isview,r.viewtime,'notice' as p "   
				     + " from b_notice n left join b_reader r on n.id = r.nid left join k_customer c on n.agencyid=c.id "  
				     + " where r.source='b_notice' and n.mode='已审核' and r.reader = ? and r.ctype!='k_micfono' " 
				     + " union "
				     + " select a.id,caption = case when LEN(a.title)>50  then substring(a.title,1,50 )+'...' else a.title end," 
				     + " acontent as body,attachment as attachmentid,subString(atime,1,10) as ntime," 
				     + " customerName as agencyInfo,customerName as agency,a.userid as loginname,'' as reference,'是否公开' as status,  a.userid as fillareaname,"
				     + " a.userid as fillarea,a.userid as loginid,customerName as agencyid,  a.id as nid,'k_testernotice' as source,"
				     + " a.userid as reader,isview = case when b.noticeid is null then 'n' when b.noticeid='' then 'n'  else 'y' end,"
				     + " atime as viewtime,'tersternotice' as p  from k_testernotice a " 
				     + " left join (select distinct noticeid,companyid from k_TesterComposition where companyid = '"+officecode+"') b on a.id = b.noticeid " 
				     + " left join b_reader r on a.id = r.nid "
				     + " where a.status = '1' and source = 'k_testernotice' and r.reader = '"+officecode+"' ";
				 
				 // 在线填报
				 String sql_task = "";
				 
				 if("k_micfo".equalsIgnoreCase(ctypetabname)){
					 sql_task = " select s.id,caption = case when LEN(s.title)>50  then substring(s.title,1,50 )+'...' else s.title end, " 
						      + " taskCnt as body,s.attachment as attachmentid,subString(createDate,1,10) as ntime, "
						      + " s.customerName as agencyInfo,s.customerName as agency,taskMan as loginname,'' as reference,'是否公开' as state, "
						      + " '' as fillareaname,'' as fillarea,'' as loginid,s.customerName as agencyid,s.id as nid,'k_suptask' as source, "
						      + " taskMan as reader, "
						      + " isview = case when r.replytime is null then '未填报' when r.replytime='' then '未填报' else '已填报' end, "
						      + " replytime as viewtime,'k_suptask' as p "
						      + " from K_SupTask s left join k_testernotice t on s.NotcieID = t.id "
						      + " left join k_reply r on s.id = r.tid "
						      + " where s.state='已审核' and r.replyer = '"+reader+"' "; 
				 }
				 
				 if("k_assesser".equalsIgnoreCase(ctypetabname)){
					 sql_task = " select s.id,caption = case when LEN(s.title)>50  then substring(s.title,1,50 )+'...' else s.title end, " 
						 + " taskCnt as body,s.attachment as attachmentid,subString(createDate,1,10) as ntime, "
						 + " s.customerName as agencyInfo,s.customerName as agency,taskMan as loginname,'' as reference,'是否公开' as state, "
						 + " '' as fillareaname,'' as fillarea,'' as loginid,s.customerName as agencyid,s.id as nid,'k_suptask' as source, "
						 + " taskMan as reader, "
						 + " isview = case when r.replytime is null then '未填报' when r.replytime='' then '未填报' else '已填报' end, "
						 + " replytime as viewtime,'k_suptask' as p "
						 + " from K_SupTask s left join k_testernotice t on s.NotcieID = t.id "
						 + " left join k_reply r on s.id = r.tid "
						 + " where s.state='已审核' and r.replyer = '"+reader+"' "; 
				 }
				 
				 if("k_company".equalsIgnoreCase(ctypetabname)){
					 sql_task = " select distinct(t.id),caption = case when LEN(t.title)>50  then substring(t.title,1,50 )+'...' else t.title end, " 
						      + " describe as body,t.attachment as attachmentid,subString(publishtime,1,10) as ntime, "
						      + " fillarea as agencyInfo,fillarea as agency,reviewerName as loginname,'' as reference,'是否公开' as state, "
						      + " fillareaname,fillarea,'' as loginid,fillarea as agencyid,t.id as nid,'k_task' as source, "
						      + " reviewerName as reader, "
						      + " isview =  case isnull(r.replytime,'') when '' then '未回复' "
						      + " else " 
						      + " 	case r.replyer " 
						      + " 		when '"+reader+"' then "
						      + " 		case r.status "
						      + " 			when '合格' then '已回复 已通过' " 
						      + " 			when '不合格' then '已回复 不通过' " 
						      + " 		else '已回复 等待确认' "
						      + " 		end  "
						      + " 	else '未回复' " 
						      + " end  "
						      + " end,  "
						      + " replytime as viewtime,'k_task' as p " 
						      + " from k_task t left join k_reply r on t.id = r.tid "  
						      + " where mode='已审核' and r.replyer='"+reader+"' "; 
				 }
				 
				 sql = " select "+top+" * from ( " +sql + " union "+ sql_task + " ) as t order by ntime desc ";
			}
			
			System.out.println(this.getClass()+"      sql="+sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader);
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
			System.out.println("ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	//得到公文或通知的List   非执业会员不显示检查组人员通知
	public ArrayList getForMicfono(String table,String reader,int count)throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			ArrayList list = new ArrayList();
			
			String top = "";
			
			if(count != 0){
				top = " top " + count;
			}
			
			
			// 非执业会员只能看到普通通知
			 sql = " select "+top+"  n.id,caption = case when LEN(n.caption)>50 then substring(n.caption,1,50)+'...' else n.caption end,"
				 + " n.body,n.attachmentid,subString(n.ntime,1,10) as ntime,n.agency,n.loginname,n.reference,n.status," 
			 	 + " n.fillareaname,n.fillarea,n.loginid,n.agencyid," 
		         + " r.nid,r.source,r.reader,r.isview,r.viewtime,'notice' as p " 
				 + " from b_notice n left join b_reader r on n.id = r.nid " 
				 + " where r.source='b_notice' and n.mode='已审核' and r.reader = ? and r.ctype='k_micfono' ";
			
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader);
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
			System.out.println("ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	//保存已阅的时间
	public void save(String nid,String reader)throws Exception {
		PreparedStatement ps = null;
		String sql = "";
		try {
			ASFuntion CHF=new ASFuntion();
			sql = "update b_reader set isview = 1 ,viewtime = ? where nid = ? and reader = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, CHF.getDateAndTime());
			ps.setString(2, nid);
			ps.setString(3, reader);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
	
	 
}
