package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PendidikanView extends JPanel {
    
    public JTextField txtKdPendidikan = new JTextField();
    public JTextField txtKode = new JTextField();
    public JTextField txtNamaInstansi = new JTextField();
    public JTextField txtDariTahun = new JTextField();
    public JTextField txtSampaiTahun = new JTextField();
    public JTextField txtJurusan = new JTextField();
    
    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnUbah = new JButton("Ubah");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnBatal = new JButton("Batal");
    public JButton btnRefresh = new JButton("Refresh");
    
    public JTable tablePendidikan = new JTable();
    public DefaultTableModel modelTable;
    public JLabel lblStatus = new JLabel("Sistem Siap");
    
    public PendidikanView() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel pnlInput = new JPanel(new GridBagLayout());
        pnlInput.setBorder(BorderFactory.createTitledBorder("Data Pendidikan"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        int row = 0;
        
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        txtKdPendidikan.setEditable(false);
        txtKdPendidikan.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtKdPendidikan, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Kode:"), gbc);
        gbc.gridx = 1;
        txtKode.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtKode, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Nama Instansi:"), gbc);
        gbc.gridx = 1;
        txtNamaInstansi.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtNamaInstansi, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Dari Tahun:"), gbc);
        gbc.gridx = 1;
        txtDariTahun.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtDariTahun, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Sampai Tahun:"), gbc);
        gbc.gridx = 1;
        txtSampaiTahun.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtSampaiTahun, gbc);
        
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        pnlInput.add(new JLabel("Jurusan:"), gbc);
        gbc.gridx = 1;
        txtJurusan.setPreferredSize(new Dimension(200, 30));
        pnlInput.add(txtJurusan, gbc);
        
        JPanel pnlButton = new JPanel(new FlowLayout());
        pnlButton.add(btnSimpan);
        pnlButton.add(btnUbah);
        pnlButton.add(btnHapus);
        pnlButton.add(btnBatal);
        pnlButton.add(btnRefresh);
        
        modelTable = new DefaultTableModel(new String[]{
            "ID", "Kode", "Nama Instansi", "Dari Tahun", "Sampai Tahun", "Jurusan"
        }, 0);
        tablePendidikan.setModel(modelTable);
        tablePendidikan.setRowHeight(30);
        
        JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStatus.setBorder(BorderFactory.createEtchedBorder());
        pnlStatus.add(new JLabel("Status: "));
        pnlStatus.add(lblStatus);
        
        JPanel pnlNorth = new JPanel(new BorderLayout());
        pnlNorth.add(pnlInput, BorderLayout.NORTH);
        pnlNorth.add(pnlButton, BorderLayout.CENTER);
        
        add(pnlNorth, BorderLayout.NORTH);
        add(new JScrollPane(tablePendidikan), BorderLayout.CENTER);
        add(pnlStatus, BorderLayout.SOUTH);
    }
    
    public void resetForm() {
        txtKdPendidikan.setText("");
        txtKode.setText("");
        txtNamaInstansi.setText("");
        txtDariTahun.setText("");
        txtSampaiTahun.setText("");
        txtJurusan.setText("");
    }
}