package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.PenggunaModel;
import com.iwal.utsdbcobabywal.view.UbahPasswordView;
import javax.swing.*;
import java.sql.*;

public class UbahPasswordController {
    private UbahPasswordView view;
    private PenggunaModel model;
    private String username;
    
    public UbahPasswordController(UbahPasswordView view, PenggunaModel model, String username) {
        this.view = view;
        this.model = model;
        this.username = username;
        
        view.btnSimpan.addActionListener(e -> prosesUbahPassword());
        view.btnBatal.addActionListener(e -> view.dispose());
    }
    
    private void prosesUbahPassword() {
        String passwordLama = new String(view.txtPasswordLama.getPassword()).trim();
        String passwordBaru = new String(view.txtPasswordBaru.getPassword()).trim();
        String konfirmasi = new String(view.txtKonfirmasi.getPassword()).trim();
        
        if (passwordLama.isEmpty() || passwordBaru.isEmpty() || konfirmasi.isEmpty()) {
            view.lblStatus.setText("Semua field harus diisi!");
            return;
        }
        
        if (!passwordBaru.equals(konfirmasi)) {
            view.lblStatus.setText("Password baru dan konfirmasi tidak cocok!");
            return;
        }
        
        if (passwordBaru.length() < 4) {
            view.lblStatus.setText("Password minimal 4 karakter!");
            return;
        }
        
        try {
            ResultSet rs = model.cariPengguna(username);
            if (rs.next()) {
                String passwordDB = rs.getString("psw_pengguna");
                
                if (!passwordLama.equals(passwordDB)) {
                    view.lblStatus.setText("Password lama salah!");
                    return;
                }
                
                if (model.ubah(username, passwordBaru, rs.getString("level_user"), rs.getString("status_akun"))) {
                    JOptionPane.showMessageDialog(view, "Password berhasil diubah!");
                    view.dispose();
                } else {
                    view.lblStatus.setText("Gagal mengubah password!");
                }
            }
        } catch (SQLException e) {
            view.lblStatus.setText("Error: " + e.getMessage());
        }
    }
}