package com.wts.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wts.cms.dao.ArticleRes;
import com.wts.cms.domain.Article;
import com.wts.cms.domain.Channel;
import com.wts.cms.service.ChannelService;
import com.wts.cms.util.HLUtils;

@RequestMapping("article")
@Controller
public class ArticleController {

	@Autowired
	ArticleRes articleRes;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	@Resource
	private ChannelService channelService;
	
	@RequestMapping("search")
	public String search(String key,Article article,Model model,@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "2") Integer pageSize) {
		
		// 0封装查询条件
		article.setStatus(1);
		model.addAttribute("article", article);
		// 1.查询出所有的栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		// 从es索引库查询    (只完成普通的搜索无高亮)
		/*List<Article> list = articleRes.findByTitle(key);
		PageInfo<Article> info = new PageInfo<>(list);
		model.addAttribute("info",info);*/
		// 高亮搜索HighLight
		long start = System.currentTimeMillis();
		PageInfo<Article> info = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, pageSize, new String[] {"title"}, "id", key);
		long end = System.currentTimeMillis();
		System.err.println("es搜索消耗时间为"+(end-start)+"毫秒");
		model.addAttribute("key", key);
		model.addAttribute("info",info);
		return "index/index";
	}
}
