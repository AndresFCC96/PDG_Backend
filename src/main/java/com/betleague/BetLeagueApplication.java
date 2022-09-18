package com.betleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.betleague.mapper")
public class BetLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetLeagueApplication.class, args);
	}

}
