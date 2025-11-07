/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class tugas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Aksi Tombol");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new BorderLayout());
                
                //buat label dan tombol-tombol
                JLabel label = new JLabel("Silakan klik tombol yang ada.");
                JButton buttonSouth = new JButton("SOUTH");
                JButton buttonNorth = new JButton("NORTH");
                JButton buttonWest = new JButton("WEST");
                JButton buttonEast = new JButton("EAST");
                JButton buttonCenter = new JButton("CENTER");

                // aksi tombol SOUTH 
                buttonSouth.addActionListener(e -> {
                    label.setText("Tombol SOUTH diklik!");
                });

                // aksi tombol NORTH
                buttonNorth.addActionListener(e -> {
                    label.setText("Tombol NORTH diklik!");
                });

                // aksi tombol WEST
                buttonWest.addActionListener(e -> {
                    label.setText("Tombol WEST diklik!");
                });

                // aksi tombol EAST
                buttonEast.addActionListener(e -> {
                    label.setText("Tombol EAST diklik!");
                });

                // aksi tombol CENTER
                buttonCenter.addActionListener(e -> {
                    label.setText("Tombol CENTER diklik!");
                });

                // tambah semua komponen sesuai posisinya
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonSouth, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
