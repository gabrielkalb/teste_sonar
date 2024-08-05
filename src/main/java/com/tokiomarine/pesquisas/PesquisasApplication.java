package com.tokiomarine.pesquisas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class PesquisasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PesquisasApplication.class, args);
	}

}
