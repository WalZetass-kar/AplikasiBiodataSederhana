package com.iwal.utsdbcobabywal.controller;

import com.iwal.utsdbcobabywal.model.*;
import com.iwal.utsdbcobabywal.view.DashboardView;
import java.sql.*;

public class DashboardController {
    private DashboardView view;
    private Connection conn;
    
    public DashboardController(DashboardView view) {
        this.view = view;
        this.conn = Koneksi.getKoneksi();
        loadStats();
    }
    
    private void loadStats() {
        try {
            int mahasiswa = getCount("tb_biodata");
            int pengguna = getCount("tb_pengguna");
            int pendidikan = getCount("tb_pendidikan");
            int pengalaman = getCount("tb_pengalaman_kerja");
            int master = getCount("tb_master");
            int histori = getCount("tb_pengguna_histori");
            
            view.updateStats(mahasiswa, pengguna, pendidikan, pengalaman, master, histori);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private int getCount(String tableName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}