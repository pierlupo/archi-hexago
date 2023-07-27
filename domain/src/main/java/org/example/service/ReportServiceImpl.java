package org.example.service;

import org.example.entity.Report;
import org.example.port.ReportRepo;
import org.example.port.ReportService;

import java.time.LocalDateTime;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportRepo reportRepo;

    public ReportServiceImpl(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public Report createReport(double latitude, double longitude, LocalDateTime date, int level, String comment) {
        Report report = new Report(latitude, longitude, date, level, comment);
        try {
            this.reportRepo.save(report);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return reportRepo.save(report);
    }

    @Override
    public List<Report> listRecentReports() {
        return reportRepo.findAll();
    }

    @Override
    public Report findReportById(int reportId) {
        return reportRepo.findById(reportId);
    }

    @Override
    public void deleteReport(int reportId) {
        reportRepo.deleteById(reportId);
    }

    @Override
    public Report updateReport(int reportId, Report report) {
        reportRepo.findById(reportId);
        if(reportId > 0) {
            try {
                report.setLatitude(report.getLatitude());
                report.setLongitude(report.getLongitude());
                report.setDate(report.getDate());
                report.setLevel(report.getLevel());
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
       return  reportRepo.save(report);
    }
}
