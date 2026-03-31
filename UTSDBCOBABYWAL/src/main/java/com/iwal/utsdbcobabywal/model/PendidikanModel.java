package com.iwal.utsdbcobabywal.model;

import java.sql.*;

public class PendidikanModel {
    private Connection conn;
    
    public PendidikanModel() {
        conn = Koneksi.getKoneksi();
    }
    
    public ResultSet tampilkanSemua() throws SQLException {
        String sql = "SELECT * FROM tb_pendidikan ORDER BY kd_pendidikan";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    public boolean simpan(String kode, String namaInstansi, String dariTahun, String sampaiTahun, String jurusan) throws SQLException {
        String sql = "INSERT INTO tb_pendidikan (kode, nama_instansi, dari_tahun, sampai_tahun, jurusan) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, namaInstansi);
        ps.setString(3, dariTahun);
        ps.setString(4, sampaiTahun);
        ps.setString(5, jurusan);
        return ps.executeUpdate() > 0;
    }
    
    public boolean ubah(int kdPendidikan, String kode, String namaInstansi, String dariTahun, String sampaiTahun, String jurusan) throws SQLException {
        String sql = "UPDATE tb_pendidikan SET kode=?, nama_instansi=?, dari_tahun=?, sampai_tahun=?, jurusan=? WHERE kd_pendidikan=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, namaInstansi);
        ps.setString(3, dariTahun);
        ps.setString(4, sampaiTahun);
        ps.setString(5, jurusan);
        ps.setInt(6, kdPendidikan);
        return ps.executeUpdate() > 0;
    }
    
    public boolean hapus(int kdPendidikan) throws SQLException {
        String sql = "DELETE FROM tb_pendidikan WHERE kd_pendidikan=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, kdPendidikan);
        return ps.executeUpdate() > 0;
    }
}