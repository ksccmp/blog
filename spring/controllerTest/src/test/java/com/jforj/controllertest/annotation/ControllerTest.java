package com.jforj.controllertest.annotation;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

// annotation이 class, interface, record 등의 선언에 사용될 수 있도록 설정
@Target(ElementType.TYPE)
// annotation이 runtime 단계에서 사용될 수 있도록 설정
@Retention(RetentionPolicy.RUNTIME)
// annotation이 javadoc 문서화에 표현될 수 있도록 설정
@Documented
// annotation이 부모 클래스에 선언되어 있을 때 자식 클래스에도 상속되도록 설정
@Inherited
// spring 통합 테스트를 위한 사용 환경 설정
@SpringBootTest
// mockMvc 사용을 위한 설정
@AutoConfigureMockMvc
public @interface ControllerTest {
}
