package com.gildedrose.gildedRose;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.gildedrose.gildedRose")
@EnableJpaRepositories("com.gildedrose.gildedRose")
public class AopConfig {

}
