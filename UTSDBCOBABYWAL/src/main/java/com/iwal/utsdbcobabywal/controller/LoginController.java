package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.PenggunaModel;
import com.iwal.utsdbcobabywal.model.PenggunaHistoriModel;
import com.iwal.utsdbcobabywal.view.LoginView;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginView view;
    private PenggunaModel model;
    private PenggunaHistoriModel historiModel;
    private JDialog dialog;
    private MenuUtamaController menuController;

    public LoginController(LoginView view, PenggunaModel model, PenggunaHistoriModel historiModel, 
                          JDialog dialog, MenuUtamaController menuController) {
        this.view = view;
        this.model = model;
        this.historiModel = historiModel;
        this.dialog = dialog;
        this.menuController = menuController;
        
        this.view.btnLogin.addActionListener(e -> prosesLogin());
        this.view.btnBatal.addActionListener(e -> dialog.dispose());
    }

    private void prosesLogin() {
        String username = view.txtUsername.getText().trim();
        String password = new String(view.txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            view.lblStatus.setText("Username dan Password harus diisi!");
            return;
        }

        try {
            ResultSet rs = model.cariPengguna(username);
            if (rs.next()) {
                String passwordDB = rs.getString("psw_pengguna");

                if (password.equals(passwordDB)) {
                    String level = rs.getString("level_user");
                    String status = rs.getString("status_akun");

                    if (status.equalsIgnoreCase("Aktif")) {
                        historiModel.simpanHistori(username, "Login berhasil");
                        model.updateLastLogin(username);

                        JOptionPane.showMessageDialog(dialog, "Login berhasil sebagai " + level);
                        
                        menuController.loginBerhasil(username, level);
                        dialog.dispose();
                    } else {
                        view.lblStatus.setText("Akun Anda " + status);
                    }
                } else {
                    view.lblStatus.setText("Password salah!");
                }
            } else {
                view.lblStatus.setText("Username tidak ditemukan!");
            }
        } catch (SQLException e) {
            view.lblStatus.setText("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(dialog, "Gagal terhubung ke database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}