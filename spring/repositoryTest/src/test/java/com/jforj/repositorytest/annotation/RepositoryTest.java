package com.jforj.repositorytest.annotation;


import com.jforj.repositorytest.config.QuerydslTestConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

// annotation이 class, interface, record 등의 선언에 사용될 수 있도록 설정
@Target(ElementType.TYPE)
// annotation이 runtime 단계에서 사용될 수 있도록 설정
@Retention(RetentionPolicy.RUNTIME)
// annotation이 javadoc 문서화에 표현될 수 있도록 설정
@Documented
// annotation이 부모 클래스에 선언되어 있을 때 자식 클래스에도 상속되도록 설정
@Inherited
// JPA 테스트 코드 구성 설정을 도와주는 어노테이션 ( + @Repository 관련 설정 포함)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class))
// DataJpaTest에 의해 테스트용 데이터베이스가 자동으로 구성되지만, 실제 사용되는 DB를 사용하고 싶은 경우 다음과 같이 설정
// 실제 사용되는 DB를 사용하지 않는 경우 테스트용 데이터베이스 구성을 위한 추가 설정 필요
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// querydsl 사용을 위한 설정 파일 import
@Import(QuerydslTestConfig.class)
public @interface RepositoryTest {
}
