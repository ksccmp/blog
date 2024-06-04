package com.jforj.querydslpagination;

import com.jforj.querydslpagination.dto.PagingStudent;
import com.jforj.querydslpagination.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Page<PagingStudent> getStudents(Pageable pageable) {
        return studentRepository.getStudents(pageable);
    }
}
