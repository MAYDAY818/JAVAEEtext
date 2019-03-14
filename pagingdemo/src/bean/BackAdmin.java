package bean;

public class BackAdmin {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BackAdmin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public BackAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
