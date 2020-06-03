/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.impl.PaisDAOImpl;
import mx.uacm.curso.entidades.Pais;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaisDAOTest {

    private static EntityManager em;

    private static PaisDAO paisDAO;

    @AfterAll
    //ejecuta antes de todos los tests
    public static void antes() {
        System.out.println("iniciando tests");
    }

    @AfterAll
    //ejecuta despues de todos los tests
    public static void terminar() {
        System.out.println("tests terminados");
    }

    @BeforeAll
    public static void inicializar() throws Exception {
        System.out.println("inicializando..");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-proyecto-memoria");
        em = emf.createEntityManager();
        paisDAO = new PaisDAOImpl(em);
        System.out.println("inicializado");
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        em.flush();
        System.out.println("despues del test");
        em.getTransaction().rollback();
    }

    @Test
    public void buscarPorIdTest(){
        Pais p = paisDAO.buscarPorId(1);
        Assertions.assertNotNull(p);
    }
    
    @Test
    public void mapeoPaisLugaresTest() {
        Pais p = paisDAO.buscarPorId(2);
        Assertions.assertNotNull(p);
        Assertions.assertEquals(12, p.getLugares().size());
    }
    
    @Test 
    public void obtenPorTweetsIdsTest(){       
      
        List<Integer> tweetsIds = new ArrayList<Integer>();
        tweetsIds.add(1);
        tweetsIds.add(2);
        tweetsIds.add(3);
        tweetsIds.add(4);
        tweetsIds.add(7);
        List<Pais> p = paisDAO.obtenPorTweetsIds(tweetsIds);
        Assertions.assertNotNull(p);
        Assertions.assertEquals(3, p.size());
        
    }

}
