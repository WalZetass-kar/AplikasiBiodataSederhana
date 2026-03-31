package com.iwal.utsdbcobabywal.model;

import java.sql.*;

public class PengalamanModel {
    private Connection conn;
    
    public PengalamanModel() {
        conn = Koneksi.getKoneksi();
    }
    
    public ResultSet tampilkanSemua() throws SQLException {
        String sql = "SELECT * FROM tb_pengalaman_kerja ORDER BY kd_pengalaman";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    public boolean simpan(String kode, String namaPerusahaan, String jabatan, String tahunBekerja) throws SQLException {
        String sql = "INSERT INTO tb_pengalaman_kerja (kode, nama_perusahaan, jabatan_terakhir, terakhir_bekerja) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, namaPerusahaan);
        ps.setString(3, jabatan);
        ps.setString(4, tahunBekerja);
        return ps.executeUpdate() > 0;
    }
    
    public boolean ubah(int kdPengalaman, String kode, String namaPerusahaan, String jabatan, String tahunBekerja) throws SQLException {
        String sql = "UPDATE tb_pengalaman_kerja SET kode=?, nama_perusahaan=?, jabatan_terakhir=?, terakhir_bekerja=? WHERE kd_pengalaman=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.setString(2, namaPerusahaan);
        ps.setString(3, jabatan);
        ps.setString(4, tahunBekerja);
        ps.setInt(5, kdPengalaman);
        return ps.executeUpdate() > 0;
    }
    
    public boolean hapus(int kdPengalaman) throws SQLException {
        String sql = "DELETE FROM tb_pengalaman_kerja WHERE kd_pengalaman=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, kdPengalaman);
        return ps.executeUpdate() > 0;
    }
}