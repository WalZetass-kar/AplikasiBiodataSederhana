package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    public JTextField txtUsername = new JTextField();
    public JPasswordField txtPassword = new JPasswordField();
    public JButton btnLogin = new JButton("Login");
    public JButton btnBatal = new JButton("Batal");
    public JLabel lblStatus = new JLabel("Silahkan login dengan akun Anda");
    
    public LoginView() {
        setLayout(new BorderLayout());
        
        JPanel pnlMain = new JPanel(new GridBagLayout());
        pnlMain.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0;
        pnlMain.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        txtUsername.setPreferredSize(new Dimension(150, 25));
        pnlMain.add(txtUsername, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        pnlMain.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        txtPassword.setPreferredSize(new Dimension(150, 25));
        pnlMain.add(txtPassword, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        lblStatus.setForeground(Color.RED);
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
        pnlMain.add(lblStatus, gbc);
        
        JPanel pnlButton = new JPanel(new FlowLayout());
        btnLogin.setBackground(new Color(70, 130, 180));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(80, 30));
        
        btnBatal.setBackground(new Color(190, 190, 190));
        btnBatal.setForeground(Color.WHITE);
        btnBatal.setFocusPainted(false);
        btnBatal.setPreferredSize(new Dimension(80, 30));
        
        pnlButton.add(btnLogin);
        pnlButton.add(btnBatal);
        
        add(pnlMain, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);
    }
}