package Week5;

public class experimentnine {

    public static void main(String[] args) {
        String binaryNumber = "101010"; // Example binary number
        System.out.println("Original binary number: " + binaryNumber);

        String onesComplement = calculateOnesComplement(binaryNumber);
        System.out.println("1's complement: " + onesComplement);

        String twosComplement = calculateTwosComplement(binaryNumber);
        System.out.println("2's complement: " + twosComplement);
    }

    public static String calculateOnesComplement(String binaryNumber) {
        StringBuilder onesComplement = new StringBuilder();

        for (int i = 0; i < binaryNumber.length(); i++) {
            char bit = binaryNumber.charAt(i);
            onesComplement.append(bit == '0' ? '1' : '0');
        }

        return onesComplement.toString();
    }

    public static String calculateTwosComplement(String binaryNumber) {
        // Calculate 1's complement first
        String onesComplement = calculateOnesComplement(binaryNumber);

        // Add 1 to the least significant bit of the 1's complement to get the 2's complement
        StringBuilder twosComplement = new StringBuilder();
        boolean carry = true;
        for (int i = onesComplement.length() - 1; i >= 0; i--) {
            char bit = onesComplement.charAt(i);
            if (carry) {
                if (bit == '0') {
                    twosComplement.insert(0, '1');
                    carry = false;
                } else {
                    twosComplement.insert(0, '0');
                }
            } else {
                twosComplement.insert(0, bit);
            }
        }

        return twosComplement.toString();
    }
}
