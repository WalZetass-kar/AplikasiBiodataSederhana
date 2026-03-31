package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.PenggunaModel;
import com.iwal.utsdbcobabywal.view.PenggunaView;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PenggunaController {
    private PenggunaView view;
    private PenggunaModel model;
    
    public PenggunaController(PenggunaView view, PenggunaModel model) {
        this.view = view;
        this.model = model;
        
        this.view.getBtnSimpan().addActionListener(e -> simpanData());
        this.view.getBtnUbah().addActionListener(e -> ubahData());
        this.view.getBtnHapus().addActionListener(e -> hapusData());
        this.view.getBtnRefresh().addActionListener(e -> refreshData());
        
        this.view.getTablePengguna().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && view.getTablePengguna().getSelectedRow() != -1) {
                int row = view.getTablePengguna().getSelectedRow();
                view.getTxtUsername().setText(view.getModelTable().getValueAt(row, 0).toString());
                view.getCbLevel().setSelectedItem(view.getModelTable().getValueAt(row, 1).toString());
                view.getCbStatus().setSelectedItem(view.getModelTable().getValueAt(row, 2).toString());
                view.getTxtPassword().setText("");
            }
        });
        
        loadData();
    }
    
    private void loadData() {
        try {
            view.getModelTable().setRowCount(0);
            ResultSet rs = model.tampilkanSemua();
            while (rs.next()) {
                view.getModelTable().addRow(new Object[]{
                    rs.getString("nm_pengguna"),
                    rs.getString("level_user"),
                    rs.getString("status_akun")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error load data: " + e.getMessage());
        }
    }
    
    private void simpanData() {
        String username = view.getTxtUsername().getText().trim();
        String password = new String(view.getTxtPassword().getPassword()).trim();
        String level = view.getCbLevel().getSelectedItem().toString();
        String status = view.getCbStatus().getSelectedItem().toString();
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Username dan Password tidak boleh kosong!");
            return;
        }
        
        try {
            ResultSet rs = model.cariPengguna(username);
            if (rs.next()) {
                JOptionPane.showMessageDialog(view, "Username sudah terdaftar!");
                return;
            }
            
            if (model.simpan(username, password, level, status)) {
                JOptionPane.showMessageDialog(view, "Data berhasil disimpan!");
                loadData();
                resetForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error simpan: " + e.getMessage());
        }
    }
    
    private void ubahData() {
        int row = view.getTablePengguna().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan diubah!");
            return;
        }
        
        String username = view.getTxtUsername().getText().trim();
        String password = new String(view.getTxtPassword().getPassword()).trim();
        String level = view.getCbLevel().getSelectedItem().toString();
        String status = view.getCbStatus().getSelectedItem().toString();
        
        try {
            if (model.ubah(username, password, level, status)) {
                JOptionPane.showMessageDialog(view, "Data berhasil diubah!");
                loadData();
                resetForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error ubah: " + e.getMessage());
        }
    }
    
    private void hapusData() {
        int row = view.getTablePengguna().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan dihapus!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String username = view.getTxtUsername().getText().trim();
            try {
                if (model.hapus(username)) {
                    JOptionPane.showMessageDialog(view, "Data berhasil dihapus!");
                    loadData();
                    resetForm();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error hapus: " + e.getMessage());
            }
        }
    }
    
    private void refreshData() {
        loadData();
        resetForm();
        view.getLblStatus().setText("Data direfresh dari database");
    }
    
    private void resetForm() {
        view.getTxtUsername().setText("");
        view.getTxtPassword().setText("");
        view.getCbLevel().setSelectedIndex(0);
        view.getCbStatus().setSelectedIndex(0);
        view.getTablePengguna().clearSelection();
    }
}