package com.iwal.utsdbcobabywal.model;

import java.sql.*;

public class MasterModel {
    private Connection conn;
    
    public MasterModel() {
        conn = Koneksi.getKoneksi();
    }
    
    public ResultSet tampilkanSemua() throws SQLException {
        String sql = "SELECT * FROM tb_master ORDER BY id";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    public boolean simpan(String kode, String nama, String keterangan) throws SQLException {
        String sql = "INSERT INTO tb_master (kode, nama, keterangan) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, nama);
        ps.setString(3, keterangan);
        return ps.executeUpdate() > 0;
    }
    
    public boolean ubah(int id, String kode, String nama, String keterangan) throws SQLException {
        String sql = "UPDATE tb_master SET kode=?, nama=?, keterangan=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, nama);
        ps.setString(3, keterangan);
        ps.setInt(4, id);
        return ps.executeUpdate() > 0;
    }
    
    public boolean hapus(int id) throws SQLException {
        String sql = "DELETE FROM tb_master WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
}