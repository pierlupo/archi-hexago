package com.infrastructure.repository.Impl;

import com.infrastructure.entity.ReportEntity;
import com.infrastructure.repository.ReportEntityRepo;
import org.example.entity.Report;
import org.example.port.ReportRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ReportRepoImpl implements ReportRepo {

    @Autowired
    private ReportEntityRepo reportEntityRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Report save(Report report) {
        ReportEntity reportEntity = modelMapper.map(report, ReportEntity.class);
        reportEntityRepo.save(reportEntity);
        return report;
    }

    @Override
    public Report findById(int reportId) {
        Optional<ReportEntity> reportEntityOptional = reportEntityRepo.findById(reportId);
        if(reportEntityOptional.isPresent()) {
            return modelMapper.map(reportEntityOptional.get(), Report.class);
        }
        throw new RuntimeException("Report Not found");
    }

    @Override
    public List<Report> findAll() {
        List<Report> reports = new ArrayList<>();
        reportEntityRepo.findAll().forEach(r -> {
            reports.add(modelMapper.map(r, Report.class));
        });
        return reports;
    }

    @Override
    public void deleteById(int reportId) {
        reportEntityRepo.deleteById(reportId);
    }

    @Override
    public Report updateReport(int reportId, Report report) {
    return null;
    }
}
