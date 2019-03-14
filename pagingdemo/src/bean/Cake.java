package bean;

public class Cake {
	
	
	private int    cake_class_id;
	private String cake_class_name;
	private int    cake_class_size;
	private String cake_class_shape;
	private String cake_class_flavor;
	private Double cake_class_price;
	private String cake_class_introduce;
	private String cake_class_image_url;
	
	public Cake() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cake(int cake_class_id, String cake_class_name, int cake_class_size, String cake_class_shape,
			String cake_class_flavor, Double cake_class_price, String cake_class_introduce,
			String cake_class_image_url) {
		super();
		this.cake_class_id = cake_class_id;
		this.cake_class_name = cake_class_name;
		this.cake_class_size = cake_class_size;
		this.cake_class_shape = cake_class_shape;
		this.cake_class_flavor = cake_class_flavor;
		this.cake_class_price = cake_class_price;
		this.cake_class_introduce = cake_class_introduce;
		this.cake_class_image_url = cake_class_image_url;
	}
	
	
	public int getCake_class_id() {
		return cake_class_id;
	}
	public void setCake_class_id(int cake_class_id) {
		this.cake_class_id = cake_class_id;
	}
	public String getCake_class_name() {
		return cake_class_name;
	}
	public void setCake_class_name(String cake_class_name) {
		this.cake_class_name = cake_class_name;
	}
	public int getCake_class_size() {
		return cake_class_size;
	}
	public void setCake_class_size(int cake_class_size) {
		this.cake_class_size = cake_class_size;
	}
	public String getCake_class_shape() {
		return cake_class_shape;
	}
	public void setCake_class_shape(String cake_class_shape) {
		this.cake_class_shape = cake_class_shape;
	}
	public String getCake_class_flavor() {
		return cake_class_flavor;
	}
	public void setCake_class_flavor(String cake_class_flavor) {
		this.cake_class_flavor = cake_class_flavor;
	}
	public Double getCake_class_price() {
		return cake_class_price;
	}
	public void setCake_class_price(Double cake_class_price) {
		this.cake_class_price = cake_class_price;
	}
	public String getCake_class_introduce() {
		return cake_class_introduce;
	}
	public void setCake_class_introduce(String cake_class_introduce) {
		this.cake_class_introduce = cake_class_introduce;
	}
	public String getCake_class_image_url() {
		return cake_class_image_url;
	}
	public void setCake_class_image_url(String cake_class_image_url) {
		this.cake_class_image_url = cake_class_image_url;
	}

}
