package com.jforj.controllertest.controller;

import com.jforj.controllertest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/names")
    public ResponseEntity<List<String>> getNames() {
        List<String> names = studentService.searchNames();
        return ResponseEntity.ok(formatNames(names));
    }

    /**
     * name의 prefix에 controller를 붙이도록 formatting 수행
     *
     * @param names 이름 목록
     * @return formatting된 이름 목록
     */
    private List<String> formatNames(List<String> names) {
        return names
                .stream()
                .map(name -> "controller".concat(name))
                .collect(Collectors.toList());
    }
}
