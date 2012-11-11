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
        
        if (!clienteExiste(cliente.getCpf())){            
            listaClientes.put(cliente.getCpf(), cliente);
            cadastrou = true;
        } 
        
       
        return cadastrou;
               
    }
    

    public boolean clienteExiste(String cpf){
        
       return (Cliente)listaClientes.get(cpf) != null;
        
    }
    
    public Cliente buscaCliente(String cpf){
        return (Cliente)listaClientes.get(cpf);
    }
    
}
