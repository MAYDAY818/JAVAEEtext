package common;

public class Page {
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 每页的条数
	 */
	private int columnPage = 9;
	/**
	 * 一共有多少条数据
	 */
	private int columnCount;
	/**
	 * 一共有多少页
	 */
	private int pageCount;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getColumnPage() {
		return columnPage;
	}
	public void setColumnPage(int columnPage) {
		this.columnPage = columnPage;
	}
	public int getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
		int i = columnCount % columnPage == 0 ? 0 : 1;
		pageCount = columnCount / columnPage + i;
	}
	public int getPageCount() {
		return pageCount;
	}
}
