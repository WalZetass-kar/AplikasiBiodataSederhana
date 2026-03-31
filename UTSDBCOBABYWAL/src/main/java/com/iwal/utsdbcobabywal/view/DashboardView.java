package com.iwal.utsdbcobabywal.view;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel {
    private JLabel lblTotalMahasiswa;
    private JLabel lblTotalPengguna;
    private JLabel lblTotalPendidikan;
    private JLabel lblTotalPengalaman;
    private JLabel lblTotalMaster;
    private JLabel lblTotalHistori;
    
    public DashboardView() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        
        String[] icons = {"📊", "👥", "🎓", "💼", "📋", "📜"};
        String[] titles = {"Total Mahasiswa", "Total Pengguna", "Total Pendidikan", 
                          "Total Pengalaman", "Total Master", "Total Histori"};
        Color[] colors = {
            new Color(52, 152, 219),
            new Color(46, 204, 113),
            new Color(155, 89, 182),
            new Color(241, 176, 53),
            new Color(230, 126, 34),
            new Color(231, 76, 60)
        };
        
        lblTotalMahasiswa = new JLabel("0");
        lblTotalPengguna = new JLabel("0");
        lblTotalPendidikan = new JLabel("0");
        lblTotalPengalaman = new JLabel("0");
        lblTotalMaster = new JLabel("0");
        lblTotalHistori = new JLabel("0");
        
        JLabel[] valueLabels = {
            lblTotalMahasiswa, lblTotalPengguna, lblTotalPendidikan,
            lblTotalPengalaman, lblTotalMaster, lblTotalHistori
        };
        
        for (int i = 0; i < icons.length; i++) {
            JPanel card = createStatCard(icons[i], titles[i], valueLabels[i], colors[i]);
            
            gbc.gridx = i % 3;
            gbc.gridy = i / 3;
            add(card, gbc);
        }
    }
    
    private JPanel createStatCard(String icon, String title, JLabel valueLabel, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(color);
        card.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
        
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        valueLabel.setFont(new Font("Arial", Font.BOLD, 36));
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        card.add(iconLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(valueLabel);
        
        return card;
    }
    
    public void updateStats(int mahasiswa, int pengguna, int pendidikan, int pengalaman, int master, int histori) {
        lblTotalMahasiswa.setText(String.valueOf(mahasiswa));
        lblTotalPengguna.setText(String.valueOf(pengguna));
        lblTotalPendidikan.setText(String.valueOf(pendidikan));
        lblTotalPengalaman.setText(String.valueOf(pengalaman));
        lblTotalMaster.setText(String.valueOf(master));
        lblTotalHistori.setText(String.valueOf(histori));
    }
}