import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GammaFunction extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private static final String LOG_FILE = "gamma_log.txt";

    public GammaFunction() {
        setTitle("Gamma Function Calculator");
        setSize(420, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter a real number x:"));
        inputField = new JTextField(10);
        topPanel.add(inputField);
        JButton computeButton = new JButton("Compute Γ(x)");
        topPanel.add(computeButton);

        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        computeButton.addActionListener(e -> {
            String inputText = inputField.getText();
            try {
                double x = Double.parseDouble(inputText);
                if (x <= 0 && x == Math.floor(x)) {
                    throw new IllegalArgumentException("Error: Input must be a real number greater than 0.");
                }
                double result = gamma(x);
                String output = String.format("Γ(%.8f) = %.8f", x, result);
                outputArea.setText(output);
                log("INPUT: " + x + " | RESULT: " + result);
            } catch (IllegalArgumentException ex) {
                outputArea.setText("Error: " + ex.getMessage());
                log("INPUT: " + inputText + " | ERROR: " + ex.getMessage());
            } catch (Exception ex) {
                outputArea.setText("Error: Invalid input. Please enter a valid real number.");
                log("INPUT: " + inputText + " | ERROR: Invalid input.");
            }
        });
    }

    public static double gamma(double x) {
        double[] lanczos = {
                676.5203681218851, -1259.1392167224028, 771.32342877765313,
                -176.61502916214059, 12.507343278686905, -0.13857109526572012,
                9.9843695780195716e-6, 1.5056327351493116e-7
        };

        if (x < 0.5) {
            return Math.PI / (Math.sin(Math.PI * x) * gamma(1 - x));
        }

        x -= 1;
        double a = 0.99999999999980993;
        for (int i = 0; i < lanczos.length; i++) {
            a += lanczos[i] / (x + i + 1);
        }

        double t = x + 7 + 0.5;
        return Math.sqrt(2 * Math.PI) * Math.pow(t, x + 0.5) * Math.exp(-t) * a;
    }

    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            out.println("[" + timestamp + "] " + message);
        } catch (IOException e) {
            System.err.println("Failed to write to log file.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GammaFunction().setVisible(true));
    }
}
