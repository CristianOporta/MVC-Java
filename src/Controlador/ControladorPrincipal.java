package Controlador;

import Vista.VPrincipal;
import Vista.VProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ControladorPrincipal implements ActionListener {
    private final VPrincipal frmPri;
    private final VProducto frmPro;
    

    public ControladorPrincipal(VPrincipal frmPri, VProducto frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmPri.menu_producto.addActionListener(this);
        this.frmPri.menu_salir.addActionListener(this);
        this.frmPro.btn_regresar.addActionListener(this);
        
        // Agregar el WindowListener a frmPro
        this.frmPro.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frmPro.dispose();
                frmPri.setLocationRelativeTo(null);
                frmPri.setVisible(true); // Mostrar la vista principal al cerrar frmPro
            }
        });
    }

    public void inciar(){
        frmPro.setTitle("Producto");
        frmPri.setTitle("Principal");
        frmPri.setLocationRelativeTo(null);
        frmPro.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmPri.menu_producto){
            frmPro.setLocationRelativeTo(null);
            frmPro.setVisible(true);
            frmPri.dispose();
        }
        
        if (e.getSource() == frmPro.btn_regresar) {
            frmPri.setLocationRelativeTo(null);
            frmPri.setVisible(true); // Mostrar la vista principal al hacer clic en "Regresar"
            frmPro.dispose();
        }
        
        if(e.getSource()==frmPri.menu_salir){
            System.exit(0);
        }
    }
}
