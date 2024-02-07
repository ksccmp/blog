package com.jforj.propertiesclass.service;

import com.jforj.propertiesclass.properties.SpringProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertiesService {
    private final SpringProperties springProperties;

    public void print() {
        log.info("properties에 담겨 있는 데이터 >>> ".concat(springProperties.data())); // record 변수 사용 방식으로 변경
    }
}
