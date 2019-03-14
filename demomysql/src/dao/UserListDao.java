package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;


public class UserListDao {
	
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<User>();
		Connection conn = Mysqldao.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "id , "
				+ "name , "
				+ "password "
				+ "from user ";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("password"));
				userList.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Mysqldao.close(rs);
			Mysqldao.close(pstmt);
			Mysqldao.close(conn);
		}
		
		return userList;
	}
}
