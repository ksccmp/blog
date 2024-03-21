package com.jforj.soliddip.bestcase;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ServiceCaseImpl implements ServiceCaseInterface {

    @Override
    public List<String> getNames() {
        return Arrays.asList("Henry", "Scott", "Semi");
    }
}
