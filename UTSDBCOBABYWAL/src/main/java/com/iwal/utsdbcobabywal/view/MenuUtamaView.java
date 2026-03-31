package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import java.awt.*;

public class MenuUtamaView extends JFrame {
    
    public JButton btnDashboard = new JButton("Dashboard");
    public JButton btnMaster = new JButton("Master");
    public JButton btnPengguna = new JButton("Pengguna");
    public JButton btnFormBiodata = new JButton("Form Biodata");
    public JButton btnPendidikan = new JButton("Pendidikan");
    public JButton btnPengalaman = new JButton("Pengalaman");
    public JButton btnHistoriLogin = new JButton("Histori Login");
    public JButton btnUbahPassword = new JButton("Ubah Password");
    public JButton btnLogin = new JButton("Login");
    public JButton btnLogout = new JButton("Logout");
    public JButton btnKeluar = new JButton("Keluar");
    
    public JLabel lblUserInfo = new JLabel("Status: Belum Login");
    public JLabel lblStatus = new JLabel("Sistem Siap Digunakan");
    public JPanel contentPanel = new JPanel();
    
    public MenuUtamaView() {
        setTitle("Aplikasi Biodata Sederhana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(45, 62, 80));
        sidePanel.setPreferredSize(new Dimension(250, getHeight()));
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
        
        JLabel appTitle = new JLabel("APLIKASI");
        appTitle.setFont(new Font("Arial", Font.BOLD, 18));
        appTitle.setForeground(new Color(52, 152, 219));
        appTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(appTitle);
        
        JLabel appSubtitle = new JLabel("BIODATA");
        appSubtitle.setFont(new Font("Arial", Font.BOLD, 24));
        appSubtitle.setForeground(Color.WHITE);
        appSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(appSubtitle);
        
        sidePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(200, 2));
        separator.setForeground(new Color(52, 152, 219));
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(separator);
        
        sidePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        
        Dimension btnSize = new Dimension(200, 40);
        Font btnFont = new Font("Arial", Font.PLAIN, 13);
        Color btnColor = new Color(52, 152, 219);
        
        JButton[] menuButtons = {
            btnDashboard, btnMaster, btnPengguna, btnFormBiodata, 
            btnPendidikan, btnPengalaman, btnHistoriLogin, btnUbahPassword
        };
        
        for (JButton btn : menuButtons) {
            btn.setFont(btnFont);
            btn.setPreferredSize(btnSize);
            btn.setMaximumSize(btnSize);
            btn.setMinimumSize(btnSize);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setBackground(btnColor);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            sidePanel.add(btn);
            sidePanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }
        
        sidePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JSeparator separator2 = new JSeparator();
        separator2.setMaximumSize(new Dimension(200, 2));
        separator2.setForeground(new Color(52, 152, 219));
        separator2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(separator2);
        
        sidePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        btnLogin.setFont(btnFont);
        btnLogin.setPreferredSize(btnSize);
        btnLogin.setMaximumSize(btnSize);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setBackground(new Color(46, 204, 113));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        sidePanel.add(btnLogin);
        sidePanel.add(Box.createRigidArea(new Dimension(0, 8)));
        
        btnLogout.setFont(btnFont);
        btnLogout.setPreferredSize(btnSize);
        btnLogout.setMaximumSize(btnSize);
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBackground(new Color(241, 176, 53));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFocusPainted(false);
        sidePanel.add(btnLogout);
        sidePanel.add(Box.createRigidArea(new Dimension(0, 8)));
        
        btnKeluar.setFont(btnFont);
        btnKeluar.setPreferredSize(btnSize);
        btnKeluar.setMaximumSize(btnSize);
        btnKeluar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnKeluar.setBackground(new Color(231, 76, 60));
        btnKeluar.setForeground(Color.WHITE);
        btnKeluar.setFocusPainted(false);
        sidePanel.add(btnKeluar);
        
        sidePanel.add(Box.createVerticalGlue());
        
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setOpaque(false);
        userPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        
        JLabel userIcon = new JLabel("👤");
        userIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        userIcon.setForeground(new Color(200, 200, 200));
        userIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(userIcon);
        
        userPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        
        lblUserInfo.setFont(new Font("Arial", Font.BOLD, 12));
        lblUserInfo.setForeground(Color.WHITE);
        lblUserInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(lblUserInfo);
        
        sidePanel.add(userPanel);
        
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BorderLayout());
        
        JPanel welcomePanel = new JPanel(new GridBagLayout());
        welcomePanel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel welcomeIcon = new JLabel("📋");
        welcomeIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 100));
        welcomePanel.add(welcomeIcon, gbc);
        
        JLabel welcomeTitle = new JLabel("Selamat Datang");
        welcomeTitle.setFont(new Font("Arial", Font.BOLD, 42));
        welcomeTitle.setForeground(new Color(45, 62, 80));
        welcomePanel.add(welcomeTitle, gbc);
        
        JLabel welcomeSubtitle = new JLabel("Aplikasi Biodata Sederhana");
        welcomeSubtitle.setFont(new Font("Arial", Font.PLAIN, 22));
        welcomeSubtitle.setForeground(new Color(52, 152, 219));
        welcomePanel.add(welcomeSubtitle, gbc);
        
        contentPanel.add(welcomePanel, BorderLayout.CENTER);
        
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(new Color(240, 240, 240));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        
        JLabel statusIcon = new JLabel("●");
        statusIcon.setFont(new Font("Arial", Font.BOLD, 14));
        statusIcon.setForeground(new Color(46, 204, 113));
        
        JPanel statusLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        statusLeft.setBackground(new Color(240, 240, 240));
        statusLeft.add(statusIcon);
        statusLeft.add(lblStatus);
        statusPanel.add(statusLeft, BorderLayout.WEST);
        
        JLabel devLabel = new JLabel("© 2026 Aplikasi Biodata v1.0 | by WalZetass-Kar");
        devLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        devLabel.setForeground(new Color(120, 120, 120));
        statusPanel.add(devLabel, BorderLayout.EAST);
        
        add(sidePanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        
        kunciMenu();
    }
    
    public void kunciMenu() {
        btnDashboard.setEnabled(false);
        btnMaster.setEnabled(false);
        btnPengguna.setEnabled(false);
        btnFormBiodata.setEnabled(false);
        btnPendidikan.setEnabled(false);
        btnPengalaman.setEnabled(false);
        btnHistoriLogin.setEnabled(false);
        btnUbahPassword.setEnabled(false);
        btnLogout.setEnabled(false);
        btnLogin.setEnabled(true);
        btnKeluar.setEnabled(true);
        lblUserInfo.setText("Status: Belum Login");
        lblStatus.setText("Sistem Siap - Silahkan Login");
    }
    
    public void bukaMenu(String username, String level) {
        btnDashboard.setEnabled(true);
        btnMaster.setEnabled(true);
        btnPengguna.setEnabled(true);
        btnFormBiodata.setEnabled(true);
        btnPendidikan.setEnabled(true);
        btnPengalaman.setEnabled(true);
        btnHistoriLogin.setEnabled(true);
        btnUbahPassword.setEnabled(true);
        btnLogout.setEnabled(true);
        btnLogin.setEnabled(false);
        btnKeluar.setEnabled(true);
        lblUserInfo.setText("👤 " + username + " | " + level);
        lblStatus.setText("Sistem Siap - Login sebagai " + username + " (" + level + ")");
    }
}