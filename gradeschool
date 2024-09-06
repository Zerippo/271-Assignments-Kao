import java.util.Arrays;

public class GradeSchoolMultiplication {
    private static final int DEFAULT_BASE = 10;

    // Method to multiply two arrays representing numbers, with a given base
    public static int[] multiply(final int[] x, final int[] y, final int base) {
        int xLength = x.length; // Length of array x
        int yLength = y.length; // Length of array y
        int[] result = new int[xLength + yLength]; // Result can have at most xLen + yLen digits

        // Iterate over digits of x (starting from least significant digit)
        for (int i = xLength - 1; i >= 0; i--) {
            int carry = 0; // carry for the current partial product

            // Multiply x[i] by each digit in y
            for (int j = yLength - 1; j >= 0; j--) {
                int product = x[i] * y[j] + result[i + j + 1] + carry; // Multiply digits and add previous result and carry
                result[i + j + 1] = product % base; // Store the current digit in the result
                carry = product / base; // Compute the carry
            }

            result[i] += carry; // Add any remaining carry to the next most significant digit
        }

        // Find first non-zero digit in the result (to eliminate leading zeros)
        int firstNonZero = 0;
        while (firstNonZero < result.length && result[firstNonZero] == 0) {
            firstNonZero++;
        }

        // If result is all zeros, return [0]
        if (firstNonZero == result.length) {
            return new int[]{0};
        }

        // Return the final result array, excluding leading zeros
        return Arrays.copyOfRange(result, firstNonZero, result.length);
    }

    // Overloaded multiply method with default base 10
    public static int[] multiply(final int[] x, final int[] y) {
        return multiply(x, y, DEFAULT_BASE);
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};  
        int[] y = {5, 6, 7, 8};  
        int[] result = multiply(x, y);

        System.out.println("Multiplication Result: " + Arrays.toString(result));  
    }
}
