package cn.org.gdicpa.web.service.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.question.model.Answer;
import cn.org.gdicpa.web.service.question.model.Question;
import cn.org.gdicpa.web.service.template.model.Template;
import cn.org.gdicpa.web.service.template.model.TemplateAsk;

public class TemplateService {
	
private Connection conn = null ;
	
	public TemplateService(Connection conn) {
		this.conn = conn ;
	}
	
	public void add(Template template) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "insert into p_template(id,title,description,userId,publishDate,mark,property) values(?,?,?,?, ?,?,?) " ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,template.getId()) ;
			ps.setString(2,template.getTitle()) ;
			ps.setString(3,template.getDesc()) ;
			ps.setString(4,template.getUserId()) ;
			ps.setString(5,template.getPublishDate()) ;
			ps.setString(6,template.getMark()) ;
			ps.setString(7,template.getProperty()) ;
			ps.execute() ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	public Template getTemplate(String id) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select id,title,description,b.loginname,publishDate,mark,property from p_template a left join k_user b " 
					   +" on a.userId = b.loginid where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			Template template = new Template() ;
			if(rs.next()) {
				template.setId(rs.getString(1)) ;
				template.setTitle(rs.getString(2)) ;
				template.setDesc(rs.getString(3)) ;
				template.setUserId(rs.getString(4));
				template.setPublishDate(rs.getString(5)) ;
				template.setMark(rs.getString(6)) ;
				template.setProperty(rs.getString(7)) ;
			}
			return template ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	public void addAsk(TemplateAsk ta) {
		PreparedStatement ps = null ;
		try {
			String sql = "insert into p_templateAsk(id,templateId,askContent,userId,askDate,notShow,property) values(?,?,?,?, ?,?,?) " ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,ta.getId()) ;
			ps.setString(2,ta.getTemplateId()) ;
			ps.setString(3,ta.getAskContent()) ;
			ps.setString(4,ta.getUserId()) ;
			ps.setString(5,ta.getAskDate()) ;
			ps.setString(6,ta.getNotShow()) ;
			ps.setString(7,ta.getProperty()) ;
			ps.execute() ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	public List<TemplateAsk> getAsk(String templateId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<TemplateAsk> list = new ArrayList<TemplateAsk>();
		try {
			String sql = "select id,templateId,askContent,b.loginname,askDate,notShow,property" +
						" from p_templateAsk a left join k_user b on a.userId = b.loginId where templateId=? order by askDate asc,id desc" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,templateId) ;
			rs = ps.executeQuery() ;
			
			while(rs.next()) {
				TemplateAsk ask = new TemplateAsk() ;
				ask.setId(rs.getString(1)) ;
				ask.setTemplateId(rs.getString(2)) ;
				ask.setAskContent(rs.getString(3)) ;
				ask.setUserId(rs.getString(4)) ;
				ask.setAskDate(rs.getString(5)) ;
				ask.setNotShow(rs.getString(6)) ;
				ask.setProperty(rs.getString(7)) ;
				list.add(ask) ;
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
