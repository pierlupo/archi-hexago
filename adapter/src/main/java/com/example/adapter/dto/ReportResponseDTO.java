package com.example.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDTO {
    private int id;
    private double latitude;
    private double longitude;
    private LocalDateTime date;
    private int level;
    private String comment;
}
