/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGrillas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import objetos.Cliente;

/**
 *
 * @author javi
 */
public class GrillaCliente extends AbstractTableModel{
    ArrayList<Cliente> clientes = new ArrayList<>();
    

    @Override
    public int getRowCount() {
    return clientes.size();
    
    }

    @Override
    public int getColumnCount() {
            return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
            Cliente c = clientes.get(i);
           switch (i1){
               case 0: return c.getId_cliente();
               case 1: return c.getNombre();
               case 2: return c.getDireccion();
               case 3: return c.getEmail();
               case 4: return c.getTelefono();
               default: return "";
           
                      }
               }

    @Override
    public String getColumnName(int i) {
            switch(i){
                case 0: return "ID";
                case 1: return "NOMBRE";
                case 2: return "TELEFONO";
                case 3: return "DIRECCION";
                case 4: return "EMAIL";
                default: return "";
        }
    }
    
    public GrillaCliente(ArrayList<Cliente> c) {
     this.clientes = c;
                                
            }
    
   public Cliente getcCliente(int i){
       return this.clientes.get(i);
   
   }
    
    
    
}
