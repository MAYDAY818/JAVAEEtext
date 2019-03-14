package dao;

import java.sql.*;
import java.util.*;

import bean.BookBean;

public class BookDao {
	/**
	 * 查询
	 */
	public List<BookBean> getAllBook(){
		List<BookBean> bookList=new ArrayList<BookBean>() ;
		Connection conn =Database.getConnection();
		PreparedStatement pstmt = null;
		String sql =new String("select book_id,book_name,book_auth,book_publisher,book_price,book_image_url from book");
		try {
			pstmt =conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BookBean bookbean = new BookBean(rs.getInt("book_id"),rs.getString("book_name"),rs.getString("book_auth"),rs.getString("book_publisher"), rs.getDouble("book_price"),rs.getString("book_image_url"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
}
