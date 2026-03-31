package com.iwal.utsdbcobabywal.model;

import java.sql.*;

public class BiodataModel {
    private Connection conn;
    
    public BiodataModel() {
        conn = Koneksi.getKoneksi();
    }
    
    public ResultSet tampilkanSemua() throws SQLException {
        String sql = "SELECT * FROM tb_biodata ORDER BY nim";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
    

    public boolean simpan(String nim, String nama, String alamat, String noHp, String prodi, String jenisKelamin) throws SQLException {
        String sql = "INSERT INTO tb_biodata (nim, nama, alamat, no_hp, prodi, jenis_kelamin) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nim);
        ps.setString(2, nama);
        ps.setString(3, alamat);
        ps.setString(4, noHp);
        ps.setString(5, prodi);
        ps.setString(6, jenisKelamin);
    return ps.executeUpdate() > 0;
}
    
    public boolean ubah(String nim, String nama, String alamat, String noHp, String prodi, String jenisKelamin) throws SQLException {
        String sql = "UPDATE tb_biodata SET nama=?, alamat=?, no_hp=?, prodi=?, jenis_kelamin=? WHERE nim=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nama);
        ps.setString(2, alamat);
        ps.setString(3, noHp);
        ps.setString(4, prodi);
        ps.setString(5, jenisKelamin);
        ps.setString(6, nim);
        return ps.executeUpdate() > 0;
    }
    
    public boolean hapus(String nim) throws SQLException {
        String sql = "DELETE FROM tb_biodata WHERE nim=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nim);
        return ps.executeUpdate() > 0;
    }
    
    public ResultSet cariBerdasarkanNIM(String nim) throws SQLException {
        String sql = "SELECT * FROM tb_biodata WHERE nim = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nim);
        return ps.executeQuery();
    }
}