package cn.org.gdicpa.web.pub.datagrid;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.util.StringUtil;

//用来存储sql的变量的值
public class SqlWhereVariable {
	private String sentence = null;

	private HashMap defaultValues = new HashMap();

	//	private HashMap sessionName=new HashMap();

	public SqlWhereVariable(String sentence) {
		this.sentence = sentence;
	}

	public String getDefaultValue(String key) {
		return (String) this.defaultValues.get(key);
	}

	public SqlWhereVariable setDefaultValue(String key, String defaultValue) {
		this.defaultValues.put(key, defaultValue);
		return this;
	}

	//	public String getSessionName(String key) {
	//		return (String)this.sessionName.get(key);
	//	}
	//	public SqlWhereVariable setSessionName(String key,String SessionName) {
	//		this.sessionName.put(key, SessionName) ;
	//		return this;
	//	}

	//得到替换变量后的sql where sentenct
	public String getSentence(javax.servlet.http.HttpSession session,
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response,
			Writer out, Map sqlVariableScript,
			String sqlVariableXML) {

		String[] sqlVariables = StringUtil.getVaribles(this.sentence);
		String sqlVariable = "";

		String result = this.sentence;

		for (int i = 0; i < sqlVariables.length; i++) {

			sqlVariable = this.getXMLData(sqlVariableXML, sqlVariables[i]);

			if ("".equals(sqlVariable)) {
				sqlVariable = this.getDefaultValue(sqlVariables[i]);
			}

			//			使用map的原因是不会出现重复的key
			//			sqlVariableScript.put(sqlVariables[i], sqlVariable);

			if (sqlVariable == null) {
				//如果有一个变量找不到任何可用的值。那么这句sqlWhere就不会出现
				result = "";
				sqlVariable = "";
			}
			result = result.replaceAll("\\$\\{" + sqlVariables[i] + "\\}",
					sqlVariable);

		}

		return result;
	}

	public SqlWhereVariable setSentence(String sentence) {
		this.sentence = sentence;
		return this;
	}

	public String getSourceSentence() {
		return sentence;
	}

	public final String showNull(String str) {
		if (str == null) {
			str = "";
		}
		return str;
	}

	public String getXMLData(String XML, String name) {
		try {
			if (XML == null || name == null) {
				return "";
			}
			int len = XML.length();
			int len1 = name.length();
			int i = XML.indexOf("<" + name + ">");
			if (i >= 0) {
				int j = XML.indexOf("</" + name + ">");
				if (j >= 0) {
					return (XML.substring(i + len1 + 2, j).trim());
				}
				return "";
			}
			return "";
		} catch (Exception e) {
			return "";
		}
	}

}
