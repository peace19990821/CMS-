package com.bawei.test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class RedisTest {

	@Resource
	private RedisTemplate redisTemplate;
	
	//string
	@Test
	public void testString() {
		//获取string类型的操作对象
		ValueOperations opsForValue = redisTemplate.opsForValue();
		
		//存入数据
//		opsForValue.set("name", "张三");
		
		//获取数据
//		Object object = opsForValue.get("name");
//		System.out.println(object);
		
		//修改数据
//		opsForValue.set("name", "李四");
		
		
		//追加数据
//		opsForValue.append("name", "123");
		
		//存入对象数据
		//java.lang.ClassCastException: com.bawei.entity.Person cannot be cast to java.lang.String
//		Person person = new Person(1, "王五", 30);
//		
//		opsForValue.set("per", person);
//		
//		Object object = opsForValue.get("per");
//		System.out.println(object);
		
		//修改数值
//		opsForValue.set("age", "20");
//		
//		opsForValue.increment("age", 3);
		
		Object object = opsForValue.get("age");
		System.out.println(object);
	}
	
	//list
	@Test
	public void testList() {
		//获取list的操作对象
		ListOperations<String, String> opsForList = redisTemplate.opsForList();
		
		//添加数据
//		opsForList.leftPush("list", "java");
//		opsForList.leftPush("list", "mysql");
//		opsForList.leftPush("list", "redis");
//		opsForList.leftPush("list", "tomcat");
		
		//获取数据
//		List<String> list = opsForList.range("list", 0, -1);
		
//		System.out.println(list);
		
		//获取长度
//		Long size = opsForList.size("list");
//		System.out.println(size);
		
		
		//删除数据
		opsForList.remove("list", 0, "java");
		
		List<String> list = opsForList.range("list", 0, -1);
		
		System.out.println(list);
		
	}
	
	//set
	@Test
	public void testSet() {
		//获取set类型的操作对象
		SetOperations opsForSet = redisTemplate.opsForSet();
		
		//存入数据
		opsForSet.add("set1", 1,2,3,4,5,6,7,8);
		opsForSet.add("set2", 1,3,5,7,9);
		
		//获取数据
//		Set set = opsForSet.members("set1");
//		
//		for (Object object : set) {
//			System.out.println(object);
//		}
		
		//删除数据
//		opsForSet.remove("set1", 6,7,8);
//		
//		Set set = opsForSet.members("set1");
//		
//		for (Object object : set) {
//			System.out.println(object);
//		}
		
		
		//交集
//		Set set = opsForSet.intersect("set1", "set2");

		//差集
//		Set set = opsForSet.difference("set1", "set2");
//		Set set = opsForSet.difference("set2", "set1");
		
		//并集
		Set set = opsForSet.union("set1", "set2");
		
		for (Object object : set) {
			System.out.println(object);
		}
	}
	
	//hash
	@Test
	public void testHash() {
		
		//获取hash类型的操作对象
		HashOperations opsForHash = redisTemplate.opsForHash();
		
		//存入数据
		opsForHash.put("stu", "name", "张三");
		opsForHash.put("stu", "age", "30");
		opsForHash.put("stu", "addr", "北京");
		
		//获取数据
		//根据大键和小键获取数据
//		Object object = opsForHash.get("stu", "name");
//		System.out.println(object);
		
		//根据大键获取所有数据
//		Map entries = opsForHash.entries("stu");
//		
//		Set<Entry> entrySet = entries.entrySet();
//		
//		for (Entry entry : entrySet) {
//			System.out.println(entry.getKey() + "===" + entry.getValue());
//		}
		
		//删除数据，删除小键
		opsForHash.delete("stu", "name","age");
		
		Map entries = opsForHash.entries("stu");
		
		Set<Entry> entrySet = entries.entrySet();
		
		for (Entry entry : entrySet) {
			System.out.println(entry.getKey() + "===" + entry.getValue());
		}
	}
	
	//zset
	@Test
	public void testZSet() {
		//获取zset操作对象
		ZSetOperations<String, String> opsForZSet = redisTemplate.opsForZSet();
		
		//存入数据
		
		opsForZSet.add("zset", "小明",80);
		opsForZSet.add("zset", "小强",70);
		opsForZSet.add("zset", "小刚",90);
		opsForZSet.add("zset", "小红",100);
		
		//获取数据
		//默认分数从小到大
//		Set<TypedTuple<String>> set = opsForZSet.rangeWithScores("zset", 0, -1);
		
		//分数从大到小
//		Set<TypedTuple<String>> set = opsForZSet.reverseRangeWithScores("zset", 0, -1);
		
		//根据分数范围获取，默认从小到大
//		Set<TypedTuple<String>> set = opsForZSet.rangeByScoreWithScores("zset", 80, 100);
		
		//根据分数范围获取，从大到小
//		Set<TypedTuple<String>> set = opsForZSet.reverseRangeByScoreWithScores("zset", 80, 100);


		
		//删除数据
		opsForZSet.remove("zset", "小明","小红");
		Set<TypedTuple<String>> set = opsForZSet.rangeWithScores("zset", 0, -1);
		
		for (TypedTuple<String> typedTuple : set) {
			System.out.println(typedTuple.getValue()+"===" + typedTuple.getScore());
		}
	}
	
}
