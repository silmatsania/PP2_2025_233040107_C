/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040107.tugasmodul10.view;

import id.ac.unpas.pp2_c_233040107.tugasmodul10.model.Mahasiswa;
import id.ac.unpas.pp2_c_233040107.tugasmodul10.controller.MahasiswaController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author ASUS
 */

public class MahasiswaView extends JFrame {
    // Komponen GUI
    private JTextField txtNama, txtNIM, txtJurusan, txtCari;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    private JTable tableMahasiswa;
    private DefaultTableModel model;
    private MahasiswaController controller;

    public MahasiswaView() {
        controller = new MahasiswaController();
        initComponents();
        loadData();
    }

    private void initComponents() {
        // Setup Frame
        setTitle("Aplikasi CRUD Mahasiswa MVC");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Panel Form (Input Data)
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelForm.add(new JLabel("Nama:")); txtNama = new JTextField(); panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM:")); txtNIM = new JTextField(); panelForm.add(txtNIM);
        panelForm.add(new JLabel("Jurusan:")); txtJurusan = new JTextField(); panelForm.add(txtJurusan);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan"); btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus"); btnClear = new JButton("Clear");
        panelTombol.add(btnSimpan); panelTombol.add(btnEdit); panelTombol.add(btnHapus); panelTombol.add(btnClear);

        // LATIHAN 3: Panel Pencarian
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCari.add(new JLabel("Cari Nama:")); txtCari = new JTextField(15); btnCari = new JButton("Cari");
        panelCari.add(txtCari); panelCari.add(btnCari);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.NORTH);
        panelAtas.add(panelTombol, BorderLayout.CENTER);
        panelAtas.add(panelCari, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // 2. Tabel Data (Menampilkan Data)
        model = new DefaultTableModel(new String[]{"No", "Nama", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);

        // --- Event Listeners ---
        tableMahasiswa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNIM.setText(model.getValueAt(row, 2).toString());
                txtJurusan.setText(model.getValueAt(row, 3).toString());
            }
        });

        btnSimpan.addActionListener(e -> aksiSimpan());
        btnEdit.addActionListener(e -> aksiEdit());
        btnHapus.addActionListener(e -> aksiHapus());
        btnCari.addActionListener(e -> loadData()); 
        btnClear.addActionListener(e -> kosongkanForm());
    }

    private void loadData() {
        model.setRowCount(0);
        try {
            String keyword = txtCari.getText();
            List<Mahasiswa> list = (keyword.isEmpty()) ? controller.getAllMahasiswa() : controller.cariData(keyword);
            int no = 1;
            for (Mahasiswa m : list) {
                model.addRow(new Object[]{no++, m.getNama(), m.getNim(), m.getJurusan()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Load: " + e.getMessage());
        }
    }

    private void aksiSimpan() {
        // Latihan 2: Validasi Input
        if (txtNama.getText().isEmpty() || txtNIM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
            return;
        }
        try {
            // Latihan 4: Cek NIM
            if (controller.isNIMExists(txtNIM.getText())) {
                JOptionPane.showMessageDialog(this, "NIM sudah terdaftar!");
                return;
            }
            controller.tambahData(new Mahasiswa(txtNama.getText(), txtNIM.getText(), txtJurusan.getText()));
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            loadData(); kosongkanForm();
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void aksiEdit() {
        try {
            controller.ubahData(new Mahasiswa(txtNama.getText(), txtNIM.getText(), txtJurusan.getText()));
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            loadData(); kosongkanForm();
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Gagal Edit: " + e.getMessage()); }
    }

    private void aksiHapus() {
        try {
            controller.hapusData(txtNIM.getText());
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            loadData(); kosongkanForm();
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage()); }
    }

    private void kosongkanForm() {
        txtNama.setText(null); txtNIM.setText(null); txtJurusan.setText(null); txtCari.setText(null);
    }
}

