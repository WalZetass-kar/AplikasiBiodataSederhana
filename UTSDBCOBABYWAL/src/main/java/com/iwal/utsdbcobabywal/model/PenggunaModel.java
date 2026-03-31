package com.iwal.utsdbcobabywal.model;

import java.sql.*;

public class PenggunaModel {
    private Connection conn;

    public PenggunaModel() {
        conn = Koneksi.getKoneksi();
    }

    public ResultSet cariPengguna(String username) throws SQLException {
        String sql = "SELECT * FROM tb_pengguna WHERE nm_pengguna = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        return ps.executeQuery();
    }

    public boolean updateLastLogin(String username) throws SQLException {
        String sql = "UPDATE tb_pengguna SET terakhir_login = NOW() WHERE nm_pengguna = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        return ps.executeUpdate() > 0;
    }
    
    public ResultSet tampilkanSemua() throws SQLException {
        String sql = "SELECT * FROM tb_pengguna";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    public boolean simpan(String username, String password, String level, String status) throws SQLException {
        String sql = "INSERT INTO tb_pengguna (nm_pengguna, psw_pengguna, level_user, status_akun) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, level);
        ps.setString(4, status);
        return ps.executeUpdate() > 0;
    }
    
    public boolean ubah(String username, String password, String level, String status) throws SQLException {
        if (password == null || password.isEmpty()) {
            String sql = "UPDATE tb_pengguna SET level_user=?, status_akun=? WHERE nm_pengguna=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, level);
            ps.setString(2, status);
            ps.setString(3, username);
            return ps.executeUpdate() > 0;
        } else {
            String sql = "UPDATE tb_pengguna SET psw_pengguna=?, level_user=?, status_akun=? WHERE nm_pengguna=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, level);
            ps.setString(3, status);
            ps.setString(4, username);
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean hapus(String username) throws SQLException {
        String sql = "DELETE FROM tb_pengguna WHERE nm_pengguna=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        return ps.executeUpdate() > 0;
    }
}