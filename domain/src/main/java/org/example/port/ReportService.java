package org.example.port;

import org.example.entity.Report;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReportService {

    Report createReport(double latitude, double longitude, int level, String comment);
    List<Report> listRecentReports();
    List<Report> getAllReports();
    List<Report> getReportsByDate(LocalDateTime dateTime);
    List<Report> getReportsByLocation(double latitude, double longitude);
    Report findReportById(int reportId);
    void deleteReport(int reportId);
    Report updateReport(int reportId, Report report);
}
