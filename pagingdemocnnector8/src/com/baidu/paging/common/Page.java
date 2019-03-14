package com.baidu.paging.common;

/**
 * Page class
 * 
 * @author xieweijing
 * @date 2018-10-30
 *
 */
public class Page {

	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 每页有多少条
	 */
	private int columnPage = 10;
	private int columnCount;
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
	public int getPageCount() {
		return pageCount;
	}
	public int getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
		this.pageCount = columnCount / columnPage + columnCount % columnPage == 0 ? 0 : 1;
	}
}
