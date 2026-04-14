package com.app.measurementservice.core;

import com.app.measurementservice.model.IMeasurable;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        if (unit == null)            throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit  = unit;
    }

    public double getValue() { return value; }
    public U      getUnit()  { return unit; }

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        if (!targetUnit.getClass().equals(unit.getClass()))
            throw new IllegalArgumentException("Target unit must belong to the same class");
        double base      = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Quantity<?> other = (Quantity<?>) o;
        if (!this.unit.getClass().equals(other.unit.getClass())) return false;
        
        double baseA = unit.convertToBaseUnit(value);
        double baseB = other.unit.convertToBaseUnit(other.value);
        return Math.abs(baseA - baseB) < 0.01;
    }

    // ── Arithmetic ───────────────────────────────────────────────

    private enum ArithmeticOperation {
        ADD     { @Override public double compute(double a, double b) { return a + b; } },
        SUBTRACT{ @Override public double compute(double a, double b) { return a - b; } },
        DIVIDE  {
            @Override public double compute(double a, double b) {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            }
        };
        public abstract double compute(double a, double b);
    }

    public Quantity<U> add(Quantity<U> other)                    { return add(other, unit); }
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double result = performBaseArithmetic(other, targetUnit, ArithmeticOperation.ADD, true);
        return buildQuantityFromBase(result, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other)               { return subtract(other, unit); }
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        double result = performBaseArithmetic(other, targetUnit, ArithmeticOperation.SUBTRACT, true);
        return buildQuantityFromBase(result, targetUnit);
    }

    public double divide(Quantity<U> other) {
        return performBaseArithmetic(other, null, ArithmeticOperation.DIVIDE, false);
    }

    private double performBaseArithmetic(Quantity<U> other, U targetUnit,
                                         ArithmeticOperation op, boolean targetRequired) {
        validateOperands(other, targetUnit, targetRequired);
        double a = unit.convertToBaseUnit(value);
        double b = other.unit.convertToBaseUnit(other.value);
        return op.compute(a, b);
    }

    private void validateOperands(Quantity<U> q, U targetUnit, boolean targetRequired) {
        if (q == null)                          throw new IllegalArgumentException("Operand cannot be null");
        if (!Double.isFinite(this.value) || !Double.isFinite(q.value))
            throw new IllegalArgumentException("Values must be finite");
        if (!this.unit.getClass().equals(q.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");
        if (targetRequired) {
            if (targetUnit == null)             throw new IllegalArgumentException("Target unit cannot be null");
            if (!this.unit.getClass().equals(targetUnit.getClass()))
                throw new IllegalArgumentException("Invalid target unit category");
        }
    }

    private Quantity<U> buildQuantityFromBase(double baseValue, U targetUnit) {
        return new Quantity<>(round(targetUnit.convertFromBaseUnit(baseValue)), targetUnit);
    }

    private double round(double v) { return (double) Math.round(v * 100) / 100; }

    @Override
    public String toString() { return String.format("%.2f %s", value, unit); }
}
