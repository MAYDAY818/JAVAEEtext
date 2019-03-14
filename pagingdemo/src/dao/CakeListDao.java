package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Cake;



public class CakeListDao {
	/**
	 * 查询所有
	 */
	public List<Cake> getAllCake() {
		List<Cake> cakeList = new ArrayList<Cake>();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "cake_list_id,"
				+ "cake_list_name,"
				+ "cake_list_size,"
				+ "cake_list_shape,"
				+ "cake_list_flavor,"
				+ "cake_list_price,"
				+ "cake_list_introduce,"
				+ "cake_list_image_url  "
				+ "from cake_list ";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cake cake = new Cake(
						rs.getInt("cake_list_id"), 
						rs.getString("cake_list_name"),
						rs.getInt("cake_list_size"), 
						rs.getString("cake_list_shape"), 
						rs.getString("cake_list_flavor"),
						rs.getDouble("cake_list_price"),
						rs.getString("cake_list_introduce"),
						rs.getString("cake_list_image_url"));
				cakeList.add(cake);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		
		return cakeList;
	}
	/**
	 * 根据ID查询
	 * @throws SQLException 
	 */
	public Cake getCakeById(int cakeId)  {
		Cake cake=new Cake();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "cake_list_id,"
				+ "cake_list_name,"
				+ "cake_list_size,"
				+ "cake_list_shape,"
				+ "cake_list_flavor,"
				+ "cake_list_price,"
				+ "cake_list_introduce,"
				+ "cake_list_image_url  "
				+ "from cake_list "
				+ "where cake_list_id = ?";
		ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,cakeId);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					cake.setCake_class_id(rs.getInt("cake_list_id"));
					cake.setCake_class_name(rs.getString("cake_list_name"));
					cake.setCake_class_size(rs.getInt("cake_list_size"));
					cake.setCake_class_shape(rs.getString("cake_list_shape"));
					cake.setCake_class_flavor(rs.getString("cake_list_flavor"));
					cake.setCake_class_price(rs.getDouble("cake_list_price"));
					cake.setCake_class_introduce(rs.getString("cake_list_introduce"));
					cake.setCake_class_image_url(rs.getString("cake_list_image_url"));
					System.out.println(cake.getCake_class_name());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				CakeDatabase.close(rs);
				CakeDatabase.close(pstmt);
				CakeDatabase.close(conn);
			}
			
		return cake;
	}
	
	public List<Cake> getSubCake(int from, int count){
		List<Cake> list = new ArrayList<Cake>();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		Cake cake=new Cake();
		ResultSet rs = null;
		try {
			String sql = "select "
					+ "cake_list_id,"
					+ "cake_list_name,"
					+ "cake_list_size,"
					+ "cake_list_shape,"
					+ "cake_list_flavor,"
					+ "cake_list_price,"
					+ "cake_list_introduce,"
					+ "cake_list_image_url  "
					+ "from cake_list"
					+ "where cake_list_id = ?"
					+ "limit ?,?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, from);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cake.setCake_class_id(rs.getInt("cake_list_id"));
				cake.setCake_class_name(rs.getString("cake_list_name"));
				cake.setCake_class_size(rs.getInt("cake_list_size"));
				cake.setCake_class_shape(rs.getString("cake_list_shape"));
				cake.setCake_class_flavor(rs.getString("cake_list_flavor"));
				cake.setCake_class_price(rs.getDouble("cake_list_price"));
				cake.setCake_class_introduce(rs.getString("cake_list_introduce"));
				cake.setCake_class_image_url(rs.getString("cake_list_image_url"));
				list.add(cake);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		return list;
	}
	
	
	public int getCount() {
		int count = 0;
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) c from cake_list";
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
	/**
	 * 根据类别查询
	 * @throws SQLException 
	 */
	public List<Cake> getCakeBySize(int attribute) {
		List<Cake> cakeList = new ArrayList<Cake>();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "cake_list_id,"
				+ "cake_list_name,"
				+ "cake_list_size,"
				+ "cake_list_shape,"
				+ "cake_list_flavor,"
				+ "cake_list_price,"
				+ "cake_list_introduce,"
				+ "cake_list_image_url  "
				+ "from cake_list "
				+ "where cake_list_size = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attribute);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cake cake = new Cake(
						rs.getInt("cake_list_id"), 
						rs.getString("cake_list_name"),
						rs.getInt("cake_list_size"), 
						rs.getString("cake_list_shape"), 
						rs.getString("cake_list_flavor"),
						rs.getDouble("cake_list_price"),
						rs.getString("cake_list_introduce"),
						rs.getString("cake_list_image_url"));
				cakeList.add(cake);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		
		return cakeList;
	}
	public List<Cake> getCakeByFlavor(String parameter) {
		// TODO Auto-generated method stub
		List<Cake> cakeList = new ArrayList<Cake>();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "cake_list_id,"
				+ "cake_list_name,"
				+ "cake_list_size,"
				+ "cake_list_shape,"
				+ "cake_list_flavor,"
				+ "cake_list_price,"
				+ "cake_list_introduce,"
				+ "cake_list_image_url  "
				+ "from cake_list "
				+ "where cake_list_flavor = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, parameter);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cake cake = new Cake(
						rs.getInt("cake_list_id"), 
						rs.getString("cake_list_name"),
						rs.getInt("cake_list_size"), 
						rs.getString("cake_list_shape"), 
						rs.getString("cake_list_flavor"),
						rs.getDouble("cake_list_price"),
						rs.getString("cake_list_introduce"),
						rs.getString("cake_list_image_url"));
				cakeList.add(cake);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		
		return cakeList;
	}
	/**
	 * 添加蛋糕
	 * @throws SQLException 
	 */
	public boolean addCake(Cake cake) {
		List<Cake> cakeList = new ArrayList<Cake>();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO cake_list \r\n" + 
				"(cake_list_name,cake_list_size,cake_list_shape,cake_list_flavor,cake_list_price,cake_list_image_url)\r\n" + 
				"VALUES\r\n" + 
				"	( ?,?,?,?,?,? );";
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cake.getCake_class_name());
			pstmt.setInt(2, cake.getCake_class_size());
			pstmt.setString(3, cake.getCake_class_shape());
			pstmt.setString(4, cake.getCake_class_flavor());
			pstmt.setDouble(5, cake.getCake_class_price());
			pstmt.setString(6, cake.getCake_class_image_url());
			rs = pstmt.executeUpdate();
			if(rs!=0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		return true;
	}
	/**
	 * 根据名称查询
	 * @throws SQLException 
	 */
	public List<Cake> getCakeByName(String attribute) {
		List<Cake> cakeList = new ArrayList<Cake>();
		Connection conn = CakeDatabase.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "cake_list_id,"
				+ "cake_list_name,"
				+ "cake_list_size,"
				+ "cake_list_shape,"
				+ "cake_list_flavor,"
				+ "cake_list_price,"
				+ "cake_list_introduce,"
				+ "cake_list_image_url  "
				+ "from cake_list "
				+ "where cake_list_name like ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "'%"+attribute+"%'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cake cake = new Cake(
						rs.getInt("cake_list_id"), 
						rs.getString("cake_list_name"),
						rs.getInt("cake_list_size"), 
						rs.getString("cake_list_shape"), 
						rs.getString("cake_list_flavor"),
						rs.getDouble("cake_list_price"),
						rs.getString("cake_list_introduce"),
						rs.getString("cake_list_image_url"));
				cakeList.add(cake);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		return cakeList;
	}
}
