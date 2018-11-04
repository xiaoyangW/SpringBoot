package com.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {



	@Test
	public void contextLoads() {
		RedisTemplate  redisTemplate = new RedisTemplate();
		 redisTemplate.opsForValue().append("name","晓阳");
	}

}
