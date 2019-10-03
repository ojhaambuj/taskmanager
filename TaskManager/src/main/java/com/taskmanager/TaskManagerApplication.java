package com.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskmanager.config.Auditor;

/**
 * 
 * @author Ambuj
 *
 */
@SpringBootApplication
/*@EnableMongoAuditing
@EnableMongoRepositories
*/@Controller
public class TaskManagerApplication {

	/**
	 * Task Manager Application Root method
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
	
	/**
	 * Display index page
	 * 
	 * @return String
	 */
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	/**
	 * Get Auditor Aware
	 * @return AuditorAware<String>
	 */
	@Bean
	public AuditorAware<String> myAuditorProvider() {
		return new Auditor();
	}

}
