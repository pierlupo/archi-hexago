package com.infrastructure.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "report")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportEntity {


    @Id
    private int id;

    @Column(name="title")
    @Size(min=4, message ="Username too short; must have at least {min} characters")
    private String title;

    @Column(name="date")
    private Date date;

    @Column(name="localization")
    private String localization;

    @Column(name="description")
    private String description;
}
