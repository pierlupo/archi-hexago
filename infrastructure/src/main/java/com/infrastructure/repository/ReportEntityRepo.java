package com.infrastructure.repository;

import com.infrastructure.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportEntityRepo extends CrudRepository<ReportEntity, Integer> {
}
