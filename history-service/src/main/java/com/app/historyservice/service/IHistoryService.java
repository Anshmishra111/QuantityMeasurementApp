package com.app.historyservice.service;

import com.app.historyservice.dto.QuantityMeasurementDTO;

import java.util.List;
import java.util.Map;

public interface IHistoryService {
    List<QuantityMeasurementDTO> getAll();
    List<QuantityMeasurementDTO> getByOperation(String operation);
    List<QuantityMeasurementDTO> getByType(String measurementType);
    List<QuantityMeasurementDTO> getErrorHistory();
    Map<String, Object>          getCount(String operation);
}
