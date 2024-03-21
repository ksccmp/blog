package com.jforj.soliddip.badcase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerCase {
    private final ServiceCase serviceCase;

    @GetMapping("/names")
    public ResponseEntity<List<String>> getNames() {
        return ResponseEntity.ok(serviceCase.getNames());
    }
}
