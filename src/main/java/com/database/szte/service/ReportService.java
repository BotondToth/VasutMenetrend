package com.database.szte.service;

import com.database.szte.data.Report;
import com.database.szte.repository.ReportMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {

    @Autowired
    private ReportMongoRepository reportMongoRepository;

    @Override
    public List<Report> getAllReport() {
        return this.reportMongoRepository.findAll();
    }
}
