package com.querydsl.oneequalone.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.oneequalone.dto.SchoolOneToOneSearch;
import com.querydsl.oneequalone.entity.SchoolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

import static com.querydsl.oneequalone.entity.QSchoolEntity.schoolEntity;

@Repository
public class SchoolQueryRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

//  1=1을 사용하는 경우
    public List<SchoolEntity> findOfOneEqualsOne() {
        List<SchoolOneToOneSearch> schoolOneToOneSearches = Arrays.asList(new SchoolOneToOneSearch[]{
                SchoolOneToOneSearch.builder().no(1).address("Seoul").build(),
                SchoolOneToOneSearch.builder().no(3).address("Busan").build(),
        });

        // 조건절 동적 쿼리
        BooleanExpression booleanExpression = Expressions.asString("1").eq("1");
        for (SchoolOneToOneSearch schoolOneToOneSearch : schoolOneToOneSearches) {
            booleanExpression = booleanExpression.and(
                    schoolEntity.no
                            .eq(schoolOneToOneSearch.getNo())
                            .or(schoolEntity.address.eq(schoolOneToOneSearch.getAddress()))
            );
        }

        // 결과 반환
        return jpaQueryFactory
                .selectFrom(schoolEntity)
                .where(booleanExpression)
                .fetch();
    }

//    1=1을 사용하지 않는 경우
//    public List<SchoolEntity> findOfOneEqualsOne() {
//        List<SchoolOneToOneSearch> schoolOneToOneSearchs = Arrays.asList(new SchoolOneToOneSearch[]{
//                SchoolOneToOneSearch.builder().no(1).address("Seoul").build(),
//                SchoolOneToOneSearch.builder().no(3).address("Busan").build(),
//        });
//
//        // 조건절
//        BooleanExpression booleanExpression = null;
//        if(schoolOneToOneSearchs.size() > 0) {
//            SchoolOneToOneSearch schoolOneToOneSearch = schoolOneToOneSearchs.get(0);
//
//            booleanExpression = schoolEntity.no
//                    .eq(schoolOneToOneSearch.getNo())
//                    .or(schoolEntity.address.eq(schoolOneToOneSearch.getAddress()));
//        }
//
//        for (int i=1; i<schoolOneToOneSearchs.size(); i++) {
//            SchoolOneToOneSearch schoolOneToOneSearch = schoolOneToOneSearchs.get(i);
//
//            booleanExpression = booleanExpression.and(
//                    schoolEntity.no
//                            .eq(schoolOneToOneSearch.getNo())
//                            .or(schoolEntity.address.eq(schoolOneToOneSearch.getAddress()))
//            );
//        }
//
//        // 결과 반환
//        return jpaQueryFactory
//                .selectFrom(schoolEntity)
//                .where(booleanExpression)
//                .fetch();
//    }
}
