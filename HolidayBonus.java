public class HolidayBonus extends TwoDimRaggedArrayUtility {

    private static final double BONUS_1 = 5000;
    private static final double BONUS_2 = 2000;
    private static final double BONUS_3 = 1000;

    /**
     * Calculates the holiday bonus for each store
     *
     * @param data - the two dimensional array of store sales
     * @return an array of the bonus for each store
     */
    static double[] calculateHolidayBonus(double[][] data) {
        double[] bonus = new double[data.length];

        for (int i = 0; i < bonus.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
                    bonus[i] += BONUS_1;
                } else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
                    bonus[i] += BONUS_3;
                } else {
                    bonus[i] += BONUS_2;
                }
            }
        }

        return bonus;
    }


    /**
     * Calculates the total holiday bonuses
     *
     * @param data - the two dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;

        double[] storeBonuses = calculateHolidayBonus(data);
        for (double bonus : storeBonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }
    public static void main(String[] args) {
        // Example sales data
        double[][] salesData = { { 100, 200, 300 }, { 400, 500 }, { 600, 700, 800 } };

        // Calculate and print holiday bonuses for each store
        System.out.println("Holiday Bonuses for Each Store:");
        double[] bonuses = calculateHolidayBonus(salesData);
        for (int i = 0; i < bonuses.length; i++) {
            System.out.printf("Store %d: $%.2f\n", i + 1, bonuses[i]);
        }

        // Calculate and print total holiday bonus
        double totalBonus = calculateTotalHolidayBonus(salesData);
        System.out.printf("\nTotal Holiday Bonus: $%.2f\n", totalBonus);
    }
}
