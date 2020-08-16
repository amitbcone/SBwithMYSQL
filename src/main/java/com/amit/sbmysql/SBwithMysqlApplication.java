package com.amit.sbmysql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBwithMysqlApplication {

	@Autowired
	TrefrAcceptCrit sp;
	public static void main(String[] args) {
		SpringApplication.run(SBwithMysqlApplication.class, args);
	}

}
