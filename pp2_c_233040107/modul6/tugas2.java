/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul6;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class tugas2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 120);
        frame.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField textCelcius = new JTextField(10);
        JButton buttonKonversi = new JButton("Konversi");
        JLabel kosong = new JLabel("");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasil = new JLabel("");
        JLabel pesanError = new JLabel("");

        buttonKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textCelcius.getText().trim();
                hasil.setText("");
                pesanError.setText("");

                if (input.isEmpty()) {
                    hasil.setText("Error");
                    pesanError.setText("Input harus berupa angka!");
                    return;
                }

                try {
                    double celcius = Double.parseDouble(input);
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    hasil.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    hasil.setText("Error");
                    pesanError.setText("Input harus berupa angka!");
                }
            }
        });

        frame.add(labelCelcius);
        frame.add(textCelcius);
        frame.add(buttonKonversi);
        frame.add(kosong);
        frame.add(labelFahrenheit);
        frame.add(hasil);
        frame.add(new JLabel(""));
        frame.add(pesanError);

        frame.setVisible(true);
    }
}