package com.BridgeLab_Training.quantity_measurement_app;

public class Quantity<U extends IMeasurable> {

    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    //  EQUALS 

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Quantity<?>))
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = ((IMeasurable) other.unit)
                .convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    //  TO STRING 

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }

    //  CONVERSION 

    public double convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(base);
    }

    //  ADDITION 

    public Quantity<U> add(Quantity<U> other) {

        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Incompatible units");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(round(result), targetUnit);
    }

    //  SUBTRACTION (UC12) 

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Incompatible units");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 - base2;

        double result = targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(round(result), targetUnit);
    }

    //  DIVISION (UC12) 

    public double divide(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Incompatible units");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        if (base2 == 0)
            throw new ArithmeticException("Division by zero");

        return base1 / base2;
    }

    //  ROUNDING 

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}