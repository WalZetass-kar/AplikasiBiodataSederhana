package com.iwal.utsdbcobabywal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection koneksi;
    private static String DB_HOST = "localhost";
    private static String DB_PORT = "3306";
    private static String DB_NAME = "coba";
    private static String DB_USER = "root";
    private static String DB_PASS = "";

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mariadb://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
                
                Class.forName("org.mariadb.jdbc.Driver");
                koneksi = DriverManager.getConnection(url, DB_USER, DB_PASS);
                System.out.println("Koneksi Berhasil!");
                
            } catch (ClassNotFoundException e) {
                System.out.println("Driver tidak ditemukan: " + e.getMessage());
                JOptionPane.showMessageDialog(null, 
                    "Driver MariaDB tidak ditemukan!\nPastikan library sudah ditambahkan.", 
                    "Error Koneksi", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                System.out.println("Koneksi Gagal: " + e.getMessage());
                JOptionPane.showMessageDialog(null, 
                    "Gagal koneksi ke database!\n" +
                    "Pastikan:\n" +
                    "1. XAMPP/MySQL sudah jalan\n" +
                    "2. Database 'coba' sudah dibuat\n" +
                    "3. Username/password sesuai\n\n" +
                    "Error: " + e.getMessage(), 
                    "Error Koneksi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        return koneksi;
    }
    
    public static void testKoneksi() {
        try {
            Connection conn = getKoneksi();
            if (conn != null && !conn.isClosed()) {
                JOptionPane.showMessageDialog(null, 
                    "Koneksi database BERHASIL!", 
                    "Info Koneksi", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Koneksi database GAGAL!\n" + e.getMessage(), 
                "Error Koneksi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}