package com.bawei.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.commons.utils.FileUtil;
import com.bawei.commons.utils.StringUtil;
import com.bawei.entity.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class FileTest {
	
	@Resource
	private RedisTemplate<String, Goods> redisTemplate;

	@Test
	public void readFile() {
		//读取文件数据
		List<String> fileOfList = FileUtil.readTextFileOfList("F:\\workspace\\maven\\redis-test\\src\\test\\resources\\123.txt");
		
		//获取list操作对象
		 ListOperations<String, Goods> opsForList = redisTemplate.opsForList();
		//获取zset操作对象
		ZSetOperations<String, Goods> opsForZSet = redisTemplate.opsForZSet();
		
		for (String string : fileOfList) {
			//切分数据
			String[] ss = string.split("==");
			
			//封装数据，封装到Goods对象中
			Goods goods = new  Goods();
			
			//校验数据
			//校验id
			if(StringUtil.isNumber(ss[0])) {
				goods.setId(Integer.parseInt(ss[0]));
			}
			
			//校验商品名称（工具类的方法名称有误，此处逻辑是如果值不为空，则赋值）
//			if(StringUtil.isBlank(ss[1])) {
				
//			}
			if(ss[1] != null && !ss[1].trim().equals("")) {
				goods.setName(ss[1]);
			}
			
			//校验价格
			if(StringUtil.isBlank(ss[2])) {
				//如果价格不为空
				
				//判断是否是数字
				String price = ss[2].substring(1);
				if(StringUtil.isNumber(price)) {
					//如果是数字
					goods.setPrice(new BigDecimal(price));
					
				}else {
					//如果不是数字
					goods.setPrice(new BigDecimal(0));
				}
			}else {
				//如果价格为空
				goods.setPrice(new BigDecimal(0));
			}
			
			//校验百分比
			//判断是否为空
			if(ss.length == 4) {
				if(StringUtil.isBlank(ss[3])) {
					//如果不为空
					
					//判断是否数字
					String sell = ss[3].replace("%", "");
					if(StringUtil.isNumber(sell)) {
						//如果是数字
						goods.setSell(Double.parseDouble(sell));
						
					}else {
						//如果不是数字
						goods.setSell(0);
					}
					
				}else {
					//如果为空
					goods.setSell(0);
				}
				
			}else {
				//如果没有销售百分比，则长度不到4
				goods.setSell(0);
			}
			
			
			//打印输出
			System.out.println(goods);
			//存入redis中
//			opsForList.leftPush("goods_list", goods);
//			opsForZSet.add("goods_zset", goods, goods.getSell());
		}
		
		
		System.out.println("存储完毕");
	}
	
	
	
	//获取redis中数据的方法
	@Test
	public void getList() {
		
		//获取list的操作对象
		ListOperations<String, Goods> opsForList = redisTemplate.opsForList();
		
		//当前页
		int pageNum = 2;
		
		//每页条数
		int pageSize = 10;
		
		
		//获取值  
//		List<Goods> list = opsForList.range("goods_list", 0, 9);
		
		//开始下标，结束下标		(pageNum - 1)* pageSize , pageNum*pageSize - 1
		List<Goods> list = opsForList.range("goods_list", (pageNum - 1)* pageSize , pageNum*pageSize - 1);
		
		//打印
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}
	//获取redis中数据的方法
	@Test
	public void getZSet() {
		
		//获取zset的操作对象
		ZSetOperations<String, Goods> opsForZSet = redisTemplate.opsForZSet();
		
		//当前页
		int pageNum = 1;
		
		//每页条数
		int pageSize = 10;
		
		
		//获取值  
//		Set<Goods> set = opsForList.range("goods_zset", 0, 9);
		
		//开始下标，结束下标		(pageNum - 1)* pageSize , pageNum*pageSize - 1
		 Set<Goods> set = opsForZSet.reverseRange("goods_zset", (pageNum - 1)* pageSize , pageNum*pageSize - 1);
		
		//打印
		for (Goods goods : set) {
			System.out.println(goods);
		}
	}
	
}
