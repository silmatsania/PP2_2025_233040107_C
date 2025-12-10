/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.modul8.model;

/**
 *
 * @author ASUS
 */

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling; // BARU: Variabel untuk keliling

    // Menghitung luas (Logika Bisnis)
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }

    // BARU: Menghitung keliling (Latihan 2)
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    // Setters
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    // Getter untuk Luas
    public double getLuas() {
        return luas;
    }
    
    // BARU: Getter untuk Keliling (Latihan 2)
    public double getKeliling() {
        return keliling;
    }
}