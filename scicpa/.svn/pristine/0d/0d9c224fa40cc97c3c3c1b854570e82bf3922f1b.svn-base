package cn.org.gdicpa.web.service.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.course.model.Course;

public class CourseService {
	
	Connection conn = null ;
	
	public CourseService(Connection conn) {
		this.conn =  conn ;
	}
	
	public Course getCourse(String id) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select id,title,pubdate,b.loginname,teacher,video,content,outline,description,property from k_course a left join k_user b " 
					   +" on a.userId = b.loginid where id=?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			rs = ps.executeQuery() ;
			Course course = new Course();
			if(rs.next()) {
				course.setId(rs.getString(1)) ;
				course.setTitle(rs.getString(2));
				course.setPubdate(rs.getString(3)) ;
				course.setUserId(rs.getString(4)) ;
				course.setTeacher(rs.getString(5)) ;
				course.setVideo(rs.getString(6)) ;
				course.setContent(rs.getString(7));
				course.setOutline(rs.getString(8)) ;
				course.setDescription(rs.getString(9)) ;
				course.setProperty(rs.getString(10)) ;
			}
			return course ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
	
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
	}

}
