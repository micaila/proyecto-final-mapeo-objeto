/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.PaisDAO;
import mx.uacm.curso.entidades.Pais;

public class PaisDAOImpl extends GenericDAOImpl<Pais, Integer> implements PaisDAO {

    public PaisDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Pais> obtenPorTweetsIds(List<Integer> tweetsIds) {
        TypedQuery<Pais> consulta =
                em.createQuery("SELECT p FROM Pais p JOIN p.lugares l "
                        + "WHERE l.tweet.id IN :patron GROUP BY p.id ",
                        Pais.class);
        consulta.setParameter("patron", tweetsIds);
        return consulta.getResultList();    
    }

}
