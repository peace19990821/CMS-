package com.bawei.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.bawei.entity.Goods;
import com.bawei.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private RedisTemplate<String, Goods> redisTemplate;

	@Override
	public PageInfo<Goods> getList(Integer pageNum, Integer pageSize) {
		//获取list操作对象
		ListOperations<String, Goods> opsForList = redisTemplate.opsForList();
		
		//获取数据 (pageNum - 1)*pageSize,pageNum*pageSize-1
		List<Goods> list = opsForList.range("goods_list", (pageNum - 1)*pageSize , pageNum*pageSize-1);
		
		//获取总条数
		Long total = opsForList.size("goods_list");
		
		//返回数据
		//封装分页条件
		Page<Goods> page = new Page<Goods>(pageNum, pageSize);
		
		//将数据存入其中
		page.addAll(list);
		
		//设置总条数
		page.setTotal(total);
		
		return new PageInfo<Goods>(page);
	}

	@Override
	public PageInfo<Goods> getSellList(Integer pageNum, Integer pageSize) {
		//获取zset操作对象
		ZSetOperations<String, Goods> opsForZSet = redisTemplate.opsForZSet();
		
		//获取数据   (pageNum - 1)*pageSize,pageNum*pageSize-1
		Set<Goods> set = opsForZSet.reverseRange("goods_zset",  (pageNum - 1)*pageSize , pageNum*pageSize-1);
		
		//获取总条数
		Long total = opsForZSet.size("goods_zset");
		
		//封装数据
		//封装分页条件
		Page<Goods> page = new Page<Goods>(pageNum, pageSize);
		
		//将数据存入其中
		page.addAll(set);
		
		//设置总条数
		page.setTotal(total);
		
		return new PageInfo<Goods>(page);
	}
	
	
	
}
