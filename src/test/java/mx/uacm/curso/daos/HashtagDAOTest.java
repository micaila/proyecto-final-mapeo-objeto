/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.impl.HashtagDAOImpl;
import mx.uacm.curso.dtos.ConteoHashtagDTO;
import mx.uacm.curso.entidades.Hashtag;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HashtagDAOTest {

    private static EntityManager em;

    private static HashtagDAO hashtagDAO;

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
        hashtagDAO = new HashtagDAOImpl(em);
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
    public void buscarPorIdTest() throws Exception {
        Hashtag h = hashtagDAO.buscarPorId(1);
        Assertions.assertNotNull(h);
    }
    
    @Test
    public void mapeoHashtagsTweetsTest() throws Exception {
        Hashtag h = hashtagDAO.buscarPorId(2);
        Assertions.assertNotNull(h);
        Assertions.assertEquals(5, h.getTweets().size());
    }
    
    @Test
    public void nombresHashashtagsTest(){    
      List<String> nombres = hashtagDAO.nombresHashtags();
      Assertions.assertEquals(48, nombres.size());
    }
    
    @Test
    public void conteoHashtagsTest(){    
      List<ConteoHashtagDTO> t = hashtagDAO.conteoHashtags();
      Assertions.assertEquals(48, t.size());
    }

}
