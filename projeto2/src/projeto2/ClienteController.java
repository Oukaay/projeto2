/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.Hashtable;

/**
 *
 * @author ViniSilva
 */
public class ClienteController {
    
    
    private  Hashtable listaClientes = new Hashtable();
   
    
    public boolean cadastraCliente(Cliente cliente){
        
        boolean cadastrou = false;
        
        if (!clienteExiste(cliente)){
            listaClientes.put(cliente.getCpf(), cliente);
            cadastrou = true;
        } 
        
       
        return cadastrou;
               
    }
    

    private boolean clienteExiste(Cliente cliente){
        
       return (Cliente)listaClientes.get(cliente.getCpf()) != null;
        
    }
    
}
