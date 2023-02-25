package com.thoc.frontend.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.client.HttpClient;

@Configuration
public class General
{
	@Bean 
    public WebClient restClient()
    { 
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true))).build();
    }
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
