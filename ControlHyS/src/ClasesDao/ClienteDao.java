/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDao;

import java.util.ArrayList;
import objetos.Cliente;

/**
 *
 * @author javi
 */
public interface ClienteDao {
    public ArrayList<Cliente> listar();
    public void insertarCliente(Cliente c);
    public void modificarCliente(Cliente c);
    public void eliminarCliente(Cliente c);
}
