package com.thoc.header.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Configuration
@EnableRedisHttpSession
public class Session extends AbstractHttpSessionApplicationInitializer 
{
	/**
	 * Redis standalone host.
	 */
	@Value(value = "${spring.redis.host}")
	private String redisHost;
	
    @Bean
    public JedisConnectionFactory connectionFactory()
    {
        return new JedisConnectionFactory(
        	new RedisStandaloneConfiguration(this.redisHost)
        );
    }
}
