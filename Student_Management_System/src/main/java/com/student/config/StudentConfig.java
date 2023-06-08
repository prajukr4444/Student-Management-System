package com.student.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.student"})
public class StudentConfig 
{
	
}


/**
 * 			==> This is a configuration class of our base packages
 * 				
 * 			==> It lets the spring to know that those are packages where we have our Component,
 * 			   Repository,Controller and we need spring to create objects for them
 * 
 * */
 