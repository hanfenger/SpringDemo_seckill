 package org.seckill.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.*;
/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * @author LK
 * spring-test junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	

	/*@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.toString());
	}*/

	@Test
	public void testQueryAll() {
		List<Seckill> seckillList = seckillDao.queryAll(0, 100);
		for(Seckill seckill:seckillList){
			System.out.println(seckill);
		}
	}

	@Test
	public void testReduceNumber() {
		Date killTime = new Date();
		seckillDao.reduceNumber(1000l, killTime);
	}
}
