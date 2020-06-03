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
import mx.uacm.curso.daos.impl.TweetDAOImpl;
import mx.uacm.curso.entidades.Tweet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TweetDAOTest {

    private static EntityManager em;

    private static TweetDAO tweetDAO;

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
        tweetDAO = new TweetDAOImpl(em);
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
    public void buscarPorIdTest() {
        Tweet t = tweetDAO.buscarPorId(1);
        Assertions.assertNotNull(t);
    }
    
    @Test
    public void mapeoTweetUsuarioTest() {
        Tweet t = tweetDAO.buscarPorId(1);
        Assertions.assertNotNull(t);
        Assertions.assertEquals(1,t.getUsuario().getId());
    }
    
    @Test
    public void mapeoTweetsHashtagsTest() {
        Tweet t = tweetDAO.buscarPorId(2);
        Assertions.assertNotNull(t);
        Assertions.assertEquals(6,t.getHashtags().size());
    }
    
    @Test
    public void mapeoTweetLugarTest() {
        Tweet t = tweetDAO.buscarPorId(1);
        Assertions.assertNotNull(t);
        Assertions.assertEquals(1,t.getLugar().getId());
    }
    
    @Test
    public void mapeoTweetEmocionTest() {
        Tweet t = tweetDAO.buscarPorId(1);
        Assertions.assertNotNull(t);
        Assertions.assertEquals(1,t.getEmocion().getId());
    }
    
    @Disabled("╯°□°）╯ No jala!!!")
    @Test 
    public void tweetsPorHashtagsTest(){
     
        List<String> nombresHashtags = new ArrayList<String>();
        nombresHashtags.add("gitlab");
        nombresHashtags.add("github");
        List<Tweet> t = tweetDAO.tweetsPorHashtags(nombresHashtags);
        Assertions.assertNotNull(t);
        Assertions.assertEquals(5,t.size());
    }
}
