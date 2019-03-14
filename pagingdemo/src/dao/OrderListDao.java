package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Order;
import bean.OrderDetail;
import bean.User;

public class OrderListDao {
	/*
	 * 查询所有订单
	 */
		public List<Order> getAllOrder() {
			List<Order> OrderList = new ArrayList<Order>();
			Connection conn = CakeDatabase.getConnection();
			ResultSet rs=null;
			PreparedStatement pstmt = null;
			String sql = "select\r\n" + 
					"order_list_id,\r\n" + 
					"order_list_date,\r\n" + 
					"order_list_user_id  \r\n" + 
					"from order_list";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					UserListDao userListDao= new UserListDao();
					System.out.println("UserListDao userListDao= new UserListDao();");
					OrderDetailDao orderDetailDao = new OrderDetailDao();
					System.out.println("OrderDetailDao orderDetailDao = new OrderDetailDao();");
					User user = userListDao.getUserById(rs.getInt("order_list_user_id"));
					System.out.println("User user = userListDao.getUserById(rs.getInt(\"order_list_user_id\"));");
					List<OrderDetail> orderDetail = orderDetailDao.getOrderDetailById(rs.getInt("order_list_id"));
					Order order = new Order(
							rs.getInt("order_list_id"), 
							rs.getString("order_list_date"),
							user,
							orderDetail);
					OrderList.add(order);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				CakeDatabase.close(rs);
				CakeDatabase.close(pstmt);
				CakeDatabase.close(conn);
			}
			return OrderList;
		}
		/*
		 * 根据用户ID查询订单
		 */
			public List<Order> getOrderById(int userId) {
				List<Order> OrderList = new ArrayList<Order>();
				Connection conn = CakeDatabase.getConnection();
				ResultSet rs=null;
				PreparedStatement pstmt = null;
				String sql = "select \r\n" + 
						"order_list_id,\r\n" + 
						"order_list_date,\r\n" + 
						"order_list_user_id\r\n" + 
						"from order_list \r\n" + 
						"where order_list_user_id = ? ;";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, userId);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						UserListDao userListDao= new UserListDao();
						OrderDetailDao orderDetailDao = new OrderDetailDao();
						User user = userListDao.getUserById(rs.getInt("order_list_user_id"));
						List<OrderDetail> orderDetail = orderDetailDao.getOrderDetailById(rs.getInt("order_list_id"));
						Order order = new Order(
								rs.getInt("order_list_id"), 
								rs.getString("order_list_date"),
								user,
								orderDetail);
						OrderList.add(order);
						System.out.println("11111");
						System.out.println(rs.getInt("order_list_id"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					CakeDatabase.close(rs);
					CakeDatabase.close(pstmt);
					CakeDatabase.close(conn);
				}
				return OrderList;
			}
	}

