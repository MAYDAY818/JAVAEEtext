package bean;

public class User {
	private int    user_class_id;
	private String user_class_name;
	private String user_class_password;
	private String user_class_email;
	private String user_class_phone;
	private String user_class_adress;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int user_class_id, String user_class_name, String user_class_password, String user_class_email,
			String user_class_phone, String user_class_adress) {
		super();
		this.user_class_id = user_class_id;
		this.user_class_name = user_class_name;
		this.user_class_password = user_class_password;
		this.user_class_email = user_class_email;
		this.user_class_phone = user_class_phone;
		this.user_class_adress = user_class_adress;
	}

	public int getUser_class_id() {
		return user_class_id;
	}
	public void setUser_class_id(int user_class_id) {
		this.user_class_id = user_class_id;
	}
	public String getUser_class_name() {
		return user_class_name;
	}
	public void setUser_class_name(String user_class_name) {
		this.user_class_name = user_class_name;
	}
	public String getUser_class_password() {
		return user_class_password;
	}
	public void setUser_class_password(String user_class_password) {
		this.user_class_password = user_class_password;
	}
	public String getUser_class_email() {
		return user_class_email;
	}
	public void setUser_class_email(String user_class_email) {
		this.user_class_email = user_class_email;
	}
	public String getUser_class_phone() {
		return user_class_phone;
	}
	public void setUser_class_phone(String user_class_phone) {
		this.user_class_phone = user_class_phone;
	}
	public String getUser_class_adress() {
		return user_class_adress;
	}
	public void setUser_class_adress(String user_class_adress) {
		this.user_class_adress = user_class_adress;
	}

}
