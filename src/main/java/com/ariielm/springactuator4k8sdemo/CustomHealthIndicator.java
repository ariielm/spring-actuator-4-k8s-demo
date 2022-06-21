package com.ariielm.springactuator4k8sdemo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    private boolean isHealthy = true;

    @Override
    public Health health() {
        return isHealthy ? Health.up().build() : Health.down().build();
    }

    public boolean reverseHealth() {
        isHealthy = !isHealthy;
        return isHealthy;
    }

}