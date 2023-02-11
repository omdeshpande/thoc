package com.thoc.user.configuration;

import org.springframework.context.annotation.*;
import org.modelmapper.ModelMapper;

@Configuration
public class General
{
    @Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
