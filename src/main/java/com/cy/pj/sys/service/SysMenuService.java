package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	/*
	 * 查询所有菜单id,name,parentId呈现到页面上
	 */
	List<Node> findZtreeMenuNodes();

	int deleteObject(Integer id);
	/**
	 * 保存菜单信息到数据库
	 * @param entity
	 * @return
	 */
	int saveObject(SysMenu entity);
	
	int updateObject(SysMenu entity);
}
