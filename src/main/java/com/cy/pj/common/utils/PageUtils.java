package com.cy.pj.common.utils;

import java.util.List;

import com.cy.pj.common.vo.PageObject;

public class PageUtils{
	
	private static int pageSize=3;
	
	public static int getPageSize() {
		return pageSize;
	}
	public static void setPageSize(int pageSize) {
		PageUtils.pageSize = pageSize;
	}
	public static int getStartIndex(Integer pageCurrent) {
		
		return (pageCurrent-1)*pageSize;
	}
	public static <T>PageObject<T> newPageObject(Integer pageCurrent, int rowCount, int pageSize, List<T> records) {
		PageObject<T> po = new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		int pageCount = (rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		return po;
	}
}