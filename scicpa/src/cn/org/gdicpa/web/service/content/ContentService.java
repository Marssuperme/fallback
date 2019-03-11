package cn.org.gdicpa.web.service.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.autocode.DELAutocode;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.content.model.ContentTable;

public class ContentService {

	private Connection conn = null;
	public ContentService(Connection conn){
		this.conn = conn;
	}
	 
	 //companyGUID;GUID;Typeid;wtdwmc;bsdwmc;khczlx;khjjxj;kmhylx;
	 //sfssqy;yyzzhm;zcdz;zczbbz;bsdwzczb;fzrmc;lxrxm;lxrdh;wtxmlx;ywyds;qyrq;bgwh;
	 //xmmc;bgrq;bgnd;bgnd2;fcbgfs;qmzyszl;qmzs1;qmzs2;qmzs3;qmzs4;qmzs5;qmzs6;zlry;sfyj;
	 //ysywf;ysywfed;kjskdfphd;sfrq;sfsm;leaveword,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,
	 //sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,attachfileId,syskhlx,isoverflow;
	
	/**
	 * 根据编号得到对象的方法
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableById(String GUID) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4,"
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,left(ysywf,len(ysywf)) as ysywf,left(ysywfed,len(ysywfed)) as ysywfed,kjskdfphd,sfrq,sfsm,leaveword," 
				+ " bbperson,bbtime,bbstate,bbbh,ywarea,bz,reportCount,bbreason,linkman,linkphone," 
				+ " sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,"
				+ " attachfileId,syskhlx,isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount "
				+ " from BB_CONTENT1 where replace(REPLACE(guid,'{',''),'}','') = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, GUID);
			//ps.setString(2, typeid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setReportCount(rs.getString(i++));
				 ct.setBbreason(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfdbxm(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));
				 
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 
	
	/**
	 * 根据编号得到对象的方法
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableById(String GUID,String typeid) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4,"
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,left(ysywf,len(ysywf)) as ysywf,left(ysywfed,len(ysywfed)) as ysywfed,kjskdfphd,sfrq,sfsm,leaveword," 
				+ " bbperson,bbtime,bbstate,bbbh,ywarea,bz,reportCount,bbreason,linkman,linkphone," 
				+ " sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,"
				+ " attachfileId,syskhlx,isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount "
				+ " from BB_CONTENT1 where GUID = ? and Typeid=? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, GUID);
			ps.setString(2, typeid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setReportCount(rs.getString(i++));
				 ct.setBbreason(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfdbxm(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 	
	/**
	 * 根据编号得到对象的方法
	 * @param bbPerson
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableByLoginidAndBbbh(String bbPerson,String bbbh) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4,"
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,left(ysywf,len(ysywf)) as ysywf,left(ysywfed,len(ysywfed)) as ysywfed,kjskdfphd,sfrq,sfsm,leaveword," 
				+ " bbperson,bbtime,bbstate,bbbh,ywarea,bz,reportCount,bbreason,linkman,linkphone," 
				+ " sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime,ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts, "
				+ " attachfileId,syskhlx,isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount "
				+ " from BB_CONTENT1 where bbperson = ? and bbbh = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbPerson);
			ps.setString(2, bbbh);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setReportCount(rs.getString(i++));
				 ct.setBbreason(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfdbxm(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 
	
	
	/**
	 * 增加
	 * @param ct
	 * @return
	 * @throws Exception
	 * ,String sys_province_cicpa
	 */
	public synchronized boolean addContentTable(ContentTable ct,String officecode, String area) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		ASFuntion af = new ASFuntion();

