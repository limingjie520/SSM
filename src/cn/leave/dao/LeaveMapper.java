package cn.leave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.leave.pojo.LeaveRecords;

public interface LeaveMapper {

	
	/**
	 * 分页查询请假记录信息
	 * @param dqy
	 * @param zy
	 * @return
	 */
		 public List<LeaveRecords> fyselect(@Param("dqy")Integer dqy,@Param("zy")Integer zy);
		 
		 /**
		  * 查询请假记录信息总记录数m
		  * @return
		  */
		 public int  count();
		 
		/**
		 * 添加新的请假记录信息
		 * @param lea
		 * @return
		 */
		 public  int addLea(LeaveRecords lea);
		 
		 /**
		  * 删除指定的请假记录信息
		  * @param id
		  * @return
		  */
		 public int delLea(@Param("id")Integer id);
}
