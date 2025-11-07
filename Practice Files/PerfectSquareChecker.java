public class PerfectSquareChecker {

    /**
     * Checks if the number in the form AABB is a perfect square.
     * A and B are digits (0-9).
     */
    public static void checkPerfectSquare() {
        for (int A = 0; A <= 9; A++) {
            for (int B = 0; B <= 9; B++) {
                int number = 1100 * A + 11 * B;
                int sqrt = (int) Math.sqrt(number);
                if (sqrt * sqrt == number) {
                    System.out.println("AABB: " + number + " is a perfect square.");
                }
            }
        }
    }

    public static void main(String[] args) {
        checkPerfectSquare();
    }
}
