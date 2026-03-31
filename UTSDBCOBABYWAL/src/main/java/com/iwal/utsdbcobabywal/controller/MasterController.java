package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.MasterModel;
import com.iwal.utsdbcobabywal.view.MasterView;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterController {
    private MasterView view;
    private MasterModel model;
    
    public MasterController(MasterView view, MasterModel model) {
        this.view = view;
        this.model = model;
        
        this.view.getBtnSimpan().addActionListener(e -> simpanData());
        this.view.getBtnUbah().addActionListener(e -> ubahData());
        this.view.getBtnHapus().addActionListener(e -> hapusData());
        this.view.getBtnRefresh().addActionListener(e -> refreshData());
        
        this.view.getTableMaster().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && view.getTableMaster().getSelectedRow() != -1) {
                int row = view.getTableMaster().getSelectedRow();
                view.getTxtId().setText(view.getModelTable().getValueAt(row, 0).toString());
                view.getTxtKode().setText(view.getModelTable().getValueAt(row, 1).toString());
                view.getTxtNama().setText(view.getModelTable().getValueAt(row, 2).toString());
                view.getTxtKeterangan().setText(view.getModelTable().getValueAt(row, 3).toString());
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
                    rs.getInt("id"),
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("keterangan")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error load data: " + e.getMessage());
        }
    }
    
    private void simpanData() {
        String kode = view.getTxtKode().getText().trim();
        String nama = view.getTxtNama().getText().trim();
        String ket = view.getTxtKeterangan().getText().trim();
        
        if (kode.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Kode dan Nama tidak boleh kosong!");
            return;
        }
        
        try {
            if (model.simpan(kode, nama, ket)) {
                JOptionPane.showMessageDialog(view, "Data berhasil disimpan!");
                loadData();
                resetForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error simpan: " + e.getMessage());
        }
    }
    
    private void ubahData() {
        int row = view.getTableMaster().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan diubah!");
            return;
        }
        
        int id = Integer.parseInt(view.getTxtId().getText());
        String kode = view.getTxtKode().getText().trim();
        String nama = view.getTxtNama().getText().trim();
        String ket = view.getTxtKeterangan().getText().trim();
        
        try {
            if (model.ubah(id, kode, nama, ket)) {
                JOptionPane.showMessageDialog(view, "Data berhasil diubah!");
                loadData();
                resetForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error ubah: " + e.getMessage());
        }
    }
    
    private void hapusData() {
        int row = view.getTableMaster().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan dihapus!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(view.getTxtId().getText());
            try {
                if (model.hapus(id)) {
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
        view.getTxtId().setText("");
        view.getTxtKode().setText("");
        view.getTxtNama().setText("");
        view.getTxtKeterangan().setText("");
        view.getTableMaster().clearSelection();
    }
}