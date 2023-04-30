package com.lambda.apigateway.function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class LambdaApiGatewayFunction implements Function<APIGatewayProxyRequestEvent, List<String>> {

    @Override
    public List<String> apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        log.info("lambda apply 수행");

        List<String> strings = new ArrayList<>();

        if(StringUtils.hasText(apiGatewayProxyRequestEvent.getBody())) {
            Map<String, Object> map = new ObjectMapper().convertValue(apiGatewayProxyRequestEvent.getBody(), Map.class);
            strings.add(map.get("title").toString());
            strings.add(map.get("name").toString());
        }

        strings.add("sample");

        log.info("lambda apply 종료");

        return strings;
    }
}
