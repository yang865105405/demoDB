package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	@RequestMapping("doMenuListUI")
	public String doMenuListUI(){
		return "sys/menu_list";
	}
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
	@RequestMapping("doMenuEditUI")
	public String doMenuEditUI(){
		return "sys/menu_edit";
	}
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes(){
		return new JsonResult(
				sysMenuService.findZtreeMenuNodes());
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysMenuService.deleteObject(id);
		return new JsonResult("delete OK");
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity){
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
		sysMenuService.updateObject(entity);
		return new JsonResult("update ok");
	}
}

