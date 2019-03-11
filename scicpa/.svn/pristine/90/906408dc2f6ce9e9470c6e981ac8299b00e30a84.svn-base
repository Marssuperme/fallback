package cn.org.gdicpa.web.service.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.exam.model.Paper;
import cn.org.gdicpa.web.service.exam.model.Question;

public class ExamService {

	private Connection conn = null;

	public ExamService(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 初始化学生考试试卷
	 * 
	 * @param paperid
	 * @throws Exception
	 */
	public String addFromPaper(String userid, String paperid)
			throws Exception {
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null ;
		try {
			String sql = "select id from k_exam where userid=? and paperid=?";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,userid) ;
			ps.setString(2,paperid) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				//有试卷则返回试卷信息
				return rs.getString(1) ;
			}else {
				String uuid  =  UUID.randomUUID().toString();
				sql = "insert into k_exam(id,paperId,courseId,userId,title,totaltime,ip,state) " 
						   + " select '"+uuid+"',id,courseId,'"+userid+"',title,totaltime,'"+2+"',state from k_paper where id = ?" ;
				
				String sql2 = " insert into k_exam_detail(id,examId,questionId,userid,sequence,cType,question,options,answer,knowledge,difficulty,userAnswer,score,userScore) \n"
						+ " select NEWID(),'"
						+ uuid
						+ "',questionid,'"
						+ userid
						+ "',sequence,cType,question,options,answer,knowledge,difficulty,'','','' \n"
						+ " from k_paper_detail where paperid='" + paperid + "'";
				
				
					ps = conn.prepareStatement(sql);
					ps.setString(1,paperid) ;
					ps.execute();
					
					ps = conn.prepareStatement(sql2) ;
					ps.execute() ;
					return uuid;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
		return "";
	}
	
	public Paper getRandomPaperByCourseId(String courseId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select top 1 id,title,totaltime,totalScore from k_paper where courseid=? order by NEWID() " ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,courseId) ;
			rs = ps.executeQuery();
			if(rs.next()) {
				Paper paper = new Paper();
				paper.setId(rs.getString(1)) ;
				paper.setTitle(rs.getString(2)) ;
				paper.setTotaltime(rs.getString(3)) ;
				return paper;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
		return null;
	}
	
	public List getExamDetails(String examId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<Question> singleList = new ArrayList<Question>(); //单选题
		List<Question> multiList = new ArrayList<Question>(); //多选题
		List<Question> judgeList = new ArrayList<Question>(); //判断题
		List<Question> fillList = new ArrayList<Question>(); //填空题
		List<Question> qaList = new ArrayList<Question>(); //问答题
		List<List> examList = new ArrayList<List>();
		try {
			String sql = "select id,ctype,Sequence,question,score,options,answer,knowledge,notes,userAnswer from k_exam_detail where examId=? order by ctype,Sequence" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,examId) ;
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String ctype = rs.getString(2) ;
				Question question = new Question();
				question.setId(id);
				question.setSequence(rs.getString(3)) ;
				question.setQuestion(rs.getString(4)) ;
				question.setScore(rs.getString(5)) ;
				String options = rs.getString(6) ;
				question.setAnswer(rs.getString(7)) ;
				question.setKnowledge(rs.getString(8)) ;
				question.setNotes(rs.getString(9)) ;
				String userAnswer = rs.getString(10) ;
				question.setUserAnswer(userAnswer) ;
				question.setCtype(ctype) ;
				if("单选题".equals(ctype)) {
					String[] optArr = options.split("~`~`") ;
					String opts = "";
					String check = "";
					for(String opt:optArr) {
						if(opt.equals(userAnswer)) {
							check = "checked=\"checked\"" ;
						}
						opts += "<input type=\"radio\" "+check+" value=\""+opt+"\" id=\""+id+"\" name=\""+id+"\">"+opt+"<br>" ;
					}
					question.setOptions(opts);
					singleList.add(question) ;
				}else if("多选题".equals(ctype)) {
					String[] optArr = options.split("~`~`") ;
					String opts = "";
					String check = "";
					for(String opt:optArr) {
						if(userAnswer.indexOf(opt) > 0 || userAnswer.equals(opt)) {
							check = "checked=\"checked\"" ;
						}else {
							check = "" ;
						}
						opts += "<input type=\"checkbox\" "+check+" value=\""+opt+"\" id=\""+id+"\" name=\""+id+"\">"+opt+"<br>" ;
					}
					question.setOptions(opts);
					multiList.add(question) ;
				}else if("判断题".equals(ctype)) {
					judgeList.add(question) ;
				}else if("填空题".equals(ctype)) {
					fillList.add(question) ;
				}else {
					qaList.add(question) ;
				}
			}
			examList.add(singleList);
			examList.add(multiList);
			examList.add(judgeList);
			examList.add(fillList);
			examList.add(qaList);
			return examList ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
		return null;
	}
	
	public void updateUserAnswer(String id,String answer) {
		PreparedStatement ps = null ;
		try {
			String sql = "update k_exam_detail set UserAnswer=? where id=?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,answer) ;
			ps.setString(2,id) ;
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
	}
	
	public void updateExamState(String examId) {
		PreparedStatement ps = null ;
		try {
			String sql = "update k_exam set isPost='已提交' where id=?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,examId) ;
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
	}
	
	public boolean isPaperExist(String courseId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select 1 from k_paper where courseid=? " ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,courseId) ;
			rs = ps.executeQuery();
			if(rs.next()) {
				return true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
		return false;
	}
	
	public boolean isExamFinish(String courseId,String userId) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			String sql = "select 1 from k_exam where courseid=? and userId=? and isPost='已提交'" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,courseId) ;
			ps.setString(2,userId) ;
			rs = ps.executeQuery();
			if(rs.next()) {
				return true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
		return false;
	}
	
	/**
	 * 是否禁用
	 * @param courseId
	 * @return
	 */
	public boolean getPaperState(String courseId) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		String state = "";
		try {
			String sql = "select state from k_exam where courseid=? " ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,courseId) ;
			rs = ps.executeQuery();
			if(rs.next()) {
				state = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);

		}
		return "禁用".equals(state)?true:false;
	}
	
}
