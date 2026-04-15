package com.app.measurementservice.dto.request;

import com.app.measurementservice.entity.QuantityDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConvertRequestDTO {

    @Valid @NotNull(message = "thisQuantity must not be null")
    private QuantityDTO thisQuantity;

    @NotBlank(message = "targetUnit must not be blank")
    private String targetUnit;

    public ConvertRequestDTO() {}

    public QuantityDTO getThisQuantity() { return thisQuantity; }
    public void setThisQuantity(QuantityDTO v) { this.thisQuantity = v; }
    public String getTargetUnit() { return targetUnit; }
    public void setTargetUnit(String v) { this.targetUnit = v; }
}
