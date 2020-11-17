package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;
@Mapper
public interface SysRoleDao {
	/**
	 * 分页查询角色信息
	 * @param name
	 * @param startIndex 上一页的结束位置
	 * @param pageSize 每一页要查询的记录数
	 * @return
	 */
	List<SysRole> findPageObjects(
			@Param("name") String name,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	
	int getRowCount(@Param("name")String name);		
	int deleteObject(Integer id);
	
	int insertObject(SysRole entity);
	/**
	 * 基于角色id获取角色以及对应的菜单信息
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	/**
	 * 更新角色自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
}
