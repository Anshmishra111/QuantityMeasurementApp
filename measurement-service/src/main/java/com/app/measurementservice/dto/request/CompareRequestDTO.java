package com.app.measurementservice.dto.request;

import com.app.measurementservice.entity.QuantityDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CompareRequestDTO {

    @Valid @NotNull(message = "thisQuantity must not be null")
    private QuantityDTO thisQuantity;

    @Valid @NotNull(message = "thatQuantity must not be null")
    private QuantityDTO thatQuantity;

    public CompareRequestDTO() {}

    public QuantityDTO getThisQuantity() { return thisQuantity; }
    public void setThisQuantity(QuantityDTO v) { this.thisQuantity = v; }
    public QuantityDTO getThatQuantity() { return thatQuantity; }
    public void setThatQuantity(QuantityDTO v) { this.thatQuantity = v; }
}
