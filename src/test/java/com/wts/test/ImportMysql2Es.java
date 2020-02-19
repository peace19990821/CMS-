package com.wts.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.wts.cms.dao.ArticleRes;
import com.wts.cms.domain.Article;
import com.wts.cms.domain.ArticleWithBLOBs;
import com.wts.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class ImportMysql2Es {

	@Autowired
	ArticleRes articleRes;
	
	@Autowired
	ArticleService articleService;
	
	@Test
	public void testImportMysql2Es() {
		// 1.从mysql中查询文章信息
		ArticleWithBLOBs article = new ArticleWithBLOBs();
		article.setStatus(1);
		List<ArticleWithBLOBs> list = articleService.findAll(article);
		// 2. 把查询出来的文章批量保存到es索引库
		articleRes.saveAll(list);
	}
}
