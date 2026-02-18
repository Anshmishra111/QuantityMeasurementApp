package com.BridgeLab_Training.quantity_measurement_app;

class UC1FeetMeasurementEquality {

	    // Inner class to represent Feet measurement
	    public static class Feet {
	        private final double value;

	        // Constructor
	        public Feet(double value) {
	            this.value = value;
	        }

	        // Getter (optional but good practice)
	        public double getValue() {
	            return value;
	        }

	        // Override equals() method
	        @Override
	        public boolean equals(Object obj) {

	            // 1. Reference check
	            if (this == obj) {
	                return true;
	            }

	            // 2. Null check
	            if (obj == null) {
	                return false;
	            }

	            // 3. Type check
	            if (this.getClass() != obj.getClass()) {
	                return false;
	            }

	            // 4. Cast and compare values
	            Feet other = (Feet) obj;
	            return Double.compare(this.value, other.value) == 0;
	        }
	    }

	    // Main method (for manual testing)
	    public static void main(String[] args) {

	        Feet f1 = new Feet(1.0);
	        Feet f2 = new Feet(1.0);

	        boolean result = f1.equals(f2);

	        System.out.println("Are equal? " + result);
	    }
	}
