package com.lambda.apigateway;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.lambda.apigateway.function.LambdaApiGatewayFunction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class LambdaApiGatewayApplication {

    @Bean
    public Function<APIGatewayProxyRequestEvent, List<String>> lambdaApiGatewayFunctionBean() {
        return new LambdaApiGatewayFunction();
    }

    public static void main(String[] args) {
        SpringApplication.run(LambdaApiGatewayApplication.class, args);
    }
}
