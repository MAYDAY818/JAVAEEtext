package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserListDao {
	/*
	 * 查询所有
	 */

		public List<User> getAllUser() {
			List<User> userList = new ArrayList<User>();
			Connection conn = CakeDatabase.getConnection();
			ResultSet rs=null;
			PreparedStatement pstmt = null;
			String sql = "select \r\n" + 
					"user_id,\r\n" + 
					"user_list_name,\r\n" + 
					"user_list_password,\r\n" + 
					"user_list_email,\r\n" + 
					"user_list_phone,\r\n" + 
					"user_list_adress\r\n" + 
					"from user_list;";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					User user = new User(
							rs.getInt("user_id"), 
							rs.getString("user_list_name"),
							rs.getString("user_list_password"), 
							rs.getString("user_list_email"), 
							rs.getString("user_list_phone"),
							rs.getString("user_list_adress"));
					userList.add(user);
					System.out.println(user.getUser_class_id());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				CakeDatabase.close(rs);
				CakeDatabase.close(pstmt);
				CakeDatabase.close(conn);
			}
			return userList;
		}
		/*
		 * 根据ID查询
		 */
		public User getUserById(int userId)  {
			Connection conn = CakeDatabase.getConnection();
			ResultSet rs=null;
			User user = new User();
			PreparedStatement pstmt = null;
			String sql = "select \r\n" + 
					"user_id,\r\n" + 
					"user_list_name,\r\n" + 
					"user_list_password,\r\n" + 
					"user_list_email,\r\n" + 
					"user_list_phone,\r\n" + 
					"user_list_adress\r\n" + 
					"from user_list\r\n" +
					"where user_id = ?";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,userId);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						user.setUser_class_id(rs.getInt("user_id"));
						user.setUser_class_name(rs.getString("user_list_name"));
						user.setUser_class_password(rs.getString("user_list_password"));
						user.setUser_class_email(rs.getString("user_list_email"));
						user.setUser_class_phone(rs.getString("user_list_phone"));
						user.setUser_class_adress(rs.getString("user_list_adress"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					CakeDatabase.close(rs);
					CakeDatabase.close(pstmt);
					CakeDatabase.close(conn);
				}
				

			return user;
		}
		/*
		 * 根据email查询
		 */
		public User getUserByEmail(String email)  {
			Connection conn = CakeDatabase.getConnection();
			ResultSet rs=null;
			User user = new User();
			PreparedStatement pstmt = null;
			String sql = "select "
					+ "user_id,"
					+ "user_list_name,"
					+ "user_list_password,"
					+ "user_list_email,"
					+ "user_list_phone,"
					+ "user_list_adress"
					+ "from user_list"
					+ "where user_list_email = ?";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,email);
					rs = pstmt.executeQuery();
					user.setUser_class_id(rs.getInt("user_id"));
					user.setUser_class_name(rs.getString("user_list_name"));
					user.setUser_class_password(rs.getString("user_list_password"));
					user.setUser_class_email(rs.getString("user_list_email"));
					user.setUser_class_phone(rs.getString("user_list_phone"));
					user.setUser_class_adress(rs.getString("user_list_adress"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					CakeDatabase.close(rs);
					CakeDatabase.close(pstmt);
					CakeDatabase.close(conn);
				}
				

			return user;
		}
		/*
		 * 检查用户是否存在
		 */
		public User checkUser(String email,String password)  {
			Connection conn = CakeDatabase.getConnection();
			ResultSet rs=null;
			User user = new User();
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM `user_list`\r\n" + 
					"WHERE user_list_email =  ? AND\r\n" + 
					"user_list_password = ? ";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,email);
					pstmt.setString(2,password);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						user.setUser_class_id(rs.getInt("user_id"));
						user.setUser_class_name(rs.getString("user_list_name"));
						user.setUser_class_password(rs.getString("user_list_password"));
						user.setUser_class_email(rs.getString("user_list_email"));
						user.setUser_class_phone(rs.getString("user_list_phone"));
						user.setUser_class_adress(rs.getString("user_list_adress"));
						return user;
						}
					else
					{
						return null;
						}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					CakeDatabase.close(rs);
					CakeDatabase.close(pstmt);
					CakeDatabase.close(conn);
				}
				return null;
		}
		/*
		 * 添加用户
		 * */
		public Boolean addUser(String name,String email, String password) {
			// TODO Auto-generated method stub
			Connection conn = CakeDatabase.getConnection();
			boolean rs=false;
			User user = new User();
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO \r\n" + 
					"user_list \r\n" + 
					"(\r\n" + 
					"user_list_name ,\r\n" + 
					"user_list_email ,\r\n" + 
					"user_list_password \r\n" + 
					")\r\n" + 
					"VALUES (?,?,?); ";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,name);
					pstmt.setString(2,email);
					pstmt.setString(3, password);
					rs = pstmt.execute();
					return rs;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
		}
		/*
		 * 查询人数
		 * */
		public int getCount() {
			int count = 0;
			Connection conn = CakeDatabase.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select count(*) c from user_list";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					count = rs.getInt("c");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				CakeDatabase.close(rs);
				CakeDatabase.close(pstmt);
				CakeDatabase.close(conn);
			}
			return count;
		}
		/*
		 * 根据ID删除
		 * */
		public int removeUserById(int id) {
			int count = 0;
			Connection conn = CakeDatabase.getConnection();
			PreparedStatement pstmt = null;
			boolean rs = false;
			String sql = "delete  "
					+ " from user_list "
					+ " where user_id = ? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				rs = pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return count;
		}
	
}
