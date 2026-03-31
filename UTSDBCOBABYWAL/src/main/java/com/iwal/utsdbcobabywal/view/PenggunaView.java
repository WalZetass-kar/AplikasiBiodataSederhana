package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PenggunaView extends JFrame {
    
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> cbLevel;
    private JComboBox<String> cbStatus;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnRefresh;
    private JTable tablePengguna;
    private DefaultTableModel modelTable;
    private JLabel lblStatus;
    
    public PenggunaView() {
        setTitle("Menu Pengguna");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        cbLevel = new JComboBox<>(new String[]{"Admin", "Operator", "User"});
        cbStatus = new JComboBox<>(new String[]{"Aktif", "Tidak Aktif"});
        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnRefresh = new JButton("Refresh");
        modelTable = new DefaultTableModel(new String[]{"Username", "Level", "Status"}, 0);
        tablePengguna = new JTable(modelTable);
        lblStatus = new JLabel("Sistem Siap");
        
        JPanel pnlInput = new JPanel(new GridBagLayout());
        pnlInput.setBorder(new TitledBorder("Form Pengguna"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        pnlInput.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(txtUsername, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        pnlInput.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(txtPassword, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        pnlInput.add(new JLabel("Level:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(cbLevel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        pnlInput.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(cbStatus, gbc);
        
        JPanel pnlButton = new JPanel(new FlowLayout());
        pnlButton.add(btnSimpan);
        pnlButton.add(btnUbah);
        pnlButton.add(btnHapus);
        pnlButton.add(btnRefresh);
        
        JPanel pnlNorth = new JPanel(new BorderLayout());
        pnlNorth.add(pnlInput, BorderLayout.NORTH);
        pnlNorth.add(pnlButton, BorderLayout.CENTER);
        
        JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStatus.setBorder(BorderFactory.createEtchedBorder());
        pnlStatus.add(new JLabel("Status: "));
        pnlStatus.add(lblStatus);
        
        add(pnlNorth, BorderLayout.NORTH);
        add(new JScrollPane(tablePengguna), BorderLayout.CENTER);
        add(pnlStatus, BorderLayout.SOUTH);
    }
    
    public JTextField getTxtUsername() { return txtUsername; }
    public JPasswordField getTxtPassword() { return txtPassword; }
    public JComboBox<String> getCbLevel() { return cbLevel; }
    public JComboBox<String> getCbStatus() { return cbStatus; }
    public JButton getBtnSimpan() { return btnSimpan; }
    public JButton getBtnUbah() { return btnUbah; }
    public JButton getBtnHapus() { return btnHapus; }
    public JButton getBtnRefresh() { return btnRefresh; }
    public JTable getTablePengguna() { return tablePengguna; }
    public DefaultTableModel getModelTable() { return modelTable; }
    public JLabel getLblStatus() { return lblStatus; }
}