package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorProducto implements ActionListener {
    private final Producto pro;
    private final VProducto frmPro;
    private final ConsultasProducto proC;

    public ControladorProducto(Producto pro, VProducto frmPro, ConsultasProducto proC) {
        this.pro = pro;
        this.frmPro = frmPro;
        this.proC = proC;
        this.frmPro.btn_agregar.addActionListener(this);
        this.frmPro.btn_buscar.addActionListener(this);
        this.frmPro.btn_eliminar.addActionListener(this);
        this.frmPro.btn_limpiar.addActionListener(this);
        this.frmPro.btn_modificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Boton Agregar
        if (e.getSource() == frmPro.btn_agregar) {
            
            if (frmPro.txt_codigo.getText().isEmpty() || frmPro.txt_nombre.getText().isEmpty() || frmPro.txt_precio.getText().isEmpty() || frmPro.txt_cantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmPro, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return; // Detiene la ejecución del método si hay campos vacíos.
            }
            
            pro.setCodigo(frmPro.txt_codigo.getText());
            pro.setNombre(frmPro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmPro.txt_precio.getText()));
            pro.setCantidad(Integer.parseInt(frmPro.txt_cantidad.getText())); // Agrega la cantidad
            
            if (proC.registrar(pro)) {
                JOptionPane.showMessageDialog(null, "Producto Agregado!", "Satisfactorio", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Agregar!", "Error", JOptionPane.WARNING_MESSAGE);
                limpiar();
            }
        } 
        //----------------------------------------------
        
        // Boton Modificar
        if (e.getSource() == frmPro.btn_modificar) {
            
            if (frmPro.txt_codigo.getText().isEmpty() || frmPro.txt_nombre.getText().isEmpty() || frmPro.txt_precio.getText().isEmpty() || frmPro.txt_cantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmPro, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return; // Detiene la ejecución del método si hay campos vacíos.
            }
            
            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
            pro.setCodigo(frmPro.txt_codigo.getText());
            pro.setNombre(frmPro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmPro.txt_precio.getText()));
            pro.setCantidad(Integer.parseInt(frmPro.txt_cantidad.getText())); // Agrega la cantidad
            
            if (proC.modificar(pro)) {
                JOptionPane.showMessageDialog(null, "Producto Modificado", "Satisfactorio", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.WARNING_MESSAGE);
                limpiar();
            }
        }
        //----------------------------------------------
        
        
        // Boton Eliminar
        if(e.getSource()==frmPro.btn_eliminar){
            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null, "Producto Eliminado", "Satisfactorio", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                limpiar();
            }
        }
        //----------------------------------------------
        
        
        // Boton Buscar
        if(e.getSource()==frmPro.btn_buscar){
            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
            if(proC.buscar(pro)){
                frmPro.txt_id.setText(String.valueOf(pro.getId()));
                frmPro.txt_codigo.setText(pro.getCodigo());
                frmPro.txt_nombre.setText(pro.getNombre());
                frmPro.txt_precio.setText(String.valueOf(pro.getPrecio()));
                frmPro.txt_cantidad.setText(String.valueOf(pro.getCantidad()));
            }else{
                JOptionPane.showMessageDialog(null, "Error al Buscar", "Error", JOptionPane.WARNING_MESSAGE);
                limpiar();
            }
        }
        //----------------------------------------------

        // Boton Limpiar
        if(e.getSource()==frmPro.btn_limpiar){
            limpiar();
        }
        //----------------------------------------------   
    }
    //----------------------------------------------
    
    // Boton Buscar
    public void limpiar(){
        frmPro.txt_codigo.setText(null);
        frmPro.txt_id.setText(null);
        frmPro.txt_nombre.setText(null);
        frmPro.txt_precio.setText(null);
        frmPro.txt_cantidad.setText(null); // Limpia también el campo de cantidad
    }
    //----------------------------------------------
}
