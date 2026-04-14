package com.app.historyservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Read-only JPA entity — same table as measurement-service.
 * ddl-auto=none in application.properties so we never modify the schema.
 */
@Entity
@Table(name = "quantity_measurements")
public class QuantityMeasurementEntity {

    @Id
    private Long id;

    private double thisValue;
    private String thisUnit;
    private String thisMeasurementType;

    private double thatValue;
    private String thatUnit;
    private String thatMeasurementType;

    private String operation;
    private double resultValue;
    private String resultUnit;
    private String resultMeasurementType;
    private String resultString;

    private boolean isError;
    private String  errorMessage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuantityMeasurementEntity() {}

    // ── Getters only (read-only) ─────────────────────────────────

    public Long   getId()                    { return id; }
    public double getThisValue()             { return thisValue; }
    public String getThisUnit()              { return thisUnit; }
    public String getThisMeasurementType()   { return thisMeasurementType; }
    public double getThatValue()             { return thatValue; }
    public String getThatUnit()              { return thatUnit; }
    public String getThatMeasurementType()   { return thatMeasurementType; }
    public String getOperation()             { return operation; }
    public double getResultValue()           { return resultValue; }
    public String getResultUnit()            { return resultUnit; }
    public String getResultMeasurementType() { return resultMeasurementType; }
    public String getResultString()          { return resultString; }
    public boolean isError()                 { return isError; }
    public String getErrorMessage()          { return errorMessage; }
    public LocalDateTime getCreatedAt()      { return createdAt; }
    public LocalDateTime getUpdatedAt()      { return updatedAt; }
}
