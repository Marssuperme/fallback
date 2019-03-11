package cn.org.gdicpa.web.service.grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.grade.model.Grade;

public class GradeService {
	private static final int EXPERT = 0;

	private static final int RESOURCE = 100;

	private Connection conn = null;

	public static final String TOP_TOTAL = "expert*100+resource desc";
	public static final String TOP_EXPERT = "expert desc";
	public static final String TOP_RESOURCE = "resource desc";

	public GradeService(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 保存分数
	 * @param grade
	 * @return
	 * @throws Exception
	 */
	public int save(Grade grade) throws Exception {

		DbUtil dbUtil = new DbUtil(conn);

		String sql = "insert into k_grade(loginid,expert,resource,gradeType) values(?,?,?,?)";
		Object[] args = new Object[] { grade.getLoginId(), grade.getExpert(),
				grade.getResource(), grade.getGradeType() };

		return dbUtil.executeUpdate(sql, args);

	}

	/**
	 * 删除记录
	 * @param loginId
	 * @return
	 * @throws Exception
	 */
	public int remove(String loginId) throws Exception {
		DbUtil dbUtil = new DbUtil(conn);

		String sql = "delete from k_grade where loginid=? ";
		Object[] args = new Object[] { loginId };

		return dbUtil.executeUpdate(sql, args);
	}

	/**
	 * 更新分数
	 * @param grade
	 * @return
	 * @throws Exception
	 */
	public int update(Grade grade) throws Exception {
		DbUtil dbUtil = new DbUtil(conn);

		String sql = "update k_grade set expert=?,resource=? "
				+ " where loginid=? ";
		Object[] args = new Object[] {

		grade.getExpert(), grade.getResource(), grade.getLoginId() };

		return dbUtil.executeUpdate(sql, args);
	}

	/**
	 * 获取个人分数信息
	 * @param loginId
	 * @return
	 * @throws Exception
	 */
	public Grade getGradeByLoginId(String loginId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		Grade grade = new Grade();
		grade.setLoginId(loginId);

		try {
			String sql = " select expert,resource,gradeType from k_grade where loginId=? ";

			ps = conn.prepareStatement(sql);
			ps.setString(1, loginId);

			rs = ps.executeQuery();

			if (rs.next()) {

				grade.setExpert(rs.getInt(1));
				grade.setResource(rs.getInt(2));
				grade.setGradeType(rs.getString(3));
			} else {
				//如果没有记录，就初始化
				grade.setExpert(EXPERT);
				grade.setResource(RESOURCE);
				grade.setGradeType("0");

				save(grade);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}

		return grade;
	}

	/**
	 * 获得用户资源分排名
	 * @param loginId
	 * @return
	 * @throws Exception
	 */
	public int getTop(String loginId, String topType) throws Exception {

		String sql = " select ROW_NUM from ( "
				+ " select loginId,ROW_NUMBER() OVER(order by " + topType
				+ ") AS ROW_NUM " + " from k_grade) a where loginId=? ";

		Object[] args = new Object[] { loginId };

		int top = new DbUtil(conn).queryForInt(sql, args);

		return top;
	}
}
