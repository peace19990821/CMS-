package com.wts.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wts.cms.domain.Show;
import com.wts.cms.service.ShowService;
import com.wts.common.utils.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestShow {

	@Autowired
	ShowService service;
	
	// 测试查询方法
	@Test
	public void testlist() {
		Show show  = new Show();
		List<Show> selects = service.selects(show);
		for (Show show2 : selects) {
			System.out.println(show2);
		}
	}
	
	// 测试删除方法
	@Test
	public void testdel() {
		Integer id = 1;
		service.del(id);
	}
	
	// 测试添加方法
	@Test
	public void testAdd() {
		Show show = new Show();
		show.setId(67);
		show.setText("撒打算就立刻");
		boolean httpUrl = StringUtil.isHttpUrl("打算就立刻");
		if(httpUrl == true) {
			show.setUrl("http://localhost:90/my#");
		}else {
			System.out.println("错误地址");
		}
		show.setCreated("2013-12-10");
		show.setUserId(1);
		service.addShow(show);
	}
	
}
