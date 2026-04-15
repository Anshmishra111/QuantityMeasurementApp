package com.app.historyservice.dto;

import com.app.historyservice.entity.QuantityMeasurementEntity;

import java.util.List;
import java.util.stream.Collectors;

public class QuantityMeasurementDTO {

    private double  thisValue;
    private String  thisUnit;
    private String  thisMeasurementType;
    private double  thatValue;
    private String  thatUnit;
    private String  thatMeasurementType;
    private String  operation;
    private String  resultString;
    private double  resultValue;
    private String  resultUnit;
    private String  resultMeasurementType;
    private String  errorMessage;
    private boolean error;

    public QuantityMeasurementDTO() {}

    public static QuantityMeasurementDTO fromEntity(QuantityMeasurementEntity e) {
        QuantityMeasurementDTO d = new QuantityMeasurementDTO();
        d.thisValue             = e.getThisValue();
        d.thisUnit              = e.getThisUnit();
        d.thisMeasurementType   = e.getThisMeasurementType();
        d.thatValue             = e.getThatValue();
        d.thatUnit              = e.getThatUnit();
        d.thatMeasurementType   = e.getThatMeasurementType();
        d.operation             = e.getOperation();
        d.resultString          = e.getResultString();
        d.resultValue           = e.getResultValue();
        d.resultUnit            = e.getResultUnit();
        d.resultMeasurementType = e.getResultMeasurementType();
        d.errorMessage          = e.getErrorMessage();
        d.error                 = e.isError();
        return d;
    }

    public static List<QuantityMeasurementDTO> fromEntityList(List<QuantityMeasurementEntity> list) {
        return list.stream().map(QuantityMeasurementDTO::fromEntity).collect(Collectors.toList());
    }

    public double  getThisValue()               { return thisValue; }
    public String  getThisUnit()                { return thisUnit; }
    public String  getThisMeasurementType()     { return thisMeasurementType; }
    public double  getThatValue()               { return thatValue; }
    public String  getThatUnit()                { return thatUnit; }
    public String  getThatMeasurementType()     { return thatMeasurementType; }
    public String  getOperation()               { return operation; }
    public String  getResultString()            { return resultString; }
    public double  getResultValue()             { return resultValue; }
    public String  getResultUnit()              { return resultUnit; }
    public String  getResultMeasurementType()   { return resultMeasurementType; }
    public String  getErrorMessage()            { return errorMessage; }
    public boolean isError()                    { return error; }
}
