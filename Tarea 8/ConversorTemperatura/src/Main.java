import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private ConversorView vista;

    public Main(ConversorView vista) {
        this.vista = vista;
        inicializarEventos();
    }


    private double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    private double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }


    private void inicializarEventos() {
        vista.getBtnFahrenheit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir("fahrenheit");
            }
        });

        vista.getBtnKelvin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir("kelvin");
            }
        });
    }

    private void convertir(String tipo) {
        String entrada = vista.getTxtCelsius().getText().trim();

        if (entrada.isEmpty()) {
            vista.mostrarAviso(
                    "Por favor ingrese un valor de temperatura.",
                    "Campo vacío"
            );
            return;
        }

        try {
            double celsius = Double.parseDouble(entrada);

            if (tipo.equals("fahrenheit")) {
                double resultado = celsiusAFahrenheit(celsius);
                vista.setResultado(
                        String.format("Resultado: %.2f °F", resultado),
                        new Color(30, 90, 200)
                );
            } else {
                double resultado = celsiusAKelvin(celsius);
                vista.setResultado(
                        String.format("Resultado: %.2f K", resultado),
                        new Color(20, 140, 80)
                );
            }

        } catch (NumberFormatException ex) {
            vista.mostrarError(
                    "Entrada no válida. Por favor ingrese un número.",
                    "Error de entrada"
            );
            vista.getTxtCelsius().requestFocus();
        }
    }


    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConversorView vista = new ConversorView();
                new Main(vista);
                vista.setVisible(true);
            }
        });
    }
    }
