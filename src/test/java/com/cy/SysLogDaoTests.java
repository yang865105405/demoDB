package com.cy;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogDaoTests {
	@Autowired
	private SysLogDao sysLogDao;
	@Test
	public void testSysLogDaoTests()  {
		int rows = sysLogDao.deleteObject(19);
		System.out.println(rows);
		
	}
	@Test
	public void testDelectObjects()  {
		int rows = sysLogDao.deleteObjects(25,26);
		System.out.println(rows);
		
	}
	@Test
	public void testGetRowCount() {
		int rowCount = sysLogDao.getRowCount("admin");
		System.out.println(rowCount);
	}
	@Test
	public void testFindPageObjects() {
		List<SysLog> list = sysLogDao.findPageObjects("admin", 0, 3);
		System.out.println(list.size());
	}
}
