/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mx.uacm.curso.daos.EmocionDAO;
import mx.uacm.curso.dtos.EmocionPredominanteDTO;
import mx.uacm.curso.entidades.Emocion;

public class EmocionDAOImpl extends GenericDAOImpl<Emocion, Integer> implements EmocionDAO {

    public EmocionDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public EmocionPredominanteDTO emocionPredominantePorTweetsIds(List<Integer> tweetsIds) {
        
        List<String> emociones = new ArrayList<>(Arrays.asList("felicidad","tristeza","enojo","miedo","animado","indiferente"));
        
        Query consulta = em.createQuery("SELECT AVG(e.felicidad) AS felicidad ,AVG(e.tristeza) AS tristeza,AVG(e.enojo) AS enojo,"
                + " AVG(e.miedo) AS miedo,AVG(e.animado) AS animado, AVG(e.indiferente) AS indiferente FROM"
                + " Tweet t INNER JOIN t.emocion e WHERE t.id IN :tweetsIds");
        consulta.setParameter("tweetsIds", tweetsIds);
        Object[] avg = (Object[]) consulta.getSingleResult();
        
        int idmax = 0;
        Double max = (Double)avg[0];        
        for (int i = 0; i < avg.length; i++) {
            Double a =(Double)avg[i];
            if (a<=max) {
            } else { 
                max=a;
                idmax=i;
            }           
        }     
        return new EmocionPredominanteDTO(emociones.get(idmax),max);
    }
}
