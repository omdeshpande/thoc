package com.thoc.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;

import com.thoc.servicediscovery.configuration.Authentication;

@SpringBootApplication
@EnableEurekaServer
@Import({Authentication.class})
public class Application 
{
    public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
