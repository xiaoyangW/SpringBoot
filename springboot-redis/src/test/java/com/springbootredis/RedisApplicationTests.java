package com.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	RedisTemplate<String,String> redisTemplate;

	@Test
	public void redisString() {
		//redis string
		ValueOperations<String, String> valueOperations= redisTemplate.opsForValue();
		valueOperations.set("name","晓阳");

	}
	@Test
	public void redisHash(){
		//redis hash
		HashOperations<String, String, String> hashOperations= redisTemplate.opsForHash();
		Map<String,String> map = new HashMap<>(3);
		map.put("name2","name22");
		map.put("name3","name2233");
		map.put("name4","name2244");
		hashOperations.putAll("names",map);
	}

	@Test
	public void redisSet(){
        SetOperations<String, String> opsForSet = redisTemplate.opsForSet();
        //System.out.println(opsForSet.add("set_test","1","2","3"));
        System.out.println(opsForSet.members("set_test"));
	}
    @Test
	public void redisZSet(){
        ZSetOperations<String, String> opsForZSet = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();
        set.add(new DefaultTypedTuple<>("w", (double) 1L));
        set.add(new DefaultTypedTuple<>("xy", (double) 2L));
        set.add(new DefaultTypedTuple<>("t", (double) 3L));
        opsForZSet.add("zset_test",set);
    }
    @Test
    public void redisList(){
        ListOperations<String, String> opsForList = redisTemplate.opsForList();
        opsForList.leftPushAll("list",Arrays.asList("1","2","3"));
	}

}
