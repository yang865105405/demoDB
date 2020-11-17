package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
	/** 负责关系表中数据的操作 */
	int deleteObjectsByMenuId(Integer menuId);
	int deleteObjectsByRoleId(Integer roleId);
	
	/**
	 * 
	 * @param roleId  角色id
	 * @param menuIds  多个菜单id
	 * @return
	 */
	int insertObjects(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	List<Integer> findMenuIdsByRoleId(@Param("roleIds") Integer[] roleIds);
	
}
