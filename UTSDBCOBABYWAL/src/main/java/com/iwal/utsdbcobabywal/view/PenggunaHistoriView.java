package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PenggunaHistoriView extends JPanel {
    
    public JTable tableHistori = new JTable();
    public DefaultTableModel modelTable;
    public JButton btnRefresh = new JButton("Refresh");
    public JButton btnHapusSemua = new JButton("Hapus Semua");
    public JLabel lblStatus = new JLabel("Sistem Siap");
    
    public PenggunaHistoriView() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel pnlButton = new JPanel(new FlowLayout());
        pnlButton.add(btnRefresh);
        pnlButton.add(btnHapusSemua);
        
        modelTable = new DefaultTableModel(new String[]{
            "ID", "Username", "Aktivitas", "Keterangan", "Waktu"
        }, 0);
        tableHistori.setModel(modelTable);
        tableHistori.setRowHeight(30);
        tableHistori.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        
        JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStatus.setBorder(BorderFactory.createEtchedBorder());
        pnlStatus.add(new JLabel("Status: "));
        pnlStatus.add(lblStatus);
        
        add(pnlButton, BorderLayout.NORTH);
        add(new JScrollPane(tableHistori), BorderLayout.CENTER);
        add(pnlStatus, BorderLayout.SOUTH);
    }
}