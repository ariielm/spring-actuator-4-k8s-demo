package com.ariielm.springactuator4k8sdemo.healthindicator.customreadiness;

public class CustomReadinessHealthRecover {

    private CustomReadinessHealthRecover(){}

    public static void recoverHealth() {
        CustomReadinessHealthIndicator.makeHealthy();
    }
}
