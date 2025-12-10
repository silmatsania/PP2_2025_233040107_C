/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul8.controller;

import id.ac.unpas.pp2_c_233040107.modul8.model.PersegiPanjangModel;
import id.ac.unpas.pp2_c_233040107.modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */

public class PersegiPanjangController {
    
    private PersegiPanjangModel model;
    private PersegiPanjangView view;
    
    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;
        
        // Menghubungkan tombol di View dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
        this.view.addResetListener(new ResetListener()); // BARU: Daftarkan ResetListener (Latihan 3)
    }
    
    // Inner Class untuk menangani event klik tombol Hitung
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();
                
                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);
                
                // 3. Jalankan logika bisnis di Model
                model.hitungLuas();
                model.hitungKeliling(); // BARU: Hitung Keliling
                
                // 4. Ambil hasil dari Model dan tampilkan kembali di View
                double luas = model.getLuas();
                double keliling = model.getKeliling(); // BARU: Ambil hasil keliling (Latihan 2)
                
                view.setHasil(luas);
                view.setKeliling(keliling); // BARU: Tampilkan hasil keliling (Latihan 2)
                
            } catch (NumberFormatException ex) {
                // Handle jika user memasukkan huruf
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // BARU: Inner Class untuk menangani event klik tombol Reset (Latihan 3)
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearInputs();
        }
    }
}