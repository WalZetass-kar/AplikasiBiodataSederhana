package com.iwal.utsdbcobabywal.model;

import java.sql.*;

public class PenggunaHistoriModel {
    private Connection conn;

    public PenggunaHistoriModel() {
        conn = Koneksi.getKoneksi();
    }

    public ResultSet tampilkanSemua() throws SQLException {
        String sql = "SELECT * FROM tb_pengguna_histori ORDER BY kd_histori DESC";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    public boolean simpan(String username, String keterangan) throws SQLException {
        String sql = "INSERT INTO tb_pengguna_histori (nm_pengguna, keterangan, tgl_wkt) VALUES (?, ?, NOW())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, keterangan);
        return ps.executeUpdate() > 0;
    }
    
    public boolean simpanHistori(String username, String keterangan) throws SQLException {
        return simpan(username, keterangan);
    }

    public boolean hapusSemua() throws SQLException {
        String sql = "DELETE FROM tb_pengguna_histori";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeUpdate() > 0;
    }
}