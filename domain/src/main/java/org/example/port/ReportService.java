package org.example.port;

import org.example.entity.Report;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReportService {

    Report createReport(double latitude, double longitude, LocalDateTime date, int level, String comment);
    List<Report> listRecentReports();
    Report findReportById(int reportId);
    void deleteReport(int reportId);
    Report updateReport(int reportId, Report report);
}
