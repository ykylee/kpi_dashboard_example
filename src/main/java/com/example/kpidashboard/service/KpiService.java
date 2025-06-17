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
    private int projectCount;
    private double avgCompletionRate;
    private double avgReviewParticipation;
    private double avgUnapprovedCodeAdoptionRate;
    private double avgSAMScore;
    private double avgUnitTestCoverage;
    private double avgUnitTestExecutionRate;
    private double avgUnitTestAutomationRate;
    private double avgExceptionTestCaseRate;
    private double avgRequirementsTestCaseAutomationRate;
    private double avgRequirementsTestCaseLinkageRate;
    private double avgDefectTestCaseConversionRate;
    private double avgEarlyDefectDiscoveryRate;
    private double avgDefectsPerRelease;

    @PostConstruct
    public void init() throws IOException {
        ClassPathResource resource = new ClassPathResource("data/kpi_data.csv");
        try (InputStream is = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = reader.readLine(); // header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 14) {
                    continue;
                }
                projectCount++;
                avgCompletionRate += Double.parseDouble(parts[1]);
                avgReviewParticipation += Double.parseDouble(parts[2]);
                avgUnapprovedCodeAdoptionRate += Double.parseDouble(parts[3]);
                avgSAMScore += Double.parseDouble(parts[4]);
                avgUnitTestCoverage += Double.parseDouble(parts[5]);
                avgUnitTestExecutionRate += Double.parseDouble(parts[6]);
                avgUnitTestAutomationRate += Double.parseDouble(parts[7]);
                avgExceptionTestCaseRate += Double.parseDouble(parts[8]);
                avgRequirementsTestCaseAutomationRate += Double.parseDouble(parts[9]);
                avgRequirementsTestCaseLinkageRate += Double.parseDouble(parts[10]);
                avgDefectTestCaseConversionRate += Double.parseDouble(parts[11]);
                avgEarlyDefectDiscoveryRate += Double.parseDouble(parts[12]);
                avgDefectsPerRelease += Double.parseDouble(parts[13]);
            }
        }
        if (projectCount > 0) {
            avgCompletionRate /= projectCount;
            avgReviewParticipation /= projectCount;
            avgUnapprovedCodeAdoptionRate /= projectCount;
            avgSAMScore /= projectCount;
            avgUnitTestCoverage /= projectCount;
            avgUnitTestExecutionRate /= projectCount;
            avgUnitTestAutomationRate /= projectCount;
            avgExceptionTestCaseRate /= projectCount;
            avgRequirementsTestCaseAutomationRate /= projectCount;
            avgRequirementsTestCaseLinkageRate /= projectCount;
            avgDefectTestCaseConversionRate /= projectCount;
            avgEarlyDefectDiscoveryRate /= projectCount;
            avgDefectsPerRelease /= projectCount;
        }
    }

    public int getProjectCount() { return projectCount; }
    public double getAvgCompletionRate() { return avgCompletionRate; }
    public double getAvgReviewParticipation() { return avgReviewParticipation; }
    public double getAvgUnapprovedCodeAdoptionRate() { return avgUnapprovedCodeAdoptionRate; }
    public double getAvgSAMScore() { return avgSAMScore; }
    public double getAvgUnitTestCoverage() { return avgUnitTestCoverage; }
    public double getAvgUnitTestExecutionRate() { return avgUnitTestExecutionRate; }
    public double getAvgUnitTestAutomationRate() { return avgUnitTestAutomationRate; }
    public double getAvgExceptionTestCaseRate() { return avgExceptionTestCaseRate; }
    public double getAvgRequirementsTestCaseAutomationRate() { return avgRequirementsTestCaseAutomationRate; }
    public double getAvgRequirementsTestCaseLinkageRate() { return avgRequirementsTestCaseLinkageRate; }
    public double getAvgDefectTestCaseConversionRate() { return avgDefectTestCaseConversionRate; }
    public double getAvgEarlyDefectDiscoveryRate() { return avgEarlyDefectDiscoveryRate; }
    public double getAvgDefectsPerRelease() { return avgDefectsPerRelease; }
}
