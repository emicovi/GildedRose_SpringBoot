package com.gildedrose.gildedRose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories
@SpringBootApplication
public class GildedRoseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GildedRoseApplication.class, args);
	}

}
