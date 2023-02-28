package com.thoc.frontend.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.client.HttpClient;

@Configuration
@EnableDiscoveryClient
public class General
{
	@Bean
    public WebClient restClient()
    { 
        return this.restClientBuilder().clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true))).build();
    }
	
	@Bean
    @LoadBalanced
    public WebClient.Builder restClientBuilder() 
	{
        return WebClient.builder();
    }
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
