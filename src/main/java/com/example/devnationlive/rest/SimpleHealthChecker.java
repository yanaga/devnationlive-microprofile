package com.example.devnationlive.rest;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

@Health
@ApplicationScoped
public class SimpleHealthChecker implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("simple-check").up().build();
    }
}
