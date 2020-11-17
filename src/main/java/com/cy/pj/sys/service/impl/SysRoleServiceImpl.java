package com.cy.pj.sys.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.utils.PageUtils;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.验证参数的合法性
		//1.1验证pageCurrent的合法性
		if(pageCurrent==null||pageCurrent<1) throw new IllegalArgumentException("当前页码不正确!");
		//2.基于条件查询的总记录数
		//2.1执行查询
		int rowCount=sysRoleDao.getRowCount(name);
		if (rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		System.out.println("rowCount="+rowCount);
		int pageSize=PageUtils.getPageSize();
		System.out.println("pageSize="+pageSize);
		int startIndex=PageUtils.getStartIndex(pageCurrent);
		System.out.println("startIndex="+startIndex);
		List<SysRole> records =sysRoleDao.findPageObjects(name, startIndex, pageSize);
		System.out.println(records);
		return PageUtils.newPageObject(pageCurrent, startIndex, pageSize,records);
	}
	@Override
	public int deleteObject(Integer id) {
		//1.验证参数的合法性
		if(id==null||id<1)
			throw new ServiceException("id的值不正确,id="+id);
		//2.执行dao操作
		//删除自身表的信息(物理上没关系,删除顺序没关系)
		int rows=sysRoleDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("数据可能已经不存在");
		//删除角色和菜单的信息
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		//删除角色和用户的信息
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//3.返回结果
		return rows;
	}
	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("必须为角色赋予权限");
		//2.保存数据
		int rows=sysRoleDao.insertObject(entity);
		//System.out.println(entity.getId());
		sysRoleMenuDao.insertObjects(entity.getId(),menuIds);

		//3.返回结果
		return rows;
	}

	@Override 
	public SysRoleMenuVo findObjectById(Integer id) { 
		//1.合法性验证
		if(id==null||id<=0) throw new ServiceException("id的值不合法"); 
		//2.执行查询
		SysRoleMenuVo result=sysRoleDao.findObjectById(id); 
		//3.验证结果并返回
		if(result==null) throw new ServiceException("此记录已经不存在"); 
		return result; 
	}
	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("更新的对象不能为空");
		if(entity.getId()==null)
			throw new ServiceException("id的值不能为空");

		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("必须为角色指定一个权限");

		//2.更新数据
		int rows=sysRoleDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("对象可能已经不存在");
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObjects(entity.getId(),menuIds);

		//3.返回结果
		return rows;
	}



}
