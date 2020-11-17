package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

/*
 * 用户行为日志
 */
public interface SysLogService {
	PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);
	/***
	 * 基于用户传入的多个id执行日志的额删除业务
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer...ids);
}
