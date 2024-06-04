package com.jforj.querydslpagination.controller;

import com.jforj.querydslpagination.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Object> getStudents(Pageable pageable) {
        return ResponseEntity.ok(
                studentService.getStudents(pageable)
        );
    }
}
