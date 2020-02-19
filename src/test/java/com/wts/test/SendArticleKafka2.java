package com.wts.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wts.cms.domain.ArticleWithBLOBs;
import com.wts.common.utils.FileUtilIO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:producer.xml")
public class SendArticleKafka2 {
	// 注入kafka模板
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	// 测试时候发送成功
	@Test
	public void testArticle() throws Exception {
		// 获取文章的地址
		File file = new File("D:/1708D22");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			// 获取文章标题
			String title = file2.getName().replace(".txt", "");
			// 获取文章内容
			String content = FileUtilIO.readFile(file2, "utf8");
			// 获取对象
			ArticleWithBLOBs awb = new ArticleWithBLOBs();
			// 添加标题
			awb.setTitle(title);
			// 添加内容
			awb.setContent(content);
			// 将对象转成json串
			String jsonString = JSON.toJSONString(awb);
			
			// 发送kafka
			kafkaTemplate.send("1708D",jsonString);
		}
	}
}
