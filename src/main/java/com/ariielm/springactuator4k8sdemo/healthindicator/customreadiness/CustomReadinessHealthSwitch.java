package com.ariielm.springactuator4k8sdemo.healthindicator.customreadiness;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomReadinessHealthSwitch {

    @GetMapping(path = "/readiness/unhealthy")
    @ResponseBody
    public boolean unhealthy() {
        return CustomReadinessHealthIndicator.makeUnhealthy();
    }

    @GetMapping(path = "/readiness/healthy")
    @ResponseBody
    public boolean healthy() {
        return CustomReadinessHealthIndicator.makeHealthy();
    }
}
