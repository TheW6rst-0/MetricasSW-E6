public class BadCalculator {

    // Hardcoded credentials (Security Issue)
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        BadCalculator calculator = new BadCalculator();
        calculator.performCalculations();
    }

    // Method with potential NullPointerException (S2259)
    public void performCalculations() {
        String operation = null;
        if (operation.equals("add")) { // Possible NPE if operation is null
            System.out.println(add(5, 3));
        } else if (operation.equals("subtract")) {
            System.out.println(subtract(5, 3));
        } else if (operation.equals("multiply")) {
            System.out.println(multiply(5, 3));
        } else if (operation.equals("divide")) {
            System.out.println(divide(5, 3));
        } else {
            System.out.println("Invalid operation");
        }
    }

    // Commented-out code (S125)
    /*public int add(int a, int b) {
        int result = 0;
        for (int i = 0; i < 1; i++) { // Unnecessary loop
            result = a + b;
        }
        return result;
    }*/

    // Method comparing boxed integers using '==' (S1698)
    public int subtract(Integer a, Integer b) {
        if (a == b) { // Incorrect comparison of Integer objects
            return 0;
        }
        return a - b;
    }

    // Method with potential division by zero (S3518)
    public int divide(int a, int b) {
        return a / b; // No check for division by zero
    }

    // Method with redundant condition
    public int multiply(int a, int b) {
        if (a == 0 || b == 0) { // Redundant condition
            return 0;
        }
        return a * b;
    }

    // Unused private method (S1144)
    private void unusedMethod() {
        System.out.println("This method is never used.");
    }
}