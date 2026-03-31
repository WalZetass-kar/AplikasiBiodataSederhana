package com.iwal.utsdbcobabywal;

import com.iwal.utsdbcobabywal.controller.MenuUtamaController;
import com.iwal.utsdbcobabywal.view.MenuUtamaView;
import javax.swing.SwingUtilities;

public class UTSDBCOBABYWAL {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuUtamaView menuUtama = new MenuUtamaView();
            new MenuUtamaController(menuUtama, "", "");
            menuUtama.setVisible(true);
        });
    }
}