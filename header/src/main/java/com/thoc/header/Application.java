package com.thoc.header;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.thoc.header.configuration.Authentication;
import com.thoc.header.configuration.Session;

@SpringBootApplication
@Import({Authentication.class, Session.class})
public class Application 
{
    public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
