package com.thoc.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import com.thoc.frontend.configuration.Authentication;
import com.thoc.frontend.configuration.General;
import com.thoc.frontend.configuration.Session;

@SpringBootApplication
@EnableDiscoveryClient
@Import({Authentication.class, Session.class, General.class})
public class Application 
{
    public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
