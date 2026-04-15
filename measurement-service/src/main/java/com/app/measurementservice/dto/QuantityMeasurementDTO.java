package com.app.measurementservice.dto;

import com.app.measurementservice.entity.QuantityMeasurementEntity;

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

    // ── Getters & Setters ────────────────────────────────────────

    public double  getThisValue()                      { return thisValue; }
    public void    setThisValue(double v)              { this.thisValue = v; }
    public String  getThisUnit()                       { return thisUnit; }
    public void    setThisUnit(String v)               { this.thisUnit = v; }
    public String  getThisMeasurementType()            { return thisMeasurementType; }
    public void    setThisMeasurementType(String v)    { this.thisMeasurementType = v; }
    public double  getThatValue()                      { return thatValue; }
    public void    setThatValue(double v)              { this.thatValue = v; }
    public String  getThatUnit()                       { return thatUnit; }
    public void    setThatUnit(String v)               { this.thatUnit = v; }
    public String  getThatMeasurementType()            { return thatMeasurementType; }
    public void    setThatMeasurementType(String v)    { this.thatMeasurementType = v; }
    public String  getOperation()                      { return operation; }
    public void    setOperation(String v)              { this.operation = v; }
    public String  getResultString()                   { return resultString; }
    public void    setResultString(String v)           { this.resultString = v; }
    public double  getResultValue()                    { return resultValue; }
    public void    setResultValue(double v)            { this.resultValue = v; }
    public String  getResultUnit()                     { return resultUnit; }
    public void    setResultUnit(String v)             { this.resultUnit = v; }
    public String  getResultMeasurementType()          { return resultMeasurementType; }
    public void    setResultMeasurementType(String v)  { this.resultMeasurementType = v; }
    public String  getErrorMessage()                   { return errorMessage; }
    public void    setErrorMessage(String v)           { this.errorMessage = v; }
    public boolean isError()                           { return error; }
    public void    setError(boolean v)                 { this.error = v; }
}
