package cn.liuenci.entity;

import java.util.List;

public class PagesEntity<T> {
	private int currpage;
	private int pagesize;
	private int total;
	private int pages;
	private List<T> data;

	public PagesEntity(int currpage, int pagesize, int total, List<T> data) {
		this.currpage = currpage;
		this.pagesize = pagesize;
		this.total = total;
		this.data = data;
	}

	public PagesEntity() {
		super();
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