		try {
			
			// 设置报备编号
			String bbbh = new DELAutocode().getAutoCode("报备编号", area);
//			if(area.equals(ct.getYwarea())){ 	// 本地报备
//				bbbh += "0";
//			}else{	// 异地报备
//				bbbh += "1";
//			}
			
			// 加四位随机号 避免事务所能根据防伪编号规则猜测出来
			bbbh = bbbh + this.getRandom();
			
			ct.setBbbh(bbbh);
			
			sql = " insert into BB_CONTENT1("
				+ " companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4,"
				+ " qmzs5,qmzs6,zlry,sfyj,ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword," 
				+ " bbperson,bbtime,bbstate,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,pattern,attachfileId," +
						"syskhlx,isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount)"     
				+ " values(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, " 
				+ " ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, " 
				+ " ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?," 
				+ " ?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			
			// decimal 数据类型  
			if(ct.getBsdwzczb()==null || "".equals(ct.getBsdwzczb())){
				ct.setBsdwzczb("0");
			}
			
			int i = 1;
			ps.setString(i++, ct.getCompanyGUID());
			ps.setString(i++, ct.getGuid());
			ps.setString(i++, ct.getTypeid());
			ps.setString(i++, ct.getWtdwmc());
//			ps.setString(i++, ct.getBsdwmc());
			ps.setString(i++, ct.getBsdwmc().replaceAll("\\s", ""));//为了接下家不要存在空格
			ps.setString(i++, ct.getKhczlx());
			ps.setString(i++, ct.getKhjjxj());
			ps.setString(i++, ct.getKmhylx());
			ps.setString(i++, ct.getSfssqy());
		    ps.setString(i++, ct.getYyzzhm());
		    
			ps.setString(i++, ct.getZcdz());
			ps.setString(i++, ct.getZczbbz());
			ps.setString(i++, ct.getBsdwzczb());
			ps.setString(i++, ct.getFzrmc());
			ps.setString(i++, ct.getLxrxm());
			ps.setString(i++, ct.getLxrdh());
			ps.setString(i++, ct.getWtxmlx());
			ps.setString(i++, ct.getYwyds());
			ps.setString(i++, ct.getQyrq());
			ps.setString(i++, ct.getBgwh());
			
			ps.setString(i++, ct.getXmmc());
			ps.setString(i++, ct.getBgrq());
			ps.setString(i++, ct.getBgnd());
			ps.setString(i++, ct.getBgnd2());
			ps.setString(i++, ct.getFcbgfs());
			ps.setString(i++, ct.getQmzyszl());
			ps.setString(i++, ct.getQmzs1());
			ps.setString(i++, ct.getQmzs2());
			ps.setString(i++, ct.getQmzs3());
			ps.setString(i++, ct.getQmzs4());
			
			ps.setString(i++, ct.getQmzs5());
			ps.setString(i++, ct.getQmzs6());
			ps.setString(i++, ct.getZlry());
			ps.setString(i++, ct.getSfyj());
			ps.setString(i++, ct.getYsywf());
			ps.setString(i++, ct.getYsywfed());
			ps.setString(i++, ct.getKjskdfphd());
			ps.setString(i++, ct.getSfrq());
			ps.setString(i++, ct.getSfsm());
			ps.setString(i++, ct.getLeaveword());
			
			ps.setString(i++, ct.getBbperson());
			ps.setString(i++, ct.getBbtime());
			ps.setString(i++, ct.getBbstate());
			
			ps.setString(i++, this.getCpanobyName(ct.getQmzs1(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs2(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs3(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs4(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs5(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs6(),officecode));
//			ps.setString(i++, ct.getQmzs1()!="" && ct.getQmzs1()!=null ? ct.getCpa1() : "");
//			ps.setString(i++, ct.getQmzs2()!="" && ct.getQmzs2()!=null ? ct.getCpa2() : "");
//			ps.setString(i++, ct.getQmzs3()!="" && ct.getQmzs3()!=null ? ct.getCpa3() : "");
//			ps.setString(i++, ct.getQmzs4()!="" && ct.getQmzs4()!=null ? ct.getCpa4() : "");
//			ps.setString(i++, ct.getQmzs5()!="" && ct.getQmzs5()!=null ? ct.getCpa5() : "");
//			ps.setString(i++, ct.getQmzs6()!="" && ct.getQmzs6()!=null ? ct.getCpa6() : "");
			
			ps.setString(i++, ct.getBbbh());
			
			ps.setString(i++, ct.getYwarea());
			ps.setString(i++, ct.getBz());
			ps.setString(i++, ct.getLinkman());
			ps.setString(i++, ct.getLinkphone());
			ps.setString(i++, ct.getSfbz());
			ps.setString(i++, ct.getXmkhlx());
			ps.setString(i++, ct.getKjskdfphd2());
			ps.setString(i++, ct.getZdsfbzje());
			ps.setString(i++, ct.getSflkh());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, ct.getBaogaoniandu());
			ps.setString(i++, ct.getIsnexts());
			ps.setString(i++, "事务所登陆报备手工报备");
			ps.setString(i++, ct.getAttachfileId());
			ps.setString(i++, ct.getSyskhlx());
			ps.setString(i++, ct.getIsoverflow());
			ps.setString(i++, ct.getSfdbxm());
			ps.setString(i++, ct.getDbxmmc());
			ps.setString(i++, ct.getQtcyzs());
			
			ps.setString(i++, getCPANOString(ct.getQtcyzs(),officecode));
			ps.setString(i++, ct.getSfztb());
			ps.setString(i++, ct.getDiscountBySeven());
			
			int flag = ps.executeUpdate();
			if(flag>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println("执行 insert into 出错  sql:"+sql+"   info:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 增加
	 * @param ct
	 * @return
	 * @throws Exception
	 * 
	 */
	public synchronized boolean addContentTable(ContentTable ct,String officecode, String area,String sys_province_cicpa) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		ASFuntion af = new ASFuntion();
		
		String isAuto = new DbUtil(conn).queryForString("select isauto from k_company where loginid=?", new Object[]{ct.getBbperson()});
		
		System.out.println("测试 add isAuto : " + isAuto);
		
		try {
			
			// 设置报备编号
			String bbbh = new DELAutocode().getAutoCode("报备编号", area);
			System.out.println("addContentTable报备号："+ct.getBbbh());
//			if(area.equals(ct.getYwarea())){ 	// 本地报备
//				bbbh += "0";
//			}else{	// 异地报备
//				bbbh += "1";
//			}
			
			// 加四位随机号 避免事务所能根据防伪编号规则猜测出来
			bbbh = bbbh + this.getRandom();
			
			ct.setBbbh(bbbh);
			
			sql = " insert into BB_CONTENT1("
				+ " companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4,"
				+ " qmzs5,qmzs6,zlry,sfyj,ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword," 
				+ " bbperson,bbtime,bbstate,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,pattern,attachfileId," +
						"syskhlx,isoverflow,isauto,isPack,packName,qtcyzs,qtcpa,sfztb,discount)"     
				+ " values(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, " 
				+ " ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, " 
				+ " ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?," 
				+ " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			
			// decimal 数据类型  
			if(ct.getBsdwzczb()==null || "".equals(ct.getBsdwzczb())){
				ct.setBsdwzczb("0");
			}
			
			int i = 1;
			ps.setString(i++, ct.getCompanyGUID());
			ps.setString(i++, ct.getGuid());
			ps.setString(i++, ct.getTypeid());
			ps.setString(i++, ct.getWtdwmc());
			ps.setString(i++, ct.getBsdwmc().replaceAll("\\s", ""));//为了接下家不要存在空格
			ps.setString(i++, ct.getKhczlx());
			ps.setString(i++, ct.getKhjjxj());
			ps.setString(i++, ct.getKmhylx());
			ps.setString(i++, ct.getSfssqy());
		    ps.setString(i++, ct.getYyzzhm());
		    
			ps.setString(i++, ct.getZcdz());
			ps.setString(i++, ct.getZczbbz());
			ps.setString(i++, ct.getBsdwzczb());
			ps.setString(i++, ct.getFzrmc());
			ps.setString(i++, ct.getLxrxm());
			ps.setString(i++, ct.getLxrdh());
			ps.setString(i++, ct.getWtxmlx());
			ps.setString(i++, ct.getYwyds());
			ps.setString(i++, ct.getQyrq());
			ps.setString(i++, ct.getBgwh());
			
			ps.setString(i++, ct.getXmmc());
			ps.setString(i++, ct.getBgrq());
			ps.setString(i++, ct.getBgnd());
			ps.setString(i++, ct.getBgnd2());
			ps.setString(i++, ct.getFcbgfs());
			ps.setString(i++, ct.getQmzyszl());
			ps.setString(i++, ct.getQmzs1());
			ps.setString(i++, ct.getQmzs2());
			ps.setString(i++, ct.getQmzs3());
			ps.setString(i++, ct.getQmzs4());
			
			ps.setString(i++, ct.getQmzs5());
			ps.setString(i++, ct.getQmzs6());
			ps.setString(i++, ct.getZlry());
			ps.setString(i++, ct.getSfyj());
			ps.setString(i++, ct.getYsywf());
			ps.setString(i++, ct.getYsywfed());
			ps.setString(i++, ct.getKjskdfphd());
			ps.setString(i++, ct.getSfrq());
			ps.setString(i++, ct.getSfsm());
			ps.setString(i++, ct.getLeaveword());
			
			ps.setString(i++, ct.getBbperson());
			ps.setString(i++, ct.getBbtime());
			ps.setString(i++, ct.getBbstate());
			
			ps.setString(i++, this.getCpanobyName(ct.getQmzs1(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs2(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs3(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs4(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs5(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs6(),officecode));
//			ps.setString(i++, ct.getQmzs1()!="" && ct.getQmzs1()!=null ? ct.getCpa1() : "");
//			ps.setString(i++, ct.getQmzs2()!="" && ct.getQmzs2()!=null ? ct.getCpa2() : "");
//			ps.setString(i++, ct.getQmzs3()!="" && ct.getQmzs3()!=null ? ct.getCpa3() : "");
//			ps.setString(i++, ct.getQmzs4()!="" && ct.getQmzs4()!=null ? ct.getCpa4() : "");
//			ps.setString(i++, ct.getQmzs5()!="" && ct.getQmzs5()!=null ? ct.getCpa5() : "");
//			ps.setString(i++, ct.getQmzs6()!="" && ct.getQmzs6()!=null ? ct.getCpa6() : "");
			
			ps.setString(i++, ct.getBbbh());
			
			ps.setString(i++, ct.getYwarea());
			ps.setString(i++, ct.getBz());
			ps.setString(i++, ct.getLinkman());
			ps.setString(i++, ct.getLinkphone());
			ps.setString(i++, ct.getSfbz());
			ps.setString(i++, ct.getXmkhlx());
			ps.setString(i++, ct.getKjskdfphd2());
			ps.setString(i++, ct.getZdsfbzje());
			ps.setString(i++, ct.getSflkh());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, ct.getBaogaoniandu());
			ps.setString(i++, ct.getIsnexts());
			ps.setString(i++, "事务所登陆报备手工报备");
			ps.setString(i++, ct.getAttachfileId());
			ps.setString(i++, ct.getSyskhlx());
			ps.setString(i++, ct.getIsoverflow());
			ps.setString(i++, isAuto);
			ps.setString(i++, ct.getSfdbxm());
			ps.setString(i++, ct.getDbxmmc());
			ps.setString(i++, ct.getQtcyzs());
			
			ps.setString(i++, getCPANOString(ct.getQtcyzs(),officecode));
			ps.setString(i++, ct.getSfztb());
			ps.setString(i++, ct.getDiscountBySeven());
			
			int flag = ps.executeUpdate();
			if(flag>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println("执行 insert into 出错  sql:"+sql+"   info:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(ps);
		}
	}	

	/**
	 * 增加
	 * @param ct
	 * @return
	 * @throws Exception
	 */
	public synchronized boolean addContentTable(ContentTable ct,String officecode) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		ASFuntion af = new ASFuntion();
		try {
			
			sql = " insert into BB_CONTENT1("
				+ " companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4,"
				+ " qmzs5,qmzs6,zlry,sfyj,ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword," 
				+ " bbperson,bbtime,bbstate,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,attachfileId,syskhlx," +
						"isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount)"     
				+ " values(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, " 
				+ " ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, " 
				+ " ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?," 
				+ " ?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			
			// decimal 数据类型  
			if(ct.getBsdwzczb()==null || "".equals(ct.getBsdwzczb())){
				ct.setBsdwzczb("0");
			}
			
			int i = 1;
			ps.setString(i++, ct.getCompanyGUID());
			ps.setString(i++, ct.getGuid());
			ps.setString(i++, ct.getTypeid());
			ps.setString(i++, ct.getWtdwmc());
//			ps.setString(i++, ct.getBsdwmc());
			ps.setString(i++, ct.getBsdwmc().replaceAll("\\s", ""));//为了接下家不要存在空格
			ps.setString(i++, ct.getKhczlx());
			ps.setString(i++, ct.getKhjjxj());
			ps.setString(i++, ct.getKmhylx());
			ps.setString(i++, ct.getSfssqy());
		    ps.setString(i++, ct.getYyzzhm());
		    
			ps.setString(i++, ct.getZcdz());
			ps.setString(i++, ct.getZczbbz());
			ps.setString(i++, ct.getBsdwzczb());
			ps.setString(i++, ct.getFzrmc());
			ps.setString(i++, ct.getLxrxm());
			ps.setString(i++, ct.getLxrdh());
			ps.setString(i++, ct.getWtxmlx());
			ps.setString(i++, ct.getYwyds());
			ps.setString(i++, ct.getQyrq());
			ps.setString(i++, ct.getBgwh());
			
			ps.setString(i++, ct.getXmmc());
			ps.setString(i++, ct.getBgrq());
			ps.setString(i++, ct.getBgnd());
			ps.setString(i++, ct.getBgnd2());
			ps.setString(i++, ct.getFcbgfs());
			ps.setString(i++, ct.getQmzyszl());
			ps.setString(i++, ct.getQmzs1());
			ps.setString(i++, ct.getQmzs2());
			ps.setString(i++, ct.getQmzs3());
			ps.setString(i++, ct.getQmzs4());
			
			ps.setString(i++, ct.getQmzs5());
			ps.setString(i++, ct.getQmzs6());
			ps.setString(i++, ct.getZlry());
			ps.setString(i++, ct.getSfyj());
			ps.setString(i++, ct.getYsywf());
			ps.setString(i++, ct.getYsywfed());
			ps.setString(i++, ct.getKjskdfphd());
			ps.setString(i++, ct.getSfrq());
			ps.setString(i++, ct.getSfsm());
			ps.setString(i++, ct.getLeaveword()); 
			
			ps.setString(i++, ct.getBbperson());
			ps.setString(i++, ct.getBbtime());
			ps.setString(i++, ct.getBbstate());
			
			ps.setString(i++, this.getCpanobyName(ct.getQmzs1(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs2(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs3(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs4(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs5(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs6(),officecode));
//			ps.setString(i++, ct.getQmzs1()!="" && ct.getQmzs1()!=null ? ct.getCpa1() : "");
//			ps.setString(i++, ct.getQmzs2()!="" && ct.getQmzs2()!=null ? ct.getCpa2() : "");
//			ps.setString(i++, ct.getQmzs3()!="" && ct.getQmzs3()!=null ? ct.getCpa3() : "");
//			ps.setString(i++, ct.getQmzs4()!="" && ct.getQmzs4()!=null ? ct.getCpa4() : "");
//			ps.setString(i++, ct.getQmzs5()!="" && ct.getQmzs5()!=null ? ct.getCpa5() : "");
//			ps.setString(i++, ct.getQmzs6()!="" && ct.getQmzs6()!=null ? ct.getCpa6() : "");
			
			ps.setString(i++, ct.getBbbh());
			
			ps.setString(i++, ct.getYwarea());
			ps.setString(i++, ct.getBz());
			ps.setString(i++, ct.getLinkman());
			ps.setString(i++, ct.getLinkphone());
			ps.setString(i++, ct.getSfbz());
			ps.setString(i++, ct.getXmkhlx());
			ps.setString(i++, ct.getKjskdfphd2());
			ps.setString(i++, ct.getZdsfbzje());
			ps.setString(i++, ct.getSflkh());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, ct.getBaogaoniandu());
			ps.setString(i++, ct.getIsnexts());
			ps.setString(i++, ct.getAttachfileId());
			ps.setString(i++, ct.getSyskhlx());
			ps.setString(i++, ct.getIsoverflow());
			ps.setString(i++, ct.getSfdbxm());
			ps.setString(i++, ct.getDbxmmc());
			ps.setString(i++, ct.getQtcyzs());
			
			ps.setString(i++, getCPANOString(ct.getQtcyzs(),officecode));
			ps.setString(i++, ct.getSfztb());
			ps.setString(i++, ct.getDiscountBySeven());
			
			int flag = ps.executeUpdate();
			if(flag>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println("执行 insert into 出错  sql:"+sql+"   info:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 修改
	 * @param ct
	 * @return
	 * @throws Exception
	 * ,String sys_province_cicpa
	 */
	public boolean updateContentTable(ContentTable ct,String officecode) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		ASFuntion af = new ASFuntion();
		try {
			sql = " update BB_CONTENT1 set"
				+ " wtdwmc=?,bsdwmc=?,khczlx=?,khjjxj=?,kmhylx=?,sfssqy=?,yyzzhm=?,zcdz=?,zczbbz=?,bsdwzczb=?,"
				+ "	fzrmc=?,lxrxm=?,lxrdh=?,wtxmlx=?,ywyds=?,qyrq=?,bgwh=?,xmmc=?,bgrq=?,bgnd=?,"
				+ "	bgnd2=?,fcbgfs=?,qmzyszl=?,qmzs1=?,qmzs2=?,qmzs3=?,qmzs4=?,qmzs5=?,qmzs6=?,zlry=?,"
				+ " sfyj=?,ysywf=?,ysywfed=?,kjskdfphd=?,sfrq=?,sfsm=?,leaveword=?,bbperson=?,bbstate=?,cpa1=?,"
				+ " cpa2=?,cpa3=?,cpa4=?,cpa5=?,cpa6=?,ywarea=?,bz=?,linkman=?,linkphone=?,bbtime=?, "
				+ " sfbz=?,xmkhlx=?,kjskdfphd2=?,zdsfbzje=?,sflkh=?,lastUpdateTime=?,ysywfedUpdateTime=?,kjskdfphd2UpdateTime=?,baogaoniandu=?,isnexts=?,"
				+ " attachfileId=?,syskhlx=?,isoverflow=?,isPack=?,packName=?,qtcyzs=?,qtcpa=?,sfztb=?,discount=? "
				+ " where GUID = ?" ;
			
			// 报备完成后就不修改报备时间
			if("N".equalsIgnoreCase(ct.getIsUpdateTime())){
				sql = " update BB_CONTENT1 set"
					+ " wtdwmc=?,bsdwmc=?,khczlx=?,khjjxj=?,kmhylx=?,sfssqy=?,yyzzhm=?,zcdz=?,zczbbz=?,bsdwzczb=?,"
					+ "	fzrmc=?,lxrxm=?,lxrdh=?,wtxmlx=?,ywyds=?,qyrq=?,bgwh=?,xmmc=?,bgrq=?,bgnd=?,"
					+ "	bgnd2=?,fcbgfs=?,qmzyszl=?,qmzs1=?,qmzs2=?,qmzs3=?,qmzs4=?,qmzs5=?,qmzs6=?,zlry=?,"
					+ " sfyj=?,ysywf=?,ysywfed=?,kjskdfphd=?,sfrq=?,sfsm=?,leaveword=?,bbperson=?,bbstate=?,cpa1=?,"
					+ " cpa2=?,cpa3=?,cpa4=?,cpa5=?,cpa6=?,ywarea=?,bz=?,linkman=?,linkphone=?,sfbz=?, "
					+ " xmkhlx=?,kjskdfphd2=?,zdsfbzje=?,sflkh=?,lastUpdateTime=?,ysywfedUpdateTime=?,kjskdfphd2UpdateTime=?,baogaoniandu=?,isnexts=?, "
					+ " attachfileId=?,syskhlx=?,isoverflow=?,isPack=?,packName=?,qtcyzs=?,qtcpa=?,sfztb=?,discount=? "
					+ " where GUID = ?" ;
			}
			
			ps = conn.prepareStatement(sql);
			
			// decimal 数据类型  
			if(ct.getBsdwzczb()==null || "".equals(ct.getBsdwzczb())){
				ct.setBsdwzczb("0");
			}
			
			int i = 1;
			 
			ps.setString(i++, ct.getWtdwmc());
//			ps.setString(i++, ct.getBsdwmc());
			ps.setString(i++, ct.getBsdwmc().replaceAll("\\s", ""));//为了接下家不要存在空格
			ps.setString(i++, ct.getKhczlx());
			ps.setString(i++, ct.getKhjjxj());
			ps.setString(i++, ct.getKmhylx());
			ps.setString(i++, ct.getSfssqy());
		    ps.setString(i++, ct.getYyzzhm());
			ps.setString(i++, ct.getZcdz());
			ps.setString(i++, ct.getZczbbz());
			ps.setString(i++, ct.getBsdwzczb());
			ps.setString(i++, ct.getFzrmc());
			ps.setString(i++, ct.getLxrxm());
			ps.setString(i++, ct.getLxrdh());
			ps.setString(i++, ct.getWtxmlx());
			ps.setString(i++, ct.getYwyds());
			ps.setString(i++, ct.getQyrq());
			ps.setString(i++, ct.getBgwh());
			ps.setString(i++, ct.getXmmc());
			ps.setString(i++, ct.getBgrq());
			ps.setString(i++, ct.getBgnd());
			ps.setString(i++, ct.getBgnd2());
			ps.setString(i++, ct.getFcbgfs());
			ps.setString(i++, ct.getQmzyszl());
			ps.setString(i++, ct.getQmzs1());
			ps.setString(i++, ct.getQmzs2());
			ps.setString(i++, ct.getQmzs3());
			ps.setString(i++, ct.getQmzs4());
			ps.setString(i++, ct.getQmzs5());
			ps.setString(i++, ct.getQmzs6());
			ps.setString(i++, ct.getZlry());
			ps.setString(i++, ct.getSfyj());
			ps.setString(i++, ct.getYsywf());
			ps.setString(i++, ct.getYsywfed());
			ps.setString(i++, ct.getKjskdfphd());
			ps.setString(i++, ct.getSfrq());
			ps.setString(i++, ct.getSfsm());
			ps.setString(i++, ct.getLeaveword()); 
			ps.setString(i++, ct.getBbperson());
			ps.setString(i++, ct.getBbstate());
			
			ps.setString(i++, this.getCpanobyName(ct.getQmzs1(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs2(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs3(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs4(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs5(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs6(),officecode));
//			ps.setString(i++, ct.getQmzs1()!="" && ct.getQmzs1()!=null ? ct.getCpa1() : "");
//			ps.setString(i++, ct.getQmzs2()!="" && ct.getQmzs2()!=null ? ct.getCpa2() : "");
//			ps.setString(i++, ct.getQmzs3()!="" && ct.getQmzs3()!=null ? ct.getCpa3() : "");
//			ps.setString(i++, ct.getQmzs4()!="" && ct.getQmzs4()!=null ? ct.getCpa4() : "");
//			ps.setString(i++, ct.getQmzs5()!="" && ct.getQmzs5()!=null ? ct.getCpa5() : "");
//			ps.setString(i++, ct.getQmzs6()!="" && ct.getQmzs6()!=null ? ct.getCpa6() : "");
			
			ps.setString(i++, ct.getYwarea());
			ps.setString(i++, ct.getBz());
			ps.setString(i++, ct.getLinkman());
			ps.setString(i++, ct.getLinkphone());
			
			if(!"N".equalsIgnoreCase(ct.getIsUpdateTime())){
				ps.setString(i++, ct.getBbtime());
			}
			
			ps.setString(i++, ct.getSfbz());
			ps.setString(i++, ct.getXmkhlx());
			ps.setString(i++, ct.getKjskdfphd2());
			ps.setString(i++, ct.getZdsfbzje());
			ps.setString(i++, ct.getSflkh());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, ct.getYsywfedUpdateTime());
			ps.setString(i++, ct.getKjskdfphd2UpdateTime());
			ps.setString(i++, ct.getBaogaoniandu());
			ps.setString(i++, ct.getIsnexts());
			
			ps.setString(i++, ct.getAttachfileId());
			ps.setString(i++, ct.getSyskhlx());
			ps.setString(i++, ct.getIsoverflow());
			ps.setString(i++, ct.getSfdbxm());
			ps.setString(i++, ct.getDbxmmc());
			ps.setString(i++, ct.getQtcyzs());
			
			ps.setString(i++, getCPANOString(ct.getQtcyzs(),officecode));
			ps.setString(i++, ct.getSfztb());
			ps.setString(i++, ct.getDiscountBySeven());
			
			ps.setString(i++, ct.getGuid());
			
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}

	/**
	 * 修改
	 * @param ct
	 * @return
	 * @throws Exception
	 * 
	 */
	public boolean updateContentTable(ContentTable ct,String officecode,String sys_province_cicpa) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		ASFuntion af = new ASFuntion();
		
		String isAuto = new DbUtil(conn).queryForString("select isauto from k_company where loginid=?", new Object[]{ct.getBbperson()});
		
		System.out.println("测试 update isAuto : " + isAuto);
		
		try {
			sql = " update BB_CONTENT1 set"
				+ " wtdwmc=?,bsdwmc=?,khczlx=?,khjjxj=?,kmhylx=?,sfssqy=?,yyzzhm=?,zcdz=?,zczbbz=?,bsdwzczb=?,"
				+ "	fzrmc=?,lxrxm=?,lxrdh=?,wtxmlx=?,ywyds=?,qyrq=?,bgwh=?,xmmc=?,bgrq=?,bgnd=?,"
				+ "	bgnd2=?,fcbgfs=?,qmzyszl=?,qmzs1=?,qmzs2=?,qmzs3=?,qmzs4=?,qmzs5=?,qmzs6=?,zlry=?,"
				+ " sfyj=?,ysywf=?,ysywfed=?,kjskdfphd=?,sfrq=?,sfsm=?,leaveword=?,bbperson=?,bbstate=?,cpa1=?,"
				+ " cpa2=?,cpa3=?,cpa4=?,cpa5=?,cpa6=?,ywarea=?,bz=?,linkman=?,linkphone=?,bbtime=?, "
				+ " sfbz=?,xmkhlx=?,kjskdfphd2=?,zdsfbzje=?,sflkh=?,lastUpdateTime=?,ysywfedUpdateTime=?,kjskdfphd2UpdateTime=?,baogaoniandu=?,isnexts=?,"
				+ " attachfileId=?,syskhlx=?,isoverflow=?,isauto=?,isPack=?,packName=?,qtcyzs=?,qtcpa=?,sfztb=?,discount=? "
				+ " where GUID = ?" ;
			
			// 报备完成后就不修改报备时间
			if("N".equalsIgnoreCase(ct.getIsUpdateTime())){
				sql = " update BB_CONTENT1 set"
					+ " wtdwmc=?,bsdwmc=?,khczlx=?,khjjxj=?,kmhylx=?,sfssqy=?,yyzzhm=?,zcdz=?,zczbbz=?,bsdwzczb=?,"
					+ "	fzrmc=?,lxrxm=?,lxrdh=?,wtxmlx=?,ywyds=?,qyrq=?,bgwh=?,xmmc=?,bgrq=?,bgnd=?,"
					+ "	bgnd2=?,fcbgfs=?,qmzyszl=?,qmzs1=?,qmzs2=?,qmzs3=?,qmzs4=?,qmzs5=?,qmzs6=?,zlry=?,"
					+ " sfyj=?,ysywf=?,ysywfed=?,kjskdfphd=?,sfrq=?,sfsm=?,leaveword=?,bbperson=?,bbstate=?,cpa1=?,"
					+ " cpa2=?,cpa3=?,cpa4=?,cpa5=?,cpa6=?,ywarea=?,bz=?,linkman=?,linkphone=?,sfbz=?, "
					+ " xmkhlx=?,kjskdfphd2=?,zdsfbzje=?,sflkh=?,lastUpdateTime=?,ysywfedUpdateTime=?,kjskdfphd2UpdateTime=?,baogaoniandu=?,isnexts=?, "
					+ " attachfileId=?,syskhlx=?,isoverflow=?,isauto=?,isPack=?,packName=?,qtcyzs=?,qtcpa=?,sfztb=?,discount=? "
					+ " where GUID = ?" ;
			}
			
			ps = conn.prepareStatement(sql);
			
			// decimal 数据类型  
			if(ct.getBsdwzczb()==null || "".equals(ct.getBsdwzczb())){
				ct.setBsdwzczb("0");
			}
			
			int i = 1;
			 
			ps.setString(i++, ct.getWtdwmc());
//			ps.setString(i++, ct.getBsdwmc());
			ps.setString(i++, ct.getBsdwmc().replaceAll("\\s", ""));//为了接下家不要存在空格
			ps.setString(i++, ct.getKhczlx());
			ps.setString(i++, ct.getKhjjxj());
			ps.setString(i++, ct.getKmhylx());
			ps.setString(i++, ct.getSfssqy());
		    ps.setString(i++, ct.getYyzzhm());
			ps.setString(i++, ct.getZcdz());
			ps.setString(i++, ct.getZczbbz());
			ps.setString(i++, ct.getBsdwzczb());
			ps.setString(i++, ct.getFzrmc());
			ps.setString(i++, ct.getLxrxm());
			ps.setString(i++, ct.getLxrdh());
			ps.setString(i++, ct.getWtxmlx());
			ps.setString(i++, ct.getYwyds());
			ps.setString(i++, ct.getQyrq());
			ps.setString(i++, ct.getBgwh());
			ps.setString(i++, ct.getXmmc());
			ps.setString(i++, ct.getBgrq());
			ps.setString(i++, ct.getBgnd());
			ps.setString(i++, ct.getBgnd2());
			ps.setString(i++, ct.getFcbgfs());
			ps.setString(i++, ct.getQmzyszl());
			ps.setString(i++, ct.getQmzs1());
			ps.setString(i++, ct.getQmzs2());
			ps.setString(i++, ct.getQmzs3());
			ps.setString(i++, ct.getQmzs4());
			ps.setString(i++, ct.getQmzs5());
			ps.setString(i++, ct.getQmzs6());
			ps.setString(i++, ct.getZlry());
			ps.setString(i++, ct.getSfyj());
			ps.setString(i++, ct.getYsywf());
			ps.setString(i++, ct.getYsywfed());
			ps.setString(i++, ct.getKjskdfphd());
			ps.setString(i++, ct.getSfrq());
			ps.setString(i++, ct.getSfsm());
			ps.setString(i++, ct.getLeaveword()); 
			ps.setString(i++, ct.getBbperson());
			ps.setString(i++, ct.getBbstate());
			
			ps.setString(i++, this.getCpanobyName(ct.getQmzs1(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs2(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs3(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs4(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs5(),officecode));
			ps.setString(i++, this.getCpanobyName(ct.getQmzs6(),officecode));
			
//			ps.setString(i++, ct.getQmzs1()!="" && ct.getQmzs1()!=null ? ct.getCpa1() : "");
//			ps.setString(i++, ct.getQmzs2()!="" && ct.getQmzs2()!=null ? ct.getCpa2() : "");
//			ps.setString(i++, ct.getQmzs3()!="" && ct.getQmzs3()!=null ? ct.getCpa3() : "");
//			ps.setString(i++, ct.getQmzs4()!="" && ct.getQmzs4()!=null ? ct.getCpa4() : "");
//			ps.setString(i++, ct.getQmzs5()!="" && ct.getQmzs5()!=null ? ct.getCpa5() : "");
//			ps.setString(i++, ct.getQmzs6()!="" && ct.getQmzs6()!=null ? ct.getCpa6() : "");
			
			ps.setString(i++, ct.getYwarea());
			ps.setString(i++, ct.getBz());
			ps.setString(i++, ct.getLinkman());
			ps.setString(i++, ct.getLinkphone());
			
			if(!"N".equalsIgnoreCase(ct.getIsUpdateTime())){
				ps.setString(i++, ct.getBbtime());
			}
			
			ps.setString(i++, ct.getSfbz());
			ps.setString(i++, ct.getXmkhlx());
			ps.setString(i++, ct.getKjskdfphd2());
			ps.setString(i++, ct.getZdsfbzje());
			ps.setString(i++, ct.getSflkh());
			ps.setString(i++, af.getCurrentDate()+" "+af.getCurrentTime());
			ps.setString(i++, ct.getYsywfedUpdateTime());
			ps.setString(i++, ct.getKjskdfphd2UpdateTime());
			ps.setString(i++, ct.getBaogaoniandu());
			ps.setString(i++, ct.getIsnexts());
			
			ps.setString(i++, ct.getAttachfileId());
			ps.setString(i++, ct.getSyskhlx());
			ps.setString(i++, ct.getIsoverflow());
			ps.setString(i++, isAuto);
			ps.setString(i++, ct.getSfdbxm());
			ps.setString(i++, ct.getDbxmmc());
			ps.setString(i++, ct.getQtcyzs());
			
			ps.setString(i++, getCPANOString(ct.getQtcyzs(),officecode));
			ps.setString(i++, ct.getSfztb());
			ps.setString(i++, ct.getDiscountBySeven());
			
			ps.setString(i++, ct.getGuid());
			
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}	
	/**
	 * 删除
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public boolean deleteContentTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from BB_CONTENT1 where GUID = ?" ;
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
	
	
	/**
	 * 根据名称得到cpa编号
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getCpanobyName(String name,String officecode) throws Exception{
		DbUtil.checkConn(conn); 
		String cpano = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			//事务所类型（事务所、评估所）
			String officeType = new DbUtil(conn).queryForString("select officeType from k_company where loginid='"+officecode+"'");
			if("事务所".equals(officeType)){
				sql = " select cpano from K_Micfo where loginname=? and officecode=?" ;
			}else if("评估所".equals(officeType)){
				sql = " select AssessID from K_Assesser where loginname=? and officecode=?" ;
			}
			cpano = new DbUtil(conn).queryForString(sql,new Object[]{name,officecode});
			return cpano;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return "暂无cpa编号";
	}
	
	
	
	/**
	 * 根据名称得到cpa编号
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String getCpanobyName_GS(String name,String officecode) throws Exception{
		DbUtil.checkConn(conn); 
		String cpano = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select case when cpano='' then assessid when cpano is null then assessid else cpano end as cpano," 
				+ " loginid,loginname,officecode,assessno from k_micfo " 
				+ " union " 
				+ " select assessid as cpano,loginid,loginname,officecode,assessno from k_micfono  "
				+ " where loginname = ? and (officecode = ? or assessno = ? ) ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, officecode);
			ps.setString(3, officecode);
			rs = ps.executeQuery();
			if(rs.next()){
				cpano = rs.getString("cpano");
			}
			return cpano;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return "暂无cpa编号";
	}
	
	
	
	/**
	 * 作废
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public boolean invalid(String GUID,String bbreason,String zfperson,String reportCount) throws Exception{
		System.out.println(this.getClass()+"     reportCount= "+reportCount);
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_content1 set bbreason = ?,zfperson = ?,bbstate = '作废',reportCount=? where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,bbreason);
			ps.setString(2, zfperson);
			ps.setString(3, reportCount);
			ps.setString(4,GUID);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	/**
	 * 得到报备状态
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public String viewState(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String state = "";
		try {
			sql = " select bbstate from bb_content1 where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			rs = ps.executeQuery();
			if(rs.next()){
				state = rs.getString(1);
			}
			return state;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return state;
	}
	
	/**
	 * 得到报备时间
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public String getBBTime(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String bbtime = "";
		try {
			sql = " select bbtime from bb_content1 where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			rs = ps.executeQuery();
			if(rs.next()){
				bbtime = rs.getString(1);
			}
			return bbtime;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return bbtime;
	}
	
	/**
	 * 根据报备编号得到对象的方法
	 * @param bbbh
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableBybbbh(String bbbh) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm, "
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4," 
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,"
				+ " ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword,bbperson,bbtime,bbstate,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,attachfileId,syskhlx," +
						"isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount " 
				+ " from BB_CONTENT1 " 
				+ " where bbbh = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbbh);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfdbxm(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));	
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 
	 
	
	
	/**
	 * 根据报备编号得到对象的方法
	 * @param bbbh
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableBybbbhAndState(String bbbh) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4," 
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,"
				+ " ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword,bbperson,bbtime,bbstate,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,attachfileId,syskhlx," +
						"isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount " 
				+ " from BB_CONTENT1 " 
				+ " where bbbh = ? and bbstate = '报备完成' ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbbh);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfbz(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));
				 
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 
	
	
	
	/**
	 * 得到报备状态
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public String viewIsReviewed(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String isreviewed = "";
		try {
			sql = " select isreviewed from bb_content1 where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			rs = ps.executeQuery();
			if(rs.next()){
				isreviewed = rs.getString(1);
			}
			return isreviewed;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return isreviewed;
	}
	
	
	/**
	 * 根据报备编号得到报备状态
	 * @param bbbh
	 * @return
	 * @throws Exception
	 */
	public String getStateByBbbh(String bbbh) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String state = "";
		try {
			sql = " select bbstate from bb_content1 where bbbh = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,bbbh);
			rs = ps.executeQuery();
			if(rs.next()){
				state = rs.getString(1);
			}
			return state;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return state;
	}
	
	
	/**
	 * 根据 guid 得到报备状态
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public String getStateByGuid(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String state = "";
		try {
			sql = " select bbstate from bb_content1 where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			rs = ps.executeQuery();
			if(rs.next()){
				state = rs.getString(1);
			}
			return state;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return state;
	}
	
	/**
	 * 根据报备编号得到报备状态
	 * @param bbbh
	 * @return
	 * @throws Exception
	 */
	public String getStateByBbbhAndBbperson(String bbbh,String bbPerson) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String state = "";
		try {
			sql = " select bbstate from bb_content1 where bbbh = ? and bbPerson = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,bbbh);
			ps.setString(2,bbPerson);
			rs = ps.executeQuery();
			if(rs.next()){
				state = rs.getString(1);
			}
			return state;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return state;
	}
	
	
	/**
	 * 根据报备编号和业务所在地得到对象的方法
	 * @param bbbh
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableBybbbhAndYwarea(String bbbh,String ywarea) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4," 
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,"
				+ " ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword,bbperson,bbtime,bbstate,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,"
				+ " attachfileId,syskhlx,isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount "
				+ " from BB_CONTENT1 " 
				+ " where bbbh = ? and ywarea=? order by bbtime desc ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbbh);
			ps.setString(2, ywarea);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfdbxm(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));
				 
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 
	
	
	/**
	 * 根据报备编号和业务所在地和状态得到对象的方法
	 * @param bbbh
	 * @return
	 * @throws Exception
	 */
	public ContentTable getContentTableBybbbhAndYwareaAndBbstate(String bbbh,String ywarea) throws Exception{
		ContentTable ct = new ContentTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select companyGUID,GUID,Typeid,wtdwmc,bsdwmc,khczlx,khjjxj,kmhylx,sfssqy,yyzzhm,"
				+ "	zcdz,zczbbz,bsdwzczb,fzrmc,lxrxm,lxrdh,wtxmlx,ywyds,qyrq,bgwh,"
				+ "	xmmc,bgrq,bgnd,bgnd2,fcbgfs,qmzyszl,qmzs1,qmzs2,qmzs3,qmzs4," 
				+ " qmzs5,qmzs6,cpa1,cpa2,cpa3,cpa4,cpa5,cpa6,zlry,sfyj,"
				+ " ysywf,ysywfed,kjskdfphd,sfrq,sfsm,leaveword,bbperson,bbtime,bbstate,bbbh," 
				+ " ywarea,bz,linkman,linkphone,sfbz,xmkhlx,kjskdfphd2,zdsfbzje,sflkh,lastUpdateTime," 
				+ " ysywfedUpdateTime,kjskdfphd2UpdateTime,baogaoniandu,isnexts,attachfileId,syskhlx," +
						"isoverflow,isPack,packName,qtcyzs,qtcpa,sfztb,discount " 
				+ " from BB_CONTENT1 where bbbh = ? and ywarea=? and bbState!='暂存' and bbstate != '申请审核' " 
				+ " and bbstate != '审核通过' and bbstate != '审核未通过' and bbstate != '初审通过' ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbbh);
			ps.setString(2, ywarea);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 ct.setCompanyGUID(rs.getString(i++));
				 ct.setGuid(rs.getString(i++));
				 ct.setTypeid(rs.getString(i++));
				 ct.setWtdwmc(rs.getString(i++));
				 ct.setBsdwmc(rs.getString(i++));
				 ct.setKhczlx(rs.getString(i++));
				 ct.setKhjjxj(rs.getString(i++));
				 ct.setKmhylx(rs.getString(i++));
				 ct.setSfssqy(rs.getString(i++));
				 ct.setYyzzhm(rs.getString(i++));
				 
				 ct.setZcdz(rs.getString(i++));
				 ct.setZczbbz(rs.getString(i++));
				 ct.setBsdwzczb(rs.getString(i++));
				 ct.setFzrmc(rs.getString(i++));
				 ct.setLxrxm(rs.getString(i++));
				 ct.setLxrdh(rs.getString(i++));
				 ct.setWtxmlx(rs.getString(i++));
				 ct.setYwyds(rs.getString(i++));
				 ct.setQyrq(rs.getString(i++));
				 ct.setBgwh(rs.getString(i++));
				 
				 ct.setXmmc(rs.getString(i++));
				 ct.setBgrq(rs.getString(i++));
				 ct.setBgnd(rs.getString(i++));
				 ct.setBgnd2(rs.getString(i++));
				 ct.setFcbgfs(rs.getString(i++));
				 ct.setQmzyszl(rs.getString(i++));
				 ct.setQmzs1(rs.getString(i++));
				 ct.setQmzs2(rs.getString(i++));
				 ct.setQmzs3(rs.getString(i++));
				 ct.setQmzs4(rs.getString(i++));
				 
				 ct.setQmzs5(rs.getString(i++));
				 ct.setQmzs6(rs.getString(i++));
				 ct.setCpa1(rs.getString(i++));
				 ct.setCpa2(rs.getString(i++));
				 ct.setCpa3(rs.getString(i++));
				 ct.setCpa4(rs.getString(i++));
				 ct.setCpa5(rs.getString(i++));
				 ct.setCpa6(rs.getString(i++));
				 ct.setZlry(rs.getString(i++));
				 ct.setSfyj(rs.getString(i++));
				 
				 ct.setYsywf(rs.getString(i++));
				 ct.setYsywfed(rs.getString(i++));
				 ct.setKjskdfphd(rs.getString(i++));
				 ct.setSfrq(rs.getString(i++));
				 ct.setSfsm(rs.getString(i++));
				 ct.setLeaveword(rs.getString(i++));
				 ct.setBbperson(rs.getString(i++));
				 ct.setBbtime(rs.getString(i++));
				 ct.setBbstate(rs.getString(i++));
				 ct.setBbbh(rs.getString(i++));
				 
				 ct.setYwarea(rs.getString(i++));
				 ct.setBz(rs.getString(i++));
				 ct.setLinkman(rs.getString(i++));
				 ct.setLinkphone(rs.getString(i++));
				 ct.setSfbz(rs.getString(i++));
				 ct.setXmkhlx(rs.getString(i++));
				 ct.setKjskdfphd2(rs.getString(i++));
				 ct.setZdsfbzje(rs.getString(i++));
				 ct.setSflkh(rs.getString(i++));
				 ct.setLastUpdateTime(rs.getString(i++));
				 
				 ct.setYsywfedUpdateTime(rs.getString(i++));
				 ct.setKjskdfphd2UpdateTime(rs.getString(i++));
				 ct.setBaogaoniandu(rs.getString(i++));
				 ct.setIsnexts(rs.getString(i++));
				 ct.setAttachfileId(rs.getString(i++));
				 ct.setSyskhlx(rs.getString(i++));
				 ct.setIsoverflow(rs.getString(i++));
				 ct.setSfdbxm(rs.getString(i++));
				 ct.setDbxmmc(rs.getString(i++));
				 ct.setQtcyzs(rs.getString(i++));
				 ct.setQtcpa(rs.getString(i++));
				 ct.setSfztb(rs.getString(i++));
				 ct.setDiscountBySeven(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ct;
	} 
	 
	
	/**
	 * 得到报备数据信息
	 * @param ctguid
	 * @param tabName
	 * @return
	 * @throws Exception
	 */
	public Map getBBInfo(String ctguid,String tabName) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String temp = "";
		try {
			Map map = new HashMap();
			
			Map fieldMap = new HashMap();
			
			sql = " select *,ct.companyguid as cltguid,ct.guid as ctguid from bb_content1 ct "
				+ " left join bb_companylist clt on ct.companyguid = clt.guid "
				+ " left join "+tabName+" temp on ct.guid = temp.guid "
				+ " where ct.guid = ? ";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, ctguid);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					temp = rs.getObject(RSMD.getColumnName(i))+"";
//					if(temp.length()>=2){
//						// 字段类型 为 money 类型的特殊处理
//						if("00".equals(temp.substring(temp.length()-2, temp.length()))){
//							map.put(RSMD.getColumnName(i).toLowerCase() , temp.substring(0, temp.length()-2));
//						}else{
//							map.put(RSMD.getColumnName(i).toLowerCase() , temp);
//						}
//					}else{
//						map.put(RSMD.getColumnName(i).toLowerCase() , temp);
//					}
					
					map.put(RSMD.getColumnName(i).toLowerCase() , temp);
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
	
	/**
	 * 得到要比较的报备字段
	 * @param tabName
	 * @return
	 * @throws Exception
	 */
	public Map getBBField(String tabName) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			Map fieldMap = new HashMap();
			sql = " select fieldName from s_meaning " 
				+ " where ( tableName = 'bb_companylist' or tableName = 'bb_content1' or tableName = ? ) and readonly = '0' ";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, tabName);
	        rs = ps.executeQuery();
			while(rs.next()){
				fieldMap.put(rs.getString(1),rs.getString(1));
			}
			System.out.println(this.getClass()+"      getBBField（）         fieldMap.size()="+fieldMap.size());
	        return fieldMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 得到报备字段中文名称
	 * @param fieldName
	 * @param tabName
	 * @return
	 * @throws Exception
	 */
	public String getBBFieldChineseName(String fieldName,String tabName) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String bbFieldchineseName = "";
		try {
			sql = " select fieldmean from s_meaning where fieldname = ? and (tablename = ? or tablename = 'bb_companylist' or tablename = 'bb_content1' ) ";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, fieldName);
	        ps.setString(2, tabName);
	        
	        rs = ps.executeQuery();
			if(rs.next()){
				bbFieldchineseName = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return bbFieldchineseName;
	}
	
	
	/**
	 * 增加
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void addBBInfoHistory(Map map) throws Exception{
		
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			sql = " insert into BB_InfoChange( "
				+ " id,bbid,bbtype,changefield,beforevalue,nowvalue, "
				+ " loginid,loginname,changetime,changereason,initflag,timeflag ) "
				+ " values(?,?,?,?,?,?, ?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			ps.setString(i++, (String)map.get("id"));
			ps.setString(i++, (String)map.get("bbid"));
			ps.setString(i++, (String)map.get("bbtype"));
			ps.setString(i++, (String)map.get("changefield"));
			ps.setString(i++, (String)map.get("beforevalue"));
			ps.setString(i++, (String)map.get("nowvalue"));
			
			ps.setString(i++, (String)map.get("loginid"));
			ps.setString(i++, (String)map.get("loginname"));
			ps.setString(i++, (String)map.get("changetime"));
		    ps.setString(i++, (String)map.get("changereason"));
			ps.setString(i++, (String)map.get("initflag"));
			ps.setString(i++, (String)map.get("timeflag"));
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("执行 insert into 出错  sql:"+sql+"   info:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 生成四位随机数
	 * @return
	 */
	public String getRandom(){
		String random = "";
		double drm = Math.random() * 10000;
		int irm = (int)drm;
		if(String.valueOf(irm).length()!=4){
			String currentTimeMillis = System.currentTimeMillis()+"";
			random = currentTimeMillis.substring(currentTimeMillis.length()-4,currentTimeMillis.length());
		}else{
			random = irm+"";
		}
		
		return random;
	}
	
	/**
	 * 根据 sql 返回 Map 列
	 * @param sql
	 * @return
	 */
	public Map getMapInfoBySql(String sql){
		Map map = new HashMap();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					map.put(rsmd.getColumnName(i).toLowerCase(),rs.getString(rsmd.getColumnName(i)));
					System.out.println(rsmd.getColumnName(i).toLowerCase()+"||||"+rs.getString(rsmd.getColumnName(i)));
				}
			}
			
		} catch (SQLException e) {
			System.out.println(" 出错的 sql = "+sql);
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return map;
	}
	
	private String getCPANOString(String qtcyzs, String officecode) throws Exception {
		StringBuffer qtcpa = new StringBuffer();
		String[] arr = StringUtil.showNull(qtcyzs).split(",");
		if(arr.length>0){
			for (int i = 0; i < arr.length; i++) {
				qtcpa.append(getCpanobyName(arr[i],officecode)).append(",");
			}
		}
		return qtcpa.substring(0,qtcpa.length()-1);
	}
}