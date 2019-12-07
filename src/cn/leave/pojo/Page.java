package cn.leave.pojo;

public class Page {

	private int currPageNo; // 当前页码
	private int pageSize; // 每页显示的数据行数
	private int totalCount; // 总记录数
	private int totalPageCount; // 总页数
	
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
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
		if(totalCount>0) {
			this.totalCount = totalCount;
			
			/* 总记录数 /每页显示的数据行数*/
			this.totalPageCount=this.totalCount%this.pageSize==0?
					this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
			
		}
		
		
		
		
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	
	
}
