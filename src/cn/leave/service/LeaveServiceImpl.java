package cn.leave.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.leave.dao.LeaveMapper;
import cn.leave.pojo.LeaveRecords;
import cn.leave.util.MyBatisUtil;

public class LeaveServiceImpl implements LeaveService {

	private SqlSession session=null;
	@Override
	public List<LeaveRecords> fyselect(Integer dqy, Integer zy) {
		
		List<LeaveRecords> list=new ArrayList<LeaveRecords>();
		
		try {
			session=MyBatisUtil.createSqlSession();
			
			list=session.getMapper(LeaveMapper.class).fyselect(dqy, zy);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return list;
	}

	@Override
	public int count() {
		int count = 0 ; 
		
		
		try {
			session=MyBatisUtil.createSqlSession();
			
			count=session.getMapper(LeaveMapper.class).count();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return count;
	}

	@Override
	public int addLea(LeaveRecords lea) {
	int count = 0 ; 

		try {
			session=MyBatisUtil.createSqlSession();
			
			count=session.getMapper(LeaveMapper.class).addLea(lea);
			
			session.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			session.rollback();
			count = 0;
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return count;
	}

	@Override
	public int delLea(Integer id) {
		int count = 0 ; 

		try {
			session=MyBatisUtil.createSqlSession();
			
			count=session.getMapper(LeaveMapper.class).delLea(id);
			
			session.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			session.rollback();
			count = 0;
		}finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return count;
	}

}
