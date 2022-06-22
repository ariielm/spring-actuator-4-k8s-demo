package com.ariielm.springactuator4k8sdemo.healthindicator.customliveness;

public class CustomLivenessHealthRecover {

    private CustomLivenessHealthRecover(){}

    public static void recoverHealth() {
        CustomLivenessHealthIndicator.makeHealthy();
    }
}
