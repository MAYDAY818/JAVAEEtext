package com.baidu.paging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.paging.bean.BookBean;

/**
 * BookDao class
 * 
 * @author xieweijing
 * @date 2018-10-30
 *
 */
public class BookDao {

	public List<BookBean> getAllBook() {
		List<BookBean> bookList = new ArrayList<BookBean>();
		Connection conn = Database.getConnection();
		String sql = "select book_id,book_name,book_auth,book_publisher,book_price,book_image_url from book";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookBean bookBean = new BookBean();
				bookBean.setBookId(rs.getInt("book_id"));
				bookBean.setBookName(rs.getString("book_name"));
				bookBean.setBookAuth(rs.getString("book_auth"));
				bookBean.setBookPublisher(rs.getString("book_publisher"));
				bookBean.setBookPrice(rs.getDouble("book_price"));
				bookBean.setBookImageUrl(rs.getString("book_image_url"));
				bookList.add(bookBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(pstmt);
			Database.close(conn);
		}
		return bookList;
	}

	public List<BookBean> getSubBook(int from, int count){
		List<BookBean> list = new ArrayList<BookBean>();
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select book_id,book_name,book_auth,book_publisher,book_price,book_image_url from book limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, from);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookBean bookBean = new BookBean();
				bookBean.setBookId(rs.getInt("book_id"));
				bookBean.setBookName(rs.getString("book_name"));
				bookBean.setBookAuth(rs.getString("book_auth"));
				bookBean.setBookPublisher(rs.getString("book_publisher"));
				bookBean.setBookPrice(rs.getDouble("book_price"));
				bookBean.setBookImageUrl(rs.getString("book_image_url"));
				list.add(bookBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int getCount() {
		int count = 0;
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) c from book";
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
			Database.close(rs);
			Database.close(pstmt);
			Database.close(conn);
		}
		return count;
	}
}
