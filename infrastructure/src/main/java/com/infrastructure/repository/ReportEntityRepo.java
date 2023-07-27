package com.infrastructure.repository;

import com.infrastructure.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportEntityRepo extends CrudRepository<ReportEntity, Integer> {

    public List<ReportEntity> findAllByDate(LocalDateTime dateTime);

    public List<ReportEntity> findAllByLatitudeAndLongitude(double latitude, double longitude);


}
