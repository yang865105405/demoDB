package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {
	/** 按条件查询日志总记录数 
	 * @param username  查询条件
	 * */
	int getRowCount(@Param("username")String username);
	
	/**
	 * 基于分页查询,获取当前页的记录
	 * @param username 查询条件
	 * @param startIndex 起始位置
	 * @param pageSize 页面大小(每一个页面显示的数量)
	 * @return
	 */
	List<SysLog> findPageObjects(@Param("username")String username,
								@Param("startIndex")Integer startIndex,
								@Param("pageSize")Integer pageSize);
	
	@Delete("delete from sys_logs where id=#{id}")
	int deleteObject(Integer id);
	/**
	 * 基于传入的id值执行动态删除(可能多个操作)
	 */
	int deleteObjects(@Param("ids")Integer...ids);
}
