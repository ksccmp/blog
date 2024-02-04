package com.jforj.servicetest.service;

import com.jforj.servicetest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<String> searchNames() {
        List<String> names = studentRepository.selectNames();
        return formatNames(names);
    }

    /**
     * name의 prefix에 service를 붙이도록 formatting 수행
     *
     * @param names 이름 목록
     * @return formatting된 이름 목록
     */
    private List<String> formatNames(List<String> names) {
        return names
                .stream()
                .map(name -> "service".concat(name))
                .collect(Collectors.toList());
    }
}
