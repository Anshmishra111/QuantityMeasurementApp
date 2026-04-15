package com.app.measurementservice.model;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(false),
    FAHRENHEIT(true),
    KELVIN(false);

    final Function<Double, Double> FAHRENHEIT_TO_CELSIUS = f -> (f - 32) * 5 / 9;
    final Function<Double, Double> CELSIUS_TO_CELSIUS    = c -> c;
    final Function<Double, Double> KELVIN_TO_CELSIUS     = k -> k - 273.15;

    Function<Double, Double> conversionValue;
    SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(boolean isFahrenheit) {
        if (this.name().equals("FAHRENHEIT"))
            this.conversionValue = FAHRENHEIT_TO_CELSIUS;
        else if (this.name().equals("KELVIN"))
            this.conversionValue = KELVIN_TO_CELSIUS;
        else
            this.conversionValue = CELSIUS_TO_CELSIUS;
    }

    @Override public double getConversionValue()          { return 1; }
    @Override public double convertToBaseUnit(double v)   { return conversionValue.apply(v); }
    @Override public String getUnitName()                 { return this.name(); }
    @Override public String getMeasurementType()          { return this.getClass().getSimpleName(); }

    @Override
    public double convertFromBaseUnit(double b) {
        return switch (this) {
            case FAHRENHEIT -> (b * 9.0 / 5) + 32;
            case KELVIN     -> b + 273.15;
            default         -> b;
        };
    }

    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (TemperatureUnit u : TemperatureUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName)) return u;
        throw new IllegalArgumentException("Invalid temperature unit: " + unitName);
    }

    @Override
    public void validOperationSupport(String operation) {
        if (!supportsArithmetic.isSupported())
            throw new UnsupportedOperationException(
                    this.name() + " does not support " + operation + " operations.");
    }
}
