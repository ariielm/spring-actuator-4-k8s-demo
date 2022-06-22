package com.ariielm.springactuator4k8sdemo.healthindicator.customliveness;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class CustomLivenessHealthIndicator implements HealthIndicator {

    private static boolean isHealthy = true;

    @Override
    public Health health() {
        return isHealthy ? Health.up().build() : Health.down().build();
    }

    public static boolean makeUnhealthy() {
        isHealthy = false;
        scheduleRecovery();
        return isHealthy;
    }

    public static boolean makeHealthy() {
        isHealthy = true;
        return isHealthy;
    }

    private static void scheduleRecovery() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(CustomLivenessHealthRecover::recoverHealth, 20, TimeUnit.SECONDS);
    }

}