package com.github.flyfor;

import com.github.flyfor.config.ApiServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApiServerConfig.class)
public class FlyflyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyflyApplication.class, args);
	}
}
