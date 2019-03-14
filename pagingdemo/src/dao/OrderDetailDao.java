package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cake;
import bean.OrderDetail;

public class OrderDetailDao {
	/**
	 * 查询所有订单详情
	 */
	public List<OrderDetail> getAllOrderDetail() {
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		Connection conn = CakeDatabase.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "order_detail_id,"
				+ "order_list_id,"
				+ "order_cake_list_id,"
				+ "order_count,"
				+ "order_detail_state "
				+ "from order_detail_list";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CakeListDao cakeListDao=new CakeListDao();
				Cake cake = cakeListDao.getCakeById(rs.getInt("order_cake_list_id"));
				OrderDetail orderdetail = new OrderDetail(
						rs.getInt("order_detail_id"), 
						rs.getInt("order_list_id"),
						cake, 
						rs.getInt("order_count"),
						rs.getString("order_detail_state"));
				orderDetail.add(orderdetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		return orderDetail;
	}
	/**
	 * 根据订单号查询
	 */
	public List<OrderDetail> getOrderDetailById(int orderList) {
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		Connection conn = CakeDatabase.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String sql = "select "
				+ "order_detail_id,"
				+ "order_list_id,"
				+ "order_cake_list_id,"
				+ "order_count,"
				+ "order_detail_state "
				+ "from order_detail_list "
				+ "where order_list_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,orderList);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CakeListDao cakeListDao=new CakeListDao();
				Cake cake = cakeListDao.getCakeById(rs.getInt("order_cake_list_id"));
				OrderDetail orderdetail = new OrderDetail(
						rs.getInt("order_detail_id"), 
						rs.getInt("order_list_id"),
						cake, 
						rs.getInt("order_count"),
						rs.getString("order_detail_state"));
				orderDetail.add(orderdetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		return orderDetail;
	}
	/**
	 * 根据用户ID查询
	 */
	public List<OrderDetail> getOrderDetailByUserId(int userId) {
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		Connection conn = CakeDatabase.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String sql = "select \r\n" + 
				"order_detail_id,\r\n" + 
				"order_list_id,\r\n" + 
				"order_cake_list_id,\r\n" + 
				"order_count,\r\n" + 
				"order_detail_state \r\n" + 
				"from order_detail_list \r\n" + 
				"where order_list_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CakeListDao cakeListDao=new CakeListDao();
				Cake cake = cakeListDao.getCakeById(rs.getInt("order_cake_list_id"));
				OrderDetail orderdetail = new OrderDetail(
						rs.getInt("order_detail_id"), 
						rs.getInt("order_list_id"),
						cake, 
						rs.getInt("order_count"),
						rs.getString("order_detail_state"));
				orderDetail.add(orderdetail);
				System.out.println(rs.getInt("order_detail_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CakeDatabase.close(rs);
			CakeDatabase.close(pstmt);
			CakeDatabase.close(conn);
		}
		return orderDetail;
	}
	/**
	 * 根据订单号删除
	 */
	public void deleteOrderDetailById(int orderList) {
		Connection conn = CakeDatabase.getConnection();
		boolean rs = false;
		PreparedStatement pstmt = null;
		String sql = "delete  "
				+ " from order_detail_list "
				+ " where order_detail_id = ? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,orderList);
				rs = pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	public void addOrderDetailById(int userid, int cakeid, int quantity) {
		// TODO Auto-generated method stub
		Connection conn = CakeDatabase.getConnection();
		boolean rs = false;
		PreparedStatement pstmt = null;
		String sql = "insert into "
				+ "order_detail_list(order_list_id,order_cake_list_id,order_count,order_detail_state) "
				+ "values(?,?,?,'未付款')";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,userid);
				pstmt.setInt(2,cakeid);
				pstmt.setInt(3,quantity);
				rs = pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
