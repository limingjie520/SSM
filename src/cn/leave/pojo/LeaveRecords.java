package cn.leave.pojo;

import java.util.Date;

/**
 * 实体类
 * @author LiMingJie
 *
 */
public class LeaveRecords {
   private  int    id;//编号
   private String name;//姓名
   private String leaveTime;//请假时间
   private String reason;//请假原因
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLeaveTime() {
	return leaveTime;
}
public void setLeaveTime(String leaveTime) {
	this.leaveTime = leaveTime;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public LeaveRecords() {
	super();
	// TODO Auto-generated constructor stub
}
public LeaveRecords(String name, String leaveTime, String reason) {
	super();
	this.name = name;
	this.leaveTime = leaveTime;
	this.reason = reason;
}
   
   
}
