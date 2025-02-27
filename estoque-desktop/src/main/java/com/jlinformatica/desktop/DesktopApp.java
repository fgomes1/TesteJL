package com.jlinformatica.desktop;

import com.jlinformatica.desktop.controller.ProdutoFormController;
import com.jlinformatica.desktop.service.ProdutoService;
import com.jlinformatica.desktop.view.ProdutoForm;
import javax.swing.SwingUtilities;

public class DesktopApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ProdutoForm form = new ProdutoForm();
                ProdutoService service = new ProdutoService();
                new ProdutoFormController(form, service);
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }
}
