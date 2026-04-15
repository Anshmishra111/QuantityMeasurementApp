package com.app.historyservice.service;

import com.app.historyservice.dto.QuantityMeasurementDTO;
import com.app.historyservice.repository.IHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * UC18 – History Service Implementation.
 * All operations are READ-ONLY against the shared H2 file DB.
 */
@Service
public class HistoryServiceImpl implements IHistoryService {

    private final IHistoryRepository repository;

    public HistoryServiceImpl(IHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<QuantityMeasurementDTO> getAll() {
        return QuantityMeasurementDTO.fromEntityList(repository.findAll());
    }

    @Override
    public List<QuantityMeasurementDTO> getByOperation(String operation) {
        return QuantityMeasurementDTO.fromEntityList(
                repository.findByOperation(operation.toUpperCase()));
    }

    @Override
    public List<QuantityMeasurementDTO> getByType(String measurementType) {
        return QuantityMeasurementDTO.fromEntityList(
                repository.findByThisMeasurementType(measurementType));
    }

    @Override
    public List<QuantityMeasurementDTO> getErrorHistory() {
        return QuantityMeasurementDTO.fromEntityList(repository.findByIsError(true));
    }

    @Override
    public Map<String, Object> getCount(String operation) {
        long count = repository.countByOperationAndIsErrorFalse(operation.toUpperCase());
        return Map.of("operation", operation.toUpperCase(), "count", count);
    }
}
