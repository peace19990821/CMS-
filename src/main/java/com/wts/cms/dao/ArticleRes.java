package com.wts.cms.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wts.cms.domain.Article;
import com.wts.cms.domain.ArticleWithBLOBs;

// 此时自动具备增删改查功能
public interface ArticleRes extends ElasticsearchRepository<ArticleWithBLOBs, Integer>{

	// 根据标题查询
	List<Article> findByTitle(String key);
}
