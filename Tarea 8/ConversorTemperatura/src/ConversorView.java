import javax.swing.*;
import java.awt.*;

public class ConversorView extends JFrame {

    private JTextField txtCelsius;
    private JButton btnFahrenheit;
    private JButton btnKelvin;
    private JLabel lblResultado;

    public ConversorView() {
        setTitle("Conversor de Temperaturas");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color celesteFondo = new Color(200, 225, 255);
        Color verdeOscuro = new Color(34, 85, 34);
        Color verdeBorde = new Color(150, 190, 150);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(celesteFondo);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Conversor de Temperaturas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(verdeOscuro);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panelPrincipal.add(lblTitulo, gbc);

        JLabel lblInstruccion = new JLabel("Ingrese temperatura en grados Celsius:");
        lblInstruccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblInstruccion.setForeground(new Color(60, 60, 60));
        gbc.gridy = 1; gbc.gridwidth = 2;
        panelPrincipal.add(lblInstruccion, gbc);

        txtCelsius = new JTextField();
        txtCelsius.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCelsius.setHorizontalAlignment(JTextField.CENTER);
        txtCelsius.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(verdeBorde, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        gbc.gridy = 2; gbc.gridwidth = 2;
        panelPrincipal.add(txtCelsius, gbc);

        btnFahrenheit = new JButton("Convertir a Fahrenheit (°F)");
        btnFahrenheit.setFont(new Font("Segoe UI", Font.BOLD, 12));

        btnFahrenheit.setBackground(new Color(46, 139, 87));
        btnFahrenheit.setForeground(Color.WHITE);
        btnFahrenheit.setOpaque(true);
        btnFahrenheit.setContentAreaFilled(true);
        btnFahrenheit.setBorderPainted(false);

        btnFahrenheit.setFocusPainted(false);
        btnFahrenheit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFahrenheit.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        gbc.gridy = 3; gbc.gridwidth = 1; gbc.gridx = 0;
        panelPrincipal.add(btnFahrenheit, gbc);

        btnKelvin = new JButton("Convertir a Kelvin (K)");
        btnKelvin.setFont(new Font("Segoe UI", Font.BOLD, 12));

        btnKelvin.setBackground(new Color(34, 139, 34));
        btnKelvin.setForeground(Color.WHITE);
        btnKelvin.setOpaque(true);
        btnKelvin.setContentAreaFilled(true);
        btnKelvin.setBorderPainted(false);

        btnKelvin.setFocusPainted(false);
        btnKelvin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKelvin.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        gbc.gridx = 1;
        panelPrincipal.add(btnKelvin, gbc);

        lblResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblResultado.setForeground(verdeOscuro);
        lblResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(verdeBorde, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        lblResultado.setOpaque(true);
        lblResultado.setBackground(Color.WHITE);
        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2;
        panelPrincipal.add(lblResultado, gbc);

        add(panelPrincipal);
    }

    public JTextField getTxtCelsius() { return txtCelsius; }
    public JButton getBtnFahrenheit() { return btnFahrenheit; }
    public JButton getBtnKelvin() { return btnKelvin; }

    public void setResultado(String texto, Color color) {
        lblResultado.setText(texto);
        lblResultado.setForeground(color);
    }

    public void mostrarError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarAviso(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }
}
