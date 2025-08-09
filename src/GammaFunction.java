import java.util.*;

public class GammaFunction {

    public static double gamma(double x) {
        if (x <= 0.0) {
            throw new IllegalArgumentException("Input must be a real number greater than 0.");
        }
        double[] lanczocapp = {676.5203681218851, -1259.1392167224028, 771.32342877765313,
                -176.61502916214059, 12.507343278686905, -0.13857109526572012,
                9.9843695780195716e-6, 1.5056327351493116e-7};
        if (x < 0.5) {
            return Math.PI / (Math.sin(Math.PI * x) * gamma(1 - x));
        }
        x -= 1;
        double a = 0.99999999999980993;
        for (int i = 0; i < lanczocapp.length; i++) {
            a += lanczocapp[i] / (x + i + 1);
        }
        double t = x + 7 + 0.5;
        return Math.sqrt(2 * Math.PI) * Math.pow(t, x + 0.5) * Math.exp(-t) * a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a real number x > 0): ");
        try {
            double x = scanner.nextDouble();
            if (x <= 0) {
                System.out.println("Error: Input must be a real number greater than 0.");
            } else {
                double result = gamma(x);
                System.out.printf("Gamma(%.8f) = %.8f%n", x, result);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid real number.");
        }
        scanner.close();
    }
}
