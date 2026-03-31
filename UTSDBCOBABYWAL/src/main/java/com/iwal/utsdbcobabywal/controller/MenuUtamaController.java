package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.*;
import com.iwal.utsdbcobabywal.view.*;
import javax.swing.*;
import java.sql.SQLException;

public class MenuUtamaController {
    private MenuUtamaView view;
    private String username;
    private String level;
    
    public MenuUtamaController(MenuUtamaView view, String username, String level) {
        this.view = view;
        this.username = username;
        this.level = level;
        
        if (!username.isEmpty()) {
            view.bukaMenu(username, level);
        }
        
        view.btnDashboard.addActionListener(e -> bukaDashboard());
        view.btnMaster.addActionListener(e -> bukaMaster());
        view.btnPengguna.addActionListener(e -> bukaPengguna());
        view.btnFormBiodata.addActionListener(e -> bukaFormBiodata());
        view.btnPendidikan.addActionListener(e -> bukaPendidikan());
        view.btnPengalaman.addActionListener(e -> bukaPengalaman());
        view.btnHistoriLogin.addActionListener(e -> bukaHistoriLogin());
        view.btnUbahPassword.addActionListener(e -> bukaUbahPassword());
        view.btnLogin.addActionListener(e -> bukaLogin());
        view.btnLogout.addActionListener(e -> logout());
        view.btnKeluar.addActionListener(e -> keluar());
    }
    
    private void bukaDashboard() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        
        JFrame frameDashboard = new JFrame("Dashboard Statistik");
        frameDashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameDashboard.setSize(900, 600);
        frameDashboard.setLocationRelativeTo(null);
        
        DashboardView dashboardView = new DashboardView();
        DashboardController dashboardController = new DashboardController(dashboardView);
        
        frameDashboard.add(dashboardView);
        frameDashboard.setVisible(true);
    }
    
    private void bukaMaster() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        MasterView masterView = new MasterView();
        MasterModel masterModel = new MasterModel();
        new MasterController(masterView, masterModel);
        masterView.setVisible(true);
    }
    
    private void bukaPengguna() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        PenggunaView penggunaView = new PenggunaView();
        PenggunaModel penggunaModel = new PenggunaModel();
        new PenggunaController(penggunaView, penggunaModel);
        penggunaView.setVisible(true);
    }
    
    private void bukaFormBiodata() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        BiodataView biodataView = new BiodataView();
        BiodataModel biodataModel = new BiodataModel();
        new BiodataController(biodataView, biodataModel);
        biodataView.setVisible(true);
    }
    
    private void bukaPendidikan() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        JFrame framePendidikan = new JFrame("Data Pendidikan");
        framePendidikan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePendidikan.setSize(900, 600);
        framePendidikan.setLocationRelativeTo(null);
        
        PendidikanView pendidikanView = new PendidikanView();
        PendidikanModel pendidikanModel = new PendidikanModel();
        new PendidikanController(pendidikanView, pendidikanModel);
        
        framePendidikan.add(pendidikanView);
        framePendidikan.setVisible(true);
    }
    
    private void bukaPengalaman() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        JFrame framePengalaman = new JFrame("Data Pengalaman Kerja");
        framePengalaman.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePengalaman.setSize(900, 600);
        framePengalaman.setLocationRelativeTo(null);
        
        PengalamanView pengalamanView = new PengalamanView();
        PengalamanModel pengalamanModel = new PengalamanModel();
        new PengalamanController(pengalamanView, pengalamanModel);
        
        framePengalaman.add(pengalamanView);
        framePengalaman.setVisible(true);
    }
    
    private void bukaHistoriLogin() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        
        if (!level.equals("Admin")) {
            JOptionPane.showMessageDialog(view, "Hanya Admin yang dapat melihat histori login!");
            return;
        }
        
        HistoriLoginView historiView = new HistoriLoginView();
        PenggunaHistoriModel historiModel = new PenggunaHistoriModel();
        new PenggunaHistoriController(historiView, historiModel);
        historiView.setVisible(true);
    }
    
    private void bukaUbahPassword() {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Silahkan login terlebih dahulu!");
            return;
        }
        
        UbahPasswordView ubahPasswordView = new UbahPasswordView(view, username);
        PenggunaModel penggunaModel = new PenggunaModel();
        new UbahPasswordController(ubahPasswordView, penggunaModel, username);
        ubahPasswordView.setVisible(true);
    }
    
    private void bukaLogin() {
        JDialog loginDialog = new JDialog(view, "Login Aplikasi", true);
        loginDialog.setSize(350, 220);
        loginDialog.setLocationRelativeTo(view);
        loginDialog.setResizable(false);
        
        LoginView loginView = new LoginView();
        PenggunaModel penggunaModel = new PenggunaModel();
        PenggunaHistoriModel historiModel = new PenggunaHistoriModel();
        
        new LoginController(loginView, penggunaModel, historiModel, loginDialog, this);
        
        loginDialog.add(loginView);
        loginDialog.setVisible(true);
    }
    
    public void loginBerhasil(String username, String level) {
        this.username = username;
        this.level = level;
        view.bukaMenu(username, level);
    }
    
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(view, 
            "Yakin ingin logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PenggunaHistoriModel historiModel = new PenggunaHistoriModel();
                historiModel.simpanHistori(username, "Logout berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            this.username = "";
            this.level = "";
            view.kunciMenu();
            JOptionPane.showMessageDialog(view, "Logout berhasil");
        }
    }
    
    private void keluar() {
        int confirm = JOptionPane.showConfirmDialog(view, 
            "Yakin ingin keluar dari aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}