package com.wts.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wts.cms.dao.ArticleMapper;
import com.wts.cms.domain.Article;
import com.wts.cms.domain.ArticleWithBLOBs;
import com.wts.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> selects(Article article,Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Article> list = articleMapper.selects(article);
		return new PageInfo<Article>(list);
	}

	@Override
	public int insertSelective(ArticleWithBLOBs record) {
		return articleMapper.insertSelective(record);
	}

	@Override
	public ArticleWithBLOBs selectByPrimaryKey(Integer id) {
		
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ArticleWithBLOBs record) {
		return articleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ArticleWithBLOBs> findAll(ArticleWithBLOBs article) {
		return articleMapper.findAll(article);
	}
}
