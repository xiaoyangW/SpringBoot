package com.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	RedisTemplate<String,String> redisTemplate;

	@Test
	public void contextLoads() {
		/*ValueOperations<String, String> valueOperations= redisTemplate.opsForValue();
		valueOperations.set("name","晓阳");*/
		HashOperations<String, String, String> hashOperations= redisTemplate.opsForHash();
		Map<String,String> map = new HashMap<>(3);
		map.put("name2","name22");
		map.put("name3","name2233");
		map.put("name4","name2244");
		hashOperations.putAll("names",map);
	}

}
