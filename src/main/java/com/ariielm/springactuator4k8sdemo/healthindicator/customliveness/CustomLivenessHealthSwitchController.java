package com.ariielm.springactuator4k8sdemo.healthindicator.customliveness;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomLivenessHealthSwitchController {

    @GetMapping(path = "/liveness/unhealthy")
    @ResponseBody
    public boolean unhealthy() {
        return CustomLivenessHealthIndicator.makeUnhealthy();
    }

    @GetMapping(path = "/liveness/healthy")
    @ResponseBody
    public boolean healthy() {
        return CustomLivenessHealthIndicator.makeHealthy();
    }
}
