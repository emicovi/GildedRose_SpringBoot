package com.gildedrose.gildedRose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GildedRoseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GildedRoseApplication.class, args);
	}

}
