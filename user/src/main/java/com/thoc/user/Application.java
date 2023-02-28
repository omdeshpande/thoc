package com.thoc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.*;
import com.thoc.user.configuration.*;

@SpringBootApplication
@EnableDiscoveryClient
@Import({Authentication.class, General.class, Session.class})
public class Application
{

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

}
