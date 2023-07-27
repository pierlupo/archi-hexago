package com.example.adapter.controller;


import com.example.adapter.dto.ReportRequestDTO;
import com.example.adapter.dto.ReportResponseDTO;
import org.example.entity.Report;
import org.example.port.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {

    private final ReportService reportService;

    private final ModelMapper modelMapper;

    public ReportController(ReportService reportService, ModelMapper modelMapper) {
        this.reportService = reportService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<ReportResponseDTO> post(@RequestBody ReportRequestDTO reportRequestDTO) {
        return ResponseEntity.ok(
                modelMapper.map(
                        reportService.createReport(
                                reportRequestDTO.getLatitude(),
                                reportRequestDTO.getLongitude(),
                                reportRequestDTO.getLevel(),
                                reportRequestDTO.getComment()),
                        ReportResponseDTO.class)
        );
    }

    @GetMapping("")
    public ResponseEntity<List<ReportResponseDTO>> getReports() {
        return ResponseEntity.ok(convertToListReports(reportService.getAllReports()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReportResponseDTO> getReport(int id) {
        return ResponseEntity.ok(modelMapper.map(reportService.findReportById(id), ReportResponseDTO.class));
    }
    @GetMapping("/location/{latitude}/{longitude}")
    public ResponseEntity<List<ReportResponseDTO>> getReportsByLocation(double latitude, double longitude) {
        return ResponseEntity.ok(convertToListReports(reportService.getReportsByLocation(latitude, longitude)));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ReportResponseDTO>> getReportsByDate(LocalDateTime date) {
        return ResponseEntity.ok(convertToListReports(reportService.getReportsByDate(date)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ReportResponseDTO> edit(int id, @RequestBody ReportRequestDTO reportRequestDTO) {
        return  ResponseEntity.ok(
                modelMapper.map(
                        reportService.updateReport(id, modelMapper.map(reportRequestDTO, Report.class)),
                        ReportResponseDTO.class)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(int id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok("Report deleted");
    }


    private List<ReportResponseDTO> convertToListReports(List<Report> reports) {
        List<ReportResponseDTO> reportResponseDTOS = new ArrayList<>();
        reports.forEach(r ->reportResponseDTOS.add(modelMapper.map(r, ReportResponseDTO.class)));
        return reportResponseDTOS;
    }
    //Other EndPoints
}
