package ejerciciorepaso;

import Controlador.ControladorPrincipal;
import Controlador.ControladorProducto;

import Modelo.ConsultasProducto;
import Modelo.Producto;

import Vista.VPrincipal;
import Vista.VProducto;

public class Main {


    public static void main(String[] args) {
        // Modelo
        Producto pro = new Producto();
        ConsultasProducto proC = new ConsultasProducto();
        
        // Vista
        VProducto frmPro = new VProducto();        
        VPrincipal frmPri = new VPrincipal();
        
        // Controlador
        ControladorProducto ctrlPro = new ControladorProducto(pro,frmPro, proC);
        ControladorPrincipal ctrlPri = new ControladorPrincipal(frmPri, frmPro);
     
        // Inica la vista principal
        ctrlPri.inciar();
        frmPri.setVisible(true);

    }
    
}
