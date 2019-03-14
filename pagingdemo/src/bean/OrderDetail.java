package bean;

public class OrderDetail {
	private int orderdetail_class_id;
	private int orderdetail_class_list_id;
	private Cake orderdetail_class_cake;
	private int orderdetail_class_count;
	private String orderdetail_class_state;
	public int getOrderdetail_class_id() {
		return orderdetail_class_id;
	}
	public void setOrderdetail_class_id(int orderdetail_class_id) {
		this.orderdetail_class_id = orderdetail_class_id;
	}
	public int getOrderdetail_class_list_id() {
		return orderdetail_class_list_id;
	}
	public void setOrderdetail_class_list_id(int orderdetail_class_list_id) {
		this.orderdetail_class_list_id = orderdetail_class_list_id;
	}
	public Cake getOrderdetail_class_cake() {
		return orderdetail_class_cake;
	}
	public void setOrderdetail_class_cake(Cake orderdetail_class_cake) {
		this.orderdetail_class_cake = orderdetail_class_cake;
	}
	public int getOrderdetail_class_count() {
		return orderdetail_class_count;
	}
	public void setOrderdetail_class_count(int orderdetail_class_count) {
		this.orderdetail_class_count = orderdetail_class_count;
	}
	public String getOrderdetail_class_state() {
		return orderdetail_class_state;
	}
	public void setOrderdetail_class_state(String orderdetail_class_state) {
		this.orderdetail_class_state = orderdetail_class_state;
	}
	public OrderDetail(int orderdetail_class_id, int orderdetail_class_list_id, Cake orderdetail_class_cake,
			int orderdetail_class_count, String orderdetail_class_state) {
		super();
		this.orderdetail_class_id = orderdetail_class_id;
		this.orderdetail_class_list_id = orderdetail_class_list_id;
		this.orderdetail_class_cake = orderdetail_class_cake;
		this.orderdetail_class_count = orderdetail_class_count;
		this.orderdetail_class_state = orderdetail_class_state;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
