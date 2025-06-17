package com.example.kpidashboard.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class KpiService {
    private int totalVisitors;
    private int totalSignups;
    private double conversionRate;

    @PostConstruct
    public void init() throws IOException {
        ClassPathResource resource = new ClassPathResource("data/sample_data.csv");
        try (InputStream is = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                if (first) {
                    first = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    totalVisitors += Integer.parseInt(parts[1].trim());
                    totalSignups += Integer.parseInt(parts[2].trim());
                }
            }
        }
        if (totalVisitors != 0) {
            conversionRate = totalSignups / (double) totalVisitors;
        }
    }

    public int getTotalVisitors() {
        return totalVisitors;
    }

    public int getTotalSignups() {
        return totalSignups;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}
