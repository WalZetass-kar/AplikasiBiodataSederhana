package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.BiodataModel;
import com.iwal.utsdbcobabywal.view.BiodataView;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BiodataController {
    private BiodataView view;
    private BiodataModel model;
    
    public BiodataController(BiodataView view, BiodataModel model) {
        this.view = view;
        this.model = model;
        
        this.view.getBtnSimpan().addActionListener(e -> simpanData());
        this.view.getBtnUpdate().addActionListener(e -> updateData());
        this.view.getBtnHapus().addActionListener(e -> hapusData());
        this.view.getBtnRefresh().addActionListener(e -> refreshData());
        
        this.view.getTableBiodata().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && view.getTableBiodata().getSelectedRow() != -1) {
                int row = view.getTableBiodata().getSelectedRow();
                view.getTxtNim().setText(view.getModelTable().getValueAt(row, 0).toString());
                view.getTxtNama().setText(view.getModelTable().getValueAt(row, 1).toString());
                view.getTxtAlamat().setText(view.getModelTable().getValueAt(row, 2).toString());
                view.getTxtNoHp().setText(view.getModelTable().getValueAt(row, 3).toString());
                view.getCbProdi().setSelectedItem(view.getModelTable().getValueAt(row, 4).toString());
                view.getCbJenisKelamin().setSelectedItem(view.getModelTable().getValueAt(row, 5).toString());
            }
        });

        loadDataFromDatabase();
    }
    
    private void loadDataFromDatabase() {
        try {
            view.getModelTable().setRowCount(0);
            ResultSet rs = model.tampilkanSemua();
            while (rs.next()) {
                view.getModelTable().addRow(new Object[]{
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("no_hp"),
                    rs.getString("prodi"),
                    rs.getString("jenis_kelamin")
                });
            }
            view.getLblStatus().setText("Data berhasil dimuat dari database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error load data: " + e.getMessage());
            view.getLblStatus().setText("Gagal memuat data");
        }
    }
    
    private void simpanData() {
        String nim = view.getTxtNim().getText().trim();
        String nama = view.getTxtNama().getText().trim();
        String alamat = view.getTxtAlamat().getText().trim();
        String noHp = view.getTxtNoHp().getText().trim();
        String prodi = view.getCbProdi().getSelectedItem().toString();
        String jenisKelamin = view.getCbJenisKelamin().getSelectedItem().toString();
        
        if (nim.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(view, "NIM dan Nama tidak boleh kosong!");
            return;
        }
        
        try {
            ResultSet rs = model.cariBerdasarkanNIM(nim);
            if (rs.next()) {
                JOptionPane.showMessageDialog(view, "NIM sudah terdaftar! Gunakan NIM lain.");
                return;
            }
            
            if (model.simpan(nim, nama, alamat, noHp, prodi, jenisKelamin)) {
                JOptionPane.showMessageDialog(view, "Data berhasil disimpan ke database");
                loadDataFromDatabase();
                resetForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error simpan: " + e.getMessage());
        }
    }
    
    private void updateData() {
        int row = view.getTableBiodata().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan diupdate!");
            return;
        }
        
        String nim = view.getTxtNim().getText().trim();
        String nama = view.getTxtNama().getText().trim();
        String alamat = view.getTxtAlamat().getText().trim();
        String noHp = view.getTxtNoHp().getText().trim();
        String prodi = view.getCbProdi().getSelectedItem().toString();
        String jenisKelamin = view.getCbJenisKelamin().getSelectedItem().toString();
        
        try {
            if (model.ubah(nim, nama, alamat, noHp, prodi, jenisKelamin)) {
                JOptionPane.showMessageDialog(view, "Data berhasil diupdate");
                loadDataFromDatabase();
                resetForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error update: " + e.getMessage());
        }
    }
    
    private void hapusData() {
        int row = view.getTableBiodata().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan dihapus!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(view, 
            "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            String nim = view.getTxtNim().getText().trim();
            
            try {
                if (model.hapus(nim)) {
                    JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
                    loadDataFromDatabase();
                    resetForm();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error hapus: " + e.getMessage());
            }
        }
    }
    
    private void refreshData() {
        loadDataFromDatabase();
        resetForm();
        view.getLblStatus().setText("Data direfresh dari database");
    }
    
    private void resetForm() {
        view.getTxtNim().setText("");
        view.getTxtNama().setText("");
        view.getTxtAlamat().setText("");
        view.getTxtNoHp().setText("");
        view.getCbProdi().setSelectedIndex(0);
        view.getCbJenisKelamin().setSelectedIndex(0);
        view.getTableBiodata().clearSelection();
    }
}