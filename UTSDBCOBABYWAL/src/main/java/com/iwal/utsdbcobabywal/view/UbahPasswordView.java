package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import java.awt.*;

public class UbahPasswordView extends JDialog {
    public JPasswordField txtPasswordLama = new JPasswordField(15);
    public JPasswordField txtPasswordBaru = new JPasswordField(15);
    public JPasswordField txtKonfirmasi = new JPasswordField(15);
    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnBatal = new JButton("Batal");
    public JLabel lblStatus = new JLabel(" ");
    
    public UbahPasswordView(JFrame parent, String username) {
        super(parent, "Ubah Password", true);
        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        
        JPanel header = new JPanel();
        header.setBackground(new Color(52, 152, 219));
        header.add(new JLabel("UBAH PASSWORD - " + username.toUpperCase()));
        ((JLabel)header.getComponent(0)).setForeground(Color.WHITE);
        ((JLabel)header.getComponent(0)).setFont(new Font("Arial", Font.BOLD, 14));
        
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Password Lama:"), gbc);
        gbc.gridx = 1;
        form.add(txtPasswordLama, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Password Baru:"), gbc);
        gbc.gridx = 1;
        form.add(txtPasswordBaru, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Konfirmasi:"), gbc);
        gbc.gridx = 1;
        form.add(txtKonfirmasi, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        lblStatus.setForeground(Color.RED);
        form.add(lblStatus, gbc);
        
        JPanel button = new JPanel(new FlowLayout());
        button.add(btnSimpan);
        button.add(btnBatal);
        
        add(header, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}