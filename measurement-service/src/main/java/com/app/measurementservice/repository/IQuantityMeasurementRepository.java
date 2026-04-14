package com.app.measurementservice.repository;

import com.app.measurementservice.entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Long> {

    List<QuantityMeasurementEntity> findByOperation(String operation);
    List<QuantityMeasurementEntity> findByThisMeasurementType(String type);
    List<QuantityMeasurementEntity> findByIsError(boolean isError);
    long countByOperationAndIsErrorFalse(String operation);

    @Query("SELECT e FROM QuantityMeasurementEntity e " +
           "WHERE e.operation = :operation AND e.isError = false " +
           "ORDER BY e.createdAt DESC")
    List<QuantityMeasurementEntity> findSuccessfulByOperation(@Param("operation") String operation);
}
