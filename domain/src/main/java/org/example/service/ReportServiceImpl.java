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
    public Report createReport(double latitude, double longitude, int level, String comment) {
        Report report = new Report(latitude, longitude, LocalDateTime.now(), level, comment);
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
    public List<Report> getAllReports() {
        return reportRepo.findAll();
    }

    @Override
    public List<Report> getReportsByDate(LocalDateTime dateTime) {
        return reportRepo.findAllByDate(dateTime);
    }

    @Override
    public List<Report> getReportsByLocation(double latitude, double longitude) {
        return reportRepo.findAllByLocation(latitude, longitude);
    }

    @Override
    public Report findReportById(int reportId) {
        return reportRepo.findById(reportId);
    }

    @Override
    public void deleteReport(int reportId) {

        try {
            Report report = findReportById(reportId);
            reportRepo.delete(report);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    @Override
    public Report updateReport(int reportId, Report report) {
        try {
            Report oldReport = findReportById(reportId);
            oldReport.setComment(report.getComment());
            oldReport.setLevel(report.getLevel());
            oldReport.setLatitude(report.getLatitude());
            oldReport.setLongitude(report.getLongitude());
            return reportRepo.save(oldReport);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}