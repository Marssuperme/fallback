package cn.org.gdicpa.web.pub.autocode;

import java.sql.*;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.autocode.model.AutocodeTable;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.Debug;
/**
 *
 * <p>Title:自动生成编码的通用类
 * 需要数据库表的支持;
 * 参数支持的包括
 * ${1}、${1F}、${2}、${2F}、${3}、${3F}
 * ${OWNER}、${CURYEAR}、${EXT1}、${EXT2}、${EXT3}
 *  </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class DELAutocode {

  private final String TABLENAME = "k_autocode";
  private String ST_ATYPE = "";// 编号种类
  private String ST_OWNER = "";// 使用者

  private AutocodeTable UVO_CUR_AC = null;//当前执行了getSeries_asc1 之后的数据库表记录的UVO

  private int[] INT_SER_LENGTH = new int[]{0,0,0};    //显示执行了getSeries_asc1之后的长度数组,就是SERNUM1_LEN, SERNUM2_LEN SERNUM3_LEN

  public DELAutocode() {
  }

  /**
   * @return 当前执行了setSeries后的UVO
   *（注意：必须在getSeries_asc1执行之后调用才有效）
   */
  public AutocodeTable getCurSeriesUVO(){
    return this.UVO_CUR_AC;
  }

  /**
   * @return 当前执行了setSeries后的显示长度SERNUM1_LEN
   *（注意：必须在getSeries_asc1执行之后调用才有效）
   */
  public int[] getCurSeriesShowLen(){
    return this.INT_SER_LENGTH;
  }

  /**
   * 查看指定种类与使用者的当前值
   * @param Atype  编号种类
   * @param Owner  使用者
   * @return 一个S_AUTOCODE的UVO
   * @throws Exception
   */
  public AutocodeTable peekCurrentSeries(String Atype,String Owner) throws Exception{

    if (Atype == null)
      Atype = "";
    if (Owner == null)
      Owner = "";
    if (Atype.equals(""))
      throw new Exception("没有指定编号种类");
    if (Owner.equals(""))
      Owner = "all"; //default is all (大家都用的)

    String sql = "select * from " + TABLENAME + " where atype='" + Atype
        + "' and aowner='" + Owner + "';";
System.out.println(" sql  " + sql);
    AutocodeTable act = new AutocodeTable();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = new DBConnect().getConnect();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
System.out.println(" rs  " + rs);
      if (rs.next()) {

        act.setId(rs.getInt("id"));
        act.setAowner(rs.getString("aowner"));
        act.setAtype(rs.getString("atype"));
        act.setCurnum1(rs.getInt("curnum1"));
        act.setCurnum2(rs.getInt("curnum2"));
        act.setCurnum3(rs.getInt("curnum3"));
        act.setShowlen1(rs.getInt("showlen1"));
        act.setShowlen2(rs.getInt("showlen2"));
        act.setShowlen3(rs.getInt("showlen3"));
        act.setFormat(rs.getString("format"));
        act.setBusinesssum(rs.getString("businesssum"));
        act.setIsonly(rs.getString("isonly"));
        act.setAtime(rs.getString("atime"));
      }
    }
    catch (Exception dbe) {
      dbe.printStackTrace();
      throw new Exception("DB Exception at DELUniAutoCode.peekCurrentSeries",
                          dbe);
    }finally {
		//2006-11-07 void
    	try {
    		if(rs != null)
        		rs.close();
    		if(ps != null)
    			ps.close();
    		if(conn != null)
    			conn.close();
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}

	} // end try~catch~finally

    return act;
  }

  /**
   * 得到指定种类与使用者的自加1的值, 并更新数据表
   * 注：如果 为小于0的值则为不使用的值，仍返回但不加一
   * @param Atype  编号种类
   * @param Owner  使用者
   * @return S_AUTOCODE表中的 CUR_SERNUM1、CUR_SERNUM2、CUR_SERNUM3组成的int[]数组
   * @throws Exception
   */
  public int[] getSeries_asc1(String Atype,String Owner)throws Exception{
    if(Atype == null) Atype = "";
    if(Owner == null) Owner = "";
    if(Atype.trim().equals("")) throw new Exception("没有指定编号种类");
    if(Owner.trim().equals("")) Owner = "all";//default is all (大家都用的)

    AutocodeTable uvo_AC =  this.peekCurrentSeries(Atype,Owner);
    this.UVO_CUR_AC = uvo_AC;
    if(uvo_AC == null){
      throw new Exception("还没有配置种类为["+Atype+"]的自动编号策略");
    }
//System.err.println(">>>" + uvo_AC);
    int ai[] = new int[]{-1,-1,-1};

    ai[0] = uvo_AC.getCurnum1();
    ai[1] = uvo_AC.getCurnum2();
    ai[2] = uvo_AC.getCurnum3();

    if(ai[0] >= 0){
      ai[0] = ai[0] + 1;
    }
    if(ai[1] >= 0){
      ai[1] = ai[1] + 1;
    }
    if(ai[2] >= 0){
      ai[2] = ai[2] + 1;
    }

    this.setSeries(Atype,Owner,ai);
    if(this.UVO_CUR_AC != null){
      this.UVO_CUR_AC.setCurnum1(ai[0]);
      this.UVO_CUR_AC.setCurnum2(ai[1]);
      this.UVO_CUR_AC.setCurnum3(ai[2]);

      this.INT_SER_LENGTH[0] = uvo_AC.getShowlen1();
      this.INT_SER_LENGTH[1] = uvo_AC.getShowlen2();
      this.INT_SER_LENGTH[2] = uvo_AC.getShowlen3();

    }
    return ai;
  }

  /**
   * 得到自动编号字符串
   * @param aType 编号类型
   * @param owner 编号所有者
   * @return 系统生成的自动编号
   * @throws Exception
   */
  public String getAutoCode(String aType,String owner)throws Exception{
    return getAutoCode(aType, owner, null);
  }

  /**
   * 得到自动编号字符串
   * @param aType 编号类型
   * @param owner 编号所有者
   * @param exts 扩展输入信息
   * @return 系统生成的自动编号
   * @throws Exception
   */
  public synchronized  String getAutoCode(String aType,String owner, String []exts)throws Exception{
    /**
     * 检查输入参数的合法性
     */
    if ( aType == null || aType.trim().equals("") ) {
      throw new Exception("没有指定编号种类");
    }
    if ( owner == null || owner.trim().equals("") ) {
      /**
       * 默认为所有人
       */
      owner = "all";
    }
    
    // 清零设置
    this.clearReset(aType, owner);

    /**
     * 取字段编号配置
     */
    AutocodeTable uvoAutoCode =  this.peekCurrentSeries(aType,owner);
    this.UVO_CUR_AC = uvoAutoCode;
    if(uvoAutoCode == null){
      throw new Exception("还没有配置种类为["+aType+"],所有者为["+owner+"]的自动编号策略");
    }

    
    /**
     * 当前值,并+1
     */
    int ai[] = new int[]{-1,-1,-1};
    ai[0] = uvoAutoCode.getCurnum1();
    ai[1] = uvoAutoCode.getCurnum2();
    ai[2] = uvoAutoCode.getCurnum3();

    int codeLen[] = new int[]{-1,-1,-1};
    codeLen[0] = uvoAutoCode.getShowlen1();
    codeLen[1] = uvoAutoCode.getShowlen2();
    codeLen[2] = uvoAutoCode.getShowlen3();

    /**
     * 取配置字符串,使用MEMO字段
     */
    String strConf = uvoAutoCode.getFormat();

    /**
     * 解析配置字符串,替换变量,系统支持的变量包括-------
     */
    String strResult = "";
    int oldIdx = 0;
    int idx = strConf.indexOf("${");
    while ( idx >= 0 ) {
      String env = getEnv(strConf.substring(idx));
      strResult += strConf.substring(oldIdx, idx);
      if ( env.equals("1") ) {
        /**
         * 第一个数值
         */
        ai[0] = ai[0] + 1;
        strResult += ai[0];
      } else if ( env.startsWith("1F") ) {
        /**
         * 第一个数值,如果长度不足,则补足长度
         */
        ai[0] = ai[0] + 1;
        char fc = '0';
        if ( env.length() >= 3 ) {
          fc = env.charAt(2);
        }
        strResult += fillChar(ai[0], codeLen[0], fc);
      } else if ( env.equals("2") ) {
        /**
         * 第二个数值
         */
        ai[1] = ai[1] + 1;
        strResult += ai[1];
      } else if ( env.startsWith("2F") ) {
        /**
         * 第二个数值,如果长度不足,则补足长度
         */
        ai[1] = ai[1] + 1;
        char fc = '0';
        if ( env.length() >= 3 ) {
          fc = env.charAt(2);
        }
        strResult += fillChar(ai[1], codeLen[1], fc);
      } else if ( env.equals("3") ) {
        /**
         * 第三个数值
         */
        ai[2] = ai[2] + 1;
        strResult += ai[2];
      } else if ( env.startsWith("3F") ) {
        /**
         * 第三个数值,如果长度不足,则补足长度
         */
        ai[2] = ai[2] + 1;
        char fc = '0';
        if ( env.length() >= 3 ) {
          fc = env.charAt(2);
        }
        strResult += fillChar(ai[2], codeLen[2], fc);
      } else if ( env.equals("OWNER") ) {
        /**
         * 所有者
         */
        strResult += owner;
      } else if ( env.equals("CURYEAR") ) {
        /**
         * 当前年份
         */
        String strDate =ASFuntion.getToday();
        strDate = strDate.substring(0, 4);
        strResult += strDate;
      } else if ( env.equals("CURMONTH") ) {
          /**
           * 当前月份
           */
          String strDate =ASFuntion.getToday();
          strDate = strDate.substring(5, 7);
          strResult += strDate;
       } else if ( env.startsWith("EXT") ) {
        String extNum = "1";
        if ( env.length() > 3 ) {
          extNum = env.substring(3);
        }
        int iExtNum = (new Integer(extNum)).intValue();
        if ( exts == null || iExtNum > exts.length ) {
          throw new Exception("自动编号配置错误,扩展信息长度非法["+strConf+"]");
        }
        String strExt = exts[iExtNum-1];
        if ( strExt == null ) {
          strExt = "";
        }
        strResult += strExt;
      }

      oldIdx = idx + 2 + env.length() + 1;
      idx = strConf.indexOf("${", oldIdx);
    }
    strResult += strConf.substring(oldIdx);

    /**
     * 更新自动编号
     */
    this.setSeries(aType,owner,ai);
    
    
    if(this.UVO_CUR_AC != null){


      this.UVO_CUR_AC.setCurnum1(ai[0]);
      this.UVO_CUR_AC.setCurnum2(ai[1]);
      this.UVO_CUR_AC.setCurnum3(ai[2]);

      this.INT_SER_LENGTH[0] = UVO_CUR_AC.getShowlen1();
      this.INT_SER_LENGTH[1] = UVO_CUR_AC.getShowlen2();
      this.INT_SER_LENGTH[2] = UVO_CUR_AC.getShowlen3();

    }

    return strResult;
  }

  /**
   * 取变量,格式为${ENV_NAME}
   * @param str 输入字符串
   * @return
   */
  private String getEnv(String str) {
    int index = str.indexOf("}");
    return str.substring(2, index);
  }

  /**
   * 设置指定种类与使用者的当前值
   * @param Atype  编号种类
   * @param Owner  使用者
   * @param ai     S_AUTOCODE表中的 CUR_SERNUM1、CUR_SERNUM2、CUR_SERNUM3组成的int[]数组
   * @throws Exception
   */
  private void  setSeries(String Atype,String Owner,int[] ai)throws Exception{
    if(Atype == null) Atype = "";
    if(Owner == null) Owner = "";
    if(ai == null)  throw new Exception("没有指定值");
    if(ai.length <= 0) throw new Exception("没有指定值");
    if(Atype.trim().equals("")) throw new Exception("没有指定编号种类");
    if(Owner.trim().equals("")) Owner = "all";//default is all (大家都用的)


    String sql = "update " + TABLENAME + " set atype='"+Atype+"' ";
    if (ai.length >= 1) {
      sql += ", curnum1=" + ai[0];
    }
    if (ai.length >= 2) {
      sql += ", curnum2=" + ai[1];
    }
    if (ai.length >= 3) {
      sql += ", curnum3=" + ai[2];
    }
    if (ai.length>=1){
      if (Owner.equals(""))
        Owner = "all"; //default is all (大家都用的)

      sql+=  " where atype='" + Atype  + "' and aowner='" + Owner + "';";

      Debug.print(sql);

      Connection conn = null;
      PreparedStatement ps = null;

      try {
    	  conn = new DBConnect().getConnect();
          ps = conn.prepareStatement(sql);
          ps.execute();
      }catch(Exception e) {
    	  e.printStackTrace();
      }finally {
		//2006-11-07 void
		try {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
      } // end try~catch~finally
    }
  }


  public String fillChar(int values,int len,char fchar,char aorb)throws Exception{
    String st_temp = "";
    int int_len = -1;
    st_temp = st_temp.valueOf(values);
    int_len = st_temp.length();
    if(len < int_len) throw new Exception("编码已经超过了长度限制,请与系统管理员联系");
    for(int i=1;i<=len-int_len;i++){
      if(aorb == 'a'){   //after
        st_temp = fchar + st_temp;
      }else if(aorb == 'b'){//before
        st_temp = st_temp + fchar;
      }

    }
    return st_temp;
  }

  public String fillChar(int values, int len, char fchar) throws Exception {
    return this.fillChar(values, len, fchar, 'a');
  }

  public static void   main(String[] para) {
    DELAutocode t = new DELAutocode();
    try{
      String ai[] = new String[]{"泉商行","贷","合同"};

      System.err.println(t.getAutoCode("KHDH","",ai));
      System.err.println(t.getAutoCode("XMBH",""));

    }catch(Exception e){
        e.printStackTrace();
    }finally{
    }

  }
  
  /**
   * 清零设置
   * @param aType
   * @param owner
 * @throws Exception 
   */
  private void clearReset(String aType,String owner) throws Exception{
	  AutocodeTable at = this.peekCurrentSeries(aType,owner);
	  String now = ASFuntion.getToday();
	  String sql = "";
	  String atimeYear = "";
	  if(new ASFuntion().showNull(at.getAtime()).length()>8){
		  atimeYear = at.getAtime().substring(0, 4); 
	  }
	  String atimeMonth = "";
	  if(new ASFuntion().showNull(at.getAtime()).length()>8){
		  atimeMonth = at.getAtime().substring(5, 7);
	  }
	  String nowYear = now.substring(0, 4);
	  String nowMonth = now.substring(5, 7);
	  
	  int flag = 0;
	  // 跨年份
	  if(!atimeYear.equals(nowYear)){
		  flag = 1;
	  }
	  // 跨月份
	  if(!atimeMonth.equals(nowMonth)){
		  flag = 1;
	  }
	  if(flag == 1){
		  if("广州".equals(owner)){	// 因为广州 和 省注协 这边报备编号生成规则一样所以让出500000之前的位置出来
			  sql = " update k_autocode set curnum1 = 500000,atime=? where aowner = ? and atype = ? ";
		  }else{
			  sql = " update k_autocode set curnum1 = 0,atime=? where aowner = ? and atype = ? ";
		  }
		  Connection conn = null;
	      PreparedStatement ps = null;
		  try {
	    	  conn = new DBConnect().getConnect();
	          ps = conn.prepareStatement(sql);
	          ps.setString(1, ASFuntion.getToday());
	          ps.setString(2, owner);
	          ps.setString(3, aType);
	          ps.execute();
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
	      }  
	  }
  }
  
}
