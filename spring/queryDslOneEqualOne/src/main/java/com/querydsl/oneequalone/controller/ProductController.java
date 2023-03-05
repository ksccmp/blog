package com.querydsl.oneequalone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin("*")
public class ProductController {

    @GetMapping("/product/no")
    public ResponseEntity<Object> productNo() {
        List<Integer> productNos = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        return ResponseEntity.ok(productNos);
    }

    @GetMapping("/product/detail")
    public ResponseEntity<Object> productDetail(HttpServletRequest req, int productNo) {
        Map<String, Object> map = new HashMap<>();

        switch (productNo) {
            case 1: {
                map.put("name", "첫번째 상품");
                map.put("price", 3200);
                map.put("stock", 58);
                break;
            }

            case 2: {
                map.put("name", "두번째 상품");
                map.put("price", 5800);
                map.put("stock", 101);
                break;
            }

            default: {
                map.put("name", "그외 상품");
                map.put("price", 1000);
                map.put("stock", 10);
                break;
            }
        }

        log.info("servletPath: " + req.getServletPath());
        log.info("returnData: " + map.toString());

        return ResponseEntity.ok(map);
    }
}
