package com.example.kpidashboard.controller;

import com.example.kpidashboard.service.KpiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KpiController {
    private final KpiService kpiService;

    public KpiController(KpiService kpiService) {
        this.kpiService = kpiService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("projectCount", kpiService.getProjectCount());
        model.addAttribute("avgCompletionRate", String.format("%.2f%%", kpiService.getAvgCompletionRate() * 100));
        model.addAttribute("avgReviewParticipation", String.format("%.2f%%", kpiService.getAvgReviewParticipation()));
        model.addAttribute("avgUnapprovedCodeAdoptionRate", String.format("%.2f%%", kpiService.getAvgUnapprovedCodeAdoptionRate()));
        model.addAttribute("avgSAMScore", String.format("%.2f", kpiService.getAvgSAMScore()));
        model.addAttribute("avgUnitTestCoverage", String.format("%.2f%%", kpiService.getAvgUnitTestCoverage()));
        model.addAttribute("avgUnitTestExecutionRate", String.format("%.2f%%", kpiService.getAvgUnitTestExecutionRate()));
        model.addAttribute("avgUnitTestAutomationRate", String.format("%.2f%%", kpiService.getAvgUnitTestAutomationRate()));
        model.addAttribute("avgExceptionTestCaseRate", String.format("%.2f%%", kpiService.getAvgExceptionTestCaseRate()));
        model.addAttribute("avgRequirementsTestCaseAutomationRate", String.format("%.2f%%", kpiService.getAvgRequirementsTestCaseAutomationRate()));
        model.addAttribute("avgRequirementsTestCaseLinkageRate", String.format("%.2f%%", kpiService.getAvgRequirementsTestCaseLinkageRate()));
        model.addAttribute("avgDefectTestCaseConversionRate", String.format("%.2f%%", kpiService.getAvgDefectTestCaseConversionRate()));
        model.addAttribute("avgEarlyDefectDiscoveryRate", String.format("%.2f%%", kpiService.getAvgEarlyDefectDiscoveryRate()));
        model.addAttribute("avgDefectsPerRelease", String.format("%.2f", kpiService.getAvgDefectsPerRelease()));
        return "index";
    }
}
