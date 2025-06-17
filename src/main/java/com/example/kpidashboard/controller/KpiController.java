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
        model.addAttribute("totalVisitors", kpiService.getTotalVisitors());
        model.addAttribute("totalSignups", kpiService.getTotalSignups());
        model.addAttribute("conversionRate", String.format("%.2f%%", kpiService.getConversionRate() * 100));
        return "index";
    }
}
