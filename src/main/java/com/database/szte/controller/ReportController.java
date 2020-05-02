package com.database.szte.controller;

import com.database.szte.data.Report;
import com.database.szte.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private IReportService reportService;

    @GetMapping("/reports")
    public List<Report> getReports() {
        return reportService.getAllReport();
    }

}
