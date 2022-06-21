package com.ariielm.springactuator4k8sdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReverseCustomHealth {

    private final CustomHealthIndicator customHealthIndicator;

    @Autowired
    public ReverseCustomHealth(CustomHealthIndicator customHealthIndicator) {
        this.customHealthIndicator = customHealthIndicator;
    }

    @GetMapping(path = "/reverse")
    @ResponseBody
    public boolean reverse() {
        return this.customHealthIndicator.reverseHealth();
    }
}
