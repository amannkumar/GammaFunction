import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GammaFunction extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public GammaFunction() {
        setTitle("Gamma Function Calculator");
        setSize(420, 240);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for input
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter a real number x:"));
        inputField = new JTextField(10);
        topPanel.add(inputField);

        JButton computeButton = new JButton("Compute Γ(x)");
        topPanel.add(computeButton);

        // Output area
        outputArea = new JTextArea(4, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(inputField.getText());
                    if (x <= 0) {
                        outputArea.setText("Error: Input must be a real number greater than 0.");
                        return;
                    }
                    double result = gamma(x);
                    outputArea.setText(String.format("Γ(%.8f) = %.8f", x, result));
                } catch (Exception ex) {
                    outputArea.setText("Error: Invalid input. Please enter a valid real number.");
                }
            }
        });
    }

    public static double gamma(double x) {
        if (x <= 0.0 && x == Math.floor(x)) {
            throw new IllegalArgumentException("Γ(x) is undefined for non-positive integers.");
        }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GammaFunction().setVisible(true));
    }
}
