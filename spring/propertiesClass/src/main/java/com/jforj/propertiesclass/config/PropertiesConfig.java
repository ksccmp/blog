package com.jforj.propertiesclass.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties({
//        SpringProperties.class // properties로 관리될 클래스를 각각 등록
//})
@ConfigurationPropertiesScan("**.properties") // 패키지 구조에서 properties가 포함되는 모든 클래스 등록
public class PropertiesConfig {

}
