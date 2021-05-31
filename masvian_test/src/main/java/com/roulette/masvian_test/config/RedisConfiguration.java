package com.roulette.masvian_test.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfiguration {
    
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
         RedisStandaloneConfiguration redis_standalone_configuration = new RedisStandaloneConfiguration();
         redis_standalone_configuration.setHostName("127.0.0.1");
         redis_standalone_configuration.setPort(6379);
         JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redis_standalone_configuration);
         return jedisConnectionFactory;
    } 

    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
           RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
           redisTemplate.setConnectionFactory(jedisConnectionFactory());
           redisTemplate.setKeySerializer(new StringRedisSerializer());
           redisTemplate.setHashKeySerializer(new StringRedisSerializer());
           redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
           redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
           redisTemplate.setEnableTransactionSupport(true);
           redisTemplate.afterPropertiesSet();
           return redisTemplate;
    }
}