package com.jforj.soliddip.bestcase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerCase {
    private final ServiceCaseInterface serviceCaseInterface;

    @GetMapping("/names")
    public ResponseEntity<List<String>> getNames() {
        return ResponseEntity.ok(serviceCaseInterface.getNames());
    }
}
