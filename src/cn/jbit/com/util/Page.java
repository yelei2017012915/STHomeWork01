package cn.jbit.com.util;

import java.util.List;

public class Page<T> {
	//每页数量
	private int pageSize;
	//记录总数
	private int totalCount;
	//当前页
	private int currentPage;  
	//当前页数据集合
	private List<T> list;
	//总页数
	private int TotalPage;
	
	public Page() {
		super();
	}
	public Page(int pageSize, int totalCount, int currentPage, List<T> list,
			int totalPage) {
		super();
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.list = list;
		TotalPage = totalPage;
	}
	public int getTotalPage() {
		if (totalCount%pageSize==0) {
			TotalPage=totalCount/pageSize;
		} else {
			TotalPage=totalCount/pageSize+1;
		}
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		
		this.TotalPage = totalPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return  currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this. currentPage = currentPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	
	
	
}
