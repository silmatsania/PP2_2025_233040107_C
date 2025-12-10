/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author ASUS
 */

public class PersegiPanjangView extends JFrame {
    // Deklarasi komponen (perubahan pada lblKeliling & btnReset)
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel(":");
    private JLabel lblKeliling = new JLabel(":"); // BARU: Label untuk Keliling
    private JButton btnHitung = new JButton("Hitung"); 
    private JButton btnReset = new JButton("Reset"); // BARU: Tombol Reset
    
    // Konstruktor
    public PersegiPanjangView() {
        
        // Inisiasi
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250); 
        this.setLayout(new GridLayout(6, 2, 10, 10)); // Grid 6 baris
        this.setTitle("MVC Kalkulator");
        
        // Menambahkan komponen ke frame
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        
        // Hasil Luas
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);

        // BARU: Hasil Keliling (Latihan 2)
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblKeliling); 
        
        // Baris untuk tombol
        this.add(btnHitung);
        this.add(btnReset); // <== BARU: Tambahkan tombol Reset
    }
    
    // --- Metode Getter Input ---
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }
    
    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }
    
    // --- Metode Setter dan Error Handling ---
    
    // Menampilkan hasil Luas
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }
    
    // BARU: Menampilkan hasil Keliling (Latihan 2)
    public void setKeliling(double keliling) {
        lblKeliling.setText(String.valueOf(keliling));
    }

    // BARU: Reset input fields (Latihan 3)
    public void clearInputs() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText(":");
        lblKeliling.setText(":");
    }
    
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    // Mendaftarkan Hitung ActionListener
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    // BARU: Mendaftarkan Reset ActionListener (Latihan 3)
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}