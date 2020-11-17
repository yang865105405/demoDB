package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;

public interface SysRoleService {
	PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
	/**
	 * 基于角色id删除角色以及对应的关系
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	int saveObject(SysRole entity,Integer[] menuIds);
	
	SysRoleMenuVo findObjectById(Integer id) ;
	
	int updateObject(SysRole entity,Integer[] menuIds);
}
