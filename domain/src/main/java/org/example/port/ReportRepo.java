package org.example.port;

import org.example.entity.Report;

import java.util.List;

public interface ReportRepo {

    Report save(Report report);

    Report findById(int id);

    List<Report> findAll();

    void deleteById(int id);

    Report updateReport(int id, Report report);

}
