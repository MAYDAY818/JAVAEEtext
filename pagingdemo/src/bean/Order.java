package bean;

import java.util.List;

public class Order {
	private int order_class_id;
	private String order_class_date;
	private User order_class_user_id;
	private List<OrderDetail> order_class_list;
	public int getOrder_class_id() {
		return order_class_id;
	}
	public void setOrder_class_id(int order_class_id) {
		this.order_class_id = order_class_id;
	}
	public String getOrder_class_date() {
		return order_class_date;
	}
	public void setOrder_class_date(String order_class_date) {
		this.order_class_date = order_class_date;
	}
	public User getOrder_class_user_id() {
		return order_class_user_id;
	}
	public void setOrder_class_user_id(User order_class_user_id) {
		this.order_class_user_id = order_class_user_id;
	}
	public List<OrderDetail> getOrder_class_list() {
		return order_class_list;
	}
	public void setOrder_class_list(List<OrderDetail> order_class_list) {
		this.order_class_list = order_class_list;
	}
	public Order(int order_class_id, String order_class_date, User order_class_user_id,
			List<OrderDetail> order_class_list) {
		super();
		this.order_class_id = order_class_id;
		this.order_class_date = order_class_date;
		this.order_class_user_id = order_class_user_id;
		this.order_class_list = order_class_list;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
