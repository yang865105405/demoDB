package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao {
	/** 查询所有菜单信息 
	 * 1)一行菜单对应一个map对象(key对应菜单名
	 * 2)多行记录对应多个map,然后将map存到list集合中
	 * */
	@Select("select c.*,p.name parentName from sys_menus c left join sys_menus p on c.parentId=p.id")
	List<Map<String,Object>> findObjects();
	/** 查询所有菜单信息 
	 * 1)一行菜单对应一个Node对象(属性名和字段名相同
	 * 2)多行记录对应多个Node,然后将map存到list集合中
	 * */
	@Select("select id,name,parentId from sys_menus")
	List<Node> findZtreeMenuNodes(); 
	
	/**
	  * 根据菜单id统计子菜单的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 根据id 删除菜单
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 int insertObject(SysMenu entity);
	 
	 int updateObject(SysMenu entity);
}
