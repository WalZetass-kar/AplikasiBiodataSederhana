package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoriLoginView extends JFrame {
    
    public JTable tableHistori;
    public DefaultTableModel modelTable;
    public JButton btnRefresh = new JButton("Refresh");
    public JButton btnHapusSemua = new JButton("Hapus Semua");
    public JLabel lblStatus = new JLabel("Sistem Siap");
    
    public HistoriLoginView() {
        setTitle("Histori Login Pengguna");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(45, 62, 80));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        
        JLabel headerLabel = new JLabel("HISTORI LOGIN PENGGUNA");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        String[] columns = {"ID", "Username", "Keterangan", "Waktu Login/Logout"};
        modelTable = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableHistori = new JTable(modelTable);
        tableHistori.setRowHeight(30);
        tableHistori.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tableHistori.getTableHeader().setBackground(new Color(52, 152, 219));
        tableHistori.getTableHeader().setForeground(Color.WHITE);
        tableHistori.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(Color.WHITE);
        
        btnRefresh.setBackground(new Color(52, 152, 219));
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setFocusPainted(false);
        btnRefresh.setPreferredSize(new Dimension(100, 35));
        
        btnHapusSemua.setBackground(new Color(192, 57, 43));
        btnHapusSemua.setForeground(Color.WHITE);
        btnHapusSemua.setFocusPainted(false);
        btnHapusSemua.setPreferredSize(new Dimension(120, 35));
        
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnHapusSemua);
        
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBackground(new Color(240, 240, 240));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
        statusPanel.add(new JLabel("Status: "));
        statusPanel.add(lblStatus);
        
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(240, 240, 240));
        JLabel devLabel = new JLabel("© 2026 Aplikasi Biodata - Histori Login");
        devLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        devLabel.setForeground(new Color(100, 100, 100));
        footerPanel.add(devLabel);
        
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(statusPanel, BorderLayout.NORTH);
        southPanel.add(footerPanel, BorderLayout.SOUTH);
        
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(tableHistori), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);
    }
}