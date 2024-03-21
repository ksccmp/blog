package com.jforj.soliddip.badcase;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ServiceCase {

    public List<String> getNames() {
        return Arrays.asList("Henry", "Scott", "Semi");
    }
}
