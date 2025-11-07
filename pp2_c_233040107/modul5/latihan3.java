/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul5;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class latihan3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Label dan Tombol");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 1. atur Layout Manager
                // flowLayout akan menyusun komponen dari kiri ke kanan.
                frame.setLayout(new FlowLayout());

                // 2. buat komponen GUI
                JLabel label = new JLabel("Teks Awal");
                JButton button = new JButton("Klik Saya!");

                // 3. tambahkan Aksi (ActionListener) ke tombol
                // penambahan ini menggunakan lambda untuk mempersingkat
                // penggunaan anonymous inner class
                button.addActionListener(e -> {
                    // aksi ini akan mengubah teks pada label
                    label.setText("Tombol berhasil diklik!");
                });

                /* 4. tambahkan komponen ke frame
                   karena kita menggunakan FlowLayout,
                   keduanya akan tampil berdampingan */
                frame.add(label);
                frame.add(button);

                frame.setVisible(true);
            }
        });
    }
}