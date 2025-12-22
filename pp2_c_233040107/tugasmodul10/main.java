/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.tugasmodul10;


import id.ac.unpas.pp2_c_233040107.tugasmodul10.view.MahasiswaView;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */

public class main {
    public static void main(String[] args) {
        // Menjalankan Aplikasi
        SwingUtilities.invokeLater(() -> {
            new MahasiswaView().setVisible(true);
        });
    }
}

