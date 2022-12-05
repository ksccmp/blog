package com.lambda.batch;

import com.lambda.batch.consumer.LambdaLogConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class LambdaBatchApplication {

	@Bean
	public Consumer<Object> lambdaLogConsumerBean() {
		return new LambdaLogConsumer();
	}

	public static void main(String[] args) {
		SpringApplication.run(LambdaBatchApplication.class, args);
	}

}
