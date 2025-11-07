/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul5;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Jendela dengan JLabel");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 1. buat komponen JLabel
                JLabel label = new JLabel("Ini adalah JLabel.");

                // 2. tambahkan JLabel ke JFrame
                // secara default, JFrame menggunakan BorderLayout,
                // dan .add() akan menambahkannya ke bagian tengah (CENTER).
                frame.add(label);

                frame.setVisible(true);
            }
        });
    }
}
