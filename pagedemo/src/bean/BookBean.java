package bean;

/**
 * @author MAYDAY
 *
 */
public class BookBean {
	private int bookId;
	private String bookName;
	private String bookAuth;
	private String bookPubliter;
	private double bookPrice;
	private String bookImageUrl;
	
	
	public BookBean(int bookId, String bookName, String bookAuth, String bookPubliter, double bookPrice,
			String bookImageUrl) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuth = bookAuth;
		this.bookPubliter = bookPubliter;
		this.bookPrice = bookPrice;
		this.bookImageUrl = bookImageUrl;
	}
	
	public BookBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuth() {
		return bookAuth;
	}
	public void setBookAuth(String bookAuth) {
		this.bookAuth = bookAuth;
	}
	public String getBookPubliter() {
		return bookPubliter;
	}
	public void setBookPubliter(String bookPubliter) {
		this.bookPubliter = bookPubliter;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookImageUrl() {
		return bookImageUrl;
	}
	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}
	
	
}
