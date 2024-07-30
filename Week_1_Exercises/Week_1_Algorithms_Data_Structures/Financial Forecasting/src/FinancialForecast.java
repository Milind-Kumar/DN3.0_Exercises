import java.util.Scanner;

public class FinancialForecast {
    public static double forecast(double[] pastData, int years, int currentYear) {
        if (years == 0) {
            return pastData[currentYear];
        }
        return forecast(pastData, years - 1, currentYear) * (1 + growthRate(pastData));
    }

    public static double growthRate(double[] pastData) {
        double totalGrowth = 0;
        for (int i = 1; i < pastData.length; i++) {
            totalGrowth += (pastData[i] - pastData[i - 1]) / pastData[i - 1];
        }
        return totalGrowth / (pastData.length - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of past data points:");
        int n = scanner.nextInt();
        double[] pastData = new double[n];
        System.out.println("Enter past data points:");
        for (int i = 0; i < n; i++) {
            pastData[i] = scanner.nextDouble();
        }
        System.out.println("Enter number of years to forecast:");
        int years = scanner.nextInt();
        System.out.println("Forecasted value after " + years + " years: " + forecast(pastData, years, pastData.length - 1));
        scanner.close();
    }
}