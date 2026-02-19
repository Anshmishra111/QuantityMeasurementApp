package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    // Common base class (DRY improvement)
    public static abstract class Measurement {
        protected final double value;

        public Measurement(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reference check
            if (this == obj) return true;

            // Null check
            if (obj == null) return false;

            // Type check
            if (this.getClass() != obj.getClass()) return false;

            Measurement other = (Measurement) obj;

            // Floating point comparison
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Feet class
    public static class Feet extends Measurement {
        public Feet(double value) {
            super(value);
        }
    }

    // Inches class
    public static class Inches extends Measurement {
        public Inches(double value) {
            super(value);
        }
    }

    // Separate demo methods (as UC2 suggests)
    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Feet equal? " + f1.equals(f2));
    }

    public static void demonstrateInchesEquality() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        System.out.println("Inches equal? " + i1.equals(i2));
    }

    // Main method
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}