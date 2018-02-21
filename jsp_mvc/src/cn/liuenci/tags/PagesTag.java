package cn.liuenci.tags;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PagesTag extends SimpleTagSupport {
	private int currpage = 1;
	private int pagesize = 5;
	private int total = 0;
	private int pages = 0;
	private String url = null;

	public PagesTag() {
	}

	public PagesTag(int currpage, int pagesize, int total, int pages, String url) {
		this.currpage = currpage;
		this.pagesize = pagesize;
		this.total = total;
		this.pages = pages;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// ��ҳ��ǩ
		String pattern = "<a href=\"{0}page={1}&size={2}\">{3}</a>";
		String first = MessageFormat.format(pattern,url,1,pagesize, "��һҳ");

		String last = null;
		if (currpage < 1) {
			last = "<a href=\"#\">��һҳ</a>";
		} else {
			last = MessageFormat.format(pattern,url,currpage-1,pagesize,"��һҳ");
		}

		String next = null;
		if (currpage > pages) {
			next = "<a href=\"#\">��һҳ</a>";
		} else {
			next = MessageFormat.format(pattern,url,currpage+1,pagesize,"��һҳ");
		}

		String end = MessageFormat.format(pattern,url,pages,pagesize,"���һҳ");

		String p = "<div>" + first + " " + last + " " + next + " " + end + "</div>";
		// �����ǩ��
		this.getJspContext().getOut().print(p);
	}
}
