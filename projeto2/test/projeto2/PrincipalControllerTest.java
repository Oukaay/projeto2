/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ViniSilva
 */
public class PrincipalControllerTest {
    
    public PrincipalControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cadastra method, of class PrincipalController.
     */
    @Test
    public void testCadastra() {
        System.out.println("teste cadastra");
       
        ClienteController instance = new ClienteController();
        instance.cadastraCliente(new Cliente ("Vinicius","123"));
        
        Cliente result = instance.buscaCliente("123");
        
        assert(result.getNome().equals("Vinicius"));
    }

    /**
     * Test of listaSessoes method, of class PrincipalController.
     */
    @Test
    public void testInsercaoDuplicada() {
        System.out.println("teste cadastra");
       
        ClienteController instance = new ClienteController();
        instance.cadastraCliente(new Cliente ("Vinicius","123"));
        boolean result = instance.cadastraCliente(new Cliente ("Jose","123"));
        
        
        assertEquals(result, false);
    }

    /**
     * Test of compra method, of class PrincipalController.
     */
    @Test
    public void testCompra() throws Exception {
        System.out.println("teste compra");
        PrincipalController instance = new PrincipalController();
        
        Sessao teste = instance.getSessao(1);
        
        boolean testePrimeiraCompra = teste.compraIngresso();
        
        boolean testeSegundaCompra = teste.compraIngresso();
        
        boolean testeTerceiraCompra = teste.compraIngresso();
        
        assertEquals(testePrimeiraCompra, true);
        assertEquals(testeSegundaCompra, true);
        assertEquals(testeTerceiraCompra, false);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of buscaSessoes method, of class PrincipalController.
     */
    
    @Test
    public void testBuscaSessao(){
        System.out.println("Teste Busca Sessao");
        
        PrincipalController instance = new PrincipalController();
        
        ArrayList<Sessao> sessao = (ArrayList<Sessao>) instance.buscaSessoes("Ted");
        
        assertEquals(sessao.size(), 2);
        
        sessao = (ArrayList<Sessao>) instance.buscaSessoes("Ze mane");
        
        assertEquals(sessao.size(), 0);
        
        
        
    }
    
}
