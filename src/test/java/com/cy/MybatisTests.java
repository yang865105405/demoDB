package com.cy;


import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTests {
	@Autowired
	private SqlSessionFactory ssf;
	@Test
	public void testSqlSessionFactory()  {
		System.out.println(ssf);
		Assert.assertNotEquals(null, ssf);
	}
}
