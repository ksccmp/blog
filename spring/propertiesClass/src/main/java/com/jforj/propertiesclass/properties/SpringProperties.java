package com.jforj.propertiesclass.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("spring.properties") // properties or yml 파일의 spring.properties 하위에 있는 변수 값을 필드 값으로 정의할 수 있음
@Validated // 클래스 내부 변수값 유효성 검증을 하도록 설정 추가
public record SpringProperties(
        @NotBlank // 값이 null, 빈 문자열, 공백으로만 이루어진 문자열인 경우 exception 발생
        String data // spring.properties.data
) {
}
