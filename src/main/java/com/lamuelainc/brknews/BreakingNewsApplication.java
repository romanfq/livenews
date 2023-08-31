package com.lamuelainc.brknews;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class BreakingNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreakingNewsApplication.class, args);
	}

}
