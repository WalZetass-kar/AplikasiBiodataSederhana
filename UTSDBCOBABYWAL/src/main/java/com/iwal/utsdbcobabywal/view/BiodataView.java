package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BiodataView extends JFrame {
    
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtAlamat;
    private JTextField txtNoHp;
    private JComboBox<String> cbProdi;
    private JComboBox<String> cbJenisKelamin;
    private JButton btnSimpan;
    private JButton btnUpdate;
    private JButton btnHapus;
    private JButton btnRefresh;
    private JTable tableBiodata;
    private DefaultTableModel modelTable;
    private JLabel lblStatus;
    
    public BiodataView() {
        setTitle("Data Biodata Mahasiswa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        txtNim = new JTextField(15);
        txtNama = new JTextField(20);
        txtAlamat = new JTextField(25);
        txtNoHp = new JTextField(15);
        
        String[] prodiList = {
            "Manajemen Informatika",
            "Komputerisasi Akuntansi",
            "Hubungan Masyarakat",
            "Administrasi Bisnis",
         
        };
        cbProdi = new JComboBox<>(prodiList);
        cbProdi.setPreferredSize(new Dimension(200, 25));
        
        cbJenisKelamin = new JComboBox<>(new String[]{"Laki-Laki", "Perempuan"});
        cbJenisKelamin.setPreferredSize(new Dimension(150, 25));
        
        btnSimpan = new JButton("Simpan");
        btnUpdate = new JButton("Update");
        btnHapus = new JButton("Hapus");
        btnRefresh = new JButton("Refresh");
        
        modelTable = new DefaultTableModel(
            new String[]{"NIM", "Nama", "Alamat", "No. HP", "Program Studi", "Jenis Kelamin"}, 0
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableBiodata = new JTable(modelTable);
        tableBiodata.setRowHeight(30);
        tableBiodata.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tableBiodata.setFont(new Font("Arial", Font.PLAIN, 12));
        
        lblStatus = new JLabel("Sistem Siap");
        
        JPanel pnlInput = new JPanel(new GridBagLayout());
        pnlInput.setBorder(new TitledBorder("Form Input Biodata"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0;
        pnlInput.add(new JLabel("NIM:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        pnlInput.add(txtNim, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        pnlInput.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        pnlInput.add(txtNama, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        pnlInput.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        pnlInput.add(txtAlamat, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        pnlInput.add(new JLabel("No. HP:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        pnlInput.add(txtNoHp, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
        pnlInput.add(new JLabel("Program Studi:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 1;
        pnlInput.add(cbProdi, gbc);
        gbc.gridx = 2;
        pnlInput.add(new JLabel(""), gbc);
        
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 1;
        pnlInput.add(new JLabel("Jenis Kelamin:"), gbc);
        gbc.gridx = 1;
        pnlInput.add(cbJenisKelamin, gbc);
        
        JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        pnlButton.add(btnSimpan);
        pnlButton.add(btnUpdate);
        pnlButton.add(btnHapus);
        pnlButton.add(btnRefresh);
        
        JPanel pnlNorth = new JPanel(new BorderLayout());
        pnlNorth.add(pnlInput, BorderLayout.NORTH);
        pnlNorth.add(pnlButton, BorderLayout.SOUTH);
        
        JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStatus.setBackground(new Color(240, 240, 240));
        pnlStatus.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        pnlStatus.add(new JLabel("Status:"));
        pnlStatus.add(Box.createHorizontalStrut(5));
        pnlStatus.add(lblStatus);
        
        JPanel pnlFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlFooter.setBackground(new Color(240, 240, 240));
        JLabel lblDev = new JLabel("Database: tb_biodata | Developer by WalZetass-Kar © 2026");
        lblDev.setFont(new Font("Arial", Font.PLAIN, 11));
        pnlFooter.add(lblDev);
        
        JPanel pnlSouth = new JPanel(new BorderLayout());
        pnlSouth.add(pnlStatus, BorderLayout.NORTH);
        pnlSouth.add(pnlFooter, BorderLayout.SOUTH);
        
        add(pnlNorth, BorderLayout.NORTH);
        add(new JScrollPane(tableBiodata), BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
    }
    
    public JTextField getTxtNim() { return txtNim; }
    public JTextField getTxtNama() { return txtNama; }
    public JTextField getTxtAlamat() { return txtAlamat; }
    public JTextField getTxtNoHp() { return txtNoHp; }
    public JComboBox<String> getCbProdi() { return cbProdi; }
    public JComboBox<String> getCbJenisKelamin() { return cbJenisKelamin; }
    public JButton getBtnSimpan() { return btnSimpan; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnHapus() { return btnHapus; }
    public JButton getBtnRefresh() { return btnRefresh; }
    public JTable getTableBiodata() { return tableBiodata; }
    public DefaultTableModel getModelTable() { return modelTable; }
    public JLabel getLblStatus() { return lblStatus; }
}