package cn.org.gdicpa.web.service.surveyItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;

 
public class SurveyItemService {
	private Connection conn = null;

	public SurveyItemService(Connection conn) {
		this.conn = conn;
	}

	
	
	/** 得到问卷
	 * @param id
	 * @return 
	 */
	public List getSurveyItemDetails(String surveyId,Map userMap) {
		PreparedStatement ps = null ;
		PreparedStatement ps1 = null ;
		ResultSet rs = null ;
		ResultSet rs1 = null ;
		List titleOptionsList = new ArrayList(); //题目选项明细
		
		String loginid= userMap.get("loginid").toString();
		
		ASFuntion af = new ASFuntion();
		
		List surveyItemList = new ArrayList<List>();
		try {
			
			/**
			 * 1. 大类
			 * 2. 每一个大类下面的所有题目:包含自定义 选项答案
			 * 3. 保存答案后 对照答案 显示答案
			 */
			
			String titleSql = " select s.id,sd.mainid,si.id as siid,itemid,s.typeid,s.surname,s.state,ctype,question,options,sequence,TypeName from K_Survey s "  
						    + " left join K_SurveyDetail sd "
						    + " on s.id = sd.mainid "
						    + " left join K_SurveyItem si "  
						    + " on sd.itemid = si.id "
						    + " left join (K_Survey k inner join K_SurveyTypeDetail std on k.TypeID=std.MainID) "
						    + " on sd.MainID=k.ID and sd.TypeDetail=std.ID "
						    + " where s.id = '"+surveyId+"' order by sd.Sequence ";
			
			System.out.println("题目 titleSql="+titleSql);
			
			String sql = " Select ki.id as kiid,kid.id as kidid,kd.mainid,k.SurName,ktd.TypeName,ki.Ctype,ki.Question,kid.Lable,kid.ItemName,kid.iswrite,kid.writing,kd.sequence,kid.sequence as seq " 
						+ " From K_SurveyDetail kd "
						+ " left join (K_Survey k inner join K_SurveyTypeDetail ktd on k.TypeID=ktd.MainID) "
						+ " on kd.MainID=k.ID and kd.TypeDetail=ktd.ID "
						+ " left join  (K_SurveyItem ki left join K_SurveyItemDetail kid " 
						+ " on ki.ID=kid.MainID) on kd.ItemID=ki.ID "
						+ " Where kd.MainID='"+surveyId+"' and ki.Question = ? "
						+ " order by kd.Sequence,kid.Sequence ";
			
			System.out.println("题目 选项 sql="+sql);
			
			ps1 = conn.prepareStatement(sql);
			
			ps = conn.prepareStatement(titleSql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()) {
				
				Map map = new HashMap();

				
				for (int i = 1; i<=RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(),rs.getString(RSMD.getColumnName(i).toLowerCase()));
				}
				if("填空题".equals(rs.getString("ctype"))){
					String input = "";
					String sqlContent = "select answerContents from [dbo].[K_SurveyItemAnswer] "   
							   + " where surveyid = '"+surveyId+"' and surveyItemid = '"+rs.getString("siid")+"' and answerByUserId = '"+loginid+"' and sequence='"+rs.getString("sequence")+"' order by sequence asc";
					
					String answerContent = this.getStringInfoBySql(sqlContent,"");
					
					
					String[] answerContents = answerContent.split("&@&");
					
					
					// 注意 split分割 的 参数 
					String question = rs.getString("question");
					String[] questions = question.replace("()","&@&").split("&@&");
					
					for (int i = 0; i < questions.length-1; i++) {
						boolean bl = true;
						for (int j = 0; j < answerContents.length; j++) {
							if(i==j){
								bl = false;
								input = input + questions[i] + "<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" name=\""+rs.getString("siid")+"_@_"+rs.getString("sequence")+"_**_填空题"+"\"  value=\""+af.showNull(answerContents[i])+"\" >";
							}
						}
						if(bl){
							input = input + questions[i] + "<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" name=\""+rs.getString("siid")+"_@_"+rs.getString("sequence")+"_**_填空题"+"\" >";
						}
					}
					
					map.put("question",input+questions[questions.length-1]);
				}
			
				ps1.setString(1, map.get("question")+"");
				rs1 = ps1.executeQuery();
				
				List optiosList = new ArrayList();
				String opts = "";
				
				while(rs1.next()) {
					// 答案表里面是否有该选项了
					String answer = new DbUtil(conn).queryForString(" select id from K_SurveyItemAnswer " +
							"where surveyid = ? and surveyitemid = ? and answercontents = ? and answerByUserId = ? "
							,new Object[]{surveyId,rs1.getString("kiid"),rs1.getString("itemname"),loginid});
					
					String check = "";
					if(answer!=null && !"".equals(answer)){
						check = " checked=\"checked\" ";
					}
					
					if("单选题".equals(rs1.getString("ctype"))){
						// 该选项包含自定义 并且是选中了该选项 才显示自定义答案，否则不要显示自定义答案。自定义选项没选中但是有自定义答案的话会保存自定义答案						
						if("1".equals(rs1.getString("iswrite"))){
							if(!"".equals(check) && null!=check){
								String answerContents = new DbUtil(conn).queryForString(" select answerContents from K_SurveyItemAnswer " +
										"where surveyid = ? and surveyitemid = ? and answerByUserId = ? and sequence = ? and answerContents <> ? order by sequence desc "
										,new Object[]{surveyId,rs1.getString("kiid"),loginid,rs1.getString("seq"),rs1.getString("itemname")});
								
								optiosList.add("&nbsp;&nbsp;<input type=\"radio\" id=\""+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"\" value=\""+rs1.getString("itemname")+"_**_"+rs1.getString("seq")+"\" onClick=\"disReadonly('"+rs1.getString("kidid")+"')\" onFocus=\"this.blur()\" "+check+" >"+rs1.getString("lable")+"、"+rs1.getString("itemname")+
										"&nbsp;&nbsp;<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" id=\"id_"+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"_**_"+rs1.getString("seq")+"\" value=\""+af.showNull(answerContents)+"\"  onClick=\"prompt('"+rs1.getString("kidid")+"') \" ><br>");
							}else{
								optiosList.add("&nbsp;&nbsp;<input type=\"radio\" id=\""+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"\" value=\""+rs1.getString("itemname")+"_**_"+rs1.getString("seq")+"\" onClick=\"disReadonly('"+rs1.getString("kidid")+"')\" onFocus=\"this.blur()\" >"+rs1.getString("lable")+"、"+rs1.getString("itemname")+
										"&nbsp;&nbsp;<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" readonly=\"readonly\" id=\"id_"+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"_**_"+rs1.getString("seq")+"\" onClick=\"prompt('"+rs1.getString("kidid")+"') \" ><br>");
							}
						}else{
							optiosList.add("&nbsp;&nbsp;<input type=\"radio\" id=\""+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"\" value=\""+rs1.getString("itemname")+"_**_"+rs1.getString("seq")+"\" onClick=\"disReadonly('"+rs1.getString("kidid")+"')\" onFocus=\"this.blur()\" "+check+" >"+rs1.getString("lable")+"、"+rs1.getString("itemname")+"<br>");
						}
					}else if("多选题".equals(rs1.getString("ctype"))){
						if("1".equals(rs1.getString("iswrite"))){
							// 该选项包含自定义 并且是选中了该选项 才显示自定义答案，否则不要显示自定义答案。自定义选项没选中但是有自定义答案的话会保存自定义答案
							if(!"".equals(check) && null!=check){
								String answerContents = new DbUtil(conn).queryForString(" select answerContents from K_SurveyItemAnswer " +
										"where surveyid = ? and surveyitemid = ? and answerByUserId = ? and sequence = ? and answerContents <> ? order by sequence desc "
										,new Object[]{surveyId,rs1.getString("kiid"),loginid,rs1.getString("seq"),rs1.getString("itemname")});
								
								optiosList.add("&nbsp;&nbsp;<input type=\"checkbox\" id=\""+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"\" value=\""+rs1.getString("itemname")+"_**_"+rs1.getString("seq")+"\" onClick=\"disReadonly('"+rs1.getString("kidid")+"')\" "+check+" >"+rs1.getString("lable")+"、"+rs1.getString("itemname")+
								"&nbsp;&nbsp;<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" id=\"id_"+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"_**_"+rs1.getString("seq")+"\" value=\""+af.showNull(answerContents)+"\" onClick=\"prompt('"+rs1.getString("kidid")+"') \" ><br>");
							}else{
								optiosList.add("&nbsp;&nbsp;<input type=\"checkbox\" id=\""+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"\" value=\""+rs1.getString("itemname")+"_**_"+rs1.getString("seq")+"\" onClick=\"disReadonly('"+rs1.getString("kidid")+"')\" >"+rs1.getString("lable")+"、"+rs1.getString("itemname")+
										"&nbsp;&nbsp;<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" readonly=\"readonly\" id=\"id_"+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"_**_"+rs1.getString("seq")+"\" onClick=\"prompt('"+rs1.getString("kidid")+"') \" ><br>");
							}
						}else{
							optiosList.add("&nbsp;&nbsp;<input type=\"checkbox\" id=\""+rs1.getString("kidid")+"\" name=\""+rs1.getString("kiid")+"\" value=\""+rs1.getString("itemname")+"_**_"+rs1.getString("seq")+"\" "+check+" >"+rs1.getString("lable")+"、"+rs1.getString("itemname")+"<br>");
						}
					}else if("问答题".equals(rs1.getString("ctype"))){
						String answerContents = new DbUtil(conn).queryForString(" select answerContents from K_SurveyItemAnswer " +
								"where surveyid = ? and surveyitemid = ? and answerByUserId = ? "
								,new Object[]{surveyId,rs1.getString("kiid"),loginid});
						
						optiosList.add("<textarea name=\""+rs1.getString("kiid")+"_**_1"+"\" style=\" width='95%' \" rows=\"8\">"+af.showNull(answerContents)+"</textarea> <br>");
					}
				}
				
				map.put("optiosList", optiosList);
				
				surveyItemList.add(map);
			}
			
			return surveyItemList ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(rs1);
			DbUtil.close(ps);
			DbUtil.close(ps1);
		}
		return null;
	}
	
	
	
	 
	/** 得到问卷
	 * @param id
	 * @return
	 */
	public List getSurveyItemDetails_bak(String surveyItemId,Map userMap) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List typeList = new ArrayList(); //类型
		List titleList = new ArrayList(); //题目
		
		String loginid= userMap.get("loginid").toString();
		
		List<List> surveyItemList = new ArrayList<List>();
		try {
			
			String tempSql = " Select k.SurName,ktd.TypeName,ki.Ctype,ki.Question,kid.Lable,kid.ItemName,kid.iswrite,kid.writing " 
						   + " From K_SurveyDetail kd "
						   + " left join (K_Survey k inner join K_SurveyTypeDetail ktd on k.TypeID=ktd.MainID) "
						   + " on kd.MainID=k.ID and kd.TypeDetail=ktd.ID "
						   + " left join  (K_SurveyItem ki left join K_SurveyItemDetail kid " 
						   + " on ki.ID=kid.MainID) on kd.ItemID=ki.ID "
						   + " Where kd.MainID='{75B25EF4-F1CB-4F9D-BD17-AB7EE1F9E079}' "
						   + " order by kd.Sequence,kid.Sequence ";
			
			String sql = " select distinct typename,std.initflag from K_SurveyDetail sd "
				  	   + " left join K_SurveyTypeDetail std on std.id = sd.typedetail "
				  	   + " where sd.mainid = '"+surveyItemId+"' order by std.initflag asc ";
			
			
						
						
			System.out.println("sql="+sql);
			
			// 类型 list
			typeList = this.getListInfoBySql(sql);
			
			sql = " select sd.id as sdid,sd.sequence, "
					   + " si.id as siid,si.createby,si.createtime,si.ctype,si.question,si.options,si.lastby,si.lasttime, "
					   + " sia.id as siaid,sia.answercontents,sia.answerbyuserid,sia.answerbyusername, "
					   + " std.typename "
					   + " from K_SurveyDetail sd "
					   + " inner join K_SurveyItem si on si.id = sd.itemid "  
					   + " left join (select max(id) as id,max(answercontents) as answercontents,max(answerbyuserid) as answerbyuserid," 
					   + " surveyitemid,max(sequence) as sequence,max(answerbyusername) as answerbyusername " 
					   + " from K_SurveyItemAnswer group by surveyitemid ) sia on sia.surveyitemid = si.id "
					   + " left join K_SurveyTypeDetail std on std.id = sd.typedetail "
					   + " where sd.mainid = ? "
					   + " order by std.InitFlag, sd.Sequence, sia.Sequence ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,surveyItemId) ;
			rs = ps.executeQuery();
			
			System.out.println("sql="+sql);
			
			ResultSetMetaData RSMD = rs.getMetaData();	
			Map map = null;
			
			while(rs.next()) {
					map = new HashMap();
					String siid = rs.getString("siid")+"" ;
					String ctype = rs.getString("ctype")+"" ;
					
					String options = rs.getString("options")+"" ;
					String answercontents = rs.getString("answercontents")+"" ;
					
					for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)));
					}
					
					
					if("单选题".equals(ctype)) {
						String[] optArr = options.split("~`~`") ;
						String opts = "";
						String check = "";
						for(String opt:optArr) {
							if(opt.replace("@$@", "").indexOf(answercontents)>-1 || answercontents.indexOf(opt.replace("@$@", ""))>-1) {
								check = " checked=\"checked\" " ;
							}else{
								check = "" ;
							}
							if(opt.indexOf("@$@")>-1){
								opt = opt.replace("@$@", "");
								opts += "&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"radio\" "+check+" value=\""+opt+"\" id=\""+opt.substring(0, 1)+siid+"\" name=\""+siid+"\">"+opt+"&nbsp;&nbsp;<input style=\"border:0px;border-bottom:1px solid #aaa;height:0px;\" id=\"id_"+opt.substring(0, 1)+siid+"\" forValue=\""+opt.substring(0, 1)+siid+"\" anotherValue=\""+opt+"\" onkeyup=\"f_setValue(this)\" value=\""+answercontents.replace("@$@", "").replace(opt, "").replace("$##$", "")+"\" ><br>" ;
							}else{
								opts += "&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"radio\" "+check+" value=\""+opt+"\" id=\""+opt.substring(0, 1)+siid+"\" name=\""+siid+"\">"+opt+"<br>" ;
							}
						}
	
						map.put("options", opts);
						
					}else if("多选题".equals(ctype)) {
						answercontents = this.getStringInfoBySql("select answercontents from [dbo].[K_SurveyItemAnswer]  where surveyid = '"+surveyItemId+"' and surveyitemid = '"+siid+"' and answerbyuserid = '"+loginid+"'","~`~`");
						String[] optArr = options.split("~`~`") ;
						String opts = "";
						String check = "";
						for(String opt:optArr) {
							if(answercontents!=null && !"".equals(answercontents)){
								if(answercontents.indexOf(opt) >= 0 || answercontents.equals(opt)) {
									check = " checked=\"checked\" " ;
								}else {
									check = "" ;
								}
							}else{
								check = "" ;
							}
							if(opt.indexOf("@$@")>-1){
								opt = opt.replace("@$@", ""); 
								opts += "&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" "+check+" value=\""+opt+"\" id=\""+opt.substring(0, 1)+siid+"\" name=\""+siid+"\">"+opt+"&nbsp;&nbsp; <input style=\"border:0px;border-bottom:1px solid #aaa;height:0px; \" id=\"id_"+opt.substring(0, 1)+siid+"\" forValue=\""+opt.substring(0, 1)+siid+"\" anotherValue=\""+opt+"\" onkeyup=\"f_setValue(this)\" value=\""+answercontents.replace("@$@", "").replace(opt, "").replace("$##$", "")+"\" > <br>" ;
							}else{
								opts += "&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" "+check+" value=\""+opt+"\" id=\""+opt.substring(0, 1)+siid+"\" name=\""+siid+"\">"+opt+"<br>" ;
							}
						}
						System.out.println("opts="+opts);
						map.put("options", opts);
						
					}else if("问答题".equals(ctype)) {
						String opts = "";
						answercontents = this.getStringInfoBySql("select answercontents from [dbo].[K_SurveyItemAnswer]  where surveyid = '"+surveyItemId+"' and surveyitemid = '"+siid+"' and answerbyuserid = '"+loginid+"'","$@$").replace("$@$", "");
						opts += "<textarea id=\""+siid+"\" name=\""+siid+"\" style=\" width='95%' \" rows=\"8\">"+answercontents+"</textarea> <br>" ;
						System.out.println("opts="+opts);
						map.put("options", opts);
					}
					titleList.add(map) ;
			}
			surveyItemList.add(titleList);
			surveyItemList.add(typeList);
			
			return surveyItemList ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	
	
	/** list
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List getListInfoBySql(String sql) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = null;
		Map map = null;
		
		try {
			list = new ArrayList();
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();
	        
			while(rs.next()){
				map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)));
				}
				list.add(map);
			}
			
	        return list;
	        
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	/** Map
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Map getMapInfoBySql(String sql) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map map = new HashMap();
		 
		try {
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();
	        
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					System.out.println(rs.getObject(RSMD.getColumnName(i)).toString());
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)).toString().replaceAll("\n", "<br/>"));
				}
			}
			
	        return map;
	        
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	 
	
	/** 保存
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void saveSurveyItem(Map map) throws Exception {
		
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into K_SurveyItemAnswer(id,surveyid,surveyItemId,surveyItemDetailid,Sequence, "
				+ " answerContents,answerByUserId,answerByUserName,answerTime) " 
				+ " values(?,?,?,?,?,  ?,?,?,?)" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			
			ps.setString(i++, map.get("id").toString());
			ps.setString(i++, map.get("surveyid").toString());
			ps.setString(i++, map.get("siid").toString());
			ps.setString(i++, "");
			ps.setString(i++, map.get("sequence").toString());
			ps.setString(i++, map.get("answercontents").toString());
			ps.setString(i++, map.get("answerbyuserid").toString());
			ps.setString(i++, map.get("answerbyusername").toString());
			ps.setString(i++, map.get("answertime").toString());
			
			ps.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
		
	}
	
	

	/** 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void delSurveyItem(Map map,String titleType) throws Exception {
		
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			if("multiTitle".equalsIgnoreCase(titleType)){
				sql = " delete from K_SurveyItemAnswer where surveyid = ? and surveyItemId = ? and answerByUserId = ? and answercontents = ? " ;
			}else{
				sql = " delete from K_SurveyItemAnswer where surveyid = ? and surveyItemId = ? and answerByUserId = ?  " ;
			}
			ps = conn.prepareStatement(sql);
			int i = 1;
			
			ps.setString(i++, map.get("surveyid").toString());
			ps.setString(i++, map.get("siid").toString());
			ps.setString(i++, map.get("answerbyuserid").toString());
			
			if("multiTitle".equalsIgnoreCase(titleType)){
				ps.setString(i++, map.get("answercontents").toString());
			}
			
			ps.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
		
	}
	
	
	/** 删除
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void delSurveyItem(String surveyId,String userId) throws Exception {
		
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			sql = " delete from K_SurveyItemAnswer where surveyid = ? and answerByUserId = ? " ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			
			ps.setString(i++, surveyId);
			ps.setString(i++, userId);
			
			ps.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
		
	}
	
	/** 得到问卷
	 * @param id
	 * @return
	 */
	public List getSurveyItemDetails_BAK(String surveyItemId) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List typeList = new ArrayList(); //类型
		List singleList = new ArrayList(); //单选题
		List multiList = new ArrayList(); //多选题
		List judgeList = new ArrayList(); //判断题
		List fillList = new ArrayList(); //填空题
		List qtList = new ArrayList(); //问答题
		List<List> surveyItemList = new ArrayList<List>();
		try {
//			String sql = " select a.*,b.ctype,b.Question,c.TypeName,bd.Lable,bd.ItemName,bd.IsWrite,b.Options From K_SurveyDetail a "  
//					   + " left join (K_SurveyItem b inner join K_SurveyItemDetail bd on b.ID=bd.MainID) on a.ItemID=b.ID "  
//					   + " left join K_SurveyTypeDetail c on a.TypeDetail=c.ID "
//					   + " Where a.MainID=? order by c.InitFlag, a.Sequence, bd.Sequence" ;
			
			String sql = " select distinct typename from K_SurveyDetail sd "
				  	   + " left join K_SurveyTypeDetail std on std.id = sd.typedetail "
				  	   + " where sd.mainid = '"+surveyItemId+"'";
			
			typeList = this.getListInfoBySql(sql);
			
			sql = " select sd.id as sdid,sd.sequence, "
					   + " si.id as siid,si.createby,si.createtime,si.ctype,si.question,si.options,si.lastby,si.lasttime, "
					   + " sia.id as siaid,sia.answercontents,sia.answerbyuserid,sia.answerbyusername, "
					   + " std.typename "
					   + " from K_SurveyDetail sd "
					   + " inner join K_SurveyItem si on si.id = sd.itemid "  
					   + " left join K_SurveyItemAnswer sia on sia.surveyitemid = si.id "
					   + " left join K_SurveyTypeDetail std on std.id = sd.typedetail "
					   + " where sd.mainid = ? "
					   + " order by std.InitFlag, sd.Sequence, sia.Sequence ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,surveyItemId) ;
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();	
			Map map = null;
			
			while(rs.next()) {
				
				map = new HashMap();
				
				String siid = rs.getString("siid") ;
				String ctype = rs.getString("ctype") ;
				String options = rs.getString("options") ;
				String answercontents = rs.getString("answercontents") ;
				
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)));
				}
				
				
				if("单选题".equals(ctype)) {
					String[] optArr = options.split("~`~`") ;
					String opts = "";
					String check = "";
					for(String opt:optArr) {
						if(opt.equals(answercontents)) {
							check = "checked=\"checked\"" ;
						}
						opts += "<input type=\"radio\" "+check+" value=\""+opt+"\" id=\""+siid+"\" name=\""+siid+"\">"+opt+"<br>" ;
					}

					map.put("options", opts);
					singleList.add(map) ;
					
				}else if("多选题".equals(ctype)) {
					String[] optArr = options.split("~`~`") ;
					String opts = "";
					String check = "";
					for(String opt:optArr) {
						if(answercontents!=null && !"".equals(answercontents)){
							if(answercontents.indexOf(opt) > 0 || answercontents.equals(opt)) {
								check = "checked=\"checked\"" ;
							}else {
								check = "" ;
							}
						}else{
							check = "" ;
						}
						opts += "<input type=\"checkbox\" "+check+" value=\""+opt+"\" id=\""+siid+"\" name=\""+siid+"\">"+opt+"<br>" ;
					}
					
					map.put("options", opts);
					multiList.add(map) ;
					
				}else if("判断题".equals(ctype)) {
					judgeList.add(map) ;
				}else if("填空题".equals(ctype)) {
					fillList.add(map) ;
				}else {
					map.put("options", "<input type=\"text\" name=\"jd\" id=\"jd"+siid+"\" size=\"30\" style=\"{border:0px;border-bottom:1px solid #aaa;}\" />  ");
					qtList.add(map) ;
				}
			}
			
			surveyItemList.add(singleList);
			surveyItemList.add(multiList);
			surveyItemList.add(judgeList);
			surveyItemList.add(fillList);
			surveyItemList.add(qtList);
			
			return surveyItemList ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	
	
	/** String
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public String getStringInfoBySql(String sql,String split) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String value = "";
		try {
			Map map = new HashMap();
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();	
			while(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					value += rs.getObject(RSMD.getColumnName(i))+split;
				}
			}
	        return value;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
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
}
