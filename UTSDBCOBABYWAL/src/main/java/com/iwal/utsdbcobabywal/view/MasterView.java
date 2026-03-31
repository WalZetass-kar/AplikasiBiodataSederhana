package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MasterView extends JFrame {
    
    private JTextField txtId;
    private JTextField txtKode;
    private JTextField txtNama;
    private JTextArea txtKeterangan;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnRefresh;
    private JTable tableMaster;
    private DefaultTableModel modelTable;
    private JLabel lblStatus;
    
    public MasterView() {
        setTitle("Menu Master");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        txtId = new JTextField(10);
        txtKode = new JTextField(15);
        txtNama = new JTextField(20);
        txtKeterangan = new JTextArea(3, 20);
        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnRefresh = new JButton("Refresh");
        modelTable = new DefaultTableModel(new String[]{"ID", "Kode", "Nama", "Keterangan"}, 0);
        tableMaster = new JTable(modelTable);
        lblStatus = new JLabel("Sistem Siap");
        
        JPanel pnlInput = new JPanel(new GridBagLayout());
        pnlInput.setBorder(new TitledBorder("Form Master"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        pnlInput.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        txtId.setEditable(false);
        pnlInput.add(txtId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        pnlInput.add(new JLabel("Kode:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(txtKode, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        pnlInput.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(txtNama, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        pnlInput.add(new JLabel("Keterangan:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(new JScrollPane(txtKeterangan), gbc);
        
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
        add(new JScrollPane(tableMaster), BorderLayout.CENTER);
        add(pnlStatus, BorderLayout.SOUTH);
    }
    
    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtKode() { return txtKode; }
    public JTextField getTxtNama() { return txtNama; }
    public JTextArea getTxtKeterangan() { return txtKeterangan; }
    public JButton getBtnSimpan() { return btnSimpan; }
    public JButton getBtnUbah() { return btnUbah; }
    public JButton getBtnHapus() { return btnHapus; }
    public JButton getBtnRefresh() { return btnRefresh; }
    public JTable getTableMaster() { return tableMaster; }
    public DefaultTableModel getModelTable() { return modelTable; }
    public JLabel getLblStatus() { return lblStatus; }
}