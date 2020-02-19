package com.wts.cms.kafka;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.wts.cms.dao.ArticleRes;
import com.wts.cms.domain.ArticleWithBLOBs;
import com.wts.cms.service.ArticleService;

public class MsgListener implements MessageListener<String, String>{

	@Resource
	private ArticleService articleService;
	
	@Autowired
	private ArticleRes articleRes;
	
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		//收消息
	    String value = data.value();
	    System.out.println(value);
		System.out.println("接受到信息");
	    //如果以这个开头,说明是流量肖峰的业务
		if(value.startsWith("user_view")) {
			String[] split = value.split("==");
			String id = split[1];
			//1根据id查询文章,执行浏览量+1操作
			ArticleWithBLOBs articleWithBLOBs = articleService.selectByPrimaryKey(Integer.parseInt(id));
			//2执行+1操作
			articleWithBLOBs.setHits(articleWithBLOBs.getHits() + 1);
			//3把执行后的+1数据再次保存到数据库
			articleService.updateByPrimaryKeySelective(articleWithBLOBs);
			System.err.println("浏览量+1成功");
			
		}else {
			//读取爬虫信息,保存到mysql数据库
			ArticleWithBLOBs parseObject = JSON.parseObject(value,ArticleWithBLOBs.class);
			System.out.println(parseObject);
			//保存到mysql
			
			articleService.insertSelective(parseObject);
		}
		
		//把消息转成json
//		2.把查询出来的文章，批量保存到es中
//		PageInfo<Article> selects = articleService.selects(parseObject, 1, 1000);
//		
//		articleRes.saveAll(selects.getList());
	}

}
