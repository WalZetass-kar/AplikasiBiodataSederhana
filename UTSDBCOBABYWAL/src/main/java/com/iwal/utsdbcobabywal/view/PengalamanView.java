package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PengalamanView extends JPanel {
    
    public JTextField txtKdPengalaman = new JTextField();
    public JTextField txtKode = new JTextField();
    public JTextField txtNamaPerusahaan = new JTextField();
    public JTextField txtJabatan = new JTextField();
    public JTextField txtTahunBekerja = new JTextField();
    
    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnUbah = new JButton("Ubah");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnBatal = new JButton("Batal");
    public JButton btnRefresh = new JButton("Refresh");
    
    public JTable tablePengalaman = new JTable();
    public DefaultTableModel modelTable;
    public JLabel lblStatus = new JLabel("Sistem Siap");
    
    public PengalamanView() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel pnlInput = new JPanel(new GridBagLayout());
        pnlInput.setBorder(BorderFactory.createTitledBorder("Data Pengalaman Kerja"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        int row = 0;
        
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        txtKdPengalaman.setEditable(false);
        txtKdPengalaman.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtKdPengalaman, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Kode:"), gbc);
        gbc.gridx = 1;
        txtKode.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtKode, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Nama Perusahaan:"), gbc);
        gbc.gridx = 1;
        txtNamaPerusahaan.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtNamaPerusahaan, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Jabatan:"), gbc);
        gbc.gridx = 1;
        txtJabatan.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtJabatan, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Tahun Bekerja:"), gbc);
        gbc.gridx = 1;
        txtTahunBekerja.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtTahunBekerja, gbc);
        
        JPanel pnlButton = new JPanel(new FlowLayout());
        pnlButton.add(btnSimpan);
        pnlButton.add(btnUbah);
        pnlButton.add(btnHapus);
        pnlButton.add(btnBatal);
        pnlButton.add(btnRefresh);
        
        modelTable = new DefaultTableModel(new String[]{
            "ID", "Kode", "Nama Perusahaan", "Jabatan", "Tahun Bekerja"
        }, 0);
        tablePengalaman.setModel(modelTable);
        tablePengalaman.setRowHeight(30);
        
        JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStatus.setBorder(BorderFactory.createEtchedBorder());
        pnlStatus.add(new JLabel("Status: "));
        pnlStatus.add(lblStatus);
        
        JPanel pnlNorth = new JPanel(new BorderLayout());
        pnlNorth.add(pnlInput, BorderLayout.NORTH);
        pnlNorth.add(pnlButton, BorderLayout.CENTER);
        
        add(pnlNorth, BorderLayout.NORTH);
        add(new JScrollPane(tablePengalaman), BorderLayout.CENTER);
        add(pnlStatus, BorderLayout.SOUTH);
    }
    
    public void resetForm() {
        txtKdPengalaman.setText("");
        txtKode.setText("");
        txtNamaPerusahaan.setText("");
        txtJabatan.setText("");
        txtTahunBekerja.setText("");
    }
}