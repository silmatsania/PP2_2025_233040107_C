/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.tugasmodul10.controller;



import id.ac.unpas.pp2_c_233040107.modul10.KoneksiDB;
import id.ac.unpas.pp2_c_233040107.tugasmodul10.model.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */

public class MahasiswaController {

    // Latihan 4: Metode Pengecekan Duplikasi NIM
    public boolean isNIMExists(String nim) throws SQLException {
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, nim);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    // CREATE (Menambah Data)
    public void tambahData(Mahasiswa mhs) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, mhs.getNama());
            pst.setString(2, mhs.getNim());
            pst.setString(3, mhs.getJurusan());
            pst.execute();
        }
    }

    // READ (Menampilkan Data)
    public List<Mahasiswa> getAllMahasiswa() throws SQLException {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try (Connection conn = KoneksiDB.configDB();
             Statement stm = conn.createStatement();
             ResultSet res = stm.executeQuery(sql)) {
            while (res.next()) {
                list.add(new Mahasiswa(
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                ));
            }
        }
        return list;
    }

    // LATIHAN 3: Method Cari Data
    public List<Mahasiswa> cariData(String keyword) throws SQLException {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + keyword + "%");
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    list.add(new Mahasiswa(
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                    ));
                }
            }
        }
        return list;
    }

    // UPDATE (Mengubah Data)
    public void ubahData(Mahasiswa mhs) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, mhs.getNama());
            pst.setString(2, mhs.getJurusan());
            pst.setString(3, mhs.getNim());
            pst.executeUpdate();
        }
    }

    // DELETE (Menghapus Data)
    public void hapusData(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, nim);
            pst.execute();
        }
    }
}