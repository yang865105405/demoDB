package com.cy.pj.sys.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.utils.PageUtils;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService{
	//当我们使用了lombok插件以后,在类上@Slf4j注解,此时下面的日志对象的创建可以省略
	//底层会帮我们自动生成如下语句
	//private static final Logger log = LoggerFactory.getLogger(SysLogServiceImpl.class);	
	@Autowired
	//@Qualifier("sysLogDao")//默认接口名首字母小写
	private SysLogDao sysLogDao;
	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		//2.执行删除
		int rows = sysLogDao.deleteObjects(ids);
		if (rows>0) {
			log.info("delete ok rows="+rows);
		}
		//3.验证并且返回结果
		return rows;
	}
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		//1.参数校验
		if (pageCurrent==null || pageCurrent<1) throw new IllegalArgumentException("当前页码不正确");
		//2.查询总记录并进行校验
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount==0) throw new ServiceException("系统没有查到对应记录");
		//3.查询当前页要呈现的记录
		int pageSize=PageUtils.getPageSize(); //每页最多显示3条
		int startIndex=PageUtils.getStartIndex(pageCurrent); //当前页起始位置
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.对查询的结果进行计算和封装
		PageObject<SysLog> po = PageUtils.newPageObject(pageCurrent, rowCount, pageSize, records);
		//5.返回结果
		return po;
	}
	

}
