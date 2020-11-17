package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;

import com.cy.pj.sys.service.SysLogService;

@Controller
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogServive;
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids) {
		int rows = sysLogServive.deleteObjects(ids);
		return new JsonResult("delete ok"+rows);
				
	}
	@RequestMapping("/doLogListUI")
	public String doLogListUI() {
		return "sys/log_list";
	}
	@RequestMapping("doFindPageObject")
	@ResponseBody
	public JsonResult doFindPageObject(Integer pageCurrent,String username){
		return new JsonResult(sysLogServive.findPageObjects(username, pageCurrent));
	}
}
