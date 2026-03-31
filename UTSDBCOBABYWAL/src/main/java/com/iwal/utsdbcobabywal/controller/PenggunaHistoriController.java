package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.PenggunaHistoriModel;
import com.iwal.utsdbcobabywal.view.HistoriLoginView;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PenggunaHistoriController {
    private HistoriLoginView view;
    private PenggunaHistoriModel model;

    public PenggunaHistoriController(HistoriLoginView view, PenggunaHistoriModel model) {
        this.view = view;
        this.model = model;
        loadData();

        this.view.btnRefresh.addActionListener(e -> loadData());
        this.view.btnHapusSemua.addActionListener(e -> hapusSemua());
    }

    private void loadData() {
        view.modelTable.setRowCount(0);
        try {
            ResultSet rs = model.tampilkanSemua();
            while (rs.next()) {
                view.modelTable.addRow(new Object[]{
                    rs.getInt("kd_histori"),
                    rs.getString("nm_pengguna"),
                    rs.getString("keterangan"),
                    rs.getString("tgl_wkt")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error load data: " + e.getMessage());
        }
    }

    private void hapusSemua() {
        int confirm = JOptionPane.showConfirmDialog(view,
            "Yakin hapus semua histori?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (model.hapusSemua()) {
                    JOptionPane.showMessageDialog(view, "Semua histori berhasil dihapus!");
                    loadData();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error hapus: " + e.getMessage());
            }
        }
    }
}