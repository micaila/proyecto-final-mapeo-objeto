/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.HashtagDAO;
import mx.uacm.curso.entidades.Hashtag;

public class HashtagDAOImpl extends GenericDAOImpl<Hashtag, Integer> implements HashtagDAO {

    public HashtagDAOImpl(EntityManager em) {
        super(em);
    }
    @Override
    public List<String> nombresHashtags(){
        TypedQuery<String> consulta = em.createQuery("SELECT h.nombre FROM Hashtag h", String.class);
        return consulta.getResultList();
    }

}
