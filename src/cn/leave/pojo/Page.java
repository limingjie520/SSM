package cn.leave.pojo;

public class Page {
private int zzz1;
	private int xxxxxxxx1;
	private int ttttttttttttttttt;
	private int wwww;
	private String nnn;//啊
	private int zs;//张三
    private int lmj;//帧数
	private int currPageNo; // 褰撳墠椤电爜
	private int pageSize; // 姣忛〉鏄剧ず鐨勬暟鎹鏁�
	private int totalCount; // 鎬昏褰曟暟
	private int totalPageCount; // 鎬婚〉鏁�
	
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
			
			/* 鎬昏褰曟暟 /姣忛〉鏄剧ず鐨勬暟鎹鏁�*/
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
