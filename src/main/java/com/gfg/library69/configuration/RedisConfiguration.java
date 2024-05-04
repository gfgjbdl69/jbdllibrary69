package com.gfg.library69.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    /**
     * Caching -> Redis
     *
     * 1. dependency
     * 2. Driver -> Redis
     *   a.Lettuce
     *   b. Jedis
     *
     * 3. Create a connection bean
     * 4. Create a template to access the data.
     *
     *
     *
     * */

    @Bean
    public LettuceConnectionFactory getLettuceConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration("redis-17842.c93.us-east-1-3.ec2.redns.redis-cloud.com", 17842);
        redisStandaloneConfiguration.setPassword("pgNn9mm2rh6F5ujQQk3AcGQ547VGTtwB");
        LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceConnectionFactory;
    }

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
       // redisTemplate.setHashKeySerializer(new StringRedisSerializer());
       // redisTemplate.setValueSerializer(new StringRedisSerializer());
      //  redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }

}
