/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.TweetDAO;
import mx.uacm.curso.daos.impl.EmocionDAOImpl;
import mx.uacm.curso.daos.impl.TweetDAOImpl;
import mx.uacm.curso.daos.impl.UsuarioDAOImpl;
import mx.uacm.curso.dtos.PaisYEmocionPredominanteDTO;
import mx.uacm.curso.entidades.Usuario;
import mx.uacm.curso.servicios.impl.EstadisticasServicioImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EstadisticasServicioTest {

    private static EntityManager em;

    private static EstadisticasServicio estadisticasServicio;

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
        //creamos un servicio y le configuramos sus dependencias
        EstadisticasServicioImpl estadisticasServicioImpl = new EstadisticasServicioImpl();
        estadisticasServicioImpl.setEmocionDAO(new EmocionDAOImpl(em));
        estadisticasServicioImpl.setTweetDAO(new TweetDAOImpl(em));
        //guardamos el servicio en la variable estatica
        estadisticasServicio = estadisticasServicioImpl;
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
    public void test() {
       
        
        List<String> nombresHashtags = new ArrayList<String>();
        nombresHashtags.add("gitlab");
        nombresHashtags.add("github");
        GregorianCalendar cal = new GregorianCalendar(2020,02,01);
        Date fechaMin = cal.getTime();
        cal = new GregorianCalendar(2020,03,10);
        Date fechaMax =  cal.getTime();
        List<PaisYEmocionPredominanteDTO> pye = estadisticasServicio.emocionesPredominantesAgrupadasPorPais(nombresHashtags, fechaMin, fechaMax);
        Assertions.assertNotNull(pye);
        Assertions.assertEquals(2, pye.size());
        
    }

}
